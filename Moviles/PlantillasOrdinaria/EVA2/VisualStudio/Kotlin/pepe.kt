package Kotlin

enum class colores {
    BLUE,ORANGE,RED
}

fun main() {
    println("Prueba when")
    var pepe = "RED"

    fun pruebawhen(pepe)

}

fun pruebawhen (colorr: Color): String +
    when (Color){
        BLUE -> println("azulito")
        ORANGE -> println("naranja")
        RED -> println("hot")
    }
