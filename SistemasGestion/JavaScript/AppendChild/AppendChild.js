document.getElementById("btn").addEventListener("click", add, false);

function add(){
    const parrafo = document.createElement("p");
    var texto = document.createTextNode("este es el texto");
    parrafo.appendChild(texto);
    document.body.appendChild(parrafo);
}