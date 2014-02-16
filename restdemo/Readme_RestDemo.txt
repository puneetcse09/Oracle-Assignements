############TABLE SCRIPTS ##################
DROP TABLE EA_DEV.BOOK CASCADE CONSTRAINTS;

CREATE TABLE EA_DEV.BOOK
(
  ID     INTEGER                                NOT NULL,
  TITLE  VARCHAR2(24 BYTE)
)
TABLESPACE POOL_DATA
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          40K
            NEXT             40K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;

DROP TABLE EA_DEV.AUTHOR CASCADE CONSTRAINTS;

CREATE TABLE EA_DEV.AUTHOR
(
  ID             INTEGER                        NOT NULL,
  NAME           VARCHAR2(24 BYTE),
  LAST_NAME      VARCHAR2(24 BYTE)              NOT NULL,
  DATE_OF_BIRTH  DATE
)
TABLESPACE POOL_DATA
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          40K
            NEXT             40K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;

DROP TABLE EA_DEV.CATEGORY CASCADE CONSTRAINTS;

CREATE TABLE EA_DEV.CATEGORY
(
  ID    INTEGER                                 NOT NULL,
  NAME  VARCHAR2(24 BYTE)                       NOT NULL
)
TABLESPACE POOL_DATA
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          40K
            NEXT             40K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


####################################################################
Web Application has been created with the following functional properties:

1.	Value Object classes:
a.	AuthorVO.java
b.	BookVO.java
c.	CategoryVO.java

These classes are value object classes which are responsible for the getter/setter values of each entity values i.e. encapsulation of entity data
2.	DAO Object Classes:
a.	AuthorDAO.java
b.	BookDAO.java
c.	CategoryDAO.java

These classes are responsible for the basic function method of data layer interaction with the different purpose like Summary, Detail, Update, and Delete.

3.	Resources Object Classes:
a.	AuthorResources.java
b.	BookResources.java
c.	CategoryResources.java

These classes are responsible for the Produce and Consume the web service data to the http request/response. It used the GET/POST/PUT/DELETE protocols to publish/subscribe the web service data.
4.	JDBC Connection Classes:
a.	BaseJDBC.java

This class is responsible for the JDBC connection to the Oracle using the jdbc oracle driver. All DAOs are getting connection with the ORACLE DB using the partially generic jdbc class BaseJDBC.java. Only one connection property has been defined into the BaseJDBC class to be used for all DAO.
5.	Web services can be accessed via following URLs:
a.	http:// localhost:8080/restdemo/services/category/
b.	http:// localhost:8080/restdemo/services/category/1
c.	http:// localhost:8080/restdemo/services/author/
d.	http:// localhost:8080/restdemo/services/author/1
e.	http:// localhost:8080/restdemo/services/book/
f.	http:// localhost:8080/restdemo/services/book/1

On starting of the application crud will displayed with the Book summary.
Please make sure to change the Oracle properties into the BaseJDBC.java file before running the application.


