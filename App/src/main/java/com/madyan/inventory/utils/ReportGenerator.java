package com.madyan.inventory.utils;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.madyan.inventory.models.InventoryCheck;
import com.madyan.inventory.models.InventoryDetail;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ReportGenerator {

    private Context context;

    public ReportGenerator(Context context) {
        this.context = context;
    }

    // 🔹 توليد تقرير PDF
    public void generatePDF(InventoryCheck check, List<InventoryDetail> details) {
        Document document = new Document();
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "InventoryReport_" + check.getId() + ".pdf");
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            document.add(new Paragraph("تقرير عملية الجرد رقم: " + check.getId()));
            document.add(new Paragraph("التاريخ: " + check.getDate()));
            document.add(new Paragraph("المخزن: " + check.getWarehouseId()));
            document.add(new Paragraph("--------------------------------------------------"));

            for (InventoryDetail detail : details) {
                document.add(new Paragraph("المنتج: " + detail.getProductId() +
                        " | بالنظام: " + detail.getSystemQty() +
                        " | فعلي: " + detail.getActualQty() +
                        " | الفرق: " + detail.getDifference()));
            }

            document.close();
            Toast.makeText(context, "تم إنشاء تقرير PDF بنجاح", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "خطأ أثناء إنشاء التقرير", Toast.LENGTH_SHORT).show();
        }
    }

    // 🔹 توليد تقرير Excel
    public void generateExcel(InventoryCheck check, List<InventoryDetail> details) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Inventory Report");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("المنتج");
        header.createCell(1).setCellValue("بالنظام");
        header.createCell(2).setCellValue("فعلي");
        header.createCell(3).setCellValue("الفرق");

        int rowIndex = 1;
        for (InventoryDetail detail : details) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(detail.getProductId());
            row.createCell(1).setCellValue(detail.getSystemQty());
            row.createCell(2).setCellValue(detail.getActualQty());
            row.createCell(3).setCellValue(detail.getDifference());
        }

        try {
            File file = new File(Environment.getExternalStorageDirectory(), "InventoryReport_" + check.getId() + ".xlsx");
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();
            workbook.close();
            Toast.makeText(context, "تم إنشاء تقرير Excel بنجاح", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "خطأ أثناء إنشاء التقرير", Toast.LENGTH_SHORT).show();
        }
    }
}
