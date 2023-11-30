package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.vista.Consola;

import javax.naming.OperationNotSupportedException;

public class main {
    private static ControladorRobot controladorRobot;

    public static void main(String[] args){
        int opcion;
        Consola.mostrarMenuPrincipal();
        do {
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
            Consola.motrarRobot(controladorRobot);
        } while (opcion != 0);
        Consola.despedirse();
    }

    private static void ejecutarOpcion(int opcion){
        switch (opcion){
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
        }
    }

    private static void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot(new Robot()));
    }

    private static void controlarRobotZona() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
    }

    private static void controlarRobotZonaOrientacion() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion()));
    }

    private static void controlarRobotZonaOrientacionCoordenada() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion(), Consola.elegirCoordenada()));
    }

    private static void ejecutarComando() {
        if (controladorRobot != null){
            try {
                controladorRobot.ejecutar(Consola.elegirComando());
            } catch (OperationNotSupportedException e){
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Aún no has creado ningún robot que controlar.");
        }
    }
}
