import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;


public class SearchLayout extends VBox {

    public SearchLayout() throws FileNotFoundException {

        StackPane sp = new StackPane();
        Label error = new Label();
        error.setFont(Font.font(30));
        sp.setAlignment(Pos.CENTER);
        sp.setPadding(new Insets(30,50,0,50));
        sp.getChildren().add(error);

        HBox box = new HBox();
        Label label = new Label("Search ");
        TextField search = new TextField();
        search.setPrefWidth(200);
        box.setSpacing(10);
        Button submit = new Button("");
        submit.setPrefSize(50,50);
        //submit.setStyle("-fx-background-color:red;");
        submit.setBackground(new ImageLoader().getSubmitBtnB());
        submit.setOnAction(e->{error.setText("Sorry Error 404");search.setText("");});
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(label,search,submit);



        this.setPadding(new Insets(75,10,0,10));
        this.setSpacing(10);
        this.getChildren().addAll(box,sp);

    }

}
