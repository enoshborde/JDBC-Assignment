package jdbc1;
import java.sql.*;

public class DbConnection {

 

    private static String DB_URL = "jdbc:mysql://localhost:3306/jnit";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "root";

 
    public static Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        return connection;

    }

}
