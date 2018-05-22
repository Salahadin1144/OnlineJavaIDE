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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {

    public static String PROJECT_PATH = "";
    public static String PROJECTS_PATH = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setAttribute("projectName", "Sample Project");

        System.out.println("doPOST: Project Controller called....");

        String projectName = request.getParameter("projectName");

        User user = (User) request.getSession().getAttribute("userInfo");
        String pid = LocalDateTime.now().toString();
        Project project = new Project(""+pid, projectName, user.getUserName());
        PROJECTS_PATH = "/Users/saladin/BSF-PROJECTS/"+project.getProjectOwner()+"_PROJECT";
        PROJECT_PATH = PROJECTS_PATH+"/SBF"+""+project.getProjectOwner()+""+project.getProjectName();

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
        boolean output = false;
        File userProjects = new File(PROJECTS_PATH);
        if(!userProjects.exists()){
            if(userProjects.mkdir()){
                System.out.println("User Projects created!");
            }
        }else{
            System.out.println("User Projects already exist!");
        }

        File userProject = new File(PROJECT_PATH);//+"/SBF"+""+project.getProjectOwner()+""+project.getProjectName());
        if(!userProject.exists()){
            if(userProject.mkdir()){
                System.out.println("Project created!");
                output = true;
            }
        }
        return output;
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
