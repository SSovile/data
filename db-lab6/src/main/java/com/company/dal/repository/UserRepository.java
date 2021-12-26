package com.company.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.company.models.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
