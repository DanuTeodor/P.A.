package Lab8;

import java.sql.*;

public class AlbumController {
    private Connection conn;

    public AlbumController(Connection conn) {
        this.conn = conn;
    }

    public void create(String name, int artistId, int releaseYear) {
        try {
            PreparedStatement prep = conn.prepareStatement("insert into albums columns(name, artist_id, release_year)values(?,?,?)");
            prep.setString(1, name);
            prep.setInt(2, artistId);
            prep.setInt(3, releaseYear);
            prep.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Naspa, am gasit eroarea 1 " + e);
        }
    }

    public void findByArtist(int artistId) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from albums where artist_id=" + artistId);
            boolean ok = false;
            while (resultSet.next() == true) {
                ok = true;
                System.out.println("Am gasit albumul cerut");
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("name: " + resultSet.getString("name"));
                System.out.println("artist_id: " + resultSet.getInt("artist_id"));
                System.out.println("release_year: " + resultSet.getInt("release_year"));
            }
            if(ok ==  false){
                System.out.println("Nu l-am gasit");
            }
        } catch (SQLException e) {
            System.err.println("Naspa, am gasit eroarea: 2 " + e);
        }
    }
}
