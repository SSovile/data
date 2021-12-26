package com.company.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.company.models.domain.SmartWatch;


@Repository
public interface SmartWatchRepository extends JpaRepository<SmartWatch, Integer> {
}
