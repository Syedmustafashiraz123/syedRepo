package com.syed.model;
import java.io.Serializable;


public class Movie  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String moviename;
	private String leadactor;
	private String language;
	
	public Movie(int id, String moviename,String leadactor, String language )
	{
		this.id=id;
		this.moviename=moviename;
		this.leadactor=leadactor;
		this.language=language;
	}
	
	public Movie()
	{
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getLeadactor() {
		return leadactor;
	}
	public void setLeadactor(String leadactor) {
		this.leadactor = leadactor;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moviename == null) ? 0 : moviename.hashCode());
		result = prime * result + ((leadactor == null) ? 0 : leadactor.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + id;
		
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
		Movie other = (Movie) obj;
		if (moviename == null) {
			if (other.moviename != null)
				return false;
		} else if (!moviename.equals(other.moviename))
			return false;
		
		if (leadactor == null) {
			if (other.leadactor != null)
				return false;
		} else if (!leadactor.equals(other.leadactor))
			return false;
		
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		
		if (id != other.id)
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", moviename=" + moviename + ", leadactor="
				+ leadactor + ", language=" + language + "]";
	}
	
	
	
	
	
}
