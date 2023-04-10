package APIService;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface QuestionService {

    @POST("/polls/api/api-question-auth/")
    Call<QuestionRespuesta> getToken(@Body QuestionUser questionUser);

    @POST("/polls/api/api-question-auth/")
    Call<QuestionRespuesta> getNonFieldErrors(@Body QuestionUser questionUser);

}
