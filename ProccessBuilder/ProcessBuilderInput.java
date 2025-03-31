package org.victor.ProccessBuilder;

import java.io.*;

/**
 * Crea un proceso que ejecute cat (Linux/Mac) o type (Windows) y envíale una línea de texto para que la muestre
 */

public class ProcessBuilderInput {
    public static void main(String[] args) {

        try {

            String comando = System.getProperty("os.name");

            if (comando.toLowerCase().startsWith("win")){

                comando = "cmd type";
            }else {

                comando = "cat";
            }

            ProcessBuilder pb = new ProcessBuilder(comando.split(" "));

            Process process = pb.start();


            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

            bw.write("Hola desde Java\n");
            bw.close();


            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String linea;

            while ((linea = br.readLine()) != null) {

                System.out.println("Salida: " + linea);
            }

            process.waitFor();

        } catch (IOException | InterruptedException e) {

            System.out.println("Error! " + e.getMessage());
        }
    }
}
