---CUSTOMER TABLE
create table HC_CUSTOMERS(cus_Id VARCHAR(15) PRIMARY KEY, CUS_name varchar2(255) NOT NULL, EMAIL VARCHAR2(255), PASSWORD VARCHAR2(255), PHONENUMBER NUMBER(15));


insert into HC_CUSTOMERS(cus_Id,CUS_name,EMAIL,PASSWORD,PHONENUMBER)values('2004100931','YASWANTH','YASWANTH@GMAIL.COM','Yash@2020',9110365727);
insert into HC_CUSTOMERS(cus_Id,CUS_name,EMAIL,PASSWORD,PHONENUMBER)values('2004101239','CUSTOMER1','CUSTOMER1@GMAIL.COM','Customer1@2020',9004101239);
insert into HC_CUSTOMERS(cus_Id,CUS_name,EMAIL,PASSWORD,PHONENUMBER)values('2016101239','CUSTOMER2','CUSTOMER2@GMAIL.COM','Customer2@2020',9016101239);
SELECT * FROM HC_CUSTOMERS;

DELETE FROM HC_CUSTOMERS WHERE CUS_name = 'CUSTOMER2';

UPDATE HC_CUSTOMERS
SET PASSWORD = 'Customer1@2020'
WHERE cus_Id = '2004101239';

--DROP TABLE DISEASE;

---EMPLOYEES TABLE
create table HC_EMPLOYEES(EMP_Id VARCHAR(15) PRIMARY KEY, EMP_name varchar2(255) NOT NULL, EMP_EMAIL VARCHAR2(255), EMP_PASSWORD VARCHAR2(255), EMP_PHONENUMBER NUMBER(15));


insert into HC_EMPLOYEES(EMP_Id,EMP_name,EMP_EMAIL,EMP_PASSWORD,EMP_PHONENUMBER) values('2006100931','GURRAMKONDA YASWANTH','YASWANTH@GMAIL.COM','Yash@2020',9110365727);
insert into HC_EMPLOYEES(EMP_Id,EMP_name,EMP_EMAIL,EMP_PASSWORD,EMP_PHONENUMBER) values('2006101239','DOCTOR1','DOCTOR1@GMAIL.COM','Doctor1@2020',9006101239);

SELECT * FROM HC_EMPLOYEES;

UPDATE HC_EMPLOYEES
SET EMP_Id = '2007101531'
WHERE EMP_name = 'DOCTOR2';

UPDATE HC_EMPLOYEES
SET EMP_PASSWORD = 'Doctor1@2020'
WHERE EMP_Id = '2006101239';

---DISEASE TABLE
CREATE TABLE DISEASE (DISEASE_ID VARCHAR2(15) PRIMARY KEY,DISEASE_NAME VARCHAR2(255), ORIGIN_DATE VARCHAR2(25), ORIGIN_PLACE VARCHAR2(100), DURATION VARCHAR2(100));

INSERT INTO DISEASE (DISEASE_ID,DISEASE_NAME,ORIGIN_DATE,ORIGIN_PLACE,DURATION) VALUES('2008101217','COVID-19','DECEMBER 2019','WUHAN CHINA','5 days to 6+ months');


INSERT INTO DISEASE (DISEASE_ID,DISEASE_NAME,ORIGIN_DATE,ORIGIN_PLACE,DURATION) VALUES('2008101000','COVID-19','DECEMBER 2019','WUHAN CHINA','5 days to 6+ months');

SELECT * FROM DISEASE;
SELECT * FROM DISEASE where DISEASE_ID = 2008101438;
DELETE FROM DISEASE WHERE DISEASE_ID = '200810117';

UPDATE disease SET DISEASE_NAME = JJ, duration= KK, origin_date='KK',origin_place =' K' WHERE disease_id ;

UPDATE DISEASE SET DISEASE_NAME = 'HIV/AIDS', duration= 'Lifelong', origin_date='1920', origin_place ='Republic of Congo' WHERE disease_id = '2013101704';
--DROP TABLE DISEASE;


---SYMPTOMS TABLE
CREATE TABLE SYMPTOMS (SYMPTOM_ID VARCHAR2(15) PRIMARY KEY, DISEASE_ID VARCHAR2(15), SYMPTOM_NAME VARCHAR2(100),FOREIGN KEY(DISEASE_ID) REFERENCES DISEASE(DISEASE_ID));

INSERT INTO SYMPTOMS(SYMPTOM_ID,DISEASE_ID,SYMPTOM_NAME) VALUES('2008101247','2008101217','Fever');
INSERT INTO SYMPTOMS(SYMPTOM_ID,DISEASE_ID,SYMPTOM_NAME) VALUES('2008101248','2008101217','Cough');
INSERT INTO SYMPTOMS(SYMPTOM_ID,DISEASE_ID,SYMPTOM_NAME) VALUES('2008101249','2008101217','Fatigue');
INSERT INTO SYMPTOMS(SYMPTOM_ID,DISEASE_ID,SYMPTOM_NAME) VALUES('2008101250','2008101217','Shortness of breath');
INSERT INTO SYMPTOMS(SYMPTOM_ID,DISEASE_ID,SYMPTOM_NAME) VALUES('2008101251','2008101217','Loss of taste or smell');

