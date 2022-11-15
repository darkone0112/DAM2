/* Tablas Detalles, Pedidos, Clientes, Articulos */
drop table detalle;
drop table pedidos;
drop table clientes;
drop table articulos;
alter session set NLS_DATE_FORMAT='DD/MM/YY';
create table clientes (codcli  number(6) not null,
		       	nombre char(45),
			direccion char(40),
			ciudad char(30),
			cpostal char(9),
			telefono char(9),
			empno number(4) not null,
			creditlimit number(9,2),
			comentario long,
	constraint idcli_primary_key primary key(codcli),
	constraint fk_empno foreign key (empno) references emp);


INSERT INTO CLIENTES VALUES(000001, 'JOSE LOPEZ' , 'SOL, 23', 'MADRID','28012','912345674', 7839,100000,'BUEN CLIENTE');
INSERT INTO CLIENTES VALUES(000002, 'JUAN GOMEZ' , 'SOL, 43', 'MADRID','28012','912444444',7566,100000,'BUEN CLIENTE');
INSERT INTO CLIENTES VALUES(000003, 'MARIA PEREZ' , 'GRAN VIA , 22', 'MADRID','28012','915555554',7839,200000,'FAMILIA JEFE');
INSERT INTO CLIENTES VALUES(000004, 'ELENA MARTIN' , 'PALO DE FLOR, 55', 'MADRID','28012','916666664',7839,300000,'ENCHUFADO');
INSERT INTO CLIENTES VALUES(000005, 'CARLOS MOTOS' , 'CAMILLA, 88', 'SEVILLA','38012','972787878',7654,500000,'BUEN CLIENTE');
INSERT INTO CLIENTES VALUES(000006, 'ANGEL RUIZ' , 'TRIANA, 77', 'SEVILLA','38012','972345674',7902,10000,'BUEN CLIENTE');
INSERT INTO CLIENTES VALUES(000007, 'INES PETRA' , 'BOLOS , 11', 'TOLEDO','44012','962355674',7369,0,'MOROSO');



create table pedidos (  idped number(4) not null,
			codcli number(6) not null,
			fechaped  date,
			fechafact date,
	constraint ipded_primary_key primary key (idped),
	constraint FK_CODCLI foreign key (codcli) references clientes);
	
INSERT INTO PEDIDOS VALUES (0001,000007, '17/11/99', '19/11/99');
INSERT INTO PEDIDOS VALUES (0002,000006, '18/12/99', '19/12/99');
INSERT INTO PEDIDOS VALUES (0003,000004, '27/12/99', '30/12/99');
INSERT INTO PEDIDOS VALUES (0004,000003, '04/01/00', '19/11/00');
INSERT INTO PEDIDOS VALUES (0005,000002, '07/01/00', '19/11/00');
INSERT INTO PEDIDOS VALUES (0006,000003, '08/08/00', '20/08/00');

create table articulos (idart   number(4) not null primary key,
			descrip     varchar2(20),
			stock      number(4),
			precio     number(6));
	
INSERT INTO ARTICULOS VALUES (4000, 'PIZZA',7,2000);
INSERT INTO ARTICULOS VALUES (4001, 'HAMBURGUESA',8,800);
INSERT INTO ARTICULOS VALUES (4002, 'PAELLA',1,1000);
INSERT INTO ARTICULOS VALUES (4003, 'CORDERO',5,3000);
INSERT INTO ARTICULOS VALUES (4004, 'COMIDA CHINA',9,500);


create table detalle (idped number(4) not null,
		      idart number(4) not null,
		      cantidad number(8),
	 constraint idpart_primary_key primary key (idped, idart),
	 constraint fk_idped foreign key (idped) references pedidos,
	 constraint fk_idart foreign key (idart) references articulos);

