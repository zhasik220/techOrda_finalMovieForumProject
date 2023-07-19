package com.example.finalProject.service;

import com.example.finalProject.dto.MovieDTO;
import com.example.finalProject.mapper.MovieMapper;
import com.example.finalProject.model.Movie;
import com.example.finalProject.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final CommentService commentService;

    public List<MovieDTO> getMovieList() {
        return movieMapper.toDtoList(movieRepository.findAll());
    }

    public List<MovieDTO> getMovieBySearch(String searchQuery) {
        return movieMapper.toDtoList(movieRepository.findMovieByNameSearch(searchQuery));
    }

    public MovieDTO addMovie(MovieDTO movie) {
        return movieMapper.toDto(movieRepository.save(movieMapper.toModel(movie)));
    }

    public MovieDTO getOneMovie(Long id) {
        return movieMapper.toDto(movieRepository.findById(id).orElse(new Movie()));
    }

    public List<MovieDTO> getMovieListByActorId(Long actorId) {
        return movieMapper.toDtoList(movieRepository.findAllByActorsId(actorId));
    }

    public List<MovieDTO> getMovieListByProducerId(Long producerId) {
        return movieMapper.toDtoList(movieRepository.findAllByProducerId(producerId));
    }

    public MovieDTO updateMovie(MovieDTO movie) {
        return movieMapper.toDto(movieRepository.save(movieMapper.toModel(movie)));
    }

    public void deleteMovie(Long id) {
        commentService.deleteAllCommentMovie(id);
        movieRepository.deleteById(id);
    }
}
