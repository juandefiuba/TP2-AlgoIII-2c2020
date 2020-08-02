package edu.fiuba.algo3.modelo2;

import java.util.Iterator;

public class PreguntaVerdaderoFalso {


    private ColeccionDeOpciones opciones;

    public PreguntaVerdaderoFalso(ColeccionDeOpciones opciones) {
        this.opciones = opciones;
    }

    public Iterator obtenerOpciones() {
        return this.opciones.obtenerIterador();
    }
}
