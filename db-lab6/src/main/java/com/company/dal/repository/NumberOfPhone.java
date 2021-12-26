package com.company.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.company.models.domain.NumberOfPhone;

@Repository
public interface NumberOfPhoneRepository extends JpaRepository<NumberOfPhone, Integer> {
}
