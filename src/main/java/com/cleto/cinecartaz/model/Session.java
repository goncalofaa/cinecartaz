package com.cleto.cinecartaz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection = "sessions")
@CompoundIndex(name = "session_compound_index",def = "{'cinema' : 1, 'time' : 1, 'movie':1}", unique = true)
public class Session {

    @Transient
    public static final String SEQUENCE_NAME = "session_sequence";
    @Id
    private int id;

    private Cinema cinema;

    private Timestamp time;

    private Movie movie;

    public Session(Cinema cinema, Timestamp time, Movie movie) {
        this.cinema = cinema;
        this.time = time;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", cinema=" + cinema +
                ", time=" + time +
                ", movie=" + movie +
                '}';
    }
}
