package PreguntasServicio;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface QuestionServicio {
    //GET
    @GET("/")
    Call<QuestionResponse> raiz();

    @GET("/{q1}/?format=json/")
    Call<QuestionResponse> filtrar(@Path("q1")int q1);

    //POST
    @FormUrlEncoded
    @POST("/polls/api-token-auth/")
    Call<Token> login(
            @Field("username") String username,
            @Field("password") String password
    );

}
