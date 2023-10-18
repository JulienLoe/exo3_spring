package com.example.exo3spring.services;


import com.example.exo3spring.helper.CSVHelper;
import com.example.exo3spring.helper.CSVHelperCredits;
import com.example.exo3spring.models.Credits;
import com.example.exo3spring.models.Tutorial;
import com.example.exo3spring.repositories.CreditsRepository;
import com.example.exo3spring.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class CSVService {
    @Autowired
    TutorialRepository repository;
    @Autowired
    CreditsRepository creditsRepository;

    public void save(MultipartFile file) {
        try {
            List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public void saveCredits(MultipartFile file) {
        try {
            List<Credits> credits = CSVHelperCredits.csvToCredits(file.getInputStream());
            creditsRepository.saveAll(credits);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Tutorial> getAllTutorials() {
        return repository.findAll();
    }
}
