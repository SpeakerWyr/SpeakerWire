package Api.SpeakerWyr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api.SpeakerWyr.models.Genre;
import Api.SpeakerWyr.repos.GenreRepository;

@Service
public class GenreService {

	@Autowired
	GenreRepository genreRepo;
	
	public Genre addGenre(Genre genre) {
		return genreRepo.save(genre);
	}
	
	public List<Genre> fetchGenres() {
		List<Genre> genres = (List<Genre>) genreRepo.findAll();
		
		return genres;
	}
	
	public Genre fetchGenre(long id) {
		Optional<Genre> retrievedGenre = genreRepo.findById(id);
		return retrievedGenre.get();
	}

	public void removeGenre(Genre genre) {
		genreRepo.delete(genre);
		
	}
	
}
