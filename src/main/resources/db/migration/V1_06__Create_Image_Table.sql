CREATE TABLE IF NOT EXISTS image (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       img_path VARCHAR(255),
                       variant_id BIGINT,
                       FOREIGN KEY (variant_id) REFERENCES variant (id)
);