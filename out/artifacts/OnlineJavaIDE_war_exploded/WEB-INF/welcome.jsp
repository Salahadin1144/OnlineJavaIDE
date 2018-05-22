<%@ taglib prefix="bsf" uri="http://bsf.edu" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>BSF Online Java IDE</title>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!--link rel="stylesheet" href="OnlineJavaIDE.css"-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="../js/project.js"></script>
    <script src="../js/prism.js"></script>
    <link href="blast.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="http://julian.com/research/velocity/build/jquery.velocity.min.js"></script>
    <script src="http://velocityjs.org/build/velocity.ui.js"></script>
    <script src="http://velocityjs.org/blast/build/jquery.blast.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/prism.css" type="text/css" rel="stylesheet"></link>
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
            width: 100%;
            margin: 0px;
            padding: 1px;
        }

        .panel-heading{
            height: 32px;
            font-weight: bold;
            vertical-align: text-top;
        }

        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        #sourceCode{
            font-family: 'DejaVu Sans Mono', monospace;
            border: 2px solid lightgrey;
            border-radius: 6px;
            font-size: 13pt;
            color: #000;
            padding: 10px;
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
            <a style="color:white" class="navbar-brand" href="#">BSF-Java-Editor</a>
        </div>

        <div class="collapse navbar-collapse button-menu" style="background-color: black">
            <ul class="nav navbar-nav">
                <li><a style="color:white" href="#"><i style="color:white"  class="fa fa-home"></i> HOME</a></li>
                <li>
                    <a style="color:white" id="createNewProject" href="#" data-toggle="modal" data-target="#createNewProjectModal">
                        Create New Project
                    </a>
                    <!-- Modal -->
                    <div class="modal fade" id="createNewProjectModal" tabindex="-1" aria-labelledby="exampleModalCenterTitle">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5  class="modal-title" id="exampleModalLongTitle">New Project Form</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form action="" method="get">
                                        <label>
                                            Project Name:
                                            <input id="txtProjectName" name="txtProjectName" style="width: 400px">
                                        </label>
                                        <label id="createNewProjectErrorMessage" style="margin-left: 90px; color: red"></label>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <form method="dialog">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button id="btnCreateProject"
                                                name="btnCreateProject"
                                                class="btn btn-primary enableOnInput"
                                                data-dismiss="modal"
                                                >Create</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li><a href="#">BLa</a></li>
                <li><a href="#">BLABLA</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span> 
                        <strong>${userInfo.userName}</strong>
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
                                        <p class="text-left"><strong>${userInfo.userName}</strong></p>
                                        <p class="text-left small">${userInfo.userName}@gmail.com</p>
                                        <p class="text-left">
                                            <form action="/logout">
                                                <input class="btn btn-default btn-block type="submit" value="logout">
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
                <div id="projectsList" class="panel-body">
                    Projects List:
                </div>
            </div>
        </div>
        <div class="col-sm-8 text-left" style="margin: 0px; padding: 1px; overflow: scroll; height: 100%;">
            <div class="panel panel-default panels" style="height: 100%">
                <div  class="panel-heading">
                    <span id="projectHeading"> Editor </span>
                    <div style="float: right;" >
                        <button id="compileCode" class="btn-default btn-md" type="button">Compile</button>
                        <button id="executeCode" class="btn-default btn-md" type="button">Execute</button>
                    </div>
                </div>
                <div class="modal fade" id="createNewClassModal" tabindex="1" aria-labelledby="classModalCenterTitle">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="classClassModalLongTitle">New Class Form</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="" method="get">
                                    <label>
                                        Class Name:
                                        <input id="txtClassName" name="txtClassName" style="width: 400px">
                                    </label>
                                    <label id="createNewClassErrorMessage" style="margin-left: 90px; color: red"></label>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <form method="dialog">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button id="btnCreateClass"
                                            name="btnCreateClass"
                                            class="btn btn-primary enableOnInput"
                                            data-dismiss="modal"
                                    >Create</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="editor" contenteditable="true" style="width: 100%; height: 100%;">

                    <textarea style="width: 100%; height: 100%;" id="sourceCode">

                    </textarea>

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

<div id="outputmodal" class="container-fluid text-center" style="width: 100%; margin: 0px; padding: 0px; overflow: scroll; position: fixed; bottom: 0px;">
    <div class="panel panel-default panels" style="height: 100%">
        <div class="panel-heading">Output</div>
        <div class="panel-body" id="output">

        </div>
    </div>
</div>

<%--<div class="panel-group panels>--%>
                        <%--<div class="panel panel-default>--%>
                            <%--<div class="panel-heading">--%>
                                    <%--<h4 class="panel-title">--%>
                                            <%--<a data-toggle="collapse" href="#collapse1">New Project Tag</a>--%>
                                    <%--</h4>--%>
                                <%--</div>--%>
                            <%--<div id="collapse1" class="panel-collapse collapse">--%>
                                <%--<div class="panel-body">Panel Body</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                   <%--</div>--%>

</body>
</html>
