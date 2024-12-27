package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.Getter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Entity
public class Song {

    public static Long idCounter = 0L;

    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Artist> performers;

    @ManyToOne
    private Album album;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<>();
        this.album = album;

        this.id = generateUniqueId();
    }

    private static synchronized Long generateUniqueId() {
        return ++idCounter;  // Increment the counter for each new ID
    }


    public Song(){}

    public void addPerformer(Artist performer) {
        performers.add(performer);
    }

    /*public String getId(){
        return trackId;
    }*/

}
