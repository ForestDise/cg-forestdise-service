CREATE TABLE IF NOT EXISTS variant (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255),
                         sku_code VARCHAR(255),
                         stock_quantity INT,
                         weight DOUBLE,
                         price DOUBLE,
                         img VARCHAR(255),
                         product_id BIGINT,
                         FOREIGN KEY (product_id) REFERENCES product (id)
);