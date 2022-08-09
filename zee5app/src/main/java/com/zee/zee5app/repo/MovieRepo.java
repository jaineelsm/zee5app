package com.zee.zee5app.repo;

import java.util.List;
import java.util.Optional;

//import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exceptions.NoDataFoundException;

public interface MovieRepo {
    
	
	public List<Movie> FindByOrderByMovieNameDsc();
	
    public Optional<Movie> insertMovie(Movie movie);
    public Optional<Movie> updateMovie(String movieId, Movie movie) throws NoDataFoundException;

    public Optional<Movie> getMovieByMovieId(String movieId);
    public Movie[] getAllMovies();
    public Movie[] getAllMoviesByGenre(String genre);
    public Movie[] getAllMoviesByName(String movieName);
    public String deleteMovieByMovieId(String movieId) throws NoDataFoundException;
}