package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "submissions")
public class Submissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "expertise")
    private String expertise;
    

    @Column(name = "author1")
    private String author1;

    @Column(name = "author2")
    private String author2;

    @Column(name = "abstract", columnDefinition = "TEXT")
    private String abstractText;

    @Column(name = "review1", columnDefinition = "TEXT")
    private String review1;

    @Column(name = "review2", columnDefinition = "TEXT")
    private String review2;
<<<<<<< HEAD
    @Column(name = "status")
    private String status;
=======
    
    @Column(name = "status")
    private String status;
    
>>>>>>> 418c0ab32669f93fd65a38fb095e059765122124

    // Constructors


    public Submissions() {
        // Default constructor needed by JPA
    }

    public Submissions(String title, String author1, String author2, String abstractText, String review1, String review2) {
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.abstractText = abstractText;
        this.review1 = review1;
        this.review2 = review2;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor1() {
        return author1;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getReview1() {
        return review1;
    }

    public void setReview1(String review1) {
        this.review1 = review1;
    }

    public String getReview2() {
        return review2;
    }

    public void setReview2(String review2) {
        this.review2 = review2;
    }
<<<<<<< HEAD
    
=======
>>>>>>> 418c0ab32669f93fd65a38fb095e059765122124
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
<<<<<<< HEAD
    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
=======
    
>>>>>>> 418c0ab32669f93fd65a38fb095e059765122124
}
