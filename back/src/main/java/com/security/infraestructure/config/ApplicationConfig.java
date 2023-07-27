package com.security.infraestructure.config;

import com.security.application.services.FinantialService;
import com.security.application.usecases.FinantialUseCaseImpl;
import com.security.domain.ports.out.FinantialRepositoryPort;
import com.security.infraestructure.repositories.impl.JpaFinantialRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    // configuración de beans de `finantial` xdn't

    @Bean
    public FinantialService finantialService(FinantialRepositoryPort finantialRepositoryPort){
        return new FinantialService(new FinantialUseCaseImpl(finantialRepositoryPort));
    }

    @Bean
    public FinantialRepositoryPort finantialRepositoryPort(JpaFinantialRepositoryAdapter jpaFinantialRepositoryAdapter){
        return jpaFinantialRepositoryAdapter;
    }
}