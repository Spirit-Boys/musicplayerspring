package ydhl.eb.ez.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping
	public Result<List<Song>> getLikeSongs() {
		logger.info("���ڲ���ϲ��������Ϣ...");
		Result<List<Song>> result = new Result<List<Song>>();
		List<Song> songs = service.getLikeSongs();
		result = result.ok();
		result.setData(songs);
		return result;
	}
	
	@GetMapping("/history")
	public Result<List<Song>> getListenLot(){
		logger.info("���ڲ������ö�ĸ�����Ϣ..."); 
		Result result = null;
		return result;
	}
	
	@GetMapping("/random")
	public Result<List<Song>> getRandom(){
		logger.info("����Ƽ�����...");
		Result result = null;
		return result;
	}
	
	@GetMapping("/name/{title}")
	public Result<List<Song>> searchSongByTitle(@PathVariable String title) {
		logger.info("���ڲ���ָ���������ĸ�����Ϣ...");
		return service.searchSongByTitle(title);
	}

	@GetMapping("/singer/{quality}")
	public Result<List<Song>> searchSongBySinger(@PathVariable String singer) {
		logger.info("���ڲ���ָ�����ֵĸ�����Ϣ...");
		return service.searchSongBySinger(singer);
	}
}
