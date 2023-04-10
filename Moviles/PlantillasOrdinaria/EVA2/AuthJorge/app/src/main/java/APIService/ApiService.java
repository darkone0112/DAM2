package APIService;

import com.example.authjorge.Credencial;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("polls/api-token-auth/")
    Call<LoginResponse> login(@Body Credencial credencial);


}
