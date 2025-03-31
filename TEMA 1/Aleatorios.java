package org.victor.Ejercicio01;

import java.util.Random;

/**
 * Genera 10 numeros aleatorios entre 0 y 100.
 */

public class Aleatorios {

    public static void main(String[] args) {

        int cantidadGenerados = 10;

        for (int i = 0; i < cantidadGenerados; i++){

            System.out.print(generarNumerosAleatorios(0, 100) + " ");
        }
    }

    public static int generarNumerosAleatorios(int min, int max){

        int num = (int) (Math.random() * (max - min + 1)) + min;

        return num;
    }
}
