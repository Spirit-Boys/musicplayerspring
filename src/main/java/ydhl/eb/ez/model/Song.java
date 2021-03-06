package ydhl.eb.ez.model;

public class Song {
	
	private String id;
	private String title; //������
	private String url; //���ŵ�ַ
	private String lyric; //���
	private String singer; //����
	private String cover; // д�沥�Ž���ͼƬ
	private int play = 0;
	private int search = 0;
	
	public int getPlay() {
		return play;
	}
	public void setPlay(int play) {
		this.play = play;
	}
	public int getSearch() {
		return search;
	}
	public void setSearch(int search) {
		this.search = search;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lyric == null) ? 0 : lyric.hashCode());
		result = prime * result + play;
		result = prime * result + search;
		result = prime * result + ((singer == null) ? 0 : singer.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (cover == null) {
			if (other.cover != null)
				return false;
		} else if (!cover.equals(other.cover))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lyric == null) {
			if (other.lyric != null)
				return false;
		} else if (!lyric.equals(other.lyric))
			return false;
		if (play != other.play)
			return false;
		if (search != other.search)
			return false;
		if (singer == null) {
			if (other.singer != null)
				return false;
		} else if (!singer.equals(other.singer))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", url=" + url + ", lyric=" + lyric + ", singer=" + singer
				+ ", cover=" + cover + ", play=" + play + ", search=" + search + "]";
	}
	
}