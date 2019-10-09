
$("#btntoggle").click(function () {
    $("#login").animate({height:"toggle",
        'padding-top': "toggle",
        'padding-bottom': "toggle",
        opacity: "toggle"
    });
    $("#sigin").animate({height: "toggle",
        paddingTop: "toggle",
        paddingBottom: "toggle",
        opacity: "toggle"
    });

});

class LoginForm{
    constructor(username,password){
        this.username = username;
        this.password = password;
    }
}

$("#btnlogin").click(function(){
       var user = document.getElementById('loginuser').value;
       var password = document.getElementById('loginpass').value;
       var url = 'http://localhost:8080/session/' + user + '/' + password;
           fetch(url, {
               method: 'GET',
               headers: {
                   'Content-Type': 'application/json'
               }
           })
           .then(response => response.json())
           .then(data => {
               console.log(data);
               if(data){
                   window.location.href = "home.html";
               } else {
                   alert("Incorrect username or password")
               }
           })
   });


$("#btnregistry").click(function(){
   var firstname = document.getElementById('rfname').value;
   var lastname = document.getElementById('rfname').value;
   var username = document.getElementById('loginuser').value;
   var email = document.getElementById('remail').value;
   var password = document.getElementById('loginpass').value;
   var url = 'http://localhost:8080/session/';
       fetch(url, {
           method: 'POST',
           headers: {
               'Content-Type': 'application/json'
           }
       })
       .then(response => response.json())
       .then(data => {
           console.log(data);
           if(data){
               window.location.href = "home.html";
           } else {
               alert("Incorrect username or password")
           }
       })
});


