package Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface AtraccionesService {

    @GET("/pmdm/api/atracciones/")
    Call<List<AtraccionesResponse>> listarAtracciones();

    @GET
    Call <ComentariosInfo> mostrarComentarios(@Url String url);
}
