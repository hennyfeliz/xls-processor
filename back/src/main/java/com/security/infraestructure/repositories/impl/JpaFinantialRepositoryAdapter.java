package com.security.infraestructure.repositories.impl;


import com.security.domain.model.Finantial;
import com.security.domain.ports.out.FinantialRepositoryPort;
import com.security.infraestructure.entities.FinantialEntity;
import com.security.infraestructure.repositories.JpaFinantialRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaFinantialRepositoryAdapter implements FinantialRepositoryPort {
    public final JpaFinantialRepository jpaFinantialRepository;

    public JpaFinantialRepositoryAdapter(JpaFinantialRepository jpaFinantialRepository) {
        this.jpaFinantialRepository = jpaFinantialRepository;
    }

    @Override
    public Finantial save(Finantial finantial) {
        FinantialEntity finantialEntity = FinantialEntity.fromDomainModel(finantial);
        FinantialEntity savedFinantial = jpaFinantialRepository.save(finantialEntity);
        return savedFinantial.toDomainModel();
    }

    @Override
    public void saveAll(List<Finantial> finantials) {
        List<FinantialEntity> finantialss = finantials.stream().map(FinantialEntity::fromDomainModel).toList();
        jpaFinantialRepository.saveAll(finantialss);
    }

    @Override
    public Optional<Finantial> findById(Long id) {
        return jpaFinantialRepository.findById(id)
                .map(FinantialEntity::toDomainModel);
    }

    @Override
    public List<Finantial> findAll() {
        return jpaFinantialRepository.findAll().stream()
                .map(FinantialEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Finantial> update(Finantial finantial) {
        if(jpaFinantialRepository.existsById(finantial.getId())){
            FinantialEntity finantialEntity = FinantialEntity.fromDomainModel(finantial);
            FinantialEntity updatedFinantial = jpaFinantialRepository.save(finantialEntity);
            return Optional.of(updatedFinantial.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteAll() {
        jpaFinantialRepository.deleteAll();
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        if(jpaFinantialRepository.existsById(id)){
            jpaFinantialRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
