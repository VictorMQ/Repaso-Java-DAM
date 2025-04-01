package org.victor.ProccessBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderError {
    public static void main(String[] args) {

        try {

            String comando = System.getProperty("os.name");

            if (comando.toLowerCase().startsWith("win")){

                comando = "cmd /c ech Hola, mundo!";
            }else {

                comando = "ech Hola, mundo!";
            }

            ProcessBuilder pb = new ProcessBuilder(comando.split(" "));

            Process process = pb.start();

            //Salida de error (stderr)
            BufferedReader bf = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String linea;

            while((linea = bf.readLine()) != null){

                System.out.println("Error: " + linea);
            }

            process.waitFor();

        } catch (IOException | InterruptedException e) {

            System.out.println("Error! " + e.getMessage());
        }
    }
}
