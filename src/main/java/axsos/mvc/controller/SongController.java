package axsos.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import axsos.mvc.models.Song;
import axsos.mvc.service.SongService;

@Controller
public class SongController {
	public final SongService songService;

	public SongController(SongService songService) {
		super();
		this.songService = songService;
	}

	@GetMapping("/home")
	public String index() {
		return "index.jsp";
	}

	@GetMapping("/start")
	public String listAll(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "startPage.jsp";
	}

	@GetMapping("/addSong")
	public String addNew(@ModelAttribute("song") Song song) {
		return "addNew.jsp";
	}

	@PostMapping("/start")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "addNew.jsp";
		} else {
			songService.addSong(song);
			return "redirect:/start";
		}
	}

	@RequestMapping(value = "/songs/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Integer id) {
		songService.deleteSong(id);
		return "redirect:/start";
	}

	/*
	 * @RequestMapping("/song/artist") public String artistSongs (Model model ,
	 * String artist) { model.addAttribute("artist" , artist) ; return "" ; }
	 * 
	 * @PostMapping("/song/artist") public String search (@RequestParam("artist")
	 * String artits) { songService.findArtistSongs(artits) ;
	 * return"redirect:/song/artist" ; }
	 *
	 */
	@GetMapping("/Song/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/showSongs.jsp";
	}

	@GetMapping("/Song/top10")
	public String topSongs(Model model) {
		List<Song> topSongs = songService.findTopTen();
		model.addAttribute("topSongs", topSongs);
		return "/topSongs.jsp";
	}

	/*
	 * @PostMapping("/searchResult") public String search(@RequestParam("artist")
	 * String artist) { return "redirect:/searchResult"; }
	 */

	/*
	 * @GetMapping("/searchResult") public String searchResult(Model model, String
	 * artist) { List<Song> list = songService.findAtristSong(artist);
	 * System.out.println("song is" + list); model.addAttribute("songs", list);
	 * model.addAttribute("artist", artist); return "/search.jsp"; }
	 */

	@RequestMapping("/songs/search")
	public String searchResult(@RequestParam("artist") String artist, Model model) {
		List<Song> songs = songService.findAtristSong(artist);
		model.addAttribute("songs", songs);
		model.addAttribute("artist", artist);
		return "/search.jsp";
	}

}
