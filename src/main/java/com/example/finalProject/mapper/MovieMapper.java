package com.example.finalProject.mapper;

import com.example.finalProject.dto.MovieDTO;
import com.example.finalProject.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, ActorMapper.class})
public interface MovieMapper {


    @Mapping(source = "movieName", target = "movieTitle")
    @Mapping(source = "country", target = "movieCountry")
    @Mapping(source = "country.name", target = "movieCountry.countryName")
    @Mapping(source = "year", target = "movieYear")
    @Mapping(source = "duration", target = "continuance")
    @Mapping(source = "actors", target = "movieActors")
    @Mapping(source = "producer", target = "movieDirector")
    @Mapping(source = "producer.id", target = "movieDirector.id")
    @Mapping(source = "producer.name", target = "movieDirector.directorName")
    @Mapping(source = "producer.surname", target = "movieDirector.directorSurname")
    @Mapping(source = "producer.age", target = "movieDirector.directorAge")
    @Mapping(source = "genres", target = "movieGenres")
    @Mapping(source = "description", target = "definition")
    MovieDTO toDto(Movie movie);


    @Mapping(source = "movieTitle", target = "movieName")
    @Mapping(source = "movieCountry", target = "country")
    @Mapping(source = "movieCountry.countryName", target = "country.name")
    @Mapping(source = "movieYear", target = "year")
    @Mapping(source = "continuance", target = "duration")
    @Mapping(source = "movieActors", target = "actors")
    @Mapping(source = "movieDirector", target = "producer")
    @Mapping(source = "movieDirector.id", target = "producer.id")
    @Mapping(source = "movieDirector.directorName", target = "producer.name")
    @Mapping(source = "movieDirector.directorSurname", target = "producer.surname")
    @Mapping(source = "movieDirector.directorAge", target = "producer.age")
    @Mapping(source = "movieGenres", target = "genres")
    @Mapping(source = "definition", target = "description")
    Movie toModel(MovieDTO movie);

    List<MovieDTO> toDtoList(List<Movie> movieList);

    List<Movie> toModelList(List<MovieDTO> movieDTOList);
}
