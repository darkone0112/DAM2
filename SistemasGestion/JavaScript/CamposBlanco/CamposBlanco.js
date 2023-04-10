document.getElementById('saludar').addEventListener('click', llamar, false);
function llamar() {
    var input = [];
    var error = 0;
    input = document.getElementsByTagName("input");
    var textred = [];
    textred = document.getElementsByTagName("p");
    var cockies = document.getElementById("cockies").checked;
    var sexo = document.getElementsByClassName("sexo").checked;
    if(cockies == false || sexo == false){
        alert("Se debe seleccionar un sexo y aceptar los terminos de uso");
    }
    for (let i = 0; i < input.length-1; i++) {
        if (input[i].value == ''){
            error = 1;
            textred[i].style.color = "red";
            
        }else{
            textred[i].style.color = "BLACK";
            error = 0;
        }
    }
    alert("ojo");
}

    