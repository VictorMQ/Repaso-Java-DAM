package org.victor.ProccessBuilder;

import java.io.*;

/**
 * Modifica el ejercicio 3 para que la salida estándar se guarde en un archivo output.txt
 */

public class ProcessBuilderOutput {
    public static void main(String[] args) {

        try {

            String comando = System.getProperty("os.name");

            if (comando.toLowerCase().startsWith("win")){

                comando = "cmd /c echo Hola, mundo!";
            }else {

                comando = "echo Hola, mundo!";
            }

            ProcessBuilder pb = new ProcessBuilder(comando.split(" "));

            //Salida redirigida
            pb.redirectOutput(new File("output.txt"));

            Process process = pb.start();

            process.waitFor();

            System.out.println("Salida guardada en output.txt");

        } catch (IOException | InterruptedException e) {

            System.out.println("Error! " + e.getMessage());
        }
    }
}
