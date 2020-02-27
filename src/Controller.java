

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import Connection.ConnectionClass;

public class Controller implements Initializable {

    ConnectionClass cn = ConnectionClass.getInstance();
    Connection connection = cn.getConnection();
    ObservableList<User> observableList = FXCollections.observableArrayList();

    @FXML
    TableView<User> tableView = new TableView();
    @FXML
    TableColumn<User, String> column_id;
    @FXML
    TableColumn<User, String> column_meno;
    @FXML
    TableColumn<User, String> column_priezvisko;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        column_id.setCellValueFactory(new PropertyValueFactory("id"));
        column_meno.setCellValueFactory(new PropertyValueFactory("name"));
        column_priezvisko.setCellValueFactory(new PropertyValueFactory("surname"));
        String sql = "select * from user;";
        try {
            Statement statement = connection.createStatement();
            column_id = new TableColumn<>("id");
            column_meno = new TableColumn<>("meno");
            column_priezvisko = new TableColumn<>("priezvisko");

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String meno = rs.getString("name");
                String priezvisko = rs.getString("surname");
                observableList.add(new User(id,meno, priezvisko));
            }


        } catch(SQLException e){
            e.printStackTrace();
        }

        tableView.setItems(observableList);
    }
}