INSERT INTO CHARGE_DEFINITION_MST (ID,AMOUNT,CHARGE_CODE,CHARGE_DESCRIPTION,COUNTRY_CODE,FROM_CURRENCY,RATE,RATE_BASED,STATE_CODE,TO_CURRENCY)
VALUES (1,null,'CV','Conversion Fees 2 percent from DLR to INR','USA','DLR',2,1,null,'INR');
INSERT INTO CHARGE_DEFINITION_MST (ID,AMOUNT,CHARGE_CODE,CHARGE_DESCRIPTION,COUNTRY_CODE,FROM_CURRENCY,RATE,RATE_BASED,STATE_CODE,TO_CURRENCY)
VALUES (2,null,'CGST','Centre GST 10 percent','INDIA',null,10,1,null,null);
INSERT INTO CHARGE_DEFINITION_MST (ID,AMOUNT,CHARGE_CODE,CHARGE_DESCRIPTION,COUNTRY_CODE,FROM_CURRENCY,RATE,RATE_BASED,STATE_CODE,TO_CURRENCY)
VALUES (3,null,'UST','United states tax 2 percent','USA',null,2,1,null,null);

INSERT INTO COURSE(ID,AMOUNT,COURSE_CODE,COURSE_DESC,PRICE_TYPE,MONTHS)VALUES(1,10000,'DSA','Data Structures and Algo','OT',null);
INSERT INTO COURSE(ID,AMOUNT,COURSE_CODE,COURSE_DESC,PRICE_TYPE,MONTHS)VALUES(2,null,'DSA','Data Structures and Algo','F',null);
INSERT INTO COURSE(ID,AMOUNT,COURSE_CODE,COURSE_DESC,PRICE_TYPE,MONTHS)VALUES(3,1000,'DSA','Data Structures and Algo','M',6);

INSERT INTO GENERIC_PARAMETER(ID,D_TYPE,CODE,DESCRIPTION,PARAMETER_VALUE) VALUES(1,'PriceType','OT','One Time Fees',null);
INSERT INTO GENERIC_PARAMETER(ID,D_TYPE,CODE,DESCRIPTION,PARAMETER_VALUE) VALUES(2,'PriceType','F','Free of Cost',null);
INSERT INTO GENERIC_PARAMETER(ID,D_TYPE,CODE,DESCRIPTION,PARAMETER_VALUE) VALUES(3,'PriceType','M','Monthly Subscription',null);

INSERT INTO COUNTRY(ID,COUNTRY_CODE,CURRENCY_CODE) VALUES(1,'USA','DLR');
INSERT INTO COUNTRY(ID,COUNTRY_CODE,CURRENCY_CODE) VALUES(2,'INDIA','INR');

