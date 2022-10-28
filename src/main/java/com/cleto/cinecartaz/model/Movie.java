package com.cleto.cinecartaz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Document("movies")
@CompoundIndex(name = "movie_compound_index",def = "{'title' : 1, 'duration' : 1}", unique = true)
public class Movie {

    @Id
    private long id;

    private String title;

    private String original_title;

    private String genre;

    private LocalTime duration;

    private List<Session> sessions;

    public Movie(String title, String original_title, String genre, LocalTime duration) {
        this.title = title;
        this.original_title = original_title;
        this.genre = genre;
        this.duration = duration;
        this.sessions = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", original_title='" + original_title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", sessions=" + sessions +
                '}';
    }
}
