package axsos.mvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import axsos.mvc.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Integer> {
	List<Song> findAll();

	List<Song> findByArtistContaining(String artist);

	List<Song> findFirst10ByOrderByRatingDesc();
}
