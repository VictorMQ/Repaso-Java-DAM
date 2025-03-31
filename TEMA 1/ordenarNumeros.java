package org.victor.Ejercicio01;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ordena de menor a mayor los numeros escritos por consola.
 */

public class ordenarNumeros {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String linea;

        while((linea = br.readLine()) != null){

            String numeros[] = linea.split(" ");

            int arrayNum[] = new int[numeros.length];

            for (int i = 0; i < numeros.length; i++){

                arrayNum[i] = Integer.parseInt(numeros[i]);
            }

            Arrays.sort(arrayNum);

            for (int i = 0; i < arrayNum.length; i++){

                System.out.print(arrayNum[i] + " ");
            }
        }

    }
}
