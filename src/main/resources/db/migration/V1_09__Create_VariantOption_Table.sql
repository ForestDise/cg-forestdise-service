CREATE TABLE IF NOT EXISTS variant_option (
                                variant_id INT,
                                optionvalue_id INT,
                                PRIMARY KEY (variant_id, optionvalue_id),
                                FOREIGN KEY (variant_id) REFERENCES Variant(id),
                                FOREIGN KEY (optionvalue_id) REFERENCES OptionValue(id)
);