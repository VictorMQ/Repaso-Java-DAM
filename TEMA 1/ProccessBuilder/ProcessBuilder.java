package org.victor.ProccessBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Usa ProcessBuilder para ejecutar el mismo comando del ejercicio 1
 */

public class ProcessBuilder {

    public static void main(String[] args){

        try {

            String comando = System.getProperty("os.name");

            if (comando.toLowerCase().startsWith("win")){

                comando = "cmd /c dir";
            }else {

                comando = "ls";
            }

            ProcessBuilder pb = new ProcessBuilder(comando.split(" "));

            //pb.redirectErrorStream(true);

            Process process = pb.start();


            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String linea;

            while ((linea = br.readLine()) != null) {

                System.out.println("Linea: " + linea);
            }

            int exitCode = process.waitFor();

            if (exitCode != 0) {

                System.err.println("El comando terminop con codigo de error: " + exitCode);
            }

        }catch (IOException | InterruptedException e){

            System.out.println("Error! " + e.getMessage());
        }

    }
}
