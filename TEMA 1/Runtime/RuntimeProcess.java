package org.victor.Runtime;

import java.io.IOException;

/**
 * Escribe un programa en Java que ejecute el comando dir (Windows) o ls (Linux/Mac) usando Runtime
 */

public class RuntimeProcess {

    public static void main(String[] args) {

        try {

            String[] comando;

            if (System.getProperty("os.name").toLowerCase().startsWith("win")){

                comando = new String[]{"cmd /c dir"};
            }else {

                comando = new String[]{"ls"};
            }

            Runtime runtime = Runtime.getRuntime();

            Process process = runtime.exec(comando);

            process.waitFor();

            System.out.println("Proceso terminado: " + process.exitValue());

        }catch(IOException | InterruptedException e){

            System.err.println("Error!: " + e.getMessage());
        }
    }
}
