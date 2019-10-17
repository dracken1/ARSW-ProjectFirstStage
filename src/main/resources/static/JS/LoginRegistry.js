
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



class User{
    constructor(name,lastname,username,email,password){
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

$("#btnlogin").click(function(){
       var user = document.getElementById('loginuser').value;
       var password = document.getElementById('loginpass').value;
       var url = '/session/' + user + '/' + password;
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
   var lastname = document.getElementById('rlname').value;
   var username = document.getElementById('rusername').value;
   var email = document.getElementById('remail').value;
   var password = document.getElementById('rpassword').value;
   var usertosend = new User(firstname,lastname,username,email,password);
   var url = '/session/add';
       fetch(url, {
           method: 'POST',
           headers: {
               'Content-Type': 'application/json'
           },
           body:JSON.stringify(usertosend)
       })
       .then(response => {
           if(response.ok){
               window.location.href = "home.html";
           } else {
               alert("Something went wrong!");
           }
       })
});




