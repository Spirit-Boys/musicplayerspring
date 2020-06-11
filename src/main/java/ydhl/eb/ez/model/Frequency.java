package ydhl.eb.ez.model;

public class Frequency{

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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + play;
		result = prime * result + search;
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
		Frequency other = (Frequency) obj;
		if (play != other.play)
			return false;
		if (search != other.search)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Frequency [play=" + play + ", search=" + search + "]";
	}
	
}
