package Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonajeRespuesta {

    @SerializedName("id")
    @Expose
    private int idPersonaje;

    @SerializedName("name")
    @Expose
    private String namePersonaje;

    @SerializedName("status")
    @Expose
    private String statusPersonaje;

    @SerializedName("species")
    @Expose
    private String speciesPersonaje;

    @SerializedName("gender")
    @Expose
    private String genderPersonaje;

    @SerializedName("url")
    @Expose
    private String urlPersonaje;

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public String getNamePersonaje() {
        return namePersonaje;
    }

    public String getStatusPersonaje() {
        return statusPersonaje;
    }

    public String getGenderPersonaje() {
        return genderPersonaje;
    }

    public String getSpeciesPersonaje() {
        return speciesPersonaje;
    }

    public String getUrlPersonaje() {
        return urlPersonaje;
    }
}
