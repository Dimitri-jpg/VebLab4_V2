package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import org.springframework.stereotype.Component;
import mk.ukim.finki.wp.lab.repository.jpa.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> lista_artisti = new ArrayList<>();
    public static List<Song> lista_pesni = new ArrayList<>();

    public static List<Album> lista_albumi = new ArrayList<>();

    public static List<User> users = new ArrayList<>();

    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final UserRepository userRepository;

    public DataHolder(AlbumRepository albumRepository, SongRepository songRepository, UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
        this.userRepository = userRepository;

    }

    @PostConstruct
    public void init() {
        lista_artisti.add(new Artist (11L, "Marshall", "Mathers", "Last Project: 2024"));
        lista_artisti.add(new Artist (135L, "Lil", "Uzi", "Last Project: 2024"));
        lista_artisti.add(new Artist (119L, "Don", "Toliver", "Last Project: 2024"));
        lista_artisti.add(new Artist (999L, "Roddy", "Ricch", "Last Project: 2023"));
        lista_artisti.add(new Artist (16L, "Travis", "Scott", "Last Project: 2023"));

        lista_albumi.add(new Album("Pink Tape", "rap", "2010"));
        lista_albumi.add(new Album("Marshall Mathers LP", "rap", "2010"));
        lista_albumi.add(new Album("Hardstone Psycho", "rap", "2010"));
        lista_albumi.add(new Album("Utopia", "rap", "2010"));
        lista_albumi.add(new Album("Astroworld", "rap", "2010"));

        lista_pesni.add(new Song("011", "Stan", "Rap", 2000, lista_albumi.get(0)));
        lista_pesni.add(new Song("135", "Patience", "RnB", 2023, lista_albumi.get(1)));
        lista_pesni.add(new Song("119", "4x4", "RnB", 2024, lista_albumi.get(2)));
        lista_pesni.add(new Song("999", "The Box", "Hip Hop", 2019, lista_albumi.get(3)));
        lista_pesni.add(new Song("016", "I KNOW?", "Hip Hop", 2023, lista_albumi.get(4)));

        if (albumRepository.count() == 0 && songRepository.count() == 0) {
            Album album1 = new Album("Pink Tape", "rap", "2010");
            Album album2 = new Album("Marshall Mathers LP", "rap", "2010");
            Album album3 = new Album("Hardstone Psycho", "rap", "2010");
            Album album4 = new Album("Utopia", "rap", "2010");
            Album album5 = new Album("Astroworld", "rap", "2010");

            // Save albums to the database
            albumRepository.saveAll(Arrays.asList(album1, album2, album3, album4, album5));

            Song song1 = new Song("011", "Stan", "Rap", 2000, album1);
            Song song2 = new Song("135", "Patience", "RnB", 2023, album2);
            Song song3 = new Song("119", "4x4", "RnB", 2024, album3);
            Song song4 = new Song("999", "The Box", "Hip Hop", 2019, album4);
            Song song5 = new Song("016", "I KNOW?", "Hip Hop", 2023, album5);



            songRepository.saveAll(Arrays.asList(song1, song2, song3, song4, song5));
        }

        users = new ArrayList<>();
        if (this.userRepository.count() == 0) {
            users.add(new User("elena.atanasoska", "ea", "Elena", "Atanasoska"));
            users.add(new User("darko.sasanski", "ds", "Darko", "Sasanski"));
            users.add(new User("ana.todorovska", "at", "Ana", "Todorovska"));
            this.userRepository.saveAll(users);
        }


    }

}
