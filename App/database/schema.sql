-- إنشاء الجداول الأساسية

CREATE TABLE Products (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE Warehouses (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE InventoryChecks (
    id INT PRIMARY KEY,
    date DATE NOT NULL,
    warehouseId INT NOT NULL,
    FOREIGN KEY (warehouseId) REFERENCES Warehouses(id)
);

CREATE TABLE InventoryDetails (
    id INT PRIMARY KEY,
    checkId INT NOT NULL,
    productId INT NOT NULL,
    systemQty INT NOT NULL,
    actualQty INT NOT NULL,
    difference INT GENERATED ALWAYS AS (actualQty - systemQty) STORED,
    FOREIGN KEY (checkId) REFERENCES InventoryChecks(id),
    FOREIGN KEY (productId) REFERENCES Products(id)
);
