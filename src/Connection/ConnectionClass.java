package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
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
