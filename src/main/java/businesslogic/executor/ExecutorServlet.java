package businesslogic.executor;

import businesslogic.controller.ProjectController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet("/ExecutorServlet")
public class ExecutorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPOST: Executor Controller called....");
        String code = request.getParameter("src");
        System.out.println(code);

        String javaFileName = request.getParameter("fileName");
        System.out.println(javaFileName +".java \n "+code);

        String projectPath = ProjectController.PROJECT_PATH;
        System.out.println("PROJECT PATH: "+projectPath+" "+javaFileName);

        Executor executor = new Executor();

        String output = executor.execute(projectPath, javaFileName);

        System.out.println(output);
        response.getWriter().println(output);
    }





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
