package Lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    public static Connection connection;

    public static Connection getConn() {
        if(connection != null) {
            return connection;
        }

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "teo", "sql");
            return connection;
        } catch (SQLException e) {
            System.err.println("Eroare la crearea conexiunii: " + e);
        }
        return  null;
    }
}


