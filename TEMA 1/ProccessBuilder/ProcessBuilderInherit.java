package org.victor.ProccessBuilder;

import java.io.File;
import java.io.IOException;

public class ProcessBuilderInherit {
    public static void main(String[] args) {

        try {

            String comando = System.getProperty("os.name");

            if (comando.toLowerCase().startsWith("win")){

                comando = "cmd /c echo Hola, mundo!";
            }else {

                comando = "echo Hola, mundo!";
            }

            ProcessBuilder pb = new ProcessBuilder(comando.split(" "));

            //Salida heredada (INHERIT)
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            Process process = pb.start();

            process.waitFor();

            System.out.println("Salida guardada en output.txt");

        } catch (IOException | InterruptedException e) {

            System.out.println("Error! " + e.getMessage());
        }
    }
}
