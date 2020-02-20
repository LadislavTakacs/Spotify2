import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.io.FileNotFoundException;

public class FavoritesLayout extends VBox {

    public FavoritesLayout(MusicManager mm,ObservableList music, BorderPane defaultLayout) {
//-------Top Label------------------------------------------------------------------------------------------------------
        StackPane sp = new StackPane();
        Label error = new Label("Top Ten");
        error.setFont(Font.font(30));
        sp.setAlignment(Pos.CENTER);
        sp.setPadding(new Insets(30, 50, 30, 50));
        sp.getChildren().add(error);
//-------Table view-----------------------------------------------------------------------------------------------------
        StackPane sp1 = new StackPane();
        TableView<Music> table = new TableView<>();

        TableColumn<Music,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(230);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Music,String>("name"));

        TableColumn<Music,String> artistColumn = new TableColumn<>("Artist");
        artistColumn.setMinWidth(130);
        artistColumn.setCellValueFactory(new PropertyValueFactory<Music,String>("artist"));


        table.setItems(music);
        table.getColumns().addAll(nameColumn,artistColumn);
        table.setPrefHeight(450);
//-------Play button----------------------------------------------------------------------------------------------------
        Button play = new Button("play");
        play.setPrefWidth(380);
        play.setStyle("-fx-background-color: #121212;-fx-text-fill: white;");
        play.setOnAction(e -> {
            try {
                defaultLayout.setCenter(new PlayLayout(mm,defaultLayout,this,table.getSelectionModel().getSelectedItem()));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        sp1.getChildren().addAll(table);
        sp1.setPadding(new Insets(40,0,0,0));
//----------------------------------------------------------------------------------------------------------------------
        this.getChildren().addAll(sp,sp1,play);
    }

}
