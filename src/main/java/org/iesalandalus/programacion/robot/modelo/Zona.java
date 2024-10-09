package org.iesalandalus.programacion.robot.modelo;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public record Zona(int ancho, int alto, Coordenada[]obstaculos) {
    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;
    public static final int MINIMO_OBSTACULOS = 20;
    public static final int MAXIMO_OBSTACULOS = 50;
    private static final Random generador = new Random();

    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
        if (obstaculos == null){
            obstaculos = new Coordenada[generador.nextInt(MINIMO_OBSTACULOS, MAXIMO_OBSTACULOS + 1)];
            generarObstaculos(obstaculos, ancho, alto);
        }
    }

    public Zona(int ancho, int alto){
        this(ancho, alto, null);
    }

    public Zona() {
        this(ANCHO_MINIMO, ALTO_MINIMO);
    }

    private void validarAncho(int ancho){
        if (ancho < ANCHO_MINIMO || ancho > ANCHO_MAXIMO){
            throw new IllegalArgumentException("Ancho no válido.");
        }
    }

    public void generarObstaculos(Coordenada[] obstaculos, int ancho, int alto){
        for (int i = 0; i < obstaculos.length; i++){
            Coordenada obstaculo;
            do {
                obstaculo = new Coordenada(generador.nextInt(0, ancho), generador.nextInt(0, alto));
            } while (esObstaculo(obstaculos, obstaculo));
            obstaculos[i] = obstaculo;
        }
    }
    private void validarAlto(int alto) throws IllegalArgumentException {
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO){
            throw new IllegalArgumentException("Alto no válido.");
        }
    }

    private void validarObstaculos(Coordenada[] obstaculos, Coordenada coordenada){
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        boolean esObstaculo = false;
        for (int i = 0; i < obstaculos.length || esObstaculo; i++){
            if (obstaculos[i] == coordenada){
                esObstaculo = true;
            }
        }
    }

    public boolean esObstaculo(Coordenada[] obstaculos, Coordenada coordenada){
        return ;
    }

    public Coordenada getCentro() {
        return new Coordenada(ancho/2, alto/2);
    }

    public boolean pertenece(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        return perteneceX(coordenada.getX()) && perteneceY(coordenada.getY());
    }
    private boolean perteneceX(int x){
        return (x >= 0 && x < ancho);
    }

    private boolean perteneceY(int y){
        return (y >= 0 && y < alto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zona zona = (Zona) o;
        return ancho == zona.ancho && alto == zona.alto && Arrays.equals(obstaculos, zona.obstaculos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ancho, alto);
        result = 31 * result + Arrays.hashCode(obstaculos);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Zona[ancho=%s, alto=%s, obstaculos=%s]", this.ancho, this.alto, Arrays.toString(this.obstaculos));
    }
}
