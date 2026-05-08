package com.madyan.inventory.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.madyan.inventory.R;
import com.madyan.inventory.models.InventoryCheck;

import java.util.ArrayList;
import java.util.List;

public class ReportsActivity extends AppCompatActivity {

    private RecyclerView rvReports;
    private Button btnExport;
    private List<InventoryCheck> reportList;
    private ReportsAdapter adapter; // تحتاج لإنشاء Adapter مخصص

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        rvReports = findViewById(R.id.rvReports);
        btnExport = findViewById(R.id.btnExport);

        reportList = new ArrayList<>();
        // مثال بيانات تجريبية
        reportList.add(new InventoryCheck(1, "2026-05-01", 1));
        reportList.add(new InventoryCheck(2, "2026-05-05", 2));

        adapter = new ReportsAdapter(reportList);
        rvReports.setLayoutManager(new LinearLayoutManager(this));
        rvReports.setAdapter(adapter);

        // زر تصدير التقرير
        btnExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exportReport();
            }
        });
    }

    // 🔹 تصدير التقرير (يمكن تطويره لاحقًا لتوليد PDF أو Excel)
    private void exportReport() {
        Toast.makeText(this, "تم تصدير التقرير بنجاح", Toast.LENGTH_SHORT).show();
    }
}