INSERT INTO detalle VALUES(0001, 4002 , 2);
INSERT INTO detalle VALUES(0002, 4003,  1);
INSERT INTO detalle VALUES(0003, 4004,  1);
INSERT INTO detalle VALUES(0004, 4002,  3);
INSERT INTO detalle VALUES(0005, 4002,  1);
INSERT INTO detalle VALUES(0005, 4003, 10000);
INSERT INTO detalle VALUES(0005, 4004, 5000);
INSERT INTO detalle VALUES(0006, 4004,   3);

/*Tabla doctor, enfermero, plantilla, sala, hospital*/
alter session set NLS_language='spanish';
alter session set NLS_DATE_FORMAT='DD/MM/YYYY';

drop table doctor;
drop table enfermo;
drop table plantilla;
drop table sala;
drop table hospital;


create table hospital(
	hospital_cod number (2) not null primary key,
	nombre varchar2 (12),
	direccion varchar2 (20),
	telefono varchar2 (8),
	num_cama number (4)
);

insert into hospital values (13,'Provincial','O Donell 50','964-4264',502);
insert into hospital values (18,'General','Atocha s/n','595-3111',987);
insert into hospital values (22,'La Paz','Castellana 1000','923-5411',412);
insert into hospital values (45,'San Carlos','Ciudad Universitaria','597-1500',845);

create table enfermo(
	inscripcion number (5),
	apellido varchar2 (12),
	direccion varchar2 (20),
	fecha_nac date,
	s varchar2 (1),
	nss number (9) not null primary key,
	hospital_cod number (2),
	constraint fk_enfermo foreign key (hospital_cod) references hospital (hospital_cod) on delete cascade,
	constraint ck_sexo check (s in ('M','F'))
);

insert into enfermo values (10995,'Laguia M.','Goya 20','16/05/1956','M',280862482,13);
insert into enfermo values (18004,'Serrano V.','Alcala 12','21/05/1960','F',284991452,18);
insert into enfermo values (14024,'Fernandez M.','Recoletos 50','23/06/1967','F',321790059,18);
insert into enfermo values (36658,'Domin S.','Mayor 71','01/01/1942','M',160654471,22);
insert into enfermo values (38702,'Neal R.','Orense 11','18/06/1940','F',380010217,45);
INSERT INTO enfermo VALUES (39217,'Cervantes M.','Peron 38','29/02/1952','M',440294390,22);
INSERT INTO enfermo VALUES (59076,'Miller B.','Lopez de Hoyos 2','16/09/1945','F',311969044,45);
INSERT INTO enfermo VALUES (63827,'Ruiz P.','Esquerdo 103','26/12/1980','M',100973253,18);
INSERT INTO enfermo VALUES (64823,'Fraser A.','Soto 3','10/07/1980','F',285201776,13);
INSERT INTO enfermo VALUES (74835,'Benitez E.','Argentina 5','05/10/1957','M',154811767,22);

create table sala(
	hospital_cod number (2) not null,
	sala_cod number (2) not null,
	nombre varchar (20),
	num_cama number (4),
	constraint pk_sala primary key (hospital_cod,sala_cod),
	constraint fk_sala foreign key (hospital_cod) references hospital (hospital_cod) on delete cascade
);

INSERT INTO sala VALUES (13,3,'Cuidados intensivos',21);
INSERT INTO sala VALUES (13,6,'Psiquiatrico',67);
INSERT INTO sala VALUES (18,3,'Cuidados intensivos',10);
INSERT INTO sala VALUES (18,4,'Cardiologia',53);
INSERT INTO sala VALUES (22,1,'Recuperacion',10);
INSERT INTO sala VALUES (22,6,'Psiquiatrico',118);
INSERT INTO sala VALUES (22,2,'Maternidad',34);
INSERT INTO sala VALUES (45,4,'Cardiologia',55);
INSERT INTO sala VALUES (45,1,'Recuperacion',13);
INSERT INTO sala VALUES (45,2,'Maternidad',24);


