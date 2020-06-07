package ydhl.eb.ez.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ydhl.eb.ez.model.Frequency;
import ydhl.eb.ez.model.Song;
import ydhl.eb.ez.service.Result;
import ydhl.eb.ez.service.SongService;




@RestController
@RequestMapping
public class SongController {
	private static final Logger logger = LoggerFactory.getLogger(SongController.class);
	
	@Autowired
	private SongService service;
	
	@GetMapping("/songs")
	public Result<List<Frequency>> getLikeSongs() {
		logger.info("正在查找喜欢的歌曲信息..."); 
		Result<List<Frequency>> result = new Result<List<Frequency>>();
		List<Frequency> songs = service.getLikeSongs();
		result = result.ok();
		result.setData(songs);
		return result;
	}
	
	@GetMapping("/songs/history")
	public Result<List<Frequency>> getListenLot(){
		logger.info("正在查找听过歌曲信息...");
		Result<List<Frequency>> result = new Result<List<Frequency>>();
		List<Frequency> songs = service.getHistorySongs();
		result = result.ok();
		result.setData(songs);
		return result;
		
	}
	
	@GetMapping("/songs/random")
	public List<Song> getRandom(){
		logger.info("随机推荐歌曲...");
		List<Song> songs = service.getRandomSongs(service.getAllSongs(),service.getAllSongs().size());
		return songs;
	}
	
	@GetMapping("/search/name/{title}")
	public Result<List<Song>> searchSongByTitle(@PathVariable String title) {
		logger.info("正在查找指定歌曲名的歌曲信息...");
		return service.searchSongByTitle(title);
	}

	@GetMapping("/search/singer/{quality}")
	public Result<List<Song>> searchSongBySinger(@PathVariable String singer) {
		logger.info("正在查找指定歌手的歌曲信息...");
		return service.searchSongBySinger(singer);
	}
	
	@GetMapping("/search/hot")
	public Result<List<Frequency>> searchHot() {
		logger.info("正在查找热门搜索的歌曲信息...");
		Result<List<Frequency>> result = new Result<List<Frequency>>();
		List<Frequency> songs = service.getSearchMoreSongs();
		result = result.ok();
		result.setData(songs);
		return result;
	}
}
