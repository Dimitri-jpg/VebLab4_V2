package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("InMemorySongRepository")
public class InMemorySongRepository {

    //private List<Song> lista_pesni = new ArrayList<Song>(5);



    public List<Song> findAll(){
        return DataHolder.lista_pesni;
    }

    public Song findByTrackId(String trackId){
        /*for (Song song : lista_pesni){
            if(song.getTrackId().equals(trackId)){
                return song;
            }
        }
        return null;*/
        return DataHolder.lista_pesni.stream().filter(s->s.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    /*@Override
    public List<Song> listSongs() {
        return lista_pesni;
    }*/

    public Artist addArtistToSong(Artist artist, Song song){
        for (Song s : DataHolder.lista_pesni) {
            if (s.getTrackId().equals(song.getTrackId())) {
                s.addPerformer(artist);
                return artist;
            }
        }
        return null;
    }




}
