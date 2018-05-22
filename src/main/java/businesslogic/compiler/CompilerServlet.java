package businesslogic.compiler;

import businesslogic.controller.ProjectController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

@WebServlet("/CompilerServlet")
public class CompilerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPOST: Compiler Controller called....");
        String code = request.getParameter("src");
        String javaFileName = request.getParameter("fileName");
        System.out.println(javaFileName +".java \n "+code);

        String projectPath = ProjectController.PROJECT_PATH;
        System.out.println("PROJECT PATH: "+projectPath);

        String fullJavaFilePath = projectPath+"/"+javaFileName+".java";
        String fullJavaByteCodePath = projectPath+"/"+javaFileName+".class";

        File newJavaByteCodeFile = new File(fullJavaByteCodePath);
        if (newJavaByteCodeFile.exists()) {
            newJavaByteCodeFile.delete();
        }

        File newJavaFile = new File(fullJavaFilePath);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(newJavaFile));
            writer.write(code);
            writer.close();
        } catch (IOException ex) {
            //ßLogger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        String compilationResult = "";
        if (newJavaFile.exists()) {
            compilationResult = compile(newJavaFile);
        } else {
            compilationResult = "Server error!";
        }


        response.getWriter().println(compilationResult);

    }

    private String compile(File fileName){
        String result = null;
        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        compiler.getSourceVersions().forEach((version) -> {
            System.out.println(version);
        });

        final DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();

        final StandardJavaFileManager manager = compiler.getStandardFileManager(
                diagnostics, null, null);


        final Iterable< ? extends JavaFileObject> sources
                = manager.getJavaFileObjectsFromFiles(Arrays.asList(fileName));

        for (JavaFileObject jfo : sources) {
            System.out.println(jfo.getName());
        }

        final JavaCompiler.CompilationTask task = compiler.getTask(null, manager, diagnostics, null, null, sources);

        if (task.call()) {
            System.out.println("Compiled successfully");
            result = "Compiled successfully";
        } else {
            result = "Compilation Error...\n";
            for (final Diagnostic< ? extends JavaFileObject> diagnostic
                    : diagnostics.getDiagnostics()) {

                result += String.format("%s, line %d",
                        diagnostic.getMessage(null),
                        diagnostic.getLineNumber());
                        //diagnostic.getSource().getName());

            }

            System.out.println("Compilation Error...");

        }

        return result;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
