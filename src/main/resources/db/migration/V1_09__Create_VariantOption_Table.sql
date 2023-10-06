CREATE TABLE IF NOT EXISTS VARIANT_OPTIONVALUE (
                                ID INT AUTO_INCREMENT PRIMARY KEY,
                                VARIANT_ID INT,
                                OPTIONVALUE_ID INT,
--                                 PRIMARY KEY (VARIANT_ID, OPTIONVALUE_ID),
                                FOREIGN KEY (VARIANT_ID) REFERENCES VARIANT(ID),
                                FOREIGN KEY (OPTIONVALUE_ID) REFERENCES OPTIONVALUE(ID)
);