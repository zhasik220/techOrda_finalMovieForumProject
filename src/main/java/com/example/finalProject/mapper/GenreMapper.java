package com.example.finalProject.mapper;

import com.example.finalProject.dto.GenreDTO;
import com.example.finalProject.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    @Mapping(source = "name", target = "genreName")
    GenreDTO toDTO(Genre genre);

    @Mapping(source = "genreName", target = "name")
    Genre toModel(GenreDTO genreDTO);

    List<GenreDTO> toDtoList(List<Genre> genreList);

    List<Genre> toModelList(List<GenreDTO> genreDTOList);
}
