package PracticaViaje;

import java.io.Serializable;

public class Viaje implements Serializable {
    String EHora,ESpinner,EFecha,ESpinnerIda,EHoraV,EFechaV,ESpinnerV,ENombre,EDireccion,EDni;
    public Viaje (String EHora,String ESpinner, String EFecha,String ESpinnerIda,
                  String EHoraV,String EFechaV,String ESpinnerV,String ENombre,
                  String EDireccion,String EDni) {

        this.EHora=EHora;
        this.ESpinner=ESpinner;
        this.EFecha=EFecha;
        this.ESpinnerIda=ESpinnerIda;
        this.EHoraV=EHoraV;
        this.EFechaV=EFechaV;
        this.ESpinnerV=ESpinnerV;
        this.ENombre=ENombre;
        this.EDireccion=EDireccion;
        this.EDni=EDni;
    }

    @Override
    public String toString() {
        return "Viaje: " +
                "\nNombre usuario: " +"\n"+ ENombre +
                "\nDirección usuario: " +"\n" + EDireccion +
                "\nDNI Usuario: " + "\n" + EDni +
                "\nHora de salida: " + "\n" + EHora +
                "\nCiudad Origen: " + "\n" + ESpinner +
                "\nFecha de salida: " + "\n" + EFecha +
                "\nCiudad destino: " + "\n" + ESpinnerIda +
                "\nHora de vuelta: " + "\n" + EHoraV +
                "\nFecha de vuelta: " + "\n" + EFechaV +
                "\nCiudad de vuelta: " + "\n" + ESpinnerV;

    }
}
