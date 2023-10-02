CREATE TABLE IF NOT EXISTS video (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       video_path VARCHAR(255),
                       variant_id BIGINT,
                       FOREIGN KEY (variant_id) REFERENCES variant (id)
);