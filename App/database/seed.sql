-- إدخال بيانات أولية للتجربة

INSERT INTO Products (id, name, quantity, price) VALUES
(1, 'قماش فاخر', 50, 120.00),
(2, 'خيط حرير', 200, 15.00),
(3, 'زر معدني', 500, 2.50);

INSERT INTO Warehouses (id, name) VALUES
(1, 'المخزن الرئيسي'),
(2, 'المخزن الفرعي');

INSERT INTO InventoryChecks (id, date, warehouseId) VALUES
(1, '2026-05-08', 1);

INSERT INTO InventoryDetails (id, checkId, productId, systemQty, actualQty) VALUES
(1, 1, 1, 50, 45),
(2, 1, 2, 200, 200),
(3, 1, 3, 500, 510);
