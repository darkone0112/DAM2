CREATE TABLE vendedores (
id int NOT NULL auto_increment,
nombre varchar(50) NOT NULL default '',
fecha_ingreso date NOT NULL default '0000-00-00',
salario float NOT NULL default '0',
PRIMARY KEY (id) );
