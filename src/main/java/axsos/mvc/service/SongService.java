package axsos.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import axsos.mvc.models.Song;
import axsos.mvc.repository.SongRepository;

@Service
public class SongService {
	public final SongRepository songRepo;

	public SongService(SongRepository songRepo) {
		this.songRepo = songRepo;
	}

	public List<Song> allSongs() {
		return songRepo.findAll();
	}

	public Song addSong(Song song) {
		return songRepo.save(song);
	}

	public void deleteSong(int id) {
		Song song = findSong(id);
		songRepo.delete(song);
	}

	public Song findSong(int id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}

	public List<Song> findTopTen() {
		return songRepo.findFirst10ByOrderByRatingDesc();
	}

	public List<Song> findAtristSong(String artist) {
		return songRepo.findByArtistContaining(artist) ; 
	}
}
