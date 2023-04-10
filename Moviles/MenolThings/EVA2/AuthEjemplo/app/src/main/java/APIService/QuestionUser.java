package APIService;

public class QuestionUser {
    private String nombre,password;

    public QuestionUser(String nombre,String password) {
        this.nombre=nombre;
        this.password=password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
