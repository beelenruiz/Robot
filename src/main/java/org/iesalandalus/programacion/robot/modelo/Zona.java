package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;

public record Zona(int ancho, int alto) {
    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;

    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
    }

    public Zona(){
        this(ANCHO_MINIMO, ALTO_MINIMO);
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
        return new Coordenada(ancho/2, alto/2);
    }

    public boolean pertenece(Coordenada coordenada) {
        return perteneceX(coordenada.getX()) && perteneceY(coordenada.getY());
    }
    private boolean perteneceX(int x){
        return (x >= 0 || x < ancho);
    }

    private boolean perteneceY(int y){
        return (y >= 0 || y < alto);
    }
}
