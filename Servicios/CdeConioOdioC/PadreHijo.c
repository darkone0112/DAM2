#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#define LECTURA 0
#define ESCRITURA 1
int main (void)
{   
    //variable pid_t
    pid_t pid;
    //Crea array que sera la tuberia
    int tuberia[2];
    int numA,numB,sum=0;
    
    //Activa la tuberia
    pipe(tuberia);
    
    //se realiza la creacion del hijo
    pid=fork();

    switch(pid) {
        case -1:
            printf("No se ha creado el hijo");
            exit(-1);
        case 0:
            
            //Recibe valorA
            read(tuberia[LECTURA],&numA,sizeof(numA));

            //Recibe valorB
            read(tuberia[LECTURA],&numB,sizeof(numB));

            //Realiza la operacion
            sum=numA+numB;

            //Cierra tuberia despues de recibir
            close(tuberia[LECTURA]);

            write(tuberia[ESCRITURA],&sum,sizeof(sum));

            //Cierra tuberia despues de enviar
            close(tuberia[ESCRITURA]);

        break;
        default:

            //Primer valor enviado
            printf("Introduce valor A: ");
            scanf("%d",&numA);
            write(tuberia[ESCRITURA],&numA,sizeof(numA));

            //Segundo valor enviado
            printf("Introduce valor B: ");
            scanf("%d",&numB);
            write(tuberia[ESCRITURA],&numB,sizeof(numB));
            
            //Cierra tuberia despues de escribir
            close(tuberia[ESCRITURA]);

            //Espera a que termine el hijo
            wait(NULL);

            read(tuberia[LECTURA],&sum,sizeof(sum));
            //Cierra tuberia despues de leer
            close(tuberia[LECTURA]);

            //Muestra el resultado de la suma
            printf("Padre tras sumar es: %d",sum);
            
        break;
    }
}