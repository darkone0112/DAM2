package APIService;

import retrofit2.Retrofit;

public class QuestionClient {

    private static String baseURL = "http://192.168.1.54:8000/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .build();
        }
        return retrofit;
    }

}
