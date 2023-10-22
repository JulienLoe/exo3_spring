package com.example.exo3spring.controllers;


import com.example.exo3spring.models.MoviesCreditsDTO;
import com.example.exo3spring.models.Tutorial;
import com.example.exo3spring.repositories.RequestRepository;
import com.example.exo3spring.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
    @RestController
    @RequestMapping("/api")
    public class MovieController {

        @Autowired
        TutorialRepository tutorialRepository;

    @Autowired
    RequestRepository requestRepository;

        @GetMapping("/tutorials")
        public ResponseEntity<List<MoviesCreditsDTO>> getAllTutorials(@RequestParam(required = false) String title) {
            try {
                List<MoviesCreditsDTO> tutorials = new ArrayList<MoviesCreditsDTO>();



                    requestRepository.findByTitleContaining(title).forEach(tutorials::add);

                if (tutorials.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(tutorials, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    @GetMapping("/movies/all")
    public ResponseEntity<List<MoviesCreditsDTO>> getAllMovies() {
        try {

            List<MoviesCreditsDTO> tutorial = new ArrayList<>();


                requestRepository.findAll().forEach(movies ->tutorial.add(movies));





            if (tutorial.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorial, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
