$(function () {
    var selectedProjectId;
    var activeJavaClass;
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
                        $("#createNewProjectModal").hide(); // we can not create multiple projects for now
                        if(data !== null) {
                            //alert(data.projectName + " " + data.projectId + " " + data.projectOwner);
                            var random = Math.floor(Math.random() * 10) + 1;
                            var newTag = "<div  class=\"panel-group panels\" style='height: 100%; width: 100%;'>\n" +
                            "                        <div class=\"panel panel-default\">\n" +
                            "                            <div class=\"panel-heading\">\n" +
                            "                                <h4 class=\"panel-title\">\n" +
                            "                                    <a data-toggle='collapse' href='#collapse"+random+"'>"+projectName+"</a>\n" +
                            "                                </h4>\n" +
                            "                            </div>\n" +
                            "                            <div id='collapse"+random+"' class='panel-collapse collapse'>\n" +
                            "                                <div id='mainProject' class=\"panel-body\" style='text-align: left; margin-left: 20px'>" +
                                "                             <button id='createNewClass' style='width: 100%; height: 30px'" +
                                "                                 href='#' data-toggle='modal' data-target='#createNewClassModal'>Create New Class</button><br/><hr/></div>\n" +
                            "                            </div>\n" +
                            "                        </div>\n" +
                            "                    </div>";
                            //alert(newTag);
                            $("<div>").html(newTag).appendTo("#projectsList");
                            $("#createNewProject").prop("disabled", true);
                        }
                    })
                    .fail(function () {
                        alert( "Failure" );
                    })
                ;
            }
        );

    $("#createNewClass").click(function () {
        //selectedProjectId = this.parent().id;
        var code = $("#sourceCode");
        $("#createNewClassModal").showModal();
        if(code.text().length === 0 ){
            alert("You can create a class");
        }else{
            alert("Do you want to save your work? Y/N");
        }

        //alert("Hello World");
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

            var code = $("#sourceCode");

            var className = $("#txtClassName").val();
            //alert(className);

            activeJavaClass = className;

            code.html("public class "+className + "{ " +
                "" +
                "}");
            var classHtml = "<a id='"+className+"'  href='#'>"+className+"</a>";
            var newClass = $("<div>").html(classHtml);
            newClass.appendTo("#mainProject");
            //var newTag = code.appendTo()
            //    "<div contenteditable='true'> <code id='"+className+"' style='font-family: Consolas; font-size: 14px; width: 100%; height: 100%'>"
            //                + "public class "+className + "{ <br/> <br/>}"
            //                + "</code></div>";
            //newTag.css("width", "100%").css("height","100%");
            //code.appendTo("#"+className)
            //alert(newTag);
            //code.appendTo("#editor");
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

    // $("#sourceCode").keypress(function (e) {
    //     var keyCode = e.keyCode || e.which;
    //
    //     if(keyCode === 32){
    //
    //         //e.preventDefault();
    //
    //        // $(this)
    //        //     .blast({
    //        //         search: "public"
    //        //     })
    //        //     .css({ color: "darkorchid" });
    //
    //         // //e.preventDefault();
    //         // var start = this.selectionStart;
    //         // var end = this.selectionEnd;
    //         // var val = this.value;
    //         //
    //         // this.value = val.substring(0, start) + " " + val.substring(end);
    //         // this.selectionStart = this.selectionEnd = start + 50;
    //         //return false;
    //     }
    //
    //     if (keyCode === 9) {
    //         e.preventDefault();
    //         var start = this.selectionStart;
    //         var end = this.selectionEnd;
    //         var val = this.value;
    //
    //         this.value = val.substring(0, start) + "\t" + val.substring(end);
    //         this.selectionStart = this.selectionEnd = start + 1;
    //         //return false;
    //     }
    //
    //     //$(this).css("font-size", "13pt");
    // });

    $("#compileCode").click(function () {
        var code = $("#sourceCode").val();
        $.post("/CompilerServlet", { "fileName": activeJavaClass, "src": code})
            .done(function (data) {
                // alert("Compilation Result: "+data);
                var output = $("#output");
                output.css("color", "red").css("font-family","'DejaVu Sans Mono', monospace").css("font-size","14pt") ; // font-family: 'DejaVu Sans Mono', monospace
                output.html("Compilation Result: "+data);

            })
            .fail(ajaxFailure);
    });

    $("#executeCode").click(function () {
        var code = $("#sourceCode").val();
        $.post("/ExecutorServlet", { "fileName": activeJavaClass, "src": code })
            .done(function (data) {
                // alert("success");
                var output = $("#output");
                output.css("color", "blue") ;
                output.html("Result: "+data);
            })
            .fail(ajaxFailure);
    });




});

function ajaxSuccess(data) {
    $("#projectHeading").text(data.userName);
    alert("Success: "+data.userName +" "+data.password);
}

function ajaxFailure() {
    alert("Failure");
}

function validate(value) {
    var regex = /^([a-zA-Z_$][a-zA-Z0-9_$]*)$/;
    return regex.test(value);
}

