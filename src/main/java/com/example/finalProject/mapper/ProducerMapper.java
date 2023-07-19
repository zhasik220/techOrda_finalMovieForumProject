package com.example.finalProject.mapper;

import com.example.finalProject.dto.ProducerDTO;
import com.example.finalProject.model.Producer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProducerMapper {

    @Mapping(target = "directorName", source = "name")
    @Mapping(target = "directorSurname", source = "surname")
    @Mapping(target = "directorAge", source = "age")
    ProducerDTO toDTO(Producer producer);


    @Mapping(target = "name", source = "directorName")
    @Mapping(target = "surname", source = "directorSurname")
    @Mapping(target = "age", source = "directorAge")
    Producer toModel(ProducerDTO producerDTO);

    List<ProducerDTO> toDtoList(List<Producer> producerList);

    List<Producer> toModelList(List<ProducerDTO> producerDTOList);
}
