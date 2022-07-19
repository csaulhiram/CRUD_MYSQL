package datos;

import static datos.Conexion.getConnection;
import Domain.User;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {

    public static String SQL_SELECT = "SELECT * FROM usuarios";
    public static String SQL_INSERT = "INSERT INTO usuarios(username, password) VALUES(?, ?)";
    public static String SQL_UPDATE = "UPDATE usuarios SET username = ?, password = ? WHERE id_usuario = ?";
    public static String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario = ?";
    
    
      public List<User> selectQuery() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        List<User> users = new ArrayList<>();

        try {
            conn = getConnection(); // We connect with Database
            stmt = conn.prepareStatement(SQL_SELECT); // We prepare SQL sentence

            rs = stmt.executeQuery();// We execute Query

            while (rs.next()) { // Get registers
                int idUser = rs.getInt("id_user");
                String username = rs.getString("username");
                String password = rs.getString("password");

                // Create object type User
                user = new User(idUser, username, password);
                // We add an element at the ArrayList
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {// Close conections
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return users;
    }

}
