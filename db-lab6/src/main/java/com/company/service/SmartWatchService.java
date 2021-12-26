package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.company.dal.repository.SmartWatchRepository;
import com.company.models.domain.address.Country;
import java.util.List;

import java.util.NoSuchElementException;

@Service
public class SmartWatchService {
    @Autowired
    SmartWatch smartWatchRepository;

    public List<SmartWatch> getAll() {
        return smartWatchRepository.findAll();
    }

    public smartWatch getById(Integer id) {
        return smartWatchRepository.findById(id).get();
    }

    @Transactional
    public SmartWatch create(SmartWatch smartWatch) {
        return smartWatchRepository.save(smartWatch);
    }

    @Transactional
    public void updateById(SmartWatch smartWatch, Integer id) {
        SmartWatch updatedSmartWatch = smartWatchRepositoryRepository.findById(id).get();
        updatedSmartWatch.setModel(smartWatch.getModel());
        updatedSmartWatch.setCharge(smartWatch.getCharge());
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!smartWatchRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        smartWatchRepository.deleteById(id);
    }
}