create table plantilla(
	hospital_cod number (2),
	sala_cod number (2),
	empleado_no number (4) not null primary key,
	apellido varchar (16),
	funcion varchar (10),
	turno varchar (1),
	salario number(10),
	constraint fk_plantilla foreign key (hospital_cod) references hospital (hospital_cod) on delete cascade,
	constraint fk_hosp_sala foreign key (hospital_cod,sala_cod) references sala (hospital_cod,sala_cod) on delete cascade,
	constraint ck_turno check (turno in('M','T','N'))
);

INSERT INTO plantilla VALUES (13,6,3754,'Diaz B.','Enfermera','T',226200);
INSERT INTO plantilla VALUES (13,6,3106,'Hernandez J.','Enfermero','T',275000);
INSERT INTO plantilla VALUES (18,4,6357,'Karplus W.','Interno','T',337900);
INSERT INTO plantilla VALUES (22,6,1009,'Higueras D.','Enfermera','T',200500);
INSERT INTO plantilla VALUES (22,6,8422,'Bocina G.','Enfermero','M',183800);
INSERT INTO plantilla VALUES (22,2,9901,'Nu�ez C.','Interno','M',221000);
INSERT INTO plantilla VALUES (22,1,6065,'Rivera G.','Enfermera','N',162600);
INSERT INTO plantilla VALUES (22,1,7379,'Carlos R.','Enfermera','T',211900);
INSERT INTO plantilla VALUES (45,4,1280,'AMIGO R.','Interno','N',221000);
INSERT INTO plantilla VALUES (45,1,8526,'FRANK H.','Enfermera','T',252200);

create table doctor(
	hospital_cod number (2),
	doctor_no number (3) not null primary key,
	apellido varchar2 (16),
	especialidad varchar (16),
	constraint fk_doctor foreign key (hospital_cod) references hospital (hospital_cod) on delete cascade
);

INSERT INTO DOCTOR VALUES (13,435,'Lopez A.','Cardiologia');
INSERT INTO DOCTOR VALUES (18,585,'Miller G.','Ginecologia');
INSERT INTO DOCTOR VALUES (18,982,'Cajal R.','Cardiologia');
INSERT INTO DOCTOR VALUES (22,453,'Galo D.','Pediatria');
INSERT INTO DOCTOR VALUES (22,398,'Best D.','Urologia');
INSERT INTO DOCTOR VALUES (22,386,'Cabeza D.','Psiquiatria');
INSERT INTO DOCTOR VALUES (45,607,'Nino P.','Pediatria');
INSERT INTO DOCTOR VALUES (45,522,'Adams C.','Neurologia');

/* tabla EMP, tabla DEPT */
DROP TABLE EMP;
DROP TABLE DEPT;


CREATE TABLE DEPT (
 DEPTNO              NUMBER(2) NOT NULL,
 DNAME               CHAR(14),
 LOC                 CHAR(13),
 CONSTRAINT DEPT_PRIMARY_KEY PRIMARY KEY (DEPTNO));

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

CREATE TABLE EMP (
 EMPNO               NUMBER(4) NOT NULL,
 ENAME               CHAR(10),
 JOB                 CHAR(9),
 MGR                 NUMBER(4) CONSTRAINT EMP_SELF_KEY REFERENCES EMP (EMPNO),
 HIREDATE            DATE,
 SAL                 NUMBER(7,2),
 COMM                NUMBER(7,2),
 DEPTNO              NUMBER(2) NOT NULL,
 CONSTRAINT EMP_FOREIGN_KEY FOREIGN KEY (DEPTNO) REFERENCES DEPT (DEPTNO),
 CONSTRAINT EMP_PRIMARY_KEY PRIMARY KEY (EMPNO));

