package com.example.finalProject.service;

import com.example.finalProject.dto.CountryDTO;
import com.example.finalProject.mapper.CountryMapper;
import com.example.finalProject.model.Country;
import com.example.finalProject.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public List<CountryDTO> getCountryList() {
        return countryMapper.toDtoList(countryRepository.findAllByOrderByNameAsc());
    }

    public List<CountryDTO> getCountryListSearch(String searchQuery) {
        return countryMapper.toDtoList(countryRepository.findCountryByNameSearch(searchQuery));
    }

    public CountryDTO addCountry(CountryDTO countryDTO) {
        Country country = countryMapper.toModel(countryDTO);
        return countryMapper.toDTO(countryRepository.save(country));
    }

    public CountryDTO getOneCountry(Long id) {
        return countryMapper.toDTO(countryRepository.findById(id).orElse(new Country()));
    }

    public CountryDTO updateCountry(CountryDTO countryDTO) {
        Country country = countryMapper.toModel(countryDTO);
        return countryMapper.toDTO(countryRepository.save(country));
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
