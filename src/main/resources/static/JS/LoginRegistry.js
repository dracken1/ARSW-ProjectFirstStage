
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

submit = (function () {
    return{
        submitLogin: function () {
            var user = document.getElementById('loginuser');
            var password = document.getElementById('loginpass');
            fetch('').then( location)
        },
        submitRegistry: function () {
            
        }
    };
})();