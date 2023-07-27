package com.security.infraestructure.repositories;

import com.security.infraestructure.entities.FinantialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaFinantialRepository extends JpaRepository<FinantialEntity, Long> {
}
