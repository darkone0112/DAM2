marca = window.prompt("Introducir Marca del Coche")
if (marca == "ford") {
    modelo = window.prompt("Introducir Modelo del Coche")
    if (modelo == "fiesta") {
        document.write("El descuento es de 10%")
    }
    if (modelo == "focus") {
        document.write("El descuento es de 5%")
    }
} else {
    document.write("Marca sin descuento")
}