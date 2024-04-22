package challenge.internship;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenarNumeros {
    
    // Este método ordena los números de un archivo de texto de manera ascendente - a +
    public void OrdenarNumerosLista() throws IOException {
        try {
            Scanner entrada = new Scanner(System.in);

            // Obtener el directorio "Documents" del usuario donde se guardara el txt
            String rutaDocumentos = System.getProperty("user.home") + File.separator + "Documents";
            File carpetaDocumentos = new File(rutaDocumentos);

            // Obtener la lista de archivos de texto en la carpeta "Documents" (es documentos en algunos pc)
            File[] archivos = carpetaDocumentos.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

            // Verificar si se encontraron archivos
            if (archivos == null || archivos.length == 0) {
                System.out.println("No se encontraron archivos de texto en la carpeta 'Documents'.");
                return;
            }

            // Mostrar los archivos disponibles dentro de documents
            System.out.println("Archivos disponibles en la carpeta 'Documents':");
            for (int i = 0; i < archivos.length; i++) {
                System.out.println((i + 1) + ". " + archivos[i].getName());
            }

            // Solicitar al usuario que elija un archivo para ordenar
            System.out.print("\nIngrese el número de la opción del archivo que desea ordenar: ");
            int opcion = entrada.nextInt();

            // Verificar la opción del usuario
            if (opcion < 1 || opcion > archivos.length) {
                System.out.println("Opción inválida.");
                return;
            }

            File archivoSeleccionado = archivos[opcion - 1];

            // Leer el contenido del archivo seleccionado y almacenar los números en una lista
            List<Integer> numeros = new ArrayList<>();
            try (Scanner scanner = new Scanner(archivoSeleccionado)) {
                while (scanner.hasNextInt()) {
                    numeros.add(scanner.nextInt());
                }
            }

            // Ordenar los números de menor a mayor(Predefinido)
            Collections.sort(numeros);

            // Escribe los números ordenados en el archivo seleccionado
            try (java.io.PrintWriter escritor = new java.io.PrintWriter(archivoSeleccionado)) {
                for (int numero : numeros) {
                    escritor.println(numero);
                }
            }

            System.out.println("El archivo ha sido ordenado de menor a mayor.");

        } catch (IOException error) {
            System.out.println("\nERROR: " + error.getMessage());
        }
    }
}
