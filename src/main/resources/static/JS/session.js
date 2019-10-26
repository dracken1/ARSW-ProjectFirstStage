

(function(){
    //alert("funca");
    //alert(document.cookie);
    if(getCookie("username") === null){
    //alert("entra");
        console.log(document.cookie);
        window.location.href = "index.html"
    }
})();

function getCookie(name) {
  //var regexp = new RegExp("|;\s*"+ name + ")=(.*?)(?:;|$)", "g");
  var regexp = new RegExp("(?:^" + name + "|;\s*"+ name + ")=(.*?)(?:;|$)", "g");
  var result = regexp.exec(document.cookie);
  return (result === null) ? null : result[2];
}