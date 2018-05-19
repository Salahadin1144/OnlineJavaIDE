package businesslogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("doGET method called...");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("POST method called...");
        request.setAttribute("projectName", "Sample Project");

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        UserController users = new UserController();
        List<User> userList = users.getUserList();

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        for(User user: userList){
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                System.out.println(user.getUserName()+" "+user.getPassword());

                dispatcher = request.getRequestDispatcher("WEB-INF/welcome.jsp");
                request.setAttribute("userInfo", user);
                break;
            }
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
