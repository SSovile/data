package com.company.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.company.models.domain.Producer;


@Repository
public interface ProducerRepository extends JpaRepository<Producer, Integer> {
}
