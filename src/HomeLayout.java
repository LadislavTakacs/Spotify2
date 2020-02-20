import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class HomeLayout extends VBox {

    public HomeLayout(ArrayList<String> names) throws FileNotFoundException {
//-------Top Image------------------------------------------------------------------------------------------------------
        Image image = new Image(new FileInputStream("res/PlaylistImg.jpg"));
        ImageView imageView = new ImageView(image);
        StackPane sp = new StackPane();
        sp.setAlignment(Pos.CENTER);
        sp.setPadding(new Insets(50,0,50,0));
        sp.getChildren().add(imageView);
//-------List view------------------------------------------------------------------------------------------------------
        ListView listView = new ListView();
        for (String name:names) {
            listView.getItems().add(name);
        }
        listView.setPadding(new Insets(0,0,0, 30));
        listView.setPrefWidth(100);
        listView.setMaxWidth(350);
        listView.setPrefWidth(360);
//----------------------------------------------------------------------------------------------------------------------
        this.getChildren().addAll(sp,listView);

    }

}
