package org.achkata.pathfinder.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class Config {
    @Bean
    public Random random(){
        return new Random();
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
