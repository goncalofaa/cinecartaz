package com.cleto.cinecartaz.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "cinemas")
@NoArgsConstructor
@CompoundIndex(name = "cinema_compound_index",def = "{'name' : 1, 'location' : 1, 'company':1}", unique = true)
public class Cinema {
    @Transient
    public static final String SEQUENCE_NAME = "cinema_sequence";
    @Id
    private long id;
    private String name;
    private String company;
    private String county;
    private String location;

    public Cinema(String name, String company, String county, String location) {
        this.name = name;
        this.company = company;
        this.county = county;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getCounty() {
        return county;
    }

    public String getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public void setCounty(String county) {
        this.county = county;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", county='" + county + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
