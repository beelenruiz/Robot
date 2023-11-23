package org.iesalandalus.programacion.robot.modelo;

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

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public String toString() {
        return "Coordenada -> " + "x = " + x + ", y = " + y;
    }
}
