package businesslogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("GET method called...");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("POST method called...");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        RequestDispatcher dispatcher;
        if("".equals(userName) && "".equals(password))
            dispatcher = request.getRequestDispatcher("WEB-INF/welcome.jsp");
        else dispatcher = request.getRequestDispatcher("login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
