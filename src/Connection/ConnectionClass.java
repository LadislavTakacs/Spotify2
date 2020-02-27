package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    private  static ConnectionClass instance = new ConnectionClass();

    private ConnectionClass(){

    }
    public static ConnectionClass getInstance(){
        return instance;
    }
    Connection connection;

    public Connection getConnection(){

        String databaseName = "online_shop";
        String userName = "root";
        String password="";


        try {
           // Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/"+databaseName+"?useLegacyDatetimeCode=false&serverTimezone=America/New_York",userName,password);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }
}
