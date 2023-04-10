package RickMortyAPI.APIMapear;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoPage {

    //Previa página
    @SerializedName("prev")
    @Expose
    private String prev;

    //Siguiente página
    @SerializedName("next")
    @Expose
    private String next;

    //Page actual
    @SerializedName("pages")
    @Expose
    private int pages;

    //count posición del personaje
    @SerializedName("count")
    @Expose
    private int count;

    public String getPrev() {
        return prev;
    }

    public String getNext() {
        return next;
    }

    public int getPages() {
        return pages;
    }

    public int getCount() {
        return count;
    }
}
