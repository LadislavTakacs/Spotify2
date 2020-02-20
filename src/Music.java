
import javafx.scene.media.Media;

public class Music {
   private String name;
    private String artist;
    private Media music;

    public Music(){
        this.name = "";
        this.artist = "";
    }


    public Music(String name, String artist, Media music){
        this.name = name;
        this.artist = "Hugh Laurie";
        this.music = music;
    }

    public Media getMusic() {
        return music;
    }
    public void setMusic(Media music) {
        this.music = music;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
}

