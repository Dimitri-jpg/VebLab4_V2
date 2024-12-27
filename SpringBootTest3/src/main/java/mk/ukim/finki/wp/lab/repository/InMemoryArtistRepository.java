package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("InMemoryArtistRepository")
public class InMemoryArtistRepository {
    //private List<Artist> lista_artisti = new ArrayList<Artist>(5);

    /*public ArtistRepository() {
        //Artist artist = new Artist(11L, "a", "b", "v");
        lista_artisti.add(new Artist (11L, "a", "b", "v"));
        lista_artisti.add(new Artist (110L, "aa", "bb", "vv"));
        lista_artisti.add(new Artist (1100L, "aaa", "bbb", "vvv"));
        lista_artisti.add(new Artist (11000L, "aaaa", "bbbb", "vvvv"));
        lista_artisti.add(new Artist (110000L, "aaaaa", "bbbbb", "vvvvv"));
    }*/

    public List<Artist> findAll(){
        return DataHolder.lista_artisti;
    }

    public Optional<Artist> findById(Long id){
        /*for(Artist a : lista_artisti){
            if(a.getId() == id){
                return Optional.of(a);
            }
        }
        return Optional.empty();*/
        return DataHolder.lista_artisti.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }

    /*@Override
    public List<Artist> listArtists() {
        return lista_artisti;
    }*/

    /*@Override
    public Artist findById(Long id) {
        return null;
    }*/


    /*public Song findByTrackId(String trackId){
        for(int i = 0; i < lista.size(); i++){
            if(lista[i].)
        }
    }*/
}
