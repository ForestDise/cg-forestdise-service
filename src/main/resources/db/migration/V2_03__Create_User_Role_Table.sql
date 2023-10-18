CREATE TABLE IF NOT EXISTS USER_ROLE (
                USER_ID INT,
                ROLE_ID INT,
                PRIMARY KEY (USER_ID, ROLE_ID),
                FOREIGN KEY (USER_ID) REFERENCES USER(ID),
                FOREIGN KEY (ROLE_ID) REFERENCES ROLE(ID)
);