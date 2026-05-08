package com.madyan.inventory.models;

public class Warehouse {
    private int id;
    private String name;

    // 🔹 Constructor
    public Warehouse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 🔹 Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // 🔹 Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 🔹 ToString for debugging
    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
