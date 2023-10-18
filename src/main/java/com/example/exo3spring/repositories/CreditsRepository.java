package com.example.exo3spring.repositories;

import com.example.exo3spring.models.Credits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditsRepository extends JpaRepository<Credits, Integer> {
}
