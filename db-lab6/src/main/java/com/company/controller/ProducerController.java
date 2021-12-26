package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.company.models.converter.ProducerConverter;
import com.company.models.domain.Producer;
import com.company.models.dto.ProducerDto;
import com.company.service.ProducerService;

import java.awt.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/producer")
public class ProducerController {
    @Autowired
    ProducerService producerService;

    @GetMapping
    public ResponseEntity<List<ProducerDto>> getProducerList() {
        List<ProducerDto> producerDtoList = new LinkedList<>();
        for (Producer producer: producerService.getAll()) {
            producerDtoList.add(ProducerConverter.toDTO(producer));
        }
        return new ResponseEntity<>(producerDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProducerDto> getProducer(@PathVariable Integer id) {
        try {
            Producer searchedProducer = producerService.getById(id);
            return new ResponseEntity<>(ProducerConverter.toDTO(searchedProducer), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ProducerDto> postProducer(@RequestBody ProducerDto producerDto) {
        Producer createdProducer= Producer.builder()
                .name(ProducerDto.getName())
                .brand(ProducerDto.getBrand())
                .email(ProducerDto.getEmail())
                .build();
        Producer responseProducer = producerService.create(createdProducer);
        return new ResponseEntity<>(ProducerConverter.toDTO(responseProducer), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProducerDto> putProducer(@PathVariable Integer id, @RequestBody ProducerDto producerDto) {
        try {
            Producer updatedProducerValues = Producer.builder()
                    .name(ProducerDto.getName())
                    .brand(ProducerDto.getBrand())
                    .email(ProducerDto.getEmail())
                    .build();
            producerService.updateById(updatedProducerValues, id);
            producerDto.setId(id);
            return new ResponseEntity<>(producerDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Integer> deleteProducer(@PathVariable Integer id) {
        try {
            producerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
