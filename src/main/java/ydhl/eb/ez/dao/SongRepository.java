package ydhl.eb.ez.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ydhl.eb.ez.model.Song;

@Repository
public interface SongRepository extends MongoRepository<Song, String> {
	public List<Song> findByTitle(String title);
	public List<Song> findBySinger(String singer);	
}
