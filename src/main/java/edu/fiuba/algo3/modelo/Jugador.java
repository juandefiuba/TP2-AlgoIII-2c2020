package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador
{

    private String nombre;
    private int puntaje;

    public Jugador(String nombre)
    {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public void asignarPuntos(int puntos)
    {
        this.puntaje += puntos;
    }

    public int visualizarPuntaje()
    {
        return puntaje;
    }
}
