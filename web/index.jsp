
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page info="its about my page"%>
<%@page import="java.util.Date" %>

<html>
  <head>
    <title>Login</title>
  </head>
  <body>

  <% Date date= new Date(); %>

    <form action="/login" method="post">
        User Name:
        <input type="text" name="userName" >
        Password:
        <input type="password" name="password" >
        <input type="submit" name="login" value="login">



        <p><%=date%>/p>
    </form>
  </body>
</html>
