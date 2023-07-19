package com.example.finalProject.api;


import com.example.finalProject.dto.MovieDTO;
import com.example.finalProject.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/movie")
public class MovieRestController {
    private final MovieService movieService;

    @GetMapping(value = "{id}")
    public MovieDTO getOneMovie(@PathVariable(name = "id") Long id) {
        return movieService.getOneMovie(id);
    }

    @GetMapping(value = "/get-movie-list")
    public List<MovieDTO> getCourses(@RequestParam(required = false) String searchQuery) {
        if (searchQuery != null) {
            return movieService.getMovieBySearch(searchQuery);
        }
        return movieService.getMovieList();
    }

    @GetMapping(value = "/find-actor")
    public List<MovieDTO> getMovieByActorId(@RequestParam Long actorId) {
        return movieService.getMovieListByActorId(actorId);
    }

    @GetMapping(value = "/find_producer")
    public List<MovieDTO> getMovieByAProducerId(@RequestParam Long producerId) {
         return movieService.getMovieListByProducerId(producerId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/add-movie")
    public MovieDTO addMovie(@RequestBody MovieDTO movie) {
        return movieService.addMovie(movie);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @PutMapping
    public MovieDTO movie(@RequestBody MovieDTO movie) {
        return movieService.updateMovie(movie);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{id}")
    public void deleteMovie(@PathVariable(name = "id") Long id) {
        movieService.deleteMovie(id);
    }


}
