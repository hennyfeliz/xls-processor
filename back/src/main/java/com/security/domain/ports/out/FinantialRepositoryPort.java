package com.security.domain.ports.out;

import com.security.domain.model.Finantial;

import java.util.List;
import java.util.Optional;

public interface FinantialRepositoryPort {
    Finantial save(Finantial finantial);
    Optional<Finantial> findById(Long id);
    List<Finantial> findAll();
    Optional<Finantial> update(Finantial finantial);
    boolean deleteAll();
    boolean deleteById(Long id);
}
