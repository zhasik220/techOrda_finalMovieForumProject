package com.example.finalProject.api;

import com.example.finalProject.dto.GenreDTO;
import com.example.finalProject.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/genre")
public class GenreRestController {
    private final GenreService genreService;

    @GetMapping(value = "{id}")
    public GenreDTO getOneGenre(@PathVariable(name = "id") Long id) {
        return genreService.getOneGenre(id);
    }

    @GetMapping(value = "/get-genre-list")
    public List<GenreDTO> getGenreList(@RequestParam(required = false) String searchQuery) {
        if (searchQuery != null) {
            return genreService.getGenreListSearch(searchQuery);
        }
        return genreService.getGenreList();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @PostMapping(value = "/add-genre")
    public GenreDTO addGenre(@RequestBody GenreDTO genre) {
        return genreService.addGenre(genre);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @PutMapping
    public GenreDTO updateGenre(@RequestBody GenreDTO genre) {
        return genreService.updateGenre(genre);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @DeleteMapping(value = "{id}")
    public void deleteGenre(@PathVariable(name = "id") Long id) {
        genreService.deleteGenre(id);
    }
}
