package com.example.csgoapp;

import androidx.annotation.NonNull;

import java.util.List;

public class Quote {
    private  String _id ;
    private List<String> tags;
    private String content;
    private String author;
    private String authorSlug;
    private int length;
    private String dateAdded;
    private String dateModified;

    @NonNull
    @Override
    public String toString() {
        return "Quote{" +
                "_id=" + _id +
                "tags="+ tags +
                "content="+ content +
                "author="+ author+
                "authorSlug="+ authorSlug+
                "length="+ length+
                "dateAdded="+ dateAdded+
                "dateModified="+ dateModified+
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorSlug() {
        return authorSlug;
    }

    public void setAuthorSlug(String authorSlug) {
        this.authorSlug = authorSlug;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}
