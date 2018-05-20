$(function () {
        $("#project1").click(function () {
            $.get("/ProjectController")
                .done(ajaxSuccess)
                .fail(ajaxFailure);
        });

        $("#createNewProject").click(function () {
            $("#createNewProjectModal").showModal();
        });

        $("#txtProjectName").onkeyup(function () {
            var txtProjName = $("#txtProjectName");
            if($(this).val() != '' ){
                $('.enableOnInput').prop('disabled', true);
                alert(txtProjName.value);
            }else{
                $('.enableOnInput').prop('disabled', false);
                alert("Project name cant be blank");
            }
        });

});

function ajaxSuccess(data) {
    $("#projectHeading").text(data.userName);
    alert("Success: "+data.userName +" "+data.password);
}

function ajaxFailure() {
    alert("Failure");
}