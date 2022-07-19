package test;

import Domain.User;
import datos.UsuarioDAO;
import java.util.List;

public class main {

    public static void main(String[] args) {
        // SELECT QUERY
        System.out.println("****************************************");
        System.out.println("\t\tSELECT QUERY");
        System.out.println("****************************************");
        select();

        // INSERT QUERY
        System.out.println("****************************************");
        System.out.println("\t\tINSERT QUERY");
        System.out.println("****************************************");
        insert();

        // UPDATE QUERY
        System.out.println("****************************************");
        System.out.println("\t\tUPDATE QUERY");
        System.out.println("****************************************");
        update();

        // DELETE QUERY
        System.out.println("****************************************");
        System.out.println("\t\tDELETE QUERY");
        System.out.println("****************************************");
        delete();
    }

    public static void select() {
        UsuarioDAO userSelect = new UsuarioDAO();
        List<User> users = null;
        users = userSelect.selectQuery();
        listUsers(users);
    }

    public static void insert() {
        UsuarioDAO userInsert = new UsuarioDAO();
        User user = new User("New user 3", "password3");
        userInsert.insertQuery(user);

        // Print all users
        select();
    }

    public static void update() {
        UsuarioDAO userUpdate = new UsuarioDAO();
        User user = new User(1, "userNameChanged", "passwordChanged");
        userUpdate.updateQuery(user);

        // Print all users
        select();
    }

    public static void delete() {
        UsuarioDAO userDelete = new UsuarioDAO();
        User user = new User(6);
        userDelete.deleteQuery(user);

        // Print all users
        select();
    }

    public static void listUsers(List<User> users) {
        for (User user : users) {
            System.out.println("persona: " + user);
        }
    }
}
