package com.example.exo3spring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "credits")
public class Credits {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int Id;

    @Column(length = 100000, name = "casting")
    public String cast;

    @Column(length = 100000)
    public String crew;

    @Column(name = "credits_id_csv")

    public int id;

//    @ElementCollection
//    public List<Object> cast;
//
//    @ElementCollection
//    public List<Object> crew;
    @OneToOne(mappedBy = "credits", cascade = CascadeType.ALL)
    public Tutorial tutorial;



    public Credits(String cast, String crew, int id) {
//        this.cast = new ArrayList<>();
//     this.crew = new ArrayList<>();
        this.cast = cast;
        this.crew = crew;
        this.id=id;

    }

    public Credits(){

    }


    public static class ActeurDTO {

        public int cast_id;
        public String character;
        public String credit_id;
        public int gender;
        public int id;
        public String name;
        public int order;
        public String profile_path;

        public ActeurDTO(int cast_id, String character, String credit_id, int gender, int id, String name, int order, String profile_path) {
            this.cast_id = cast_id;
            this.character = character;
            this.credit_id = credit_id;
            this.gender = gender;
            this.id = id;
            this.name = name;
            this.order = order;
            this.profile_path = profile_path;
        }

        public int getCast_id() {
            return cast_id;
        }

        public void setCast_id(int cast_id) {
            this.cast_id = cast_id;
        }

        public String getCharacter() {
            return character;
        }

        public void setCharacter(String character) {
            this.character = character;
        }

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }
    }
}
