package com.learn.learnboot.api.entity;

/*
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| bid       | int          | NO   |     | 0       |       |
| author    | varchar(255) | YES  |     | NULL    |       |
| pages     | int          | NO   |     | NULL    |       |
| title     | varchar(255) | YES  |     | NULL    |       |
| book_name | varchar(255) | YES  |     | NULL    |       |
| published | date         | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
 */

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int bid;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;
    private int pages;

    private String title;
    @Column(name="book_name")
    private String bookName;
    @Temporal(TemporalType.DATE)
    private java.util.Date published;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", title='" + title + '\'' +
                ", bookName='" + bookName + '\'' +
                ", published=" + published +
                '}';
    }
}
