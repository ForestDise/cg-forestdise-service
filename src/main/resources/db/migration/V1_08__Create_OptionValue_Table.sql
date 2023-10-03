CREATE TABLE IF NOT EXISTS optionValue (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             value VARCHAR(255),
                             option_id INT,
                             FOREIGN KEY (option_id) REFERENCES option_table(id)
);