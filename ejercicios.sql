/* Realizar un programa que solicite un pedido de un artículo
determinado, la cantidad que se pide siempre es uno, el programa
debe comprobar si hay stock suficiente y si es así actualizar el
stock y, en una tabla temporal insertar el codigo de artículo y el
mensaje "Vendido". Si no hay stock se inserta en la tabla temporal
el código del artículo y el mensaje "Sin existencias".
 */
 DESC ARTICULOS;
 drop table temporal;
 CREATE table temporal(
    codigo NUMBER (5),
    mensaje VARCHAR2(30)
 );
 SELECT * FROM TEMPORAL;
 
 DECLARE
    V_PEDIDO  ARTICULOS.IDART%TYPE := &PRODUCTO_PEDIDO; 
    V_AUX ARTICULOS.STOCK%TYPE;
 BEGIN
    SELECT ARTICULOS.STOCK INTO V_AUX FROM ARTICULOS WHERE V_PEDIDO = ARTICULOS.IDART;
    IF V_AUX > 0 THEN
        DBMS_OUTPUT.PUT_LINE('HAY STOCK');
        UPDATE ARTICULOS SET (ARTICULOS.STOCK) = (SELECT (ARTICULOS.STOCK-1)  FROM ARTICULOS WHERE ARTICULOS.IDART = V_PEDIDO)
        WHERE ARTICULOS.IDART = V_PEDIDO;
        INSERT INTO TEMPORAL VALUES (V_PEDIDO,'HAY STOCK');
    ELSE
        DBMS_OUTPUT.PUT_LINE('NO HAY STOCK');
        INSERT INTO TEMPORAL VALUES (V_PEDIDO,'NO HAY STOCK');
    END IF;
 END;
 ROLLBACK;
SELECT * FROM ARTICULOS;

/* Modificar el ejercicio anterior para actualizar la tabla de pedidos y
detalle. Se solicitará un código de cliente por teclado además del codigo de
artículo que ya se pedía en el ejercicio anterior.
El primer pedido a efectuar será el 8 y el último el 15.
La cantidad será 1.
La fecha será la del sistema.
*/

SELECT * FROM PEDIDOS;
SELECT * FROM DETALLE;
