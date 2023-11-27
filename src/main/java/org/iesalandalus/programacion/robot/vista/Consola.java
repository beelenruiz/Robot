package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola(){

    }

    public static void mostrarMenuPrincipal(){
        System.out.println("Programa para controlar unu robot mediante consola.");
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.println("1.-Controlar un robot por defecto.");
        System.out.println("2.-Controlar un robot indicando su zona.");
        System.out.println("3.-Controlar un robot indicando su zona y orientación");
        System.out.println("4.-Controlar un robot indicando su zona, orientación y coordenada inicial.");
        System.out.println("5.-Ejecutar comando.");
        System.out.println();
        System.out.println("0.-Salir.");
        System.out.println();
    }

    public static int elegirOpcion(){
        int opcion;
        do {
            System.out.print("Elige una opción: ");
            opcion = Entrada.entero();
        } while (opcion <0 || opcion > 5);
        return opcion;
    }

    public static Zona elegirZona() {
        Zona zona = null;
        do {
            System.out.print("Dime el ancho: ");
            int ancho = Entrada.entero();
            System.out.print("Dime el alto: ");
            int alto = Entrada.entero();
            try {
                zona = new Zona(ancho, alto);
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } while (zona == null);
        return zona;
    }

    public static void mostrarMenuOrientaciones(){
        System.out.println("Orientaciones");
        System.out.println("-------------");
        System.out.println();
        System.out.println("0.-Norte");
        System.out.println("1.-Noreste");
        System.out.println("2.-Este");
        System.out.println("3.-Sureste");
        System.out.println("4.-Sur");
        System.out.println("5.-Suroeste");
        System.out.println("6.-Oeste");
        System.out.println("7.-Noroeste");
        System.out.println();
    }

    public static Orientacion elegirOrientacion(){
        Orientacion orientacion;
        int opcion;
        do {
            System.out.print("Elige una orientación: ");
            opcion = Entrada.entero();
        } while (opcion <0 || opcion >7);
        return switch (opcion){
            case 0 -> Orientacion.NORTE;
            case 1 -> Orientacion.NORESTE;
            case 2 -> Orientacion.ESTE;
            case 3 -> Orientacion.SURESTE;
            case 4 -> Orientacion.SUR;
            case 5 -> Orientacion.SUROESTE;
            case 6 -> Orientacion.OESTE;
            case 7 -> Orientacion.NOROESTE;
            default -> throw new IllegalArgumentException("La opción no es válida.");
        };
    }

    public static Coordenada elegirCoordenada(){
        System.out.print("Dime la componente x: ");
        int x = Entrada.entero();
        System.out.print("Dime la componente y; ");
        int y = Entrada.entero();
        return new Coordenada(x, y);
    }

    public static char elegirComando(){
        System.out.print("Dime el comando a ejecutar: ");
        return Entrada.caracter();
    }

    public static void motrarRobot(ControladorRobot controladorRobot){
        System.out.println();
        if (controladorRobot == null){
            System.out.println("Aún no se ha creado ningún robot que controlar");
        } else {
            System.out.println(controladorRobot.getRobot());
            System.out.println();
        }
    }

    public static void despedirse() {
        System.out.println();
        System.out.println("Hasta luego lucas!!");
    }
}
