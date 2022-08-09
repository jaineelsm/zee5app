package com.zee.zee5app.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.NoDataFoundException;

public class MovieRepoImpl implements MovieRepo {
	
	private MovieRepoImpl() {
        // TODO Auto-generated constructor stub
    }
	
	private List<Movie> movies = new ArrayList<>();
	
	
    private static MovieRepo movieRepo;
    
    public static MovieRepo getInstance() {
        // userRepo object
        
    	
    	
        if(movieRepo == null) {
        	movieRepo = new MovieRepoImpl();
            
        }
        
        return movieRepo;
    }
	
    
    
//	private void ksmks() {
//		Collections.sort((List<T>) movies);
//	}
//    
//    
    
    
    

	@Override
	public Optional<Movie> insertMovie(Movie movie) {
		// TODO Auto-generated method stub
		boolean result = movies.add(movie);
		
		if(result) {
			return Optional.of(movie);
		}
		
		return Optional.empty();
//		return null;
	}

	@Override
	public Optional<Movie> updateMovie(String movieId, Movie movie) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> movie2 = this.getMovieByMovieId(movieId);
		
		if(movie2.isPresent()) {
			if(movies.remove(movie2.get())) {
				movies.add(movie);
				return Optional.of(movie);
			}else {
				throw new NoDataFoundException("NO Movie found");
			}
			
		}
		
		return Optional.empty();
		
//		return null;
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
		for (Movie movie : movies) {
			if(movie!=null && movie.getMovieId().equals(movieId)) {
				return Optional.of(movie);
			}
		}
		
		return Optional.empty();
		
		
//		return null;
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] getAllMoviesByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] getAllMoviesByName(String movieName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovieByMovieId(String movieId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional = this.getMovieByMovieId(movieId);
		if(optional.isPresent()) {
			if(!movies.remove(optional.get())) {
				throw new NoDataFoundException("No movie found");
			}else {
				return "Success";
			}
		}
		return "fail";
		
		
		
		
//		return null;
	}

	

	@Override
	public List<Movie> FindByOrderByMovieNameDsc() {
		
		List<Movie> movies2 = new ArrayList<>(movies);
		
		
//		method1
		
		Comparator<Movie> comparator =(e1,e2)->{
			return e2.getMovieName().compareTo(e1.getMovieName());
		};
		
		Collections.sort(movies2, comparator);
		
//		method2
//		Collections.sort(movies2, (e1,e2)->
//			e2.getMovieName().compareTo(e1.getMovieName()));
		
		// TODO Auto-generated method stub
		return movies2;
	}

}
