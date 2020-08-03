package edu.fiuba.algo3.modelo2;

import java.util.Iterator;

public class PreguntaMultipleChoiceClasico {
    private ColeccionDeOpciones opciones;

    public PreguntaMultipleChoiceClasico(ColeccionDeOpciones opciones) {
        this.opciones = opciones;
    }

    public Iterator obtenerOpciones() {
        return this.opciones.obtenerIterador();
    }

    public void puntuar() {
        opciones.puntuar();
    }
}
