package com.fk.moviecatalogservice.models;

public class Rating {
	private String movieId;
	private int ratings;
	public Rating(String movieId, int ratings) {
		super();
		this.movieId = movieId;
		this.ratings = ratings;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Rating [movieId=" + movieId + ", ratings=" + ratings + "]";
	}
	
	
	
}
