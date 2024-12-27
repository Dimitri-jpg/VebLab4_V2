package mk.ukim.finki.wp.lab.service.implement;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.InMemoryArtistRepository;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImplement implements ArtistService {
    private final InMemoryArtistRepository artistRepository;

    public ArtistServiceImplement(InMemoryArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) { return artistRepository.findById(id).orElse(null); }
}
