package APIService;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {

    //Se utiliza para que retrpfit utilice elementos privados
    @Expose
    public String token;

    //Se nombra el objeto devuelto
    @SerializedName("non_field_errors")
    @Expose
    public List<String> nonFieldErrors;

}
