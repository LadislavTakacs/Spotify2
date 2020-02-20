import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PlayLayout extends VBox {

    Button play,back;

    public PlayLayout(MusicManager mm, BorderPane defaultLayout,VBox lastLayout,Music music) throws FileNotFoundException {
//-------Top Image------------------------------------------------------------------------------------------------------
        Image image = new Image(new FileInputStream("res/hugh.jpg"));
        ImageView imageView = new ImageView(image);
        StackPane sp = new StackPane();
        sp.setAlignment(Pos.CENTER);
        sp.setPadding(new Insets(50,0,50,0));
        sp.getChildren().add(imageView);
//-------Name------------------------------------------------------------------------------------------------------
        StackPane label = new StackPane();
        Label name = new Label();
        name.setFont(Font.font(20));
        name.setText(music.getName());
        label.getChildren().add(name);
        label.setAlignment(Pos.CENTER);
//-------Buttons------------------------------------------------------------------------------------------------------
        play = new Button("Play");
        play.setPrefSize(190,100);
        play.setFont(Font.font(20));
        play.setStyle("-fx-background-color: #222327; -fx-text-fill: white;");
        MediaPlayer player = new MediaPlayer(music.getMusic());
        play.setOnAction(e-> player.play());

        back = new Button("Back");
        back.setStyle("-fx-background-color: #222327; -fx-text-fill: white;");
        back.setOnAction(e -> {player.pause();defaultLayout.setCenter(lastLayout);});
        back.setPrefSize(190,100);
        back.setFont(Font.font(20));

        HBox box = new HBox();
        box.getChildren().addAll(play,back);
        box.setAlignment(Pos.BOTTOM_CENTER);
        box.setPadding(new Insets(200,0,0,0));
//----------------------------------------------------------------------------------------------------------------------
        this.getChildren().addAll(sp,label,box);

    }

}
