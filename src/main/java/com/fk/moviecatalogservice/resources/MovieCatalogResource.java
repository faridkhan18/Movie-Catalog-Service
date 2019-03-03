package com.fk.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fk.moviecatalogservice.models.CatalogItem;
import com.fk.moviecatalogservice.models.Movie;
import com.fk.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		//get all movie rated ids
		
		UserRating userRating=restTemplate.getForObject("http://Rating-data-service/ratingdata/users/"+userId, UserRating.class);
		System.out.println("User Ratings1234 "+userRating);
		
		Movie movie = restTemplate.getForObject("http://Movie-Info-Service/movies/"+userId, Movie.class);
		List<CatalogItem> list =userRating.getUserRating()
			.stream()
			 	.map(rating-> new CatalogItem(movie.getName(), movie.getDesc() , rating.getRatings()))
			 	.collect(Collectors.toList());
		
		// for each movie id get all details from movie info
		//put them into one from catalog service
		
		return list;
		
		
		
	
		
	}
	
	
}
