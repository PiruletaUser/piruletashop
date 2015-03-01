package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection conn;

    public static Connection getConnection() throws SQLException {

        try {
            conn = DriverManager.getConnection("jdbc:mysql://db4free.net/piruletashopdb", "piruletashopuser", "piruleta123");
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print(e.getMessage());
        }

        return conn;
    }

    public static boolean closeConnection() {

        if (conn != null) {

            try {
                conn.close();
                return true;
            } catch (SQLException e) {
                //JOptionPane.showMessageDialog(null, e.getMessage());
                System.out.print(e.getMessage());
            }
        }

        return false;
    }
}
