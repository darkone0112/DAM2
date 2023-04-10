package PeliculasAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PeliculaService {

    @GET("/pmdm/api/peliculas")
    Call <List<Respuesta>> mostrarPelicula();





    @GET
    Call <InfoPelicula> mostrarDescripcion(
            @Url String url);

}