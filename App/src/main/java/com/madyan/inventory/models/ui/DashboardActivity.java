package com.madyan.inventory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.madyan.inventory.R;

public class DashboardActivity extends AppCompatActivity {

    private Button btnProducts, btnWarehouses, btnInventory, btnReports, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // ربط العناصر من واجهة XML
        btnProducts   = findViewById(R.id.btnProducts);
        btnWarehouses = findViewById(R.id.btnWarehouses);
        btnInventory  = findViewById(R.id.btnInventory);
        btnReports    = findViewById(R.id.btnReports);
        btnLogout     = findViewById(R.id.btnLogout);

        // 🔹 الانتقال إلى شاشة المنتجات
        btnProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });

        // 🔹 الانتقال إلى شاشة المخازن
        btnWarehouses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, WarehouseActivity.class);
                startActivity(intent);
            }
        });

        // 🔹 الانتقال إلى شاشة الجرد
        btnInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, InventoryActivity.class);
                startActivity(intent);
            }
        });

        // 🔹 الانتقال إلى شاشة التقارير
        btnReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, ReportsActivity.class);
                startActivity(intent);
            }
        });

        // 🔹 تسجيل الخروج والعودة لشاشة تسجيل الدخول
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
