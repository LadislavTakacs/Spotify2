import Connection.ConnectionClass;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {
//Button Layout
    Button home,favorites,search;
    int prefHeight;
    int prefWidth;
    Label label;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MusicManager mm = new MusicManager();
        ImageLoader iL = new ImageLoader();

        primaryStage.setTitle("< Spotify");

        BorderPane baseLayout = new BorderPane();
        Scene defaultScene = new Scene(baseLayout,380,800);
//-------Top Label------------------------------------------------------------------------------------------------------
        StackPane sp = new StackPane();
        Label label = new Label("Spotify");
        label.setFont(Font.font(30));
        sp.setStyle("-fx-background-color:#222327;    -fx-font-family: \"ProximaNovaBlack\";");
        sp.setAlignment(Pos.TOP_LEFT);
        sp.setPadding(new Insets(15));
        sp.getChildren().add(label);
        baseLayout.setTop(sp);
//--------Bottom Buttons--------------------------------  ----------------------------------------------------------------
        HBox buttonLayout = new HBox();
        prefHeight = 100;
        prefWidth = 234;
        home = new Button();
       home.setBackground(iL.getHomeBtnB());
       home.setPrefSize(prefWidth,prefHeight);
        home.setOnAction(e -> {
            try {
                baseLayout.setCenter(new HomeLayout(mm.getAllNames()));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        search = new Button();
        search.setBackground(iL.getSearchBtnB());
        search.setPrefSize(prefWidth,prefHeight);
        search.setOnAction(e -> {
     //       try {
          //      baseLayout.setCenter(new SearchLayout());
         //   } catch (FileNotFoundException ex) {
        //        ex.printStackTrace();
       //     }

            ConnectionClass connectionClass = new ConnectionClass();
            Connection conn=connectionClass.getConnection();
            String sql="select * from product;";

            try {
                Statement statement = conn.createStatement();
                ResultSet resultSet=statement.executeQuery(sql);

                while(resultSet.next()){
                    System.out.println(resultSet.getString(2));
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });


        favorites = new Button();
        favorites.setBackground(iL.getFavoritesBtnB());
        favorites.setPrefSize(prefWidth,prefHeight);

        favorites.setOnAction(e -> baseLayout.setCenter(new FavoritesLayout(mm,mm.loadData(),baseLayout)));
        buttonLayout.setAlignment(Pos.BOTTOM_CENTER);
        buttonLayout.getChildren().addAll(home,search,favorites);
        buttonLayout.setStyle("-fx-background-color:#222327; ");
        baseLayout.setBottom(buttonLayout);
        defaultScene.getStylesheets().add("style.css");
//----------------------------------------------------------------------------------------------------------------------
        baseLayout.setCenter(new HomeLayout(mm.getAllNames()));
        primaryStage.setScene(defaultScene);
        primaryStage.show();
    }
}
