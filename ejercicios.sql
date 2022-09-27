/* Realizar un programa que solicite un pedido de un artículo
determinado, la cantidad que se pide siempre es uno, el programa
debe comprobar si hay stock suficiente y si es así actualizar el
stock y, en una tabla temporal insertar el codigo de artículo y el
mensaje "Vendido". Si no hay stock se inserta en la tabla temporal
el código del artículo y el mensaje "Sin existencias".
 */
 drop table temporal;
 CREATE table temporal(
    codigo NUMBER (5),
    mensaje VARCHAR2(30)
 );
 SELECT * FROM TEMPORAL;
 DESCRIBE TEMPORAL;