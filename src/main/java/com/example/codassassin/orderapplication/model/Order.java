package com.example.codassassin.orderapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Order {
    private long id;

    private List<String> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}