INSERT INTO EMP VALUES (7839,'KING','PRESIDENT',NULL,'17/11/1981',5000,NULL,10);
INSERT INTO EMP VALUES (7698,'BLAKE','MANAGER',7839,'1/5/1981',2850,NULL,30);
INSERT INTO EMP VALUES (7782,'CLARK','MANAGER',7839,'9/6/1981',2450,NULL,10);
INSERT INTO EMP VALUES (7566,'JONES','MANAGER',7839,'2/4/1981',2975,NULL,20);
INSERT INTO EMP VALUES (7654,'MARTIN','SALESMAN',7698,'28/9/1981',1250,1400,30);
INSERT INTO EMP VALUES (7499,'ALLEN','SALESMAN',7698,'20/2/1981',1600,300,30);
INSERT INTO EMP VALUES (7844,'TURNER','SALESMAN',7698,'8/9/1981',1500,0,30);
INSERT INTO EMP VALUES (7900,'JAMES','CLERK',7698,'3/12/1981',950,NULL,30);
INSERT INTO EMP VALUES (7521,'WARD','SALESMAN',7698,'22/2/1981',1250,500,30);
INSERT INTO EMP VALUES (7902,'FORD','ANALYST',7566,'3/12/1981',3000,NULL,20);
INSERT INTO EMP VALUES (7369,'SMITH','CLERK',7902,'17/12/1980',800,NULL,20);
INSERT INTO EMP VALUES (7788,'SCOTT','ANALYST',7566,'09/12/1982',3000,NULL,20);
INSERT INTO EMP VALUES (7876,'ADAMS','CLERK',7788,'12/1/1983',1100,NULL,20);
INSERT INTO EMP VALUES (7934,'MILLER','CLERK',7782,'23/1/1982',1300,NULL,10);

/* Practica 1 */
CREATE OR REPLACE TYPE DIRECCION FORCE AS OBJECT(
    CALLE VARCHAR2(10),
    CIUDAD VARCHAR2(10),
    CP VARCHAR2(5)
);
CREATE OR REPLACE TYPE PERSONA AS OBJECT(
    CODIGO NUMBER,
    NOMBRE VARCHAR2(10),
    FECNA DATE,
    DIREC DIRECCION
);
CREATE TABLE ALUMNOS OF PERSONA(CODIGO PRIMARY KEY);
DECLARE
    DIR DIRECCION := DIRECCION(NULL,NULL,NULL);
    P PERSONA := PERSONA(NULL,NULL,NULL,NULL);
BEGIN
    DIR.CALLE := 'CALLE1';
    DIR.CIUDAD := 'CIUDAD1';
    DIR.CP := 'CP1';
    P.CODIGO := 1;
    P.NOMBRE := 'NOMBRE1';
    P.DIREC := DIR;
    P.FECNA := '10/OCT/2010';
END;
/
DROP TABLE ALUMNOS;


SELECT * FROM ALUMNOS;
INSERT INTO ALUMNOS VALUES (2,'Federico','10/oct/1980', DIRECCION('Alto','GUADA',28830));
INSERT INTO ALUMNOS VALUES (2,'JAVIER','10/oct/1980', DIRECCION('Alto','GUSSS',28830));

/* SELECCIONAR GUADA */
SELECT * FROM ALUMNOS C WHERE C.DIREC.CIUDAD = 'GUADA';
/*SELECCIONAR COLUMNA OBJETO*/
SELECT ALUMNOS.CODIGO, ALUMNOS.DIREC FROM ALUMNOS;
select * from emp;