SELECT * FROM SYMPTOMS;


    SELECT SYMPTOM_NAME
    FROM  DISEASE
    INNER JOIN  SYMPTOMS
    ON DISEASE.DISEASE_NAME = 'COVID-19';

    SELECT DISEASE_NAME,SYMPTOM_NAME
    FROM  DISEASE
    INNER JOIN  SYMPTOMS
    ON disease.disease_id = symptoms.disease_id;
    
    SELECT SYMPTOM_ID,DISEASE_NAME,SYMPTOM_NAME FROM  DISEASE INNER JOIN   SYMPTOMS ON symptoms.disease_id = disease.disease_id;

UPDATE SYMPTOMS SET DISEASE_ID = ?, SYMPTOM_NAME = ? WHERE SYMPTOM_ID = ?


---Precautions Table

CREATE TABLE Precautions (Precautions_Id VARCHAR2(15) PRIMARY KEY, DISEASE_ID VARCHAR2(15), Precautions VARCHAR2(100),FOREIGN KEY(DISEASE_ID) REFERENCES DISEASE(DISEASE_ID));

INSERT INTO Precautions(Precautions_Id,DISEASE_ID,Precautions) VALUES('2014100647','2008101217','Hand washing');
INSERT INTO Precautions(Precautions_Id,DISEASE_ID,Precautions) VALUES('2014100648','2008101217','face coverings');
INSERT INTO Precautions(Precautions_Id,DISEASE_ID,Precautions) VALUES('2014100649','2008101217','quarantine');
INSERT INTO Precautions(Precautions_Id,DISEASE_ID,Precautions) VALUES('2014100650','2008101217','social distancing');

Select * from Precautions;

SELECT Precautions_Id,DISEASE_NAME,Precautions FROM  DISEASE INNER JOIN   Precautions ON Precautions.disease_id = disease.disease_id;

SELECT * FROM  DISEASE INNER JOIN Precautions ON Precautions.disease_id = disease.disease_id;


--Doctor appointment table
CREATE TABLE Doctor_appointment (appointment_Id VARCHAR2(15) PRIMARY KEY, cus_Id VARCHAR2(15), appointment_date VARCHAR2(20), appointment_time VARCHAR2(10), problem VARCHAR2(100),FOREIGN KEY(cus_Id) REFERENCES HC_CUSTOMERS(cus_Id));


Insert Into Doctor_appointment (appointment_Id,cus_Id,appointment_date,appointment_time,problem) values('2015101512','2004101239','15/10/20','6 to 8 pm', 'Fever');
Insert Into Doctor_appointment (appointment_Id,cus_Id,appointment_date,appointment_time,problem) values('2015101515','2004100931','15/10/20','6 to 8 pm', 'Dandruff Treatment');
Insert Into Doctor_appointment (appointment_Id,cus_Id,appointment_date,appointment_time,problem) values('2015102015','2016101239','16/10/20','6 to 8 pm', 'Covid-19');

SELECT * from Doctor_appointment;

SELECT * from Doctor_appointment WHERE cus_Id = 2004101239;

--Doctor appointment status
CREATE TABLE Doctor_appointment_status (appointment_Id VARCHAR2(15) , cus_Id VARCHAR2(15), appointment_timing VARCHAR2(20));

Insert Into Doctor_appointment_status (appointment_Id,cus_Id, appointment_timing) values('2015101512','2004101239','6:15 pm to 6 :30 pm');
Insert Into Doctor_appointment_status (appointment_Id,cus_Id,appointment_timing) values('2015101515','2004100931','7:15 pm to 7 :30 pm');
Insert Into Doctor_appointment_status (appointment_Id,cus_Id, appointment_timing) values('2015102015','2016101239','6:15 pm to 6 :30 pm');

Drop table Doctor_appointment_status;

select * FROM  Doctor_appointment_status;

--Medicine order
Create Table Medicine_order (Order_Id VARCHAR2(15) PRIMARY KEY, cus_Id VARCHAR2(15), Medicine VARCHAR2(50), Quantity VARCHAR2(20),FOREIGN KEY(cus_Id) REFERENCES HC_CUSTOMERS(cus_Id));

Insert Into Medicine_order (Order_Id,cus_Id,Medicine,Quantity) values ('2016102002','2004101239','Paracetamol','10 Tablets');
Insert Into Medicine_order (Order_Id,cus_Id,Medicine,Quantity) values ('2016102003','2016101239','Montek Lc Tab','10 Tablets');
Insert Into Medicine_order (Order_Id,cus_Id,Medicine,Quantity) values ('2016102004','2016101239','Sompraz D 40MG Tab','10 Tablets');

Select * from Medicine_order;
