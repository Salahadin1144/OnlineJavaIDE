
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <form action="/login" method="post">
        User Name:
        <input type="text" name="userName" >
        Password:
        <input type="password" name="password" >
        <input type="submit" name="login" value="login">
    </form>
  </body>
</html>
