package com.example.finalProject;

import com.example.finalProject.dto.ActorDTO;
import com.example.finalProject.dto.GenreDTO;
import com.example.finalProject.dto.MovieDTO;
import com.example.finalProject.mapper.ActorMapper;
import com.example.finalProject.mapper.MovieMapper;
import com.example.finalProject.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FinalProjectApplicationTests {
	@Autowired
	ActorMapper actorMapper;
	@Autowired
	MovieMapper movieMapper;
	@Test
	void contextLoads() {
	}
	@Test
	void checkActorDTO(){
		Actor actor=new Actor();
		actor.setId(20L);
		actor.setName("Cheki");
		actor.setSurname("Chan");
		actor.setAge(22);

		ActorDTO actorDTO= actorMapper.toDTO(actor);
		Assertions.assertEquals(actor.getId(),actorDTO.getId());
		Assertions.assertEquals(actor.getName(),actorDTO.getActorName());
		Assertions.assertEquals(actor.getSurname(),actorDTO.getActorSurname());
		Assertions.assertEquals(actor.getAge(),actorDTO.getActorAge());

	}

	@Test
	void checkMovieDTO(){
		Movie movie=new Movie();
		movie.setId(1L);
		movie.setMovieName("Movie Name");
		movie.setYear(2000);
		movie.setDuration(159);
		Producer producer=new Producer();
		producer.setId(1L);
		producer.setAge(40);
		producer.setName("nameProducer");
		producer.setSurname("surnameProducer");
		movie.setProducer(producer);
		Country country=new Country();
		country.setId(2L);
		country.setName("nameCountry");
		movie.setCountry(country);
		Actor actor=new Actor();
		actor.setId(3L);
		actor.setName("nameActor");
		actor.setSurname("surnameActor");
		actor.setAge(50);
		List<Actor> actorList=new ArrayList<>();
		actorList.add(actor);
		movie.setActors(actorList);
		Genre genre =new Genre();
		genre.setId(4L);
		genre.setName("nameGenre");
		List<Genre> genreList=new ArrayList<>();
		genreList.add(genre);
		movie.setGenres(genreList);

		MovieDTO movieDTO=movieMapper.toDto(movie);

		Assertions.assertEquals(movie.getId(), movieDTO.getId());
		Assertions.assertEquals(movie.getMovieName(), movieDTO.getMovieTitle());
		Assertions.assertEquals(movie.getYear(), movieDTO.getMovieYear());
		Assertions.assertEquals(movie.getDuration(), movieDTO.getContinuance());
		Assertions.assertEquals(movie.getProducer().getId(), movieDTO.getMovieDirector().getId());
		Assertions.assertEquals(movie.getProducer().getName(), movieDTO.getMovieDirector().getDirectorName());
		Assertions.assertEquals(movie.getProducer().getSurname(), movieDTO.getMovieDirector().getDirectorSurname());
		Assertions.assertEquals(movie.getProducer().getAge(), movieDTO.getMovieDirector().getDirectorAge());


		Assertions.assertEquals(movie.getCountry().getId(), movieDTO.getMovieCountry().getId());
		Assertions.assertEquals(movie.getCountry().getName(), movieDTO.getMovieCountry().getCountryName());


		ActorDTO actorDTO = movieDTO.getMovieActors().get(0);
		Assertions.assertEquals(actor.getId(), actorDTO.getId());
		Assertions.assertEquals(actor.getName(), actorDTO.getActorName());
		Assertions.assertEquals(actor.getSurname(), actorDTO.getActorSurname());
		Assertions.assertEquals(actor.getAge(), actorDTO.getActorAge());


		GenreDTO genreDTO = movieDTO.getMovieGenres().get(0);
		Assertions.assertEquals(genre.getId(), genreDTO.getId());
		Assertions.assertEquals(genre.getName(), genreDTO.getGenreName());

	}


}
