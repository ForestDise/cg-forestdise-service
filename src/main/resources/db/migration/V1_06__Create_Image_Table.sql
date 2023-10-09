CREATE TABLE IF NOT EXISTS IMAGE (
                       ID INT PRIMARY KEY AUTO_INCREMENT,
                       IMG_PATH VARCHAR(255),
                       VARIANT_ID INT,
                       FOREIGN KEY (VARIANT_ID) REFERENCES VARIANT (ID)
);