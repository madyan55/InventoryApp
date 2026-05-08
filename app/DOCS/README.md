# Madyan Inventory ERP

نظام إدارة المخزون (ERP) مبسط لإدارة المنتجات والمخازن وتنفيذ عمليات الجرد مع توليد تقارير رسمية.

---

## 📂 هيكل المشروع
- **app/src/main/java/com/madyan/inventory/**
  - `ui/` → واجهات المستخدم (Activities)
  - `models/` → الكائنات الأساسية (Product, Warehouse, InventoryCheck, InventoryDetail)
  - `res/` → الموارد (layouts, drawables, values)
- **app/src/test/** → اختبارات الوحدات (UnitTests.java)
- **DOCS/** → التوثيق الرسمي (README, ERD, User Guide, Training Materials)

---

## 🚀 المزايا
- تسجيل الدخول الآمن.
- لوحة تحكم رئيسية للتنقل بين الوحدات.
- إدارة المنتجات والمخازن.
- تنفيذ عمليات الجرد وحساب الفروقات.
- مراجعة العمليات السابقة وتوليد تقارير.
- دعم ثنائي اللغة (عربي/إنجليزي).
- تصميم متناسق باستخدام ألوان وخطوط موحدة.

---

## 🛠️ المتطلبات
- Android Studio Arctic Fox أو أحدث.
- Java 8 أو Kotlin.
- مكتبات:
  - Material Components
  - RecyclerView
  - JUnit (للاختبارات)

---

## 📖 دليل الاستخدام
1. تسجيل الدخول عبر شاشة **LoginActivity**.
2. الانتقال إلى لوحة التحكم **DashboardActivity**.
3. إدارة المنتجات والمخازن عبر **ProductActivity** و **WarehouseActivity**.
4. تنفيذ عملية الجرد عبر **InventoryActivity**.
5. مراجعة العمليات السابقة وتصدير التقارير عبر **ReportsActivity**.

---

## 📊 التوثيق
- [ERD.png](ca://s?q=عرض_مخطط_ERD.png) → مخطط العلاقات بين الجداول.
- [ProjectStructure.md](ca://s?q=عرض_كود_ProjectStructure.md) → هيكل المشروع.
- [UserGuide.pdf](ca://s?q=عرض_ملف_UserGuide.pdf) → دليل المستخدم.
- [API_Documentation.md](ca://s?q=عرض_كود_API_Documentation.md) → توثيق الـ API.

---

## 👨‍💻 المطور
مدين الحكيمي (Madyan AL-hakimi)  
Project Owner & Technical Lead
