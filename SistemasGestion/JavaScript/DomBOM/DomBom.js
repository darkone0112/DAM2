document.getElementById('btn').addEventListener('click', llamar, false);
function llamar(){
    var e = document.getElementById("mySelect");
    var value = e.value
    var estilo = document.getElementById("textred").style;
    switch (value) {
        case "red":
            estilo.color = "red";
            break;
        case "blue": 
            estilo.color = "blue";
        break;
        case "green":
            estilo.color = "green";
        break;
        default:
            break;
    }
    var negrita = document.getElementById("negrita").checked;
    var cursiva = document.getElementById("cursiva").checked;
    var tachado = document.getElementById("tachado").checked;
    var letterStyle = document.getElementById("textred").style
    if (negrita == true) {
        letterStyle.fontWeight = "bold";
    }
    if (cursiva == true) {
        letterStyle.fontStyle= "italic";
    }
    
    if (tachado == true) {
        letterStyle.textDecoration = "line-through";
    }
    /* document.write(document.getElementById('name').value); */
    let contenido = document.getElementById("name").value;
    /* document.getElementById("displayText").innerHTML = contenido; */
    document.getElementById("textred").innerHTML = contenido;
}
 