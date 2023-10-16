package com.example.exo3spring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tutorials")
public class Tutorial {




        public String adult;
        public String belongs_to_collection;
        public Long budget;
        public String genres;
        public String homepage;
    @Id
        public String idfilm;

        public String imdb_id;
        public String original_language;
        public String original_title;
        public String overview;
        public String popularity;
        public String poster_path;
    public String production_companies;
    public String production_countries;
        public String release_date;
        public Long revenue;
        public String runtime;
        public String spoken_languages;
        public String status;
        public String tagline;
        public String title;
        public String video;
        public String vote_average;
        public Long vote_count;

    public Tutorial(String production_companies, String production_countries) {
        this.production_companies = production_companies;
        this.production_countries = production_countries;
    }

    public Tutorial( String adult,String production_companies,String spoken_languages, String production_countries, String belongs_to_collection, long budget, String genres, String homepage, String idfilm, String imdb_id, String original_language, String original_title, String overview, String popularity, String poster_path, String release_date, Long revenue, String runtime, String status, String tagline, String title, String video, String vote_average, Long vote_count) {

        this.adult = adult;
        this.belongs_to_collection = belongs_to_collection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.idfilm = idfilm;
        this.imdb_id = imdb_id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spoken_languages = spoken_language;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public Tutorial() {

    }
}


