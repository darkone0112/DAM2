package GenshinAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GenshinService {

    @GET("/characters")
    Call <List<String>> mostrarPersonajes();

    @GET("/characters/{nombre}")
    Call <InfoPersonaje> mostrarDetalle(
            @Path("nombre") String nombre);

}
