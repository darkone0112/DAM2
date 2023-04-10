package Service;

import Data.PersonajeRespuesta;
import Data.PageResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RickAndMortyService {

    @GET("api/character")
    Call<PageResponse> mostrarPersonajes(
            @Query("page") int page
    );

    //Mostrar Detalle usando la URL
    @GET
    Call <PersonajeRespuesta> mostrarDetalle(@Url String url);

    @GET
    Call <PageResponse> siguientePagina(@Url String url);

    @GET
    Call <PersonajeRespuesta> volverPagina(@Url String url);


}
