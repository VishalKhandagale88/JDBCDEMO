package crud;

import crud.domain.Users;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final UserDAO userDAO = new UserDAO();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1 . create user");
            System.out.println("2 . view all users");
            System.out.println("3 . update user");
            System.out.println("4 . delete user");
            System.out.println("5 . exit");
            int choice = sc.nextInt();

            switch (choice){
                case 1 :
                    String l = sc.nextLine();

                    System.out.println("Enter user name");
                    String name = sc.nextLine();
                    System.out.println("Enter user email");
                    String email = sc.nextLine();
                    userDAO.createUser(name,email);
                    break;
                case 2:
                    List<Users> usersList = userDAO.getAllUsers();
                    usersList.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("enter user id");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("enter user name");
                    String updateUserName = sc.nextLine();
                    System.out.println("enter user email");
                    String updateUserEmail= sc.nextLine();
                    userDAO.updateUser(id,updateUserName,updateUserEmail);
                    break;
                case 4 :
                    System.out.println("Enter user id to delete");
                    int deleteUserID = sc.nextInt();
                    userDAO.deleteUser(deleteUserID);
                    break;
                case 5 :
                    System.out.println("Exiting........");
                    return;
            }

        }
    }
}
