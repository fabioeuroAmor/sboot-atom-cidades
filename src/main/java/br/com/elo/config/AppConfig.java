package br.com.elo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AppConfig {

    // Definindo um bean para ModelMapper
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    // Definindo um bean para RestTemplate
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }



}