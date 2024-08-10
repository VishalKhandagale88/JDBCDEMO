package crud;

import crud.domain.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO -> Data access object
// jo data
public class UserDAO {
    // create
    public void createUser(String name, String email) {
        String createUserQuery = "INSERT INTO USER (name,email) VALUES (?,?) ";
        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(createUserQuery)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);

            preparedStatement.executeUpdate();

            System.out.println("User " + name + " is created");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    // read
    public List<Users> getAllUsers() {
        List<Users> usersList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                usersList.add(new Users(id, name, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    // update

    public void updateUser(int id, String name, String email) {
        String sql = "UPDATE user SET name = ? , email = ? WHERE id = ?";
        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,email);
            preparedStatement.setInt(3,id);

            int rowsEffected = preparedStatement.executeUpdate();
            if(rowsEffected > 0){
                System.out.println("User data updated");
            }else {
                System.out.println("user not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Delete
    public void deleteUser(int id){
        String sql = "DELETE FROM user WHERE id = ?";
        try(
                Connection connection = DataBaseUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1,id);
            int rowsEffected = preparedStatement.executeUpdate();
            if(rowsEffected > 0){
                System.out.println("user with id = "+id+" is removed");
            }else {
                System.out.println("user not found");
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
