package com.soloGamer.soloGamer.Model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false, length = 20)
    private String discord;

    @Column(nullable = false, length = 20)
    private String game;

    @Column(nullable = false, length = 20)
    private String level;

    @Column(nullable = false, length = 20)
    private String clasament;

    @Column(nullable = false, length = 20)
    private String main;

    public User() {
    }
        public Long getId () {
            return id;
        }

        public void setId (Long id){
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email){
            this.email = email;
        }

        public String getPassword () {
            return password;
        }

        public void setPassword (String password){
            this.password = password;
        }

        public String getDiscord() {
            return discord;
        }

        public void setDiscord(String discord) {
            this.discord = discord;
        }

        public String getGame() {
            return game;
        }

        public void setGame(String game) {
            this.game = game;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getClasament() {
            return clasament;
        }

        public void setClasament(String clasament) {
            this.clasament = clasament;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }
}
