package com.cleto.cinecartaz.model;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "cinemas")
@NoArgsConstructor
@CompoundIndex( def = "{'name' : 1, 'company' : 1}", unique = true)
public class Cinema {

    @Id
    private long id;
    private String name;
    private String company;
    private String county;
    private String location;

    private List<Session> sessions;

    public Cinema(String name, String company, String address, String county, String location) {
        this.name = name;
        this.company = company;
        this.county = county;
        this.location = location;
        this.sessions = new ArrayList<>();
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

    public List<Session> getSessions() {
        return sessions;
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

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", county='" + county + '\'' +
                ", location='" + location + '\'' +
                ", sessions=" + sessions +
                '}';
    }
}
