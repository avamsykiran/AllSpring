package in.tp.jpa.hib.demo.models.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Artists")
public class Artist implements Comparable<Artist> {

	@Id
	private int aId;
	private String aName;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "MovieArtists", 
	joinColumns = { @JoinColumn(name = "aid") }, 
	inverseJoinColumns = { @JoinColumn(name = "mid") })
	private Set<Movie> movies;

	public Artist() {

	}

	public Artist(int aId, String aName,Set<Movie> movies) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.movies=movies;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Artist [aId=" + aId + ", aName=" + aName + ", movies=" + movies
				+ "]";
	}

	public int compareTo(Artist o) {
		return this.aId - o.aId;
	}

}
