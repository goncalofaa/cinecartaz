package com.cleto.cinecartaz.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Document("movies")
@Getter
@Setter
@CompoundIndex(name = "movie_compound_index",def = "{'title' : 1, 'duration' : 1}", unique = true)
public class Movie {

    @Id
    private long id;

    private String title;

    private String original_title;

    private List<String> genre;

    private String duration;

    private String endpoint;

    private List<Session> sessions;

    public Movie(String title, String original_title, List<String> genre, String duration, String endpoint) {
        this.title = title;
        this.original_title = original_title;
        this.genre = genre;
        this.duration = duration;
        this.sessions = new ArrayList<>();
        this.endpoint= endpoint;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", original_title='" + original_title + '\'' +
                ", genre='" + genre.toString() + '\'' +
                ", duration=" + duration +
                ", sessions=" + sessions +
                '}';
    }
}
