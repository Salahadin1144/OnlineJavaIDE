
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page info="its about my page"%>
<%@page import="java.util.Date" %>

<html>
  <head>
    <title>Login</title>
      <link rel="stylesheet" type= "text/css" href="index.css">
      <link href="background5.jpg"  type="image/jpg" rel="shortcut icon" />
  </head>

  <body>

  <div class="container">
      <div class="row">
          <div class="col-md-12">
              <div class="pr-wrap">
                  <div class="pass-reset">
                     >
                      <input type="email" placeholder="Email" />
                      <input type="submit" value="Submit" class="pass-reset-submit btn btn-success btn-sm" />
                  </div>
              </div>
              <div class="wrap">
                  <h1 style="color: white">Log In</h1></p>

                  <!--  >  posting the welcomepage<-->
                  <form action="/login" method="post">
                      <input type="text" placeholder="Username" name="userName" size="40"/>
                      <br/>
                      <br/>
                      <input type="password" placeholder="Password" name="password" size="40"/>
                      <br>
                      <br/>
                      <br/>
                      <input type="submit" value="login" name="login" class=".btn-primary" />

                  </form>
              </div>
          </div>
          <footer class="logo"> <p style="color: white">&copy; 2018-2019 developed by BSF-Group</p></footer>
      </div>


    <!--form action="/login" method="post">
        User Name: <input type="text" name="userName" ><br>
        <br>
        Password: <input type="password" name="password"><br>
        <br>
        <input type="submit" name="login" value="login">

</--form-->
</div>


  </body>
</html>
