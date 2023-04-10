package PreguntasServicio;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionAPI {

    QuestionServicio service;

    private static String URL_API = "http://http://192.168.1.54:8000/";

    private static QuestionAPI instancia = null;

    //Crea la conexión con la API
    private QuestionAPI () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(QuestionServicio.class);
    }

    //Singleton
    public static QuestionAPI getInstance(){
        if (instancia == null) {
            instancia = new QuestionAPI();
        }
        return instancia;
    };

    //Devuelve el resultado de la búsqueda
    public Call<QuestionResponse> filtrar(int q1) {
        return service.filtrar(q1);
    };


}
