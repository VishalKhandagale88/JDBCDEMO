package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    static final String USER = "root";
    static final String PASSWORD = "root";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
    }
}