/* Practica 1b */
/*CREATE TYPE VETERINARIO AS AN OBJECT*/
CREATE OR REPLACE TYPE VETERINARIO AS OBJECT(
    ID NUMBER,
    NOMBRE VARCHAR2(20),
    DIRECCION VARCHAR2(40)
);
/*CREATE TABLE VETERINARIOS OF THE TYPE VETERINARIO*/
DROP TABLE VETERINARIOS;
CREATE TABLE VETERINARIOS OF VETERINARIO;
/*CREATE TYPE MASCOTA AS AN OBJECT*/
CREATE OR REPLACE TYPE MASCOTA AS OBJECT(
    ID_MASCOTA NUMBER,
    RAZA VARCHAR2(20),
    NOMBRE VARCHAR2(20),
    VET REF VETERINARIO
);
/* CREATE TABLE MASCOTAS OF THE TYPE MASCOTA */
DROP TABLE MASCOTAS;
CREATE TABLE MASCOTAS OF MASCOTA;
/* INSERT DATA INSIDE TABLE VETERINARIOS */
INSERT INTO VETERINARIOS VALUES(1,'JESUS PEREZ','C/EL MAREO, 29');
/* INSERT DATA INSIDE TABLE MASCOTAS WITH THE VETERINARIOS REFERENCE */
INSERT INTO MASCOTAS VALUES(1,'PERRO','SPROKE',
(SELECT REF(V) FROM VETERINARIOS V WHERE V.ID = 1)
);
/* SELECT THAT LIST THE ENTIRE TABLE MASCOTAS WITH THE VETERINARIOS
REFERENCE OID */
SELECT * FROM MASCOTAS;
/* SELECT THAT LIST THE ENTIRE TABLE MASCOTAS WITH THE REAL DATA, INSTEAD OF
THE OID OF THE REFERENCE */
SELECT ID_MASCOTA,RAZA,NOMBRE, DEREF(M.VET).NOMBRE FROM MASCOTAS M;
/*SELECT THAT LIST THE DATA NOMBRE, RAZA, NOMBRE DE VETERINARIO*/
SELECT NOMBRE, RAZA, DEREF(M.VET).NOMBRE FROM MASCOTAS M;

/*PRACTICA 2 METODOS*/
/*CREATE TYPE CUBO AS AN OBJECT WITH THE MEMBER FUNCTION AND PROCEDURE*/
DROP TYPE CUBO;
CREATE OR REPLACE TYPE CUBO AS OBJECT(
    LARGO INTEGER,
    ANCHO INTEGER,
    ALTO INTEGER,
    MEMBER FUNCTION SUPERFICIE RETURN INTEGER,
    MEMBER FUNCTION VOLUMEN RETURN INTEGER,
    MEMBER PROCEDURE MOSTRAR
);
CREATE OR REPLACE TYPE BODY CUBO AS
MEMBER FUNCTION SUPERFICIE RETURN INTEGER IS
BEGIN
    RETURN 2*(LARGO*ANCHO+LARGO*ANCHO+ANCHO*ALTO);
END;
MEMBER FUNCTION VOLUMEN RETURN INTEGER IS 
BEGIN
    RETURN LARGO*ALTO*ANCHO;
END;
MEMBER PROCEDURE MOSTRAR IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('LARGO: ' || LARGO || ' ANCHO: ' || ANCHO || ' ALTO: ' || ALTO);
    DBMS_OUTPUT.PUT_LINE('SUPERFICIE: ' || SUPERFICIE || ' VOLUMEN: ' || VOLUMEN);
END;
END;
/
CREATE TABLE CUBOS OF CUBO;
INSERT INTO CUBOS VALUES (10,10,10);
INSERT INTO CUBOS VALUES (3,4,5);

DECLARE
	MI_CUBO CUBO;
BEGIN
	SELECT VALUE(C) INTO MI_CUBO FROM CUBOS C WHERE C.LARGO = 10;
	
	MI_CUBO.MOSTRAR();
END;

SELECT C.VOLUMEN(),C.SUPERFICIE() FROM CUBOS C WHERE C.LARGO = 10;

/*PRACTICA 3 METODOS*/
/*0*/
CREATE OR REPLACE TYPE TRIANGULO AS OBJECT(
	BASE NUMBER,
	ALTURA NUMBER,
	MEMBER FUNCTION AREA RETURN NUMBER
);
CREATE OR REPLACE TYPE BODY TRIANGULO AS
	MEMBER FUNCTION AREA RETURN NUMBER IS
	BEGIN
		RETURN BASE*ALTURA/2;
	END;
END;
DROP TABLE TRIANGULOS;
CREATE TABLE TRIANGULOS(ID NUMBER,TRIANGULO TRIANGULO);
INSERT INTO TRIANGULOS VALUES(1,TRIANGULO(5,5));
INSERT INTO TRIANGULOS VALUES(2,TRIANGULO(10,10))

SELECT ID, TRIANGULO(BASE, ALTURA) FROM TRIANGULOS;