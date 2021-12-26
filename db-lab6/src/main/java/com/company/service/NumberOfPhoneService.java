package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.company.dal.repository.NumberOfPhoneRepository;
import com.company.models.domain.NumberOfPhone;

import java.awt.*;

@Service
public class NumberOfPhoneService {
    @Autowired
    NumberOfPhoneRepository numberOfPhoneRepository;

    public List<NumberOfPhone> getAll() {
        return numberOfPhoneRepository.findAll();
    }

    public NumberOfPhoneService getById(Integer id) {
        return numberOfPhoneRepository.findById(id).get();
    }

    public NumberOfPhoneService getByNumber(Integer number) {
        return numberOfPhoneRepository.findByNumber(number);
    }

    @Transactional
    public NumberOfPhoneService create(NumberOfPhoneService numberOfPhone) {
        return numberOfPhoneRepository.save(numberOfPhone);
    }

    @Transactional
    public void updateById(NumberOfPhoneService numberOfPhone, Integer id) {
        NumberOfPhoneService updatedNumberOfPhone = numberOfPhoneRepository.findById(id).get();
        updatedNumberOfPhone.setNumber(numberOfPhone.getNumber());
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!numberOfPhoneRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        numberOfPhoneRepository.deleteById(id);
    }
}
