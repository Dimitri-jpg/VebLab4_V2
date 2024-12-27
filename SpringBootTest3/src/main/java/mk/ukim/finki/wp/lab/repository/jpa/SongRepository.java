package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository <Song, Long> {
    List<Song> findAllByAlbum_Id(Long albumId);

    Song findByTrackId(String trackId);

    //Artist addArtistToSong(Artist artist, Song song);
    //Song findByTrackId(String trackId);
}
