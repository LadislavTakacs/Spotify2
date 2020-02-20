import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MusicManager {
    Music music = new Music();
    ArrayList<Music> allmusic;

    public MusicManager() throws IOException {
        allmusic = new ArrayList();
        loadMusic(allmusic);
        loadData();
    }


    private void loadFiles(File folder,ArrayList allMusic) throws IOException {
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                final JFXPanel fxPanel = new JFXPanel();
                Media m = new Media(Paths.get(file.getCanonicalPath()).toUri().toString());
                System.out.println(file.getCanonicalPath());
                allMusic.add(new Music(file.getName(),file.getName(),m));
            }
        }
    }

    private void loadMusic(ArrayList allMusic) throws IOException {
        File folder = new File("music");
        loadFiles(folder,allMusic);
    }

    public ObservableList loadData(){
        ObservableList<Music> music = FXCollections.observableArrayList();
        for (Music music1 : allmusic) {
            music.add(music1);
        }
        return music;
    }

    public ArrayList<String> getAllNames(){
        ArrayList<String> temp = new ArrayList();
        for (int i = 0; i <allmusic.size()-1 ; i++) {
            temp.add(allmusic.get(i).getName());
        }
        return temp;
    }

}
