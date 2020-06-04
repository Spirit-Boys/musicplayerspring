package ydhl.eb.ez.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ydhl.eb.ez.model.Song;
import ydhl.eb.ez.service.Result;

@Repository
public interface SongRepository extends MongoRepository<Song, String> {
	public Result<List<Song>> findByTitle(String title);
	public Result<List<Song>> findBySinger(String singer);	
}
