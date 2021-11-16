package com.example.projeto_pas;

public class MealType {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MealType(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
