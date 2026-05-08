package com.madyan.inventory.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "inventory.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // جدول المنتجات
        db.execSQL("CREATE TABLE Products (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "quantity INTEGER, " +
                "price REAL)");

        // جدول المخازن
        db.execSQL("CREATE TABLE Warehouses (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT)");

        // جدول عمليات الجرد
        db.execSQL("CREATE TABLE InventoryChecks (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date TEXT, " +
                "warehouseId INTEGER)");

        // جدول تفاصيل الجرد
        db.execSQL("CREATE TABLE InventoryDetails (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "checkId INTEGER, " +
                "productId INTEGER, " +
                "systemQty INTEGER, " +
                "actualQty INTEGER, " +
                "difference INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Products");
        db.execSQL("DROP TABLE IF EXISTS Warehouses");
        db.execSQL("DROP TABLE IF EXISTS InventoryChecks");
        db.execSQL("DROP TABLE IF EXISTS InventoryDetails");
        onCreate(db);
    }
}
