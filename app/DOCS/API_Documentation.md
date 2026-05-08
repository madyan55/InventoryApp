# توثيق واجهات API (API Documentation)

هذا الملف يوضح واجهات الـ API الخاصة بنظام **Madyan Inventory ERP**، مع أمثلة للطلبات والاستجابات.

---

## 📌 الأساسيات
- **Base URL:** `https://api.madyan-inventory.com/v1/`
- **Authentication:** جميع الطلبات تتطلب `Bearer Token` يتم الحصول عليه بعد تسجيل الدخول.

---

## 🔹 1. تسجيل الدخول (Login)
**Endpoint:** `POST /auth/login`

**Request:**
```json
{
  "username": "admin",
  "password": "123456"
}
