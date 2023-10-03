CREATE TABLE IF NOT EXISTS VARIANT (
                         ID INT PRIMARY KEY AUTO_INCREMENT,
                         NAME VARCHAR(255),
                         SKU_CODE VARCHAR(255),
                         STOCK_QUANTITY INT,
                         WEIGHT DOUBLE,
                         PRICE DOUBLE,
                         IMG VARCHAR(255),
                         PRODUCT_ID INT,
                         FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID)
);