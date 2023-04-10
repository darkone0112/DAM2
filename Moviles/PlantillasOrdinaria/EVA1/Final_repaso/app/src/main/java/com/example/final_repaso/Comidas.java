package com.example.final_repaso;

import java.util.ArrayList;
import java.util.Arrays;

public class Comidas {

    public String nombre;
    public String descripcion;
    public static int ORDEN_COMIDAS=0;

    private static ArrayList<String> nombresComidas = new ArrayList<String>(Arrays.asList(new String[]{"Cachopo","Hamburgesa","Sagrado Kebap","Arroz con Habichuela","Sancocho"}));
    private static ArrayList<String> descComidas = new ArrayList<String>(Arrays.asList(new String[]{"Filete empanado","Bocata con carne","Sagrado y bendito","Bandera Dominicana","Caldo con contenidos god"}));


    public static Comidas generateComida () {
        Comidas o = new Comidas();
        int aleazar = (int)(1 + Math.random()*2);
        o.nombre=nombresComidas.get(ORDEN_COMIDAS);
        o.descripcion=descComidas.get(ORDEN_COMIDAS);
        return o;
    }


    public static Comidas[] generateComidas () {
        Comidas[] comidas = new Comidas[(nombresComidas.size())];
        for (int i=0;i<(nombresComidas.size());i++) {
            comidas[i] = Comidas.generateComida();
            ORDEN_COMIDAS++;
        }
        ORDEN_COMIDAS=0;
        return comidas;
    };




}