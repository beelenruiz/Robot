package org.iesalandalus.programacion.robot.modelo;

import static org.iesalandalus.programacion.robot.modelo.Coordenada.centro;

public record Zona() {
    public static final int ANCHO_MINIMO = 0;
    public static final int ANCHO_MAXIMO = 9;
    public static final int ALTO_MINIMO = 0;
    public static final int ALTO_MAXIMO = 9;
    private static int ancho;
    private static int alto;

    public Zona(int ancho, int alto){
        validarAncho(ancho);
        validarAlto(alto);
    }

    public Zona(){
        this.ancho = ANCHO_MINIMO;
        this.alto = ALTO_MINIMO;
    }

    private void validarAncho(int ancho){
        if (ancho < ANCHO_MINIMO || ancho > ANCHO_MAXIMO){
            throw new IllegalArgumentException("No es válido");
        }
    }

    private void validarAlto(int alto){
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO){
            throw new IllegalArgumentException("No es válido");
        }
    }

    public Coordenada getCentro() {
        return centro;
    }

    public boolean pertecene(Coordenada coordenada){
        if (perteneceX() = true && perteneceY() = true){
            return true;
        } else {
            return false;
        }
    }
    private boolean perteneceX(int x){
        if(x > 9 || x < 0){
            return false;
        } else {
            return true;
        }
    }

    private boolean perteneceY(int y){
        if(y > 9 || y < 0){
            return false;
        } else {
            return true;
        }
    }
}
