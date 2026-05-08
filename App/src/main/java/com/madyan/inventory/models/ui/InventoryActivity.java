package com.madyan.inventory.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.madyan.inventory.R;
import com.madyan.inventory.models.InventoryDetail;
import com.madyan.inventory.models.Product;

import java.util.ArrayList;
import java.util.List;

public class InventoryActivity extends AppCompatActivity {

    private Spinner spWarehouse;
    private RecyclerView rvProducts;
    private Button btnCalculate, btnSave;
    private TextView tvDifference;

    private List<Product> productList;
    private InventoryAdapter adapter; // تحتاج لإنشاء Adapter مخصص
    private int totalDifference = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        spWarehouse   = findViewById(R.id.spWarehouse);
        rvProducts    = findViewById(R.id.rvProducts);
        btnCalculate  = findViewById(R.id.btnCalculate);
        btnSave       = findViewById(R.id.btnSave);
        tvDifference  = findViewById(R.id.tvDifference);

        productList = new ArrayList<>();
        // مثال بيانات تجريبية
        productList.add(new Product(1, "منتج A", 50, 10.0));
        productList.add(new Product(2, "منتج B", 30, 5.0));

        adapter = new InventoryAdapter(productList);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        rvProducts.setAdapter(adapter);

        // زر حساب الفرق
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDifference();
            }
        });

        // زر حفظ العملية
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInventoryCheck();
            }
        });
    }

    // 🔹 حساب الفرق بين الكميات بالنظام والفعلية
    private void calculateDifference() {
        totalDifference = 0;
        for (Product product : productList) {
            int systemQty = product.getQuantity();
            int actualQty = adapter.getActualQty(product.getId()); // يسترجع الكمية الفعلية من الـ Adapter
            int diff = actualQty - systemQty;
            totalDifference += diff;
        }
        tvDifference.setText("الفرق: " + totalDifference);
        Toast.makeText(this, "تم حساب الفرق", Toast.LENGTH_SHORT).show();
    }

    // 🔹 حفظ عملية الجرد
    private void saveInventoryCheck() {
        // هنا يمكن ربط العملية بقاعدة البيانات
        Toast.makeText(this, "تم حفظ عملية الجرد بنجاح", Toast.LENGTH_SHORT).show();
    }
}
