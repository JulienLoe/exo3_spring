package com.example.exo3spring.models;

import jakarta.persistence.*;


@Entity
@Table(name = "tutorials")
public class Tutorial {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;
        @Column(length = 1200)
        public String adult;
    @Column(length = 1200)
        public String belongs_to_collection;
        public Long budget;
    @Column(length = 1200)
        public String genres;
    @Column(length = 1200)
        public String homepage;
    @Column(insertable=false, updatable=false)
        public  int id;
    @Column(length = 1200)

        public String imdb_id;
    @Column(length = 1200)
        public String original_language;
    @Column(length = 1200)
        public String original_title;
    @Column(length = 1200)
        public String overview;
    @Column(length = 1200)
        public String popularity;
    @Column(length = 1200)
        public String poster_path;
    @Column(length = 1200)
    public String production_companies;
    @Column(length = 1200)
    public String production_countries;
    @Column(length = 1200)
        public String release_date;
        public Long revenue;
    @Column(length = 1200)
        public String runtime;
    @Column(length = 1200)
        public String spoken_languages;
    @Column(length = 1200)
        public String status;
    @Column(length = 1200)
        public String tagline;
    @Column(length = 1200)
        public String title;
    @Column(length = 1200)
        public String video;
    @Column(length = 1200)
        public String vote_average;
        public Long vote_count;



    public Tutorial(int Id, String adult, String belongs_to_collection, long budget, String genres, String homepage, int id, String imdb_id, String original_language, String original_title, String overview, String poster_path, String production_companies,String production_countries, String popularity, String release_date, long revenue, String runtime, String spoken_languages, String status, String tagline, String title, String video, String vote_average, long vote_count) {
        this.Id = Id;
        this.adult = adult;
        this.belongs_to_collection = belongs_to_collection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
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
        this.spoken_languages = spoken_languages;
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


