package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.company.models.converter.NumberOfPhoneConverter;
import com.company.models.domain.NumberOfPhone;
import com.company.models.dto.NumberOfPhoneDto;
import com.company.service.NumberOfPhoneService;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/number")
public class NumberOfPhoneController {
    @Autowired
    private NumberOfPhoneService numberOfPhoneService;

    @GetMapping
    public ResponseEntity<List<NumberOfPhoneDto>> getNumberOfPhoneList() {
        List<NumberOfPhoneDto> responseNumberOfPhoneDtoList = new LinkedList<>();
        for (NumberOfPhone numberOfPhone: numberOfPhoneService.getAll()) {
            responseNumberOfPhoneDtoList.add(NumberOfPhoneConverter.toDTO(numberOfPhone));
        }
        return new ResponseEntity<>(responseNumberOfPhoneDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<NumberOfPhoneDto> getNumberOfPhone(@PathVariable Integer id) {
        try {
            NumberOfPhone searchedNumberOfPhone = numberOfPhoneService.getById(id);
            NumberOfPhoneDto responseNumberOfPhoneDto = NumberOfPhoneConverter.toDTO(searchedNumberOfPhone);
            return new ResponseEntity<>(responseNumberOfPhoneDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<NumberOfPhoneDto> postNumberOfPhone(@RequestBody NumberOfPhoneDto numberOfPhoneDto) {
        NumberOfPhone createdNumberOfPhone = NumberOfPhone.builder()
                .number(numberOfPhoneDto.getNumber())
                .build();
        NumberOfPhone responseNumberOfPhone = numberOfPhoneService.create(createdNumberOfPhone);
        return new ResponseEntity<>(NumberOfPhoneConverter.toDTO(responseNumberOfPhone), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<NumberOfPhoneDto> putNumberOfPhone(@PathVariable Integer id, @RequestBody NumberOfPhoneDto numberOfPhoneDto) {
        try {
            NumberOfPhone updatedNumberOfPhoneValues = NumberOfPhone.builder()
                    .number(numberOfPhoneDto.getNumber())
                    .build();
            numberOfPhoneService.updateById(updatedNumberOfPhoneValues, id);
            numberOfPhoneDto.setId(id);
            return new ResponseEntity<>(numberOfPhoneDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Integer> deleteNumberOfPhone(@PathVariable Integer id) {
        try {
            numberOfPhoneService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
