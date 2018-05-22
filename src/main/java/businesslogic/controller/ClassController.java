package businesslogic.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@WebServlet("/ClassController")
public class ClassController extends HttpServlet {

    List<ClassInfo> javac;
    String compilationResult;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPOST: Class Controller called....");
        String code = request.getParameter("src");
        System.out.println(code);

        int compileResult = compile(code);

        System.out.println(compileResult);
        System.out.println(compilationResult);
    }

    private int compile(String code) {

        String courseDotJava = code;
//                "public class Course {\n"
//                + "\n"
//                + "    private String number;\n"
//                + "\n"
//                + "    private String title;\n"
//                + "\n"
//                + "    private int units\n"
//                + "}\n"
//                + "";
        List<String> javaFiles = new ArrayList<>();

        javaFiles.add(courseDotJava);

        try {
            javac = Javac.compile(javaFiles);
//            for(ClassInfo ci: javac){
//                System.out.println(ci);
//            }
//            File file = new File("/Users/saladin/output/file.txt");
//            Scanner sc = new Scanner(file);
//            while(sc.hasNext()){
//                String line = sc.next();
//                System.out.println(line);
//            }
        } catch (IOException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            compilationResult = ex.getMessage();
            System.out.println(compilationResult);
        }

        return Javac.COMPILATION_RESULT;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPOST: Class Controller called....");
    }
}
