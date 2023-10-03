CREATE TABLE IF NOT EXISTS image (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       img_path VARCHAR(255),
                       variant_id INT,
                       FOREIGN KEY (variant_id) REFERENCES variant (id)
);