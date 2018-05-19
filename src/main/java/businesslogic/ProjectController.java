package businesslogic;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("projectName", "Sample Project");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Project Controller called....");

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
