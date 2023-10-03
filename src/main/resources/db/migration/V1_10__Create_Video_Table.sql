CREATE TABLE IF NOT EXISTS video (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       video_path VARCHAR(255),
                       variant_id INT,
                       FOREIGN KEY (variant_id) REFERENCES variant (id)
);