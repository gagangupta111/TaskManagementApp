function validateEmaildisplay(id, email, language) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var x = document.getElementById(id);
    if (!re.test(email)){
        x.classList.add('errorBold');
        if (language == "English"){
            x.innerHTML= "&#09;" + "Please enter valid email address.";
        }else if(language == "Hindi"){
            x.innerHTML="&#09;" + "कृपया सही ईमेल टाइप कीजिये |";
        }
    }else {
        x.innerHTML=null;
    }
}
