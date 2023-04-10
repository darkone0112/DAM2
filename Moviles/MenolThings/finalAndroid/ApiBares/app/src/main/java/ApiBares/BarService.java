package ApiBares;

import java.util.List;

import ApiBares.BarMap.ReseñasResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BarService {

    @GET("pmdm/api/bares/")
    Call <List<ReseñasResponse>> listarReseña();

    @GET("/pmdm/api/bares/")
    Call <List<ReseñasResponse>> filtrarEstrella(
            @Query("estrellas") int estrellas
    );

}
