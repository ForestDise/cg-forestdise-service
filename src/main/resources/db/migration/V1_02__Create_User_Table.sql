CREATE TABLE IF NOT EXISTS USER(
    ID       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    NAME     VARCHAR(50),
    EMAIL    VARCHAR(100),
    PASSWORD VARCHAR(50),
    ADDRESS  VARCHAR(200),
    CART_ID  INT,
    FOREIGN KEY (CART_ID) REFERENCES CART(ID)
);