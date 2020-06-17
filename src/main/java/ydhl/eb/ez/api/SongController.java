package ydhl.eb.ez.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		logger.info("即将新建数据:" + c);
		Result<Song> result = new Result<Song>();
		Song saved = service.createSong(c);
		result = result.ok();
		result.setData(saved);
		return result;
	}
	
	@GetMapping
	public Result<List<Song>> getLikeSongs() {
		logger.info("正在查找喜欢的歌曲信息..."); 
		Result<List<Song>> result = new Result<List<Song>>();
		List<Song> songs = service.getLikeSongs();
		result = result.ok();
		result.setData(songs);
		return result;
	}
	
	@GetMapping("/preference")
	public List<Song> getPreSongs() {
		logger.info("正在推荐偏好的歌曲信息...");
		List<Song> songs = service.getPreSongs();
		String singer = songs.get(0).getSinger();	
		return service.searchSongBySinger(singer);
	}
	
	@GetMapping("/history")
	public Result<List<Song>> getListenLot(){
		logger.info("正在查找歌曲信息...");
		Result<List<Song>> result = new Result<List<Song>>();
		List<Song> songs = service.getHistorySongs();
		result = result.ok();
		result.setData(songs);
		return result;
	}
	
	@GetMapping("/random")
	public List<Song> getRandom(){
		logger.info("随机推荐歌曲...");
		List<Song> songs = service.getRandomSongs(service.getAllSongs(),service.getAllSongs().size());
		return songs;
	}
	
	@GetMapping("/search/title/{title}")
	public List<Song> searchSongByTitle(@PathVariable String title) {
		logger.info("正在查找指定歌曲名的歌曲信息...");
		return service.searchSongByTitle(title);
	}

	@GetMapping("/search/singer/{singer}")
	public List<Song> searchSongBySinger(@PathVariable String singer) {
		logger.info("正在查找指定歌手的歌曲信息...");
		return service.searchSongBySinger(singer);
	}
	
	@GetMapping("/search/hot")
	public Result<List<Song>> searchHot() {
		logger.info("正在查找热门搜索的歌曲信息...");
		Result<List<Song>> result = new Result<List<Song>>();
		List<Song> songs = service.getSearchMoreSongs();
		result = result.ok();
		result.setData(songs);
		return result;
	}
}
