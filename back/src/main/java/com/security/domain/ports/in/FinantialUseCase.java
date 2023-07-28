package com.security.domain.ports.in;

import com.security.domain.model.Finantial;

import java.util.List;
import java.util.Optional;

public interface FinantialUseCase {
    Finantial createFinantial(Finantial finantial);
    Optional<Finantial> getFinantialById(Long id);
    List<Finantial> getAllFinantials();
    Optional<Finantial> updateFinantial(Long id, Finantial finantial);
    boolean deleteFinantial(Long id);
    boolean deleteAll();
}
