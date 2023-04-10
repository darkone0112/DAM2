#include <stdio.h>
#include <stdlib.h>
void main()
{
	printf("Ejemplo de uso de system ():");
	printf("\n\tListado del directorio actual y envio a un fichero : ");
    /*ejecuta CMD un dir y envia el resultado al txt*/
	printf(system ("dir > ficsalida.txt" ));
	printf("\n\tAbrimos con el gedit el fichero ...");
    /*ejecuta el txt con notepad*/
	printf(system("notepad ficsalida.txt"));
	printf("\n\tEste comando es erróneo : %d", system("dir"));
	printf("\nFin de programa .... \n");
}