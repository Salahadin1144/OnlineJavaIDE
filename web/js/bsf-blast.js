$(function(){
$("body")
    .blast({ delimiter: "word" })
    // Alternate colors between each word
    .css({ color: "red" })
    //.filter(":odd").css("color", "blue");

    $("body")
        .blast({ 
            search: "But"
        })
        .css({ color: "blue" });

});