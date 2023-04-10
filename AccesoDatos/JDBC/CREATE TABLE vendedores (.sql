CREATE TABLE vendedores (
id int NOT NULL auto_increment,
nombre varchar(50) NOT NULL default '',
fecha_ingreso date NOT NULL,
salario float NOT NULL default '0',
PRIMARY KEY (id) );

INSERT INTO vendedores VALUES (1, 'Pedro Gil', '2017-04-11', 15000);
SELECT * FROM vendedores;
