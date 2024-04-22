package challenge.internship;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class VerTxt {
    
    // Tipico scanner
    private Scanner entrada = new Scanner(System.in);
    
    // Método para mostrar el contenido de un archivo de texto
    public void mostrarContenidoArchivo() {
        try {
            // Solicitar al usuario el nombre del archivo a visualizar
            
            // Obtener el directorio "Documents" del usuario donde se guardara el txt(OrdenarNumeros)
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
            
            System.out.println("Ingrese el nombre del archivo sin su extensión para visualizar:");
            String nombreArchivo = entrada.next();

            // Obtener ruta del directorio de documentos del usuario
            Path documentosDir = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Documents");
            File directorioDocumentos = documentosDir.toFile();

           

            // Construir la ruta completa del archivo
            String rutaCompleta = directorioDocumentos.getPath() + File.separator + nombreArchivo + ".txt";
            File file = new File(rutaCompleta);

            // Verificar si el archivo existe
            if (file.exists()) {
                // Leer el archivo y mostrar su contenido
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                List<Integer> listaNumeros = new ArrayList<>();

                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.trim().split("\\s+");
                    for (String parte : partes) {
                        try {
                            int numero = Integer.parseInt(parte);
                            listaNumeros.add(numero);
                        } catch (NumberFormatException e) {
                            // Ignorar partes que no pueden ser convertidas a números
                        }
                    }
                }

                br.close();

                // Mostrar los números del archivo
                System.out.println("\nLos números del archivo " + nombreArchivo + " son:");
                for (Integer numero : listaNumeros) {
                    System.out.print(numero + " ");
                }
                System.out.println("\n");
            } 
            else {
                System.out.println("\nEl archivo \"" + nombreArchivo + "\" no existe en el directorio de documentos.\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage() + "\n");
        }
    }
       
    // Método para buscar un número en un archivo de texto (alternativa 5)
    public void buscarNumero() throws IOException {
        try {
            // Solicitar al usuario el nombre del archivo y el número a buscar
            
            System.out.println("Ingrese el nombre del archivo en el que desea buscar:");
            String nombreArchivo = entrada.next();
            System.out.println("Ingrese el número que desea buscar en el archivo:");
            int numeroBuscado = entrada.nextInt();
            int cantidad = 0;

            // Obtener la ruta completa del archivo en la carpeta "Documents"
            String rutaDocumentos = System.getProperty("user.home") + File.separator + "Documents";
            String rutaCompleta = rutaDocumentos + File.separator + nombreArchivo;

            // Leer el archivo y contar la cantidad de veces que aparece el número buscado
            try (BufferedReader br = new BufferedReader(new FileReader(rutaCompleta))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] numerosEnLinea = linea.split("\\s+");
                    for (String numStr : numerosEnLinea) {
                        int num = Integer.parseInt(numStr);
                        if (num == numeroBuscado) {
                            cantidad++;
                        }
                    }
                }
            }

            // Mostrar la cantidad de veces que aparece el número buscado en el archivo
            System.out.println("El número " + numeroBuscado + " aparece " + cantidad + " veces en el archivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo no se encontró en la carpeta 'Documents'.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número entero válido.");
            entrada.nextLine(); 
        }
    }
}
