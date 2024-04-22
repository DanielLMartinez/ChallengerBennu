package challenge.internship;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danil
 */
public class CreacionNumero {
    
    private List<Integer> NumerosLista;
    private int Numero;
    private String NombreTxt;
    String Continuar;

    private Scanner respuesta = new Scanner(System.in);

    public void GenerarNumerosAleatorios() throws IOException {
        try {
            // Preguntándole al usuario cuántos números de la suerte quiere
            System.out.println("¿Cuántos números de la suerte desea crear?");
            Numero = respuesta.nextInt();
            // Inicializando la lista para almacenar los números de la suerte
            NumerosLista = new ArrayList<>();
            // Añadiendo un poco de suspenso
            System.out.println("\n--------------------");
            // Generando los números de la suerte
            for (int Contador = 0; Contador < Numero; Contador++) {
                int numeroAleatorio = (int) (Math.random() * 10);
                NumerosLista.add(numeroAleatorio);
            }
            // Revelando la magia
            System.out.println("\nLos números de la suerte son:\n");
            System.out.println("*" + NumerosLista + "*");
            // Pidiendo el nombre del documento para guardar los números de la suerte
            System.out.println("Ingrese el nombre del documento para guardar los números generados:");
            NombreTxt = respuesta.next();
            
            // Llamando al método para guardar los números de la suerte en un archivo de texto
            DocumentoGenerado();
        } catch (IOException error) {
            // Manejando errores inesperados con humor
            System.out.println("\nERROR Formato no deseado :c: " + error.getMessage());
        }
    }

    // Método para guardar los números de la suerte en un archivo de texto
    public void DocumentoGenerado() throws IOException {
        try {
            // Obteniendo la ruta al directorio Documentos del usuario
            Path documentosDir = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Documents");
            File directorioDocumentos = documentosDir.toFile();

            // Creando el directorio Documentos si no existe
            if (!directorioDocumentos.exists()) {
                directorioDocumentos.mkdirs();
            }

            // Construyendo la ruta completa al archivo de texto
            String rutaCompleta = directorioDocumentos.getPath() + File.separator + NombreTxt +".txt";

            try (BufferedWriter numeroTxt = new BufferedWriter(new FileWriter(rutaCompleta))) {
                for (Integer numero : NumerosLista) {
                    numeroTxt.write(numero.toString() + "\t");
                }
                System.out.println("\nArchivo guardado correctamente como: " + rutaCompleta);
                
            }
        } catch (IOException error) {
            System.out.println("\nERROR: " + error.getMessage());
        }
    }
}