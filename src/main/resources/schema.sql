DROP TABLE IF EXISTS CITY;
CREATE TABLE PRODUCT (
                         PRODUCT_ID INT AUTO_INCREMENT  PRIMARY KEY,
                         PRODUCT_NAME VARCHAR2(50) NOT NULL,
                         QUANTITY NUMBER(20, 6),
                         PRICE NUMBER(20, 6)
);