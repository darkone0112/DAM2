package PreguntasServicio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionResponse {
    @SerializedName("pk")
    @Expose
    private String pk;

    @SerializedName("question_text")
    @Expose
    private String question_text;

    @SerializedName("pub_date")
    @Expose
    private String pub_date;

    //Getters
    public String getPk() {
        return pk;
    };

    public String getQuestion_text() {
        return question_text;
    }

    public String getPub_date() {
        return pub_date;
    }

}
