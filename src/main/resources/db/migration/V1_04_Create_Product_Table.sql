CREATE TABLE product (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         title VARCHAR(255),
                         description TEXT,
                         main_picture VARCHAR(255),
                         status VARCHAR(50),
                         create_at DATETIME,
                         updated_at DATETIME,
                         category_id BIGINT,
                         FOREIGN KEY (category_id) REFERENCES category (id)
);