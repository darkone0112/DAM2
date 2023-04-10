package com.example.trainapp;

import java.io.Serializable;
import java.util.Date;

public class viaje implements Serializable {
    private String origen;
    private String destino;
    private Date fechaSalida;
    private  Date fechaRegreso;
    private String nombre;
    private String dni;
    private String direccion;

    public viaje(String origen,String destino,Date fechaSalida, Date fechaRegreso,String nombre,String dni,String direccion){
        this.setOrigen(origen);
        this.setDestino(destino);
        this.setFechaSalida(fechaSalida);
        this.setFechaRegreso(fechaRegreso);
        this.setNombre(nombre);
        this.setDni(dni);
        this.setDireccion(direccion);

    }
    public viaje(){
        /*default*/
    }
    /*getters*/
    public String getOrigen(){
        return origen;
    }
    public String getDestino(){
        return destino;
    }
    public Date getFechaSalida(){
        return getFechaSalida();
    }
    public Date getFechaRegreso(){
        return getFechaRegreso();
    }
    public String getNombre(){
        return nombre;
    }
    public String getDni(){
        return dni;
    }
    public String getDireccion(){
        return direccion;
    }
    /*Setters*/
    public void setOrigen(String origen){
        this.origen = origen;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }
    public void setFechaSalida(Date fechaSalida){
        this.fechaSalida = fechaSalida;
    }
    public void setFechaRegreso(Date fechaRegreso){
        this.fechaRegreso = fechaRegreso;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

}
