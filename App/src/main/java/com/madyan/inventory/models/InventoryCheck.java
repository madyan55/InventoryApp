package com.madyan.inventory.models;

public class InventoryCheck {
    private int id;
    private String date;
    private int warehouseId;

    // 🔹 Constructor
    public InventoryCheck(int id, String date, int warehouseId) {
        this.id = id;
        this.date = date;
        this.warehouseId = warehouseId;
    }

    // 🔹 Getters
    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    // 🔹 Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    // 🔹 ToString for debugging
    @Override
    public String toString() {
        return "InventoryCheck{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", warehouseId=" + warehouseId +
                '}';
    }
}
