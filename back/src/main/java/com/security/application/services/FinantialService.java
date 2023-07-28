package com.security.application.services;


import com.security.domain.model.Finantial;
import com.security.domain.ports.in.FinantialUseCase;

import java.util.List;
import java.util.Optional;

public class FinantialService implements FinantialUseCase {
    public final FinantialUseCase finantialUseCase;

    public FinantialService(FinantialUseCase finantialUseCase) {
        this.finantialUseCase = finantialUseCase;
    }

    @Override
    public Finantial createFinantial(Finantial finantial) {
        return finantialUseCase.createFinantial(finantial);
    }

    @Override
    public Optional<Finantial> getFinantialById(Long id) {
        return finantialUseCase.getFinantialById(id);
    }

    @Override
    public List<Finantial> getAllFinantials() {
        return finantialUseCase.getAllFinantials();
    }

    @Override
    public Optional<Finantial> updateFinantial(Long id, Finantial finantial) {
        return finantialUseCase.updateFinantial(id, finantial);
    }

    @Override
    public boolean deleteFinantial(Long id) {
        return finantialUseCase.deleteFinantial(id);
    }

    @Override
    public boolean deleteAll() {
        return finantialUseCase.deleteAll();
    }
}