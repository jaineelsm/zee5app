package com.zee.zee5app.dto;

//import javax.management.relation.InvalidRelationIdException;
import javax.naming.InvalidNameException;

import com.zee.zee5app.enums.Genre;
import com.zee.zee5app.enums.Languages;
import com.zee.zee5app.exceptions.InvalidIdException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode

public class Movie {
    public void setMovieId(String movieId) throws InvalidIdException {
    	int len = movieId.length();
    	if(len>=5 && len<=7) {
    		this.movieId = movieId;
    	}else {
    		System.out.println("kul");
    		throw new InvalidIdException("Id is Invalid");
    	}
    	
    	
    	
//		this.movieId = movieId;
	}
	public void setActors(String[] actors) {
		this.actors = actors;
	}
	public void setMovieName(String movieName) throws InvalidNameException {
		System.out.println("jdsncbs");
		int len = movieName.length();
		if(len<3 || movieName==null || movieName=="") {
			System.out.println("kul");
			throw new InvalidNameException("Invalid movie name");
		}else {
			this.movieName = movieName;
		}
		
		
		
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public void setLanguages(String[] languages) {
//		int count = 0;
//		for (String string : languages) {
//			for (Languages l : Languages.values()) {
//				if(Languages.valueOf(string).compareTo(l)==0) {
//				System.out.println("checked");
//					count++;
//				}
//			}
//			if(count!=languages.length) {
//				System.out.println("kul");
//				throw new InvalidNameException("invalid language set");
//			}
//			
//		}
		
		
		this.languages = languages;
		
		
		
		
		
		
	}
	public void setMovieLength(float movieLength) {
		this.movieLength = movieLength;
	}
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Movie(String movieId, String[] actors, String movieName, String director, Genre genre, String production,
			String[] languages, float movieLength) throws  InvalidNameException, InvalidIdException{
		super();
//		this.movieId = movieId;
		this.setMovieId(movieId);
		this.actors = actors;
		this.setMovieName(movieName);
		this.director = director;
		this.genre = genre;
		this.production = production;
		this.languages = languages ;
		this.movieLength = movieLength;
	}





	private String movieId;
    private String actors[];
    private String movieName;
    private String director;
    private Genre genre;
    private String production;
    private String languages[];
    private float movieLength;
    private String trailer1;
//    private byte[] trailer2;
    
    
}