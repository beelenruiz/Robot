package org.iesalandalus.programacion.robot.modelo;

import static org.iesalandalus.programacion.robot.modelo.Zona.alto;
import static org.iesalandalus.programacion.robot.modelo.Zona.ancho;

public record Coordenada(int x, int y) {
    private void validarX(int x){
        if (x < 0 || x > 9){
            throw new IllegalArgumentException("No es válido");
        }
    }
    private void validarY(int alto){
        if (y < 0 || y > 9){
            throw new IllegalArgumentException("No es válido");
        }
    }

    @Override
    public String toString() {
        return "Coordenada -> " + "x = " + x + ", y = " + y;
    }
}
