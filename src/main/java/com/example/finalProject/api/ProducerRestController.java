package com.example.finalProject.api;

import com.example.finalProject.dto.ProducerDTO;
import com.example.finalProject.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/producer")
public class ProducerRestController {
    private final ProducerService producerService;

    @GetMapping(value = "{id}")
    public ProducerDTO getOneProducer(@PathVariable(name = "id") Long id) {
        return producerService.getOneProducer(id);
    }

    @GetMapping(value = "/get-producer-list")
    public List<ProducerDTO> getProducerList(@RequestParam(required = false) String searchQuery) {
        if (searchQuery != null) {
            return producerService.getProducerListSearch(searchQuery);
        }
        return producerService.getProducerList();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @PostMapping(value = "/add-producer")
    public ProducerDTO addProducer(@RequestBody ProducerDTO producerDTO) {
        return producerService.addProducer(producerDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @PutMapping
    public ProducerDTO updateProducer(@RequestBody ProducerDTO producerDTO) {
        return producerService.updateProducer(producerDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @DeleteMapping(value = "{id}")
    public void deleteProducer(@PathVariable(name = "id") Long id) {
        producerService.deleteProducer(id);
    }
}
