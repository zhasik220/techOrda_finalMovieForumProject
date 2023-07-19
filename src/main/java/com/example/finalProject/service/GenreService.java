package com.example.finalProject.service;

import com.example.finalProject.dto.GenreDTO;
import com.example.finalProject.mapper.GenreMapper;
import com.example.finalProject.model.Genre;
import com.example.finalProject.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public List<GenreDTO> getGenreList() {
        return genreMapper.toDtoList(genreRepository.findAllByOrderByNameAsc());
    }

    public List<GenreDTO> getGenreListSearch(String searchQuery) {
        return genreMapper.toDtoList(genreRepository.findGenreByNameSearch(searchQuery));
    }


    public GenreDTO addGenre(GenreDTO genreDTO) {
        Genre genre = genreMapper.toModel(genreDTO);
        return genreMapper.toDTO(genreRepository.save(genre));
    }

    public GenreDTO getOneGenre(Long id) {
        return genreMapper.toDTO(genreRepository.findById(id).orElse(new Genre()));
    }

    public GenreDTO updateGenre(GenreDTO genreDTO) {
        Genre genre = genreMapper.toModel(genreDTO);
        return genreMapper.toDTO(genreRepository.save(genre));
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
