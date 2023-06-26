package com.example.cpt_project.domain.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "offers")
public class Offers {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "offers_seq", sequenceName = "offers_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offers_seq")
    private Long id;

    @Column(name = "id_user")
    private Long user;

    @Column(name = "id_directions")
    private Long directions;

    @Column(name = "file")
    private String file;

    @Column(name = "date_offers")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Offers() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getDirections() {
        return directions;
    }

    public void setDirections(Long directions) {
        this.directions = directions;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
