package test;

import Domain.User;
import datos.UsuarioDAO;
import java.util.List;


public class main {
    public static void main(String[] args) {
        UsuarioDAO user = new UsuarioDAO();
        List<User> users = null;
        users = user.selectQuery();
        listUsers(users);
    }
    
        public static void listUsers(List<User> users) {
        for (User user : users) {
            System.out.println("persona: " + user);
        }
    }
}
