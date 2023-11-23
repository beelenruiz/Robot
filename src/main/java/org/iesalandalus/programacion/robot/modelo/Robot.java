package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {
    Zona zona;
    Orientacion orientacion;
    Coordenada coordenada;

    public Robot(){
        getZona(zona);
    }
    public Robot(Zona zona){
        this();
        this.zona = zona;
    }
    public Robot(Zona zona, Orientacion orientacion){
        this(zona);
        this.orientacion = orientacion;
    }
    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada){
        this(zona, orientacion);
        this.coordenada = coordenada;
    }
    public Robot(Robot robot){
        this();
        Objects.requireNonNull(robot, "No puedo copiar un robot nulo.");
        robot.zona = zona;
        robot.coordenada = coordenada;
        robot.orientacion = orientacion;
    }

    public Zona getZona() {
        return zona;
    }
    private void setZona(Zona zona){
        Objects.requireNonNull(zona, "No puedes poner una zona nula");
        this.zona = zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }
    private void setOrientacion(Orientacion orientacion) {
        Objects.requireNonNull(orientacion, "No puedes poner una orientación nula.")
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }
    private void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "No puedes poner una coordenada nula.")
        this.coordenada = coordenada;
    }

    public void avanzar(){
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(zona, robot.zona) && orientacion == robot.orientacion && Objects.equals(coordenada, robot.coordenada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zona, orientacion, coordenada);
    }

    @Override
    public String toString() {
        return "Robot -> " + "zona = " + zona + ", orientación = " + orientacion + ", coordenada = " + coordenada;
    }
}
