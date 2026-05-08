package com.madyan.inventory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // ربط العناصر من واجهة XML
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin   = findViewById(R.id.btnLogin);

        // حدث الضغط على زر تسجيل الدخول
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (validateLogin(username, password)) {
                    // نجاح تسجيل الدخول → الانتقال إلى لوحة التحكم
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // فشل تسجيل الدخول → رسالة خطأ
                    Toast.makeText(LoginActivity.this, "بيانات الدخول غير صحيحة!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // 🔹 التحقق من بيانات الدخول (بسيط – يمكن تطويره لاحقًا)
    private boolean validateLogin(String username, String password) {
        // مثال: اسم مستخدم admin وكلمة مرور 1234
        return username.equals("admin") && password.equals("1234");
    }
}
