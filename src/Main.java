import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.*;

public class Main {

     static final String JDBC_URL = "jdbc:mysql://localhost:3306/JDBCdemo";
     static final String USER = "root";
     static final String PASSWORD = "root";

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Connected to database");

            Statement statement = connection.createStatement();

//            String insertUSerQuery = "INSERT INTO user(name,email) VALUES ('Ayyan','Ayyan@gmail.com')";

//            statement.executeUpdate(insertUSerQuery);

            String insertQuery = "INSERT INTO  user(name,email) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,"yoda");
            preparedStatement.setString(2,"yoda@gmail.com");
            preparedStatement.executeUpdate();

            String selectAllUsers = "SELECT * FROM user";

            PreparedStatement preparedStatementSelect = connection.prepareStatement(selectAllUsers);

            ResultSet resultSet = preparedStatementSelect.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("id : "+id +"name : "+name+" email : "+email);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException);
            sqlException.printStackTrace();
        }

    }
}