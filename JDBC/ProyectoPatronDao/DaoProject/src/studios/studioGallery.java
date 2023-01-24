package studios;

public class studioGallery {
    public static studioInterface getStudioDao(){
        return new studiosBean();
    }
}
