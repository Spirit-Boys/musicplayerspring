package ydhl.eb.ez.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ydhl.eb.ez.model.Song;
import ydhl.eb.ez.service.Result;
import ydhl.eb.ez.service.SongService;




@RestController
@RequestMapping("/songs")
public class SongController {
	private static final Logger logger = LoggerFactory.getLogger(SongController.class);
	
	@Autowired
	private SongService service;
	
	@PostMapping
	public Result<Song> createSong(@RequestBody Song c) {
		logger.info("�����½�����:" + c);
		Result<Song> result = new Result<Song>();
		Song saved = service.createSong(c);
		result = result.ok();
		result.setData(saved);
		return result;
	}
	
	@DeleteMapping("/{id}")
	public Result<Song> deleteSong(@PathVariable String id) {
		logger.info("����ɾ��:id=" + id);
		Result<Song> result = new Result<Song>();
		boolean del = service.deleteSong(id);
		if (del) {
			result = result.ok();
		} else {
			result.setStatus(Result.ERROR); 
			result.setMessage("ɾ��ʧ��"); 
		}
		return result;
	}
	
	@PutMapping
	public Result<Song> updateSong(@RequestBody Song c) {
		logger.info("������������" + c);
		Result<Song> result = new Result<Song>();
		Song updated = service.updateSong(c);
		result = result.ok();
		result.setData(updated);
		return result;
	}
	
	@GetMapping
	public Result<List<Song>> getLikeSongs() {
		logger.info("���ڲ���ϲ���ĸ�����Ϣ..."); 
		Result<List<Song>> result = new Result<List<Song>>();
		List<Song> songs = service.getLikeSongs();
		result = result.ok();
		result.setData(songs);
		return result;
	}
	
	@GetMapping("/preference")
	public Result<List<Song>> getPreSongs() {
		logger.info("�����Ƽ�ƫ�õĸ�����Ϣ...");
		List<Song> songs = service.getPreSongs();
		String singer = songs.get(0).getSinger();	
		return service.searchSongBySinger(singer);
	}
	
	@GetMapping("/history")
	public Result<List<Song>> getListenLot(){
		logger.info("���ڲ�������������Ϣ...");
		Result<List<Song>> result = new Result<List<Song>>();
		List<Song> songs = service.getHistorySongs();
		result = result.ok();
		result.setData(songs);
		return result;
	}
	
	@GetMapping("/random")
	public List<Song> getRandom(){
		logger.info("����Ƽ�����...");
		List<Song> songs = service.getRandomSongs(service.getAllSongs(),service.getAllSongs().size());
		return songs;
	}
	
	@GetMapping("/search/title/{title}")
	public Result<List<Song>> searchSongByTitle(@PathVariable String title) {
		logger.info("���ڲ���ָ���������ĸ�����Ϣ...");
		return service.searchSongByTitle(title);
	}

	@GetMapping("/search/singer/{singer}")
	public Result<List<Song>> searchSongBySinger(@PathVariable String singer) {
		logger.info("���ڲ���ָ�����ֵĸ�����Ϣ...");
		return service.searchSongBySinger(singer);
	}
	
	@GetMapping("/search/hot")
	public Result<List<Song>> searchHot() {
		logger.info("���ڲ������������ĸ�����Ϣ...");
		Result<List<Song>> result = new Result<List<Song>>();
		List<Song> songs = service.getSearchMoreSongs();
		result = result.ok();
		result.setData(songs);
		return result;
	}
}
