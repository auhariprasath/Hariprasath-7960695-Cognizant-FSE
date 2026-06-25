CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    AccountType VARCHAR2(20),
    Balance NUMBER(10,2)
);
INSERT INTO Accounts VALUES (101,'John','Savings',10000);
INSERT INTO Accounts VALUES (102,'David','Savings',15000);
INSERT INTO Accounts VALUES (103,'Mary','Current',20000);

COMMIT;
