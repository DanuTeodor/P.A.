package app;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;

public class AlbumManager {
    public static void main(String[] args) {
        ArtistRepository artistRepository = new ArtistRepository();
        AlbumRepository albumRepository = new AlbumRepository();

        Artist artist = new Artist("Killa Fonic", "Romania");
        Album album = new Album("Lama crima", 1, 2018);

        artistRepository.create(artist);
        albumRepository.create(album);

        System.out.println(artistRepository.findById(1));
        artistRepository.findByName("Killa Fonic").stream().forEach(System.out::println);

        System.out.println(albumRepository.findById(1));
        albumRepository.findByName("Lama crima").stream().forEach(System.out::println);
        albumRepository.findByArtist(artist).stream().forEach(System.out::println);
    }
}