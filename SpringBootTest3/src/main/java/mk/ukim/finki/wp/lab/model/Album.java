package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Data
@Entity
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;

    @OneToMany(mappedBy = "album")
    private List<Song> song;

    public Album(String name, String genre, String releaseYear) {
        //this.id = id;
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }


}
