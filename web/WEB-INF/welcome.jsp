<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!--link rel="stylesheet" href="OnlineJavaIDE.css"-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="../js/project.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        * {
            margin: 0px;
            padding: 1px;
            font-size: 12px;
        }

        #content {
            height: 100%;
        }

        .panels{
            height: 100%;
            margin: 0px;
            padding: 1px;
        }

        .panel-heading{
            height: 32px;

            vertical-align: text-top;
        }

        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed)
        .row.content {height: 450px}
        */
        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }


        }
    </style>
</head>
<body>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<div class="container-fluid" style="padding: 0px" >

    <nav class="navbar navbar-default nav-menu">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".button-menu">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">BSF-Online-Java-Editor</a>
        </div>

        <div class="collapse navbar-collapse button-menu" style="background-color: black">
            <ul class="nav navbar-nav">
                <li><a href="#"><i class="fa fa-home"></i> HOME</a></li>
                <li><a href="#">Berry</a></li>
                <li><a href="#">BLa</a></li>
                <li><a href="#">BLABLA</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span> 
                        <strong>User</strong>
                        <span class="glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="navbar-login">
                                <div class="row">
                                    <div class="col-lg-4">
                                        <p class="text-center">
                                            <span class="glyphicon glyphicon-user icon-size"></span>
                                        </p>
                                    </div>
                                    <div class="col-lg-8">
                                        <p class="text-left"><strong>User</strong></p>
                                        <p class="text-left small">user@gmail.com</p>
                                        <p class="text-left">
                                            <form action="/logout">
                                                <input type="submit" value="logout">
                                            </form>
                                            <!--  <a href="#" class="btn btn-primary btn-block btn-sm">Logout</a> -->
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="navbar-login navbar-login-session">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <p>
                                            <a href="#" class="btn btn-primary btn-block">My Profile</a>
                                            <a href="#" class="btn btn-danger btn-block">Change Password</a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>

        </div>

    </nav>
</div>

<div class="container-fluid text-center" >
    <div id="content" class="row content" style="height: 700px;">
        <div  class="col-sm-2 sidenav" style="margin: 0px; padding: 1px; overflow: scroll; height: 100%">
            <div id="explorer" class="panel panel-default panels" >
                <div class="panel-heading" style="text-align: left">Project Explorer</div>
                <div class="panel-body">
                    Panel Content:
                    <!--
                    <form action="/ProjectController">
                        <button value=""
                    </form>
                    -->
                    <p><a id="project1" href="#">Project - 1</a></p>
                    <p><a href="#">Link</a></p>
                    <p><a href="#">Link</a></p>
                </div>
            </div>
        </div>
        <div class="col-sm-8 text-left" style="margin: 0px; padding: 1px; overflow: scroll; height: 1000%;">
            <div class="panel panel-default panels" style="height: 1000%">
                <div  class="panel-heading">
                    <p id="projectHeading"> Editor </p>
                </div>
                <div class="panel-body" style="height: 1000%;">
                    Panel Content:
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    <hr>
                    <h3>Test</h3>
                    <p>Lorem ipsum...</p>
                </div>
            </div>
        </div>
        <div class="col-sm-2 sidenav" style="margin: 0px; padding: 1px; overflow: scroll; height: 100%">
            <div class="panel panel-default panels" style="height: 100%">
                <div class="panel-heading">Properties</div>
                <div class="panel-body">
                    Panel Content:
                    <div class="well">
                        <p>ADS</p>
                    </div>
                    <div class="well">
                        <p>ADS</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="container-fluid text-center" style="width: 100%; margin: 0px; padding: 0px; overflow: scroll; position: fixed; bottom: 0px;">
    <div class="panel panel-default panels" style="height: 100%">
        <div class="panel-heading">Output</div>
        <div class="panel-body">
            Panel Content:
            <p>&copy;2018</p>
        </div>
    </div>
</footer>

</body>
</html>
