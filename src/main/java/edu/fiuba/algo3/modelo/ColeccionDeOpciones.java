package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

import java.util.ArrayList;

public class ColeccionDeOpciones {

    protected ArrayList<Opcion> opciones;

    public ColeccionDeOpciones(int cantidadDeElementos){
        opciones = new ArrayList<>();
        for(int i = 1; i <= cantidadDeElementos; i++) {
            opciones.add( new Opcion() );    // index = [ 0 , 1 ]
        }
    }


    public int size(){
        return opciones.size();
    }

    public void agregarOpcionCorrecta(int unaPocicion){
        int elIndex = unaPocicion-1;
        opciones.get(elIndex).definirCorrecta();
    }


    public Opcion obtener(int Posicion) {
        int elIndex = Posicion-1;
        return (opciones.get(elIndex));
    }

    public EstadoDeRespuesta calificarRespuestaDelJugador(ColeccionDeOpciones respuestaCorrecta) {
        //si esta bien respondido devuelve RespondioBien , si esta mal RespondioMal
        EstadoDeRespuesta estadoDeRespuesta = null ;
        int i = 1;
        while( i < this.size() ){
            estadoDeRespuesta = this.obtener(i).mismoValor(respuestaCorrecta.obtener(i));
            i++;
        }
        return estadoDeRespuesta;
    }
}
