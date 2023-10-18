CREATE TABLE IF NOT EXISTS PRODUCT (
                         ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         TITLE VARCHAR(255),
                         DESCRIPTION TEXT,
                         MAIN_PICTURE VARCHAR(255),
                         STATUS VARCHAR(50),
                         CREATE_AT DATETIME,
                         UPDATED_AT DATETIME,
                         CATEGORY_ID INT,
                         FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID)
);