package com.security.application.usecases;


import com.security.domain.model.Finantial;
import com.security.domain.ports.in.FinantialUseCase;
import com.security.domain.ports.out.FinantialRepositoryPort;

import java.util.List;
import java.util.Optional;

public class FinantialUseCaseImpl implements FinantialUseCase {
    public final FinantialRepositoryPort finantialRepositoryPort;

    public FinantialUseCaseImpl(FinantialRepositoryPort finantialRepositoryPort) {
        this.finantialRepositoryPort = finantialRepositoryPort;
    }

    @Override
    public Finantial createFinantial(Finantial finantial) {
        return finantialRepositoryPort.save(finantial);
    }

    @Override
    public Optional<Finantial> getFinantialById(Long id) {
        return finantialRepositoryPort.findById(id);
    }

    @Override
    public List<Finantial> getAllFinantials() {
        return finantialRepositoryPort.findAll();
    }

    @Override
    public Optional<Finantial> updateFinantial(Long id, Finantial finantial) {
        return finantialRepositoryPort.update(finantial);
    }

    @Override
    public boolean deleteFinantial(Long id) {
        return finantialRepositoryPort.deleteById(id);
    }

    @Override
    public boolean deleteAll() {
        return finantialRepositoryPort.deleteAll();
    }
}

