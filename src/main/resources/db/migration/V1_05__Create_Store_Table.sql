CREATE TABLE IF NOT EXISTS STORE (
                                     ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                     NAME TEXT NOT NULL,
                                     LOGO VARCHAR(255) NOT NULL,
    HOME_IMAGE VARCHAR(255) NOT NULL,
    DEALS_IMAGE VARCHAR(255) NOT NULL,
    DEALS_SQUARE_IMAGE VARCHAR(255) NOT NULL,
    INTERACTIVE_IMAGE VARCHAR(255) NOT NULL,
    SELLER_ID INT,
    FOREIGN KEY (SELLER_ID) REFERENCES SELLER(ID)
    )