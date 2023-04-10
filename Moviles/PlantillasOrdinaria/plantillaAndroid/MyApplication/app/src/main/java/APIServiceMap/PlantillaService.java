package APIServiceMap;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PlantillaService {

    @GET("/pmdm/api/bares/")
    Call <List<ObjetoResponse>> listarObjetos();

    @GET("/pmdm/api/bares/")
    Call <ObjetoResponse> mostrarDetalle(
            @Query("estrellas") int estrellas,
            @Query("inventado") String inventado
    );

    @GET
    Call <List<ObjetoResponse>> siguientePagina(@Url String url);

    @GET("/pmdm/api/bares/{id}/{img}")
    Call <ObjetoResponse> mostrarId(
            @Path("id") int id,
            @Path("img") String img
    );

    @DELETE("pmdm/api/bares/{id}/")
    Call <Void> deleteBar(@Path("id") int id);

    @POST("pmdm/api/bares")
    Call <ObjetoResponse> addObjeto(@Body ObjetoResponse objetoResponse);
}
