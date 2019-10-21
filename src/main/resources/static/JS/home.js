
$('#gnrbtnlft').click(function(){
    window.location.href = "primeraFuncionalidad.html";
});

function mousePressed(obj) {
    obj.style.backgroundColor = "#ad8b36";
}

function mouseReleased(obj) {
    obj.style.backgroundColor = "#F9D342";
}

function mouseHover(obj) {
    obj.style.backgroundColor = "#F9D342";
}

function mouseLeave(obj) {
    obj.style.backgroundColor = "#292826";
}

$("#haccountid").click(function () {
    $("#extendeduserlogoid").animate({
        height: "toggle"
    },200);
});

function getCookie(name) {
  var regexp = new RegExp("(?:^" + name + "|;\s*"+ name + ")=(.*?)(?:;|$)", "g");
  var result = regexp.exec(document.cookie);
  return (result === null) ? null : result[1];
}

$("#outoptsiconid").click(function(){
    document.cookie = "username=; expires=Thu, 21 Aug 1970 20:00:00 UTC; path=/;"
    document.cookie = "; expires=Thu, 21 Aug 1970 20:00:00 UTC; path=/;"
    console.log(document.cookie);
    window.location.href = "LoginRegistry.html"
});

