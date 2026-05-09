package com.madyan.inventory;

import com.madyan.inventory.models.InventoryDetail;
import com.madyan.inventory.models.InventoryCheck;
import com.madyan.inventory.models.Product;
import com.madyan.inventory.models.Warehouse;

import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTests {

    // 🔹 اختبار إنشاء منتج
    @Test
    public void testProductCreation() {
        Product product = new Product(1, "قماش فاخر", 50, 120.0);
        assertEquals(1, product.getId());
        assertEquals("قماش فاخر", product.getName());
        assertEquals(50, product.getQuantity());
        assertEquals(120.0, product.getPrice(), 0.01);
    }

    // 🔹 اختبار إنشاء مخزن
    @Test
    public void testWarehouseCreation() {
        Warehouse warehouse = new Warehouse(1, "المخزن الرئيسي");
        assertEquals(1, warehouse.getId());
        assertEquals("المخزن الرئيسي", warehouse.getName());
    }

    // 🔹 اختبار عملية الجرد
    @Test
    public void testInventoryCheckCreation() {
        InventoryCheck check = new InventoryCheck(1, "2026-05-08", 1);
        assertEquals(1, check.getId());
        assertEquals("2026-05-08", check.getDate());
        assertEquals(1, check.getWarehouseId());
    }

    // 🔹 اختبار تفاصيل الجرد وحساب الفرق
    @Test
    public void testInventoryDetailDifference() {
        InventoryDetail detail = new InventoryDetail(1, 1, 1, 50, 45);
        assertEquals(-5, detail.getDifference()); // فرق عجز
        detail.setActualQty(55);
        assertEquals(5, detail.getDifference());  // فرق زيادة
    }
}
