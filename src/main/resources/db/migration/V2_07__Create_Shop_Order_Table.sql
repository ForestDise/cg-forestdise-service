CREATE TABLE IF NOT EXISTS SHOP_ORDER(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    USER_ID INT,
--     CART_LINE_ID INT,
    ORDER_DATE DATE,
    ADDRESS_ID INT,
    MESSAGE VARCHAR(2000),
    PAYMENT_METHOD VARCHAR(255),
    SHIPPING_METHOD_ID INT,
    ORDER_TOTAL DOUBLE,
    FOREIGN KEY (USER_ID) REFERENCES USER(ID),
--     FOREIGN KEY (CART_LINE_ID) REFERENCES CART_LINE(ID),
    FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS(ID),
    FOREIGN KEY (SHIPPING_METHOD_ID) REFERENCES SHIPPING_METHOD(ID)
);