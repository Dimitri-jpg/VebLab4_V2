package mk.ukim.finki.wp.lab.service.implement;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImplement implements SongService {
    private final SongRepository songRepository;

    public SongServiceImplement(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() { return songRepository.findAll(); }

    @Override
    public Song addArtistToSong(Artist artist, Song song) {
        //return songRepository.addArtistToSong(artist, song);

        for (Song s : DataHolder.lista_pesni) {
            if (s.getTrackId().equals(song.getTrackId())) {
                s.addPerformer(artist);
                //return artist;
                songRepository.save(s);
                return s;
            }
        }
        return null;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }
}
