package businesslogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

        boolean validUser = false;

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        for(User user: userList){
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                validUser = true;
                System.out.println(user.getUserName()+" "+user.getPassword());
                HttpSession loginSession = request.getSession();
                loginSession.setAttribute("userInfo", user);
                //setting session to expiry in 30 mins
                loginSession.setMaxInactiveInterval(30*60);
                Cookie cookieUserName = new Cookie("userName", userName);
                cookieUserName.setMaxAge(30*60);
                response.addCookie(cookieUserName);
                //response.sendRedirect("LoginSuccess.jsp");
                try {
                    //response.sendRedirect("WEB-INF/welcome.jsp");
                    dispatcher = request.getRequestDispatcher("WEB-INF/welcome.jsp");
                    dispatcher.forward(request, response);
                } catch (IOException | ServletException e) {
                    e.printStackTrace();
                }
                //dispatcher = request.getRequestDispatcher("WEB-INF/welcome.jsp");
                break;
            }
        }
        if(!validUser){
            try {
                response.sendRedirect("index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
