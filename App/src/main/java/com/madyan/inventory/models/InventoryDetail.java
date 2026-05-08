package com.madyan.inventory.models;

public class InventoryDetail {
    private int id;
    private int checkId;      // رقم عملية الجرد
    private int productId;    // رقم المنتج
    private int systemQty;    // الكمية بالنظام
    private int actualQty;    // الكمية الفعلية
    private int difference;   // الفرق (زيادة/عجز)

    // 🔹 Constructor
    public InventoryDetail(int id, int checkId, int productId, int systemQty, int actualQty) {
        this.id = id;
        this.checkId = checkId;
        this.productId = productId;
        this.systemQty = systemQty;
        this.actualQty = actualQty;
        this.difference = actualQty - systemQty;
    }

    // 🔹 Getters
    public int getId() {
        return id;
    }

    public int getCheckId() {
        return checkId;
    }

    public int getProductId() {
        return productId;
    }

    public int getSystemQty() {
        return systemQty;
    }

    public int getActualQty() {
        return actualQty;
    }

    public int getDifference() {
        return difference;
    }

    // 🔹 Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setSystemQty(int systemQty) {
        this.systemQty = systemQty;
        updateDifference();
    }

    public void setActualQty(int actualQty) {
        this.actualQty = actualQty;
        updateDifference();
    }

    // 🔹 تحديث الفرق تلقائيًا
    private void updateDifference() {
        this.difference = this.actualQty - this.systemQty;
    }

    // 🔹 ToString for debugging
    @Override
    public String toString() {
        return "InventoryDetail{" +
                "id=" + id +
                ", checkId=" + checkId +
                ", productId=" + productId +
                ", systemQty=" + systemQty +
                ", actualQty=" + actualQty +
                ", difference=" + difference +
                '}';
    }
}
