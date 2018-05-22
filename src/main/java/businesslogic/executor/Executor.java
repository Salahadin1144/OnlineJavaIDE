package businesslogic.executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Executor {

    public String execute(String projectPath, String javaFileName){
        Runtime rt = Runtime.getRuntime();
        Executor rte = new Executor();
        Executor.PrintOutput errorReported = null, outputMessage=null;

        String output = null;

        try {
            Process proc = rt.exec("/Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/bin/java " +
                    " -classpath " +
                    projectPath+" "+javaFileName);
            // Process proc = rt.exec("mkdir /Users/<username>/Desktop/test1");
            // Process proc = rt.exec("ping https://crunchify.com");
            errorReported = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
            errorReported.start();

            outputMessage = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
            outputMessage.start();

            while (errorReported.isAlive() || outputMessage.isAlive()) {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        output = errorReported.message;
        output = output != null ? output : outputMessage.message;
        return output;
    }

    public PrintOutput getStreamWrapper(InputStream is, String type) {
        return new PrintOutput(is, type);
    }

    private class PrintOutput extends Thread {
        InputStream is = null;
        String message = null;

        PrintOutput(InputStream is, String type) {
            this.is = is;
        }

        public void run() {
            String line = null;
            try {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(is));
                while ((line = br.readLine()) != null) {
                    if (message == null) {
                        message = line;
                    } else {
                        message += line;
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
