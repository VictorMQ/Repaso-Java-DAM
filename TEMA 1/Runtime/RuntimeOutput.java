package org.victor.Runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Modifica el codigo anterior para capturar e imprimir la salida del proceso
 */

public class RuntimeOutput {
    public static void main(String[] args) {

        try{

            String comando = System.getProperty("os.name");

            if (comando.toLowerCase().startsWith("win")){

                comando = "cmd /c dir";
            }else {

                comando = "ls";
            }

            Runtime runtime = Runtime.getRuntime();

            Process process = runtime.exec(comando.split(" "));

            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String linea = br.readLine();

            while (linea != null){

                System.out.println(linea);
            }

            process.waitFor();

        } catch (RuntimeException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
