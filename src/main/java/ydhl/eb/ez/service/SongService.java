package ydhl.eb.ez.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ydhl.eb.ez.dao.SongRepository;
import ydhl.eb.ez.model.Song;

public class SongService {
	public static final Logger logger = LoggerFactory.getLogger(SongService.class);
	
	@Autowired
	private SongRepository repo;

	public List<Song> getLikeSongs() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Result<List<Song>> searchSongByTitle(String title) {
		return repo.findByTitle(title);
	}

	public Result<List<Song>> searchSongBySinger(String singer) {
		return repo.findBySinger(singer);
	}
}

