package APIService;

public class LoginRepositorio {

    private static final String URL = "http://192.168.20.133:8000";

    private LoginRepositorio instancia;

    private LoginRepositorio () {
        servicio = new retrofit2.Retrofit().
    }

    private ApiService servicio;

    public LoginRepositorio getInstance() {
        if (instancia==null) {
            instancia = new LoginRepositorio();
        }
        return instancia;
    }



}
