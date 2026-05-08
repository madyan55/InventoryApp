package com.madyan.inventory.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.madyan.inventory.R;
import com.madyan.inventory.models.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class WarehouseActivity extends AppCompatActivity {

    private RecyclerView rvWarehouses;
    private FloatingActionButton fabAddWarehouse;
    private List<Warehouse> warehouseList;
    private WarehouseAdapter adapter; // تحتاج لإنشاء Adapter مخصص

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);

        rvWarehouses = findViewById(R.id.rvWarehouses);
        fabAddWarehouse = findViewById(R.id.fabAddWarehouse);

        warehouseList = new ArrayList<>();
        adapter = new WarehouseAdapter(warehouseList);
        rvWarehouses.setLayoutManager(new LinearLayoutManager(this));
        rvWarehouses.setAdapter(adapter);

        // زر إضافة مخزن جديد
        fabAddWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddWarehouseDialog();
            }
        });
    }

    // 🔹 نافذة إدخال مخزن جديد
    private void showAddWarehouseDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("إضافة مخزن جديد");

        View view = getLayoutInflater().inflate(R.layout.dialog_add_warehouse, null);
        EditText etName = view.findViewById(R.id.etWarehouseName);

        builder.setView(view);

        builder.setPositiveButton("حفظ", (dialog, which) -> {
            String name = etName.getText().toString().trim();

            Warehouse warehouse = new Warehouse(warehouseList.size() + 1, name);
            warehouseList.add(warehouse);
            adapter.notifyDataSetChanged();

            Toast.makeText(WarehouseActivity.this, "تم إضافة المخزن بنجاح", Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("إلغاء", (dialog, which) -> dialog.dismiss());

        builder.show();
    }
}
