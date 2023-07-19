package com.example.finalProject.mapper;

import com.example.finalProject.dto.CountryDTO;
import com.example.finalProject.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    @Mapping(source = "name", target = "countryName")
    CountryDTO toDTO(Country country);

    @Mapping(source = "countryName", target = "name")
    Country toModel(CountryDTO countryDTO);

    List<CountryDTO> toDtoList(List<Country> countryList);

    List<Country> toModelList(List<CountryDTO> countryDTOList);
}
