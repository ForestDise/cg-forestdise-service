CREATE TABLE IF NOT EXISTS CART
(
    ID      INT AUTO_INCREMENT NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS CART_LINE
(
    ID         INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    QUANTITY   INT          NOT NULL CHECK ( QUANTITY >= 0 ),
    CART_ID    INT,
    VARIANT_ID INT,
    FOREIGN KEY (CART_ID) REFERENCES CART(ID)
);