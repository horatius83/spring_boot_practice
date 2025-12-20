package com.maxpeckham.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maxpeckham.springcoredemo.Coach;
import com.maxpeckham.springcoredemo.SwimCoach;

@Configuration
public class SportConfig {
   @Bean("aquatic")
   public Coach swimCoach() {
    return new SwimCoach();
   } 
}
