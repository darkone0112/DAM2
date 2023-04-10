package RickMortyAPI.APIMapear;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import RickMortyAPI.APIMapear.Location;
import RickMortyAPI.APIMapear.Origin;

//Primera clase creada (Obtiene los datos del JSON recibido)
public class PersonajesRespuesta {

    //Fecha de debut del personaje
    @SerializedName("created")
    @Expose
    private String created;

    //Devuelve url del personaje en concreto (utiliza la id)
    @SerializedName("url")
    @Expose
    private String url;

    //Obtiene la Lista con distintos episodios en el cual aparece el personaje
    @SerializedName("episode")
    @Expose
    List<String> episode;

    //Obtiene url de la imagen ( A veces es necesario usar un objeto :/ )
    @SerializedName("image")
    @Expose
    private String imagelink;

    //Obtiene location, se requiere la clase necesaria para obtener el objeto
    @SerializedName("location")
    @Expose
    Location location;

    //Obtiene origen, se requiere la clase necesaria para obtener el objeto
    @SerializedName("origin")
    @Expose
    Origin origin;

    //Obtiene el sexo del personaje
    @SerializedName("gender")
    @Expose
    private String gender;

    //Obtiene el type ( En muchos personajes es null )
    @SerializedName("type")
    @Expose
    private String type;

    //Obtiene la especie
    @SerializedName("species")
    @Expose
    private String species;

    //Obtiene el status
    @SerializedName("status")
    @Expose
    private String status;

    //Obtiene el nombre
    @SerializedName("name")
    @Expose
    private String name;

    //Obtiene el id
    @SerializedName("id")
    @Expose
    private String id;

    public String getSpecies() { return species;}

    public List<String> getEpisode() {
        return episode;
    }

    public String getImagelink() {
        return imagelink;
    }

    public Location getLocation() {
        return location;
    }

    public Origin getOrigin() {
        return origin;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCreated() {
        return created;
    }

    public String getUrl() {
        return url;
    }
}
