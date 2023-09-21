package com.example.exo3spring.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;


    @Data
    @Builder
    public class ContactDTO {
        private UUID id;
        private String lastName;
        private String firstName;
        private LocalDate birthDate;
        private Integer Age;
    }

