package com.example.finalProject.api;

import com.example.finalProject.dto.CountryDTO;
import com.example.finalProject.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/country")
public class CountryRestController {
    private final CountryService countryService;

    @GetMapping(value = "{id}")
    public CountryDTO getOneCountry(@PathVariable(name = "id") Long id) {
        return countryService.getOneCountry(id);
    }

    @GetMapping(value = "/get-country-list")
    public List<CountryDTO> getCountryList(@RequestParam(required = false) String searchQuery) {
        if (searchQuery != null) {
            return countryService.getCountryListSearch(searchQuery);
        }
        return countryService.getCountryList();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @PostMapping(value = "/add-country")
    public CountryDTO addCountry(@RequestBody CountryDTO countryDTO) {
        return countryService.addCountry(countryDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @PutMapping
    public CountryDTO updateCountry(@RequestBody CountryDTO countryDTO) {
        return countryService.updateCountry(countryDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @DeleteMapping(value = "{id}")
    public void deleteCountry(@PathVariable(name = "id") Long id) {
        countryService.deleteCountry(id);
    }
}
