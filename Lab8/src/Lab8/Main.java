package Lab8;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Connection conn = Database.getConn();
        ArtistController artistController = new ArtistController(conn);
        AlbumController albumController = new AlbumController(conn);

        artistController.create("abc","ro");
        System.out.println("Afisam rezultatele despre artistul cu numele Killa Fonic");
        artistController.findByName("Killa Fonic");
        System.out.println("Afisam rezultatele despre albumele artistului cu ID-ul 1");
        albumController.findByArtist(1);

        artistController.findByName("NOSFE");
        albumController.findByArtist(23);
    }
}
