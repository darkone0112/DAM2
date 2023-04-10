/* Varios Alumnos una nota */
/* 
let alumnos = []
let t = window.prompt("Introducir cantidad de alumnos")
for (i = 0; i < t; i++) {
    let alumno = {
        nombre : window.prompt("Nombre"),
        notas : window.prompt("nota")
        
    }
    alumnos.push(alumno)   
    document.write("<br/>"+alumnos[i].nombre + " " + alumnos[i].nota)
}
*/

/* Un alumno Varias notas */

/* let alumno = {
    nombre : window.prompt("Nombre"),
    apellidos : window.prompt("apellidos"),
    notas : [6]
} 
document.write("Nombre del alumno: " + alumno.nombre + " " + alumno.apellidos + "<br/>")
for (i = 0 ; i < 6 ; i++) {
    alumno.notas[i] = window.prompt("Nota " + (i+1))
    document.write("* Nota " + (i+1) + " " + alumno.notas[i] + "<br/>")
}
 */

/* Unir ambos tipos = varios alumnos con varias notas */
/* ?????? */

let alumnos = []
let t = window.prompt("Cantidad alumnos")
for (i = 0;i<t; i++) {
    let alumno = {
        nombre : window.prompt("Nombre"),
        apellidos : window.prompt("apellidos"),
        notas : [6]
    }
    alumnos.push(alumno)   
    document.write("Nombre del alumno: " + alumno.nombre + " " + alumno.apellidos + "<br/>")
    for (x = 0 ; x < 6 ; x++) {
        alumnos[i].notas[x] = window.prompt("Nota " + (x+1))
        
        document.write("* Nota " + (i+1) + " " + alumnos[i].notas[x] + "<br/>")
    }
    
}



