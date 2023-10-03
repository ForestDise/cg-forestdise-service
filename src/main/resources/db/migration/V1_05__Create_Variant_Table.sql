CREATE TABLE IF NOT EXISTS variant
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(255),
    sku_code       VARCHAR(255),
    stock_quantity INT,
    weight         DOUBLE,
    price          DOUBLE,
    img            VARCHAR(255),
    product_id     INT,
    FOREIGN KEY (product_id) REFERENCES product (id)
);