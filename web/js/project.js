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