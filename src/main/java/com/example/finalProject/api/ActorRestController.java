package com.example.finalProject.api;

import com.example.finalProject.dto.ActorDTO;
import com.example.finalProject.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/actor")
public class ActorRestController {
    private final ActorService actorService;

    @GetMapping(value = "{id}")
    public ActorDTO getOneActor(@PathVariable(name = "id") Long id) {
        return actorService.getOneActor(id);
    }

    @GetMapping(value = "/get-actor-list")
    public List<ActorDTO> getActorList(@RequestParam(required = false) String searchQuery) {
        if (searchQuery != null) {
            return actorService.getActorListSearch(searchQuery);
        }
        return actorService.getActorList();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @PostMapping(value = "/add-actor")
    public ActorDTO addActor(@RequestBody ActorDTO actor) {
        return actorService.addActor(actor);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @PutMapping
    public ActorDTO updateActor(@RequestBody ActorDTO actor) {
        return actorService.updateActor(actor);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @DeleteMapping(value = "{id}")
    public void deleteActor(@PathVariable(name = "id") Long id) {
        actorService.deleteActor(id);
    }

}
