document.getElementById("add").addEventListener("click", add);

function add() {
    var addimagen = document.createElement("img");
    var zona = document.getElementById("zona");
    var gato = document.getElementById("gato").checked;
    var perro = document.getElementById("perro").checked;
    var loro = document.getElementById("loro").checked;
    var anchor = document.createElement("a");
    
    if (gato == true) {
        addimagen.src = "https://media.tenor.com/patKcXgljGYAAAAd/cursed-cat.gif"
        anchor.setAttribute("href", "https://es.wikipedia.org/wiki/Felis_silvestris_catus");
    } else {
        if (perro == true) {
            addimagen.src = "https://i.ytimg.com/vi/a2eSuXdZfMY/maxresdefault.jpg"
            anchor.setAttribute("href", "https://es.m.wikipedia.org/wiki/Canis_familiaris");
        }else {
            addimagen.src = "https://i.pinimg.com/736x/a5/d9/93/a5d993563623ead7ec9d640ca895c331.jpg"
            anchor.setAttribute("href", "https://es.m.wikipedia.org/wiki/Psittacoidea");
        }
    }
    zona.appendChild(anchor);
    anchor.appendChild(addimagen);
}