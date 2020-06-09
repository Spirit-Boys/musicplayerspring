package ydhl.eb.ez.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ydhl.eb.ez.dao.SongRepository;
import ydhl.eb.ez.model.Frequency;
import ydhl.eb.ez.model.Song;

@Service
public class SongService {
	public static final Logger logger = LoggerFactory.getLogger(SongService.class);
	
	@Autowired
	private SongRepository repo;
	
	public List<Song> getAllSongs() {
		logger.debug("从数据库读取所有音乐。。。");
		return repo.findAll();
	}

	public List<Song> getHistorySongs() {
		List<Song> result = null;
		List<Song> saved = getAllSongs();
		for(int i = 0; i < saved.size(); i++) {
			saved.get(i).getFrequencys().sort(new Comparator<Frequency>() {
				@Override
				public int compare(Frequency o1, Frequency o2) {
					int re = 0;
					if (o1.getPlay() < o2.getPlay()) {
						re = 1;
					} else if (o1.getPlay() > o2.getPlay()) {
						re = -1;
					}
					return re;
				}
			});
		}
			return result;
	}
	
	public Result<List<Song>> searchSongByTitle(String title) {
		return repo.findByTitle(title);
	}

	public Result<List<Song>> searchSongBySinger(String singer) {
		return repo.findBySinger(singer);
	}

	public List<Song> getLikeSongs() {
		List<Song> result = null;
		List<Song> saved = getAllSongs();
		for(int i = 0; i < saved.size(); i++) {
			saved.get(i).getFrequencys().sort(new Comparator<Frequency>() {
				@Override
				public int compare(Frequency o1, Frequency o2) {
					int re = 0;
					if (o1.getPlay() < o2.getPlay()) {
						re = 1;
					} else if (o1.getPlay() > o2.getPlay()) {
						re = -1;
					}
					return re;
				}
			});
			if (result.size() > 10) {
				result = result.subList(0, 10);
			}
		}
		return result;
	}

	public List<Song> getSearchMoreSongs() {
		List<Song> result = null;
		List<Song> saved = getAllSongs();
		for(int i = 0; i < saved.size(); i++) {
			saved.get(i).getFrequencys().sort(new Comparator<Frequency>() {
				@Override
				public int compare(Frequency o1, Frequency o2) {
					int re = 0;
					if (o1.getSearch() < o2.getSearch()) {
						re = 1;
					} else if (o1.getSearch() > o2.getSearch()) {
						re = -1;
					}
					return re;
				}
			});
			if (result.size() > 10) {
				result = result.subList(0, 10);
			}
		}
		return result;
	}

	public List<Song> getRandomSongs(List<Song> list,int count){
		List<Song> backList = null;
		backList = new ArrayList<Song>();
		Random random = new Random();
		int backSum = 0;
		if (list.size() >= count) {
			backSum = count;
		}else {
			backSum = list.size();
		}
		for (int i = 0; i < backSum; i++) {
//			随机数的范围为0-list.size()-1
			int target = random.nextInt(list.size());
			backList.add(list.get(target));
			list.remove(target);
		}
		return backList;
	}

	public List<Song> getPreSongs() {
		List<Song> result = null;
		List<Song> saved = getAllSongs();
		for(int i = 0; i < saved.size(); i++) {
			saved.get(i).getFrequencys().sort(new Comparator<Frequency>() {
				@Override
				public int compare(Frequency o1, Frequency o2) {
					int re = 0;
					if (o1.getPlay() < o2.getPlay()) {
						re = 1;
					} else if (o1.getPlay() > o2.getPlay()) {
						re = -1;
					}
					return re;
				}
			});
			if (result.size() > 1) {
				result = result.subList(0, 1);
			}
		}
		return result;
	}
}


