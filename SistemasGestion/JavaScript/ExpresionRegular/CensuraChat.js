let texto 
let palabra = /bomba/
do {
    texto = window.prompt("Texto: ");
    document.write(texto.replace(palabra,"****"))
} while (texto !== "exit");