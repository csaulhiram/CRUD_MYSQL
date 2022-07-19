package datos;

import static datos.Conexion.getConnection;
import Domain.User;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {

    public static String SQL_SELECT = "SELECT * FROM usuarios";
    public static String SQL_INSERT = "INSERT INTO usuarios(username, password) VALUES(?, ?)";
    public static String SQL_UPDATE = "UPDATE usuarios SET username = ?, password = ? WHERE id_user = ?";
    public static String SQL_DELETE = "DELETE FROM usuarios WHERE id_user = ?";

    public List<User> selectQuery() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        List<User> users = new ArrayList<>();

        try {
            conn = getConnection(); // Database connection
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

    public int insertQuery(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;

        try {
            conn = getConnection(); // We connect with Database
            stmt = conn.prepareStatement(SQL_INSERT); // We prepare SQL sentence
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            registers = stmt.executeUpdate();// We execute Query

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {// Close conections
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registers;
    }

    public int updateQuery(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;

        try {
            conn = getConnection(); // We connect with Database
            stmt = conn.prepareStatement(SQL_UPDATE); // We prepare SQL sentence
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getId_user());

            registers = stmt.executeUpdate();// We execute Query

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {// Close conections
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registers;
    }

    public int deleteQuery(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registers = 0;

        try {
            conn = getConnection(); // We connect with Database
            stmt = conn.prepareStatement(SQL_DELETE); // We prepare SQL sentence
            stmt.setInt(1, user.getId_user());

            registers = stmt.executeUpdate();// We execute Query

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {// Close conections
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registers;
    }
}
