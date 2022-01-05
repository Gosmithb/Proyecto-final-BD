
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ConexionAServidor {
    
    public static final String URL = "jdbc:mysql://127.0.0.1/sistema_prestamos";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public static Connection getConection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar" + e);
        }

        return con;
    }
}
