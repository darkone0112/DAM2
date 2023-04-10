document.getElementById("generar").addEventListener("click", generar, false);
function generar(){
    let data = ""
    var string = ""
    fetch("https://pokeapi.co/api/v2/pokemon/ditto")
    .then((response) => response.json())
    .then((data) => {document.getElementById("nombre").innerHTML = data.name
    console.log(data)
    for (let i = 0; i < data.abilities.length; i++) {
        document.getElementById("habilidad").innerHTML +=data.abilities[i].ability.name + "<br  >";
    }
    });
}

