package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AlbumRepository")
public class InMemoryAlbumRepository {

    public List<Album> findAll(){
        return DataHolder.lista_albumi;
    }
}
