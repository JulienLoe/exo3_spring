package com.example.exo3spring.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class ContactDTO {
        private UUID id;
        private String blabla;
        private String lastName;
        private LocalDate birthDate;
        private Integer age;
    }

