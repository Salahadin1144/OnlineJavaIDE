package businesslogic.controller;


import businesslogic.model.Project;
import businesslogic.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.util.stream.Collectors;

@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setAttribute("projectName", "Sample Project");

        System.out.println("doPOST: Project Controller called....");

        String projectName = request.getParameter("projectName");
        User user = (User) request.getSession().getAttribute("userInfo");

        Project project = new Project(""+120, projectName, user.getUserName());

        System.out.println("Project: "+project);

        //PrintWriter out = response.getWriter();


        boolean result = createProject(project);
        Gson gson = new GsonBuilder().serializeNulls().create();
        if(result){
            try{

                String json = gson.toJson(project, Project.class);
                System.out.println("JSON: "+json);
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.write(json);//.println("Hello from BSF");
                out.flush();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            String json = gson.toJson(null);
            System.out.println(json);
        }

    }

    private boolean createProject(Project project) {
        File userProjects = new File("/Users/saladin/BSF-PROJECTS/"+project.getProjectOwner()+"_PROJECT");
        if(!userProjects.exists()){
            if(userProjects.mkdir()){
                System.out.println("");
                File userProject = new File(userProjects.getPath()+"/SBF"+project.getProjectName()+""+project.getProjectOwner()+""+project.getProjectId());
                if(!userProject.exists()){
                    if(userProject.mkdir()){
                        System.out.println("Project created");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("doGET: Project Controller called....");

        User user = new User("BSF", "bsf");
        try{
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(user, User.class);
            System.out.println("JSON: "+json);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.write(json);//.println("Hello from BSF");
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
