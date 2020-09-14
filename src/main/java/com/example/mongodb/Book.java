package com.example.mongodb;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Book extends PanacheMongoEntity {

    public String title;
    public String author;

}