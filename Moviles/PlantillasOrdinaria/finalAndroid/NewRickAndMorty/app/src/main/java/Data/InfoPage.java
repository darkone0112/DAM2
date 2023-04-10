package Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoPage {

    @SerializedName("next")
    @Expose
    private String nextPage;

    @SerializedName("prev")
    @Expose
    private String prevPage;

    public String getNextPage() {
        return nextPage;
    }

    public String getPrevPage() {
        return prevPage;
    }
}
