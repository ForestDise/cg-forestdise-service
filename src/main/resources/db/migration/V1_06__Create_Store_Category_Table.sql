CREATE TABLE IF NOT EXISTS STORE_CATEGORY (
    ID  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    HERO_IMAGE VARCHAR(255) NOT NULL,
    SQUARE_IMAGE VARCHAR(255) NOT NULL,
    PARENT_STORE_CATEGORY_ID INT ,
    STORE_ID INT,
    FOREIGN KEY (PARENT_STORE_CATEGORY_ID) REFERENCES STORE_CATEGORY(ID),
    FOREIGN KEY (STORE_ID) REFERENCES STORE(ID)
)