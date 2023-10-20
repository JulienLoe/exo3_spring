package com.example.exo3spring.repositories;

import com.example.exo3spring.models.MoviesCreditsDTO;
import com.example.exo3spring.models.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public List<MoviesCreditsDTO> findAll() {
        return jdbcTemplate.query("SELECT * from tutorials", BeanPropertyRowMapper.newInstance(MoviesCreditsDTO.class));
    }


    public List<MoviesCreditsDTO> findByTitleContaining(String title) {
        String q = "SELECT * from tutorials t join credits c on c.credits_id_csv = t.movie_id WHERE title ILIKE '%" + title + "%' OR genres ILIKE '%" + title + "%' OR crew ILIKE '%" + title + "%' ";

        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(MoviesCreditsDTO.class));
    }
//    select distinct t.title  , c.crew from tutorials t join credits c on c.credits_id_csv = t.movie_id  WHERE title = 'Braveheart'
}
