package com.learn.learnboot.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.learn.learnboot.jpa.entity.User;
import jakarta.persistence.*;

@Entity
public class Author  {

    @Id
    private int id ;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "author")
    @JsonBackReference
    Book book;

    public Author(){};
    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", book=" + book +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
