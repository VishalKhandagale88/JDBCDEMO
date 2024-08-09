import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

     static final String JDBC_URL = "jdbc:mysql://localhost:3306";
     static final String USER = "root";
     static final String PASSWORD = "root";

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Connected to database");
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
            sqlException.printStackTrace();
        }

    }
}