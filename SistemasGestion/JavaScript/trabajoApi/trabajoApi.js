document.getElementById("mostrar").addEventListener("click", mostrar, false)
document.getElementById("agregar").addEventListener("click", agregar, false)
const cor = "https://cors-anywhere.herokuapp.com/"
function mostrar(){
    let data =""
    console.log("ojo")
    fetch(cor+"https://nodejs-mysql-restapi-production-d8bd.up.railway.app/api/employees")
    .then((response) => response.json())
    .then((data) => {
        console.log(data)
        for (let i = 0; i<data.length; i++) {
            document.getElementById("tabla").innerHTML += "<tr>"+"<td>"+data[i].id+"</td>"+"<td>"+data[i].name+"</td>"+"<td>"+data[i].salary+"</td>"+"</tr>"
        }    
    })
    
}
function agregar(){
    let url = 'https://nodejs-mysql-restapi-production-d8bd.up.railway.app/api/employees' 
    nombre = /*toString*/document.getElementById("nombre").value
    salario =/*toString.*/document.getElementById("salario").value
    valor ={
        name:nombre,
        salary:salario
    }
    opciones={
        method:'POST',
        body:JSON.stringify(valor),
        header:{
            'Content-type':'application/json'
        }
    }
    console.log(opciones)
    fetch(cor+url,opciones)
    .then((response) => response.json())
}