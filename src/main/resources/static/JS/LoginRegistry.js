
$("#btntoggle").click(function () {
    $("#login").animate({
        height: "toggle",
        'padding-top': "toggle",
        'padding-bottom': "toggle",
        opacity: "toggle"
    });
    $("#sigin").animate({
        height: "toggle",
        paddingTop: "toggle",
        paddingBottom: "toggle",
        opacity: "toggle"
    });
});

class User {
    constructor(name, lastname, username, email, password) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

var usuario = document.cookie;
var usertodisplay;
$("#btnlogin").click(function () {
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
            if (data.user.name != null) {
                usuario = new User(data.user.name, data.user.lastname, data.user.username, data.user.email, data.user.password);
                document.cookie = "username=" + data.user.username;
                window.location.href = "home.html";
            } else {
                Swal.fire(
                    'Sorry!',
                    '"Incorrect Username or Password"',
                    'error')
            }
        })
});

// Execute a function when the user releases a key on the keyboard
document.getElementById("login").addEventListener("keypress", function (event) {
    // Number 13 is the "Enter" key on the keyboard
    if (event.keyCode === 13) {
        // Cancel the default action, if needed
        event.preventDefault();
        // Trigger the button element with a click
        document.getElementById("btnlogin").click();


    }
});



var signinfunction = function () {
    return {
        signin: function () {
            var usernametocheck = document.getElementById('rusername').value;
            var emailtocheck = document.getElementById('remail').value;
            console.log(emailtocheck);
            var url = '/session/' + usernametocheck;
            fetch(url, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => response.json())
                .then(data => {
                    console.log("duplicated username: " + data);
                    if (data === true) {
                        Swal.fire(
                            'Sorry!',
                            'Username already exists!',
                            'error')
                    } else {

                        var url2 = '/session/user/' + emailtocheck;
                        fetch(url2, {
                            method: 'GET',
                            headers: {
                                'Content-Type': 'application/json'
                            }
                        })
                            .then(response2 => response2.json())
                            .then(data2 => {
                                console.log("Used email: " + data2);
                                if (data2 === true) {
                                    Swal.fire(
                                        'Sorry!',
                                        'Email already in use!',
                                        'error')
                                } else {
                                    var firstname = document.getElementById('rfname').value;
                                    var lastname = document.getElementById('rlname').value;
                                    var username = document.getElementById('rusername').value;
                                    var email = document.getElementById('remail').value;
                                    var password = document.getElementById('rpassword').value;
                                    var usertosend = new User(firstname, lastname, username, email, password);
                                    var url3 = '/session/add';
                                    fetch(url3, {
                                        method: 'POST',
                                        headers: {
                                            'Content-Type': 'application/json'
                                        },
                                        body: JSON.stringify(usertosend)
                                    })
                                        .then(response => {
                                            if (response.ok) {
                                                Swal.fire(
                                                    'Successfully created!',
                                                    'You have been registered!',
                                                    'success'
                                                ).then((result) => {
                                                    if (result.value) {
                                                        window.location.href = "index.html";
                                                    }})

                                            } else {
                                                Swal.fire(
                                                    'Sorry!',
                                                    'Please verify your data!',
                                                    'error')
                                            }

                                        })
                                }
                            })
                    }
                })
        }
    }
}



