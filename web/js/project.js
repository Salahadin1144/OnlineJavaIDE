$(function () {
        $('.enableOnInput').prop('disabled', true);

        $("#project1").click(function () {
            $.get("/ProjectController")
                .done(ajaxSuccess)
                .fail(ajaxFailure);
        });

        $("#createNewProject").click(function () {
            $("#createNewProjectModal").showModal();
        });

        $("#txtProjectName").keyup(function () {
            // $(this).val().length > 0 &&
            if(validate($(this).val())){
                $("#createNewProjectErrorMessage").text("");
                $('.enableOnInput').prop('disabled', false);
            }else{
                $("#createNewProjectErrorMessage").text("Invalid Project Name");
                $('.enableOnInput').prop('disabled', true);
            }
        });

        $("#btnCreateProject").click(
            function () {
                var projectName = $("#txtProjectName").val();
                //alert(projectName);
                var project = { projectName: projectName };
                $.post( "/ProjectController", project)
                    .done(function( data ) {
                        $("#createNewProjectModal").hide();
                        if(data !== null) {
                            //alert(data.projectName + " " + data.projectId + " " + data.projectOwner);
                            var random = Math.floor(Math.random() * 10) + 1;
                            var newTag = "<div id"+data.projectId+" class=\"panel-group panels\">\n" +
                            "                        <div class=\"panel panel-default\">\n" +
                            "                            <div class=\"panel-heading\">\n" +
                            "                                <h4 class=\"panel-title\">\n" +
                            "                                    <a data-toggle='collapse' href='#collapse"+random+"'>"+projectName+"</a>\n" +
                            "                                </h4>\n" +
                            "                            </div>\n" +
                            "                            <div id='collapse"+random+"' class='panel-collapse collapse'>\n" +
                            "                                <div class=\"panel-body\">" +
                                "                             <a class='createNewClass' href='#' data-toggle=\"modal\" data-target=\"#createNewClassModal\"> Create New Class</a></div>\n" +
                            "                            </div>\n" +
                            "                        </div>\n" +
                            "                    </div>";
                            //alert(newTag);
                            $("<div>").html(newTag).appendTo("#projectsList");
                        }
                    })
                    .fail(function () {
                        alert( "Failure" );
                    })
                ;
            }
        );

    $(".createNewClass").click(function () {
        $("#createNewClassModal").showModal();
    });

    $("#txtClassName").keyup(function () {
        // $(this).val().length > 0 &&
        if(validate($(this).val())){
            $("#createNewClassErrorMessage").text("");
            $('.enableOnInput').prop('disabled', false);
        }else{
            $("#createNewClassErrorMessage").text("Invalid Class Name");
            $('.enableOnInput').prop('disabled', true);
        }
    });

    $("#btnCreateClass").click(
        function () {
            var className = $("#txtClassName").val();
            alert(className);
            var code = $("<code>").html("<p>public class "+className + "{ \n \n}</p>>");
            var newTag = $("<textarea id='"+className+"' cols='80' rows='10'>");
            newTag.css("width", "100%").css("height","100%");
            code.appendTo("#"+className)
            alert(newTag);
            newTag.appendTo("#editor");
            /*
            var newClass = { className: className };
            $.post( "/ClassController", newClass)
                .done(function( data ) {
                    $("#createNewClassModal").hide();
                    if(data !== null) {
                        alert(data.projectName + " " + data.projectId + " " + data.projectOwner);
                        var random = Math.floor(Math.random() * 10) + 1;
                        var newTag = "<textarea>";
                        alert(newTag);
                        $("<div>").html(newTag).appendTo("#editor");
                    }
                })
                .fail(function () {
                    alert( "Failure" );
                })
            ;
            */
        }
    );

});

function ajaxSuccess(data) {
    $("#projectHeading").text(data.userName);
    alert("Success: "+data.userName +" "+data.password);
}

function ajaxFailure() {
    alert("Failure");
}

function validate(value) {
    var regex = /^([a-zA-Z_$][a-zA-Z\\d_$]*)$/;
    return regex.test(value);
}