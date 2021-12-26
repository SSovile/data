package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.company.dal.repository.CountryRepository;
import com.company.models.domain.address.Country;
import java.util.List;

import java.util.NoSuchElementException;

@Service
public class ProducerService {
    @Autowired
    ProducerRepository producerRepository;

    public List<Producer> getAll() {
        return producerRepository.findAll();
    }

    public Producer getById(Integer id) {
        return producerRepository.findById(id).get();
    }

    public Producer getByName(String name) {
        return producerRepository.findByName(name);
    }

    @Transactional
    public Producer create(Producer producer) {
        return producerRepository.save(producer);
    }

    @Transactional
    public void updateById(Producer producer, Integer id) {
        Producer updatedProducer = producerRepository.findById(id).get();
        updatedProducer.setName(producer.getName());
        updatedProducer.setBrand(producer.getBrand());
        updatedProducer.setEmail(producer.getEmail());
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!producerRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        producerRepository.deleteById(id);
    }
}
