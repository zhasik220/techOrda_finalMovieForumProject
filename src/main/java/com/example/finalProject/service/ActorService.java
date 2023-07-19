package com.example.finalProject.service;

import com.example.finalProject.dto.ActorDTO;
import com.example.finalProject.mapper.ActorMapper;
import com.example.finalProject.model.Actor;
import com.example.finalProject.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    public List<ActorDTO> getActorList() {
        return actorMapper.toDtoList(actorRepository.findAllByOrderByNameAsc());
    }

    public List<ActorDTO> getActorListSearch(String searchQuery) {
        return actorMapper.toDtoList(actorRepository.findActorsByNameOrSurname(searchQuery));
    }

    public ActorDTO addActor(ActorDTO actorDTO) {
        Actor actor = actorMapper.toModel(actorDTO);
        return actorMapper.toDTO(actorRepository.save(actor));
    }

    public ActorDTO getOneActor(Long id) {
        return actorMapper.toDTO(actorRepository.findById(id).orElse(new Actor()));
    }

    public ActorDTO updateActor(ActorDTO actorDTO) {
        Actor actor = actorMapper.toModel(actorDTO);
        return actorMapper.toDTO(actorRepository.save(actor));
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }


}
