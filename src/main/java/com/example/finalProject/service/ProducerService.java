package com.example.finalProject.service;

import com.example.finalProject.dto.ProducerDTO;
import com.example.finalProject.mapper.ProducerMapper;
import com.example.finalProject.model.Producer;
import com.example.finalProject.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final ProducerRepository producerRepository;
    private final ProducerMapper producerMapper;

    public List<ProducerDTO> getProducerList() {
        return producerMapper.toDtoList(producerRepository.findAllByOrderByNameAsc());
    }

    public List<ProducerDTO> getProducerListSearch(String searchQuery) {
        return producerMapper.toDtoList(producerRepository.findProducerByNameOrSurname(searchQuery));
    }

    public ProducerDTO addProducer(ProducerDTO producerDTO) {
        Producer producer = producerMapper.toModel(producerDTO);
        return producerMapper.toDTO(producerRepository.save(producer));
    }

    public ProducerDTO getOneProducer(Long id) {
        return producerMapper.toDTO(producerRepository.findById(id).orElse(new Producer()));
    }

    public ProducerDTO updateProducer(ProducerDTO producerDTO) {
        Producer producer = producerMapper.toModel(producerDTO);
        return producerMapper.toDTO(producerRepository.save(producer));
    }

    public void deleteProducer(Long id) {
        producerRepository.deleteById(id);
    }


}
