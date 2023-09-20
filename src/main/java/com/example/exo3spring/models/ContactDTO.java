package com.example.exo3spring.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


    @Data
    @Builder
    public class ContactDTO {
        private UUID id;
        private String LastName;
        private String FirstName;
        private Integer Age;
    }

