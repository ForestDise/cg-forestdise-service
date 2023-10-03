CREATE TABLE IF NOT EXISTS CART
(
    ID      INT PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE IF NOT EXISTS CART_LINE
(
    ID         INT PRIMARY KEY AUTO_INCREMENT,
    QUANTITY   INT          NOT NULL CHECK ( QUANTITY >= 0 ),
    CART_ID    INT,
    VARIANT_ID INT,
    FOREIGN KEY (CART_ID) REFERENCES CART(ID)
);