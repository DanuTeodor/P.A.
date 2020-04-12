package Lab8;

import java.sql.*;

public class ArtistController {
    private Connection conn;

    public ArtistController(Connection conn) {
        this.conn = conn;
    }

    public void create(String name, String country) {
        try {
            PreparedStatement prep = conn.prepareStatement("insert into artists columns(name, country)values(?,?)");
            prep.setString(1, name);
            prep.setString(2, country);
            prep.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Naspa, am gasit eroarea 3 " + e);
        }
    }

    public void findByName(String name) {
        try {
            boolean ok = false;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from artists where name like " + "'" + name + "'");

            while (resultSet.next() == true) {
                ok = true;
                System.out.println("L-am gasit pe " + name);
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("name: " + resultSet.getString("name"));
                System.out.println("country: " + resultSet.getString("country"));
            }
            if(ok == false){
                System.out.println("Nu am gasit boss");
            }
        } catch (SQLException e) {
            System.err.println("Naspa, am gasit eroarea 4 " + e);
        }
    }
}
