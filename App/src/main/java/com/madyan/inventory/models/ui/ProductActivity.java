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
import com.madyan.inventory.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView rvProducts;
    private FloatingActionButton fabAddProduct;
    private List<Product> productList;
    private ProductAdapter adapter; // تحتاج لإنشاء Adapter مخصص

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        rvProducts = findViewById(R.id.rvProducts);
        fabAddProduct = findViewById(R.id.fabAddProduct);

        productList = new ArrayList<>();
        adapter = new ProductAdapter(productList);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        rvProducts.setAdapter(adapter);

        // زر إضافة منتج جديد
        fabAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddProductDialog();
            }
        });
    }

    // 🔹 نافذة إدخال منتج جديد
    private void showAddProductDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("إضافة منتج جديد");

        View view = getLayoutInflater().inflate(R.layout.dialog_add_product, null);
        EditText etName = view.findViewById(R.id.etProductName);
        EditText etQty  = view.findViewById(R.id.etProductQty);
        EditText etPrice= view.findViewById(R.id.etProductPrice);

        builder.setView(view);

        builder.setPositiveButton("حفظ", (dialog, which) -> {
            String name = etName.getText().toString().trim();
            int qty = Integer.parseInt(etQty.getText().toString().trim());
            double price = Double.parseDouble(etPrice.getText().toString().trim());

            Product product = new Product(productList.size() + 1, name, qty, price);
            productList.add(product);
            adapter.notifyDataSetChanged();

            Toast.makeText(ProductActivity.this, "تم إضافة المنتج بنجاح", Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("إلغاء", (dialog, which) -> dialog.dismiss());

        builder.show();
    }
}
