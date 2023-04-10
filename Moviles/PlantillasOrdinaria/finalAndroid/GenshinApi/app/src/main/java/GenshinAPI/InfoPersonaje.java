package GenshinAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoPersonaje {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("vision")
    @Expose
    private String vision;

    @SerializedName("nation")
    @Expose
    private String nation;

    @SerializedName("description")
    @Expose
    private String description;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getVision() {
        return vision;
    }

    public String getNation() {
        return nation;
    }

    public String getDescription() {
        return description;
    }
}

