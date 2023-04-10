package APIService;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface QuestionService {
    @POST("/polls/api-token-auth/")
    Call<AuthResponse> authenticate(@Body AuthRequest authRequest);

}
