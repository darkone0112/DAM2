#include <stdio.h>
#include <time.h>
int main() {
    double tiempo = 0.0;
   int bajo, alto, i, controlador;
   printf("Introduce dos numeros (en un intervalo): ");
   scanf("%d %d", &bajo, &alto);
   printf("Los numeros enteros entre %d y %d son: ", bajo, alto , "\n");
   time_t inicio = time(NULL);4
   while (bajo < alto) {
      controlador = 0;
      if (bajo <= 1) {
         ++bajo;
         continue;
      }
      for (i = 2; i <= bajo / 2; ++i) {

         if (bajo % i == 0) {
            controlador = 1;
            break;
         }
      }
      if (controlador == 0)
         printf("%d ", bajo);
      ++bajo;
   }
   time_t final = time(NULL);
    tiempo = (final - inicio);
   printf("ha tardado %f segundos",tiempo);
   return 0;
}