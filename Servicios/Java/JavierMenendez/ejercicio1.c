#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
int main(){
    int TABLAS=10;
    int productos=0;
    for (int i=1;i<TABLAS;i++){
        if (fork()==0) {
            for (int MULTIPLICADOR=1;MULTIPLICADOR<11;MULTIPLICADOR++){
                        productos=MULTIPLICADOR;
                        printf("Soy la tabla %d: ",i);
                printf("%d x %d =%d\n",i,MULTIPLICADOR,productos);
            }
               printf("\n");
        exit(0);
        }
    }
    for (int i=0;i<TABLAS;i++) wait(NULL);
}