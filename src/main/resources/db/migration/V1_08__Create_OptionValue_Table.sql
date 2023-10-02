CREATE TABLE IF NOT EXISTS optionValue (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             value VARCHAR(255),
                             option_id BIGINT,
                             FOREIGN KEY (option_id) REFERENCES option_table(id)
);