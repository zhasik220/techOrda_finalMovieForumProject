package com.example.finalProject.mapper;

import com.example.finalProject.dto.ActorDTO;
import com.example.finalProject.model.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    @Mapping(target = "actorName", source = "name")
    @Mapping(target = "actorSurname", source = "surname")
    @Mapping(target = "actorAge", source = "age")
    ActorDTO toDTO(Actor actor);


    @Mapping(target = "name", source = "actorName")
    @Mapping(target = "surname", source = "actorSurname")
    @Mapping(target = "age", source = "actorAge")
    Actor toModel(ActorDTO actorDTO);

    List<ActorDTO> toDtoList(List<Actor> actorList);

    List<Actor> toModelList(List<ActorDTO> actorDTOList);
}
