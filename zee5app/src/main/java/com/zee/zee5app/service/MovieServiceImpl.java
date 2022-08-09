package com.zee.zee5app.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.repo.MovieRepo;
import com.zee.zee5app.repo.MovieRepoImpl;
import com.zee.zee5app.repo.UserRepoImpl;

public class MovieServiceImpl implements MovieService {
	
	private MovieServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static MovieServiceImpl movieServiceImpl;
	
	public static MovieServiceImpl getInstance() {
		// userRepo object
		
		if(movieServiceImpl == null) {
			movieServiceImpl = new MovieServiceImpl();
			
		}
		
		return movieServiceImpl;
	}

	@Override
	public Movie insertMovie(Movie movie) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(movie.getTrailer1());
		System.out.println(file.getName());
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		
		try {
			if(movie.getTrailer1() == null 
					|| movie.getTrailer1() == "" 
					|| !new File(movie.getTrailer1()).exists())
			{
				throw new FileNotFoundException("file does not exist");
			}
			else
			{
				bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
				bufferedOutputStream = new BufferedOutputStream(
						new FileOutputStream("D:\\zee5app\\trailer\\"+file.getName()),2048);
				bufferedOutputStream.write(bufferedInputStream.readAllBytes());
				System.out.println("file exists");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				bufferedInputStream.close();
				bufferedOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private MovieRepo movieRepo = MovieRepoImpl.getInstance();

	@Override
	public Optional<Movie> updateMovie(String movieId, Movie movie) throws NoDataFoundException {
		// TODO Auto-generated method stub
//		return null;
	
		return movieRepo.updateMovie(movieId, movie);
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
//		return null;
		return movieRepo.getMovieByMovieId(movieId);
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
	public String deleteMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
