package challenge.internship;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

import challenge.internship.CreacionNumero;
import challenge.internship.OrdenarNumeros;
import challenge.internship.VerTxt;
/**
 *
 * @author danil
 */
import java.util.Scanner;

import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        try {
            Scanner entrada = new Scanner(System.in);
            boolean salir = false;
            CreacionNumero creacionNumero = new CreacionNumero();
            VerTxt verTxt = new VerTxt();
            OrdenarNumeros ordenarNumeros = new OrdenarNumeros();

            while (!salir) {
                // Mostrar el menú
                System.out.println("----- MENÚ -----");
                System.out.println("1. Generar nuevo archivo de números aleatorios");
                System.out.println("2. Leer el archivo generado");
                System.out.println("3. Ordenar un archivo de números");
                System.out.println("4. Leer el archivo ordenado");
                System.out.println("5. Buscar un número en el archivo");
                System.out.println("6. Salir");
                System.out.print("Ingrese su opción: ");
                int opcion = entrada.nextInt();

                //El switch para entrar y ocupar el metodo para realizar lo que el usuario desee
                switch (opcion) {
                    case 1:
                        System.out.println("----- GENERAR NUEVO ARCHIVO -----");
                        creacionNumero.GenerarNumerosAleatorios();
                        break;
                    case 2:
                        System.out.println("----- LEER ARCHIVO GENERADO -----");
                        verTxt.mostrarContenidoArchivo();
                        break;
                    case 3:
                        System.out.println("----- ORDENAR ARCHIVO DE NÚMEROS -----");
                        ordenarNumeros.OrdenarNumerosLista();
                        break;
                    case 4:
                        System.out.println("----- LEER ARCHIVO ORDENADO -----");
                        verTxt.mostrarContenidoArchivo();
                        break;
                    case 5:
                        System.out.println("----- BUSCAR NÚMERO EN EL ARCHIVO -----");
                        verTxt.buscarNumero();
                        break;
                    // La despedida que es lo mas importante del codigo
                    case 6:
                        System.out.println("¡Hasta luego vuelva pronto <3!");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 6.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace(); // Para depuración
        }
    }
}
