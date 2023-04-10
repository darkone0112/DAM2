package videoGames;

public class VideogameGallery {
    //gallery class will implement interface VideogameInterface
    public static VideogameInterface getVideogameDao(){
        return new VideogameBean();
    }
}
