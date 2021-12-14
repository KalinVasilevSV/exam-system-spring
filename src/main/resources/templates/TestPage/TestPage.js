var numPages = 9; // Starts at 0
var page = 0;
var userSelections = {};

function savePage() {
    /* Saves checked boxes */
    var options = document.getElementsByClassName("option");
    for (var i = 0; i < 5; i++) {
        if (options[i].checked) {
            userSelections[page] = i;
            return true;
        }
    }
    return false;
}

function loadPage() {
    /* Set progress bar and question number*/
    document.getElementById("progress-bar").style.width = (((page) / numPages) * 100) + "%";
    document.getElementById("questionNumber").innerHTML = ("Question " + (page + 1));
    /* Set checkboxes */
    var options = document.getElementsByClassName("option");
    for (var i = 0; i < options.length; i++) {
        if (userSelections[page] == i) {
            options[i].checked = true;
        } else {
            options[i].checked = false;
        }
    }

    /* Get questions */
    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        var response = JSON.parse(xhttp.response);
        var options = document.getElementsByClassName("option");
        for (var i = 0; i < response.length; i ++) {
            options[i].innerText = response[i];
        }
        document.getElementById("question").innerHTML = response.question;
    };
    xhttp.open("GET", ("server.php?q=" + page), true);
    xhttp.send();
}

function next(){
    if (savePage()) {
        if (page < numPages) {
            page++;
            loadPage();
        } else {
            document.getElementById("progress-bar").style.width = "100%";
            var xhttp = new XMLHttpRequest();
            xhttp.onload = function() {
                document.getElementById("main").innerHTML = xhttp.response;
            };
            xhttp.open("GET", ("server.php?a=" + JSON.stringify(userSelections)), true);
            xhttp.send();
        }
    } else {
        alert("Please select an answer.");
    }
}

function prev(){
    if (page >= 1) {
        savePage();
        page--;
        loadPage();
    }
}