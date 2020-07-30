package edu.fiuba.algo3.modelo.EstadosOpcion;

public interface EstadoOpcion {
	
	Boolean estado();
	
	Boolean mismoValor(EstadoOpcion otroEstado);
	
	Boolean mismoValor(Tildado otroEstado);
	
	Boolean mismoValor(Destildado otroEstado);
	
	Integer puntajeObtenido(EstadoOpcion otroEstado);
	
	Integer puntajeObtenido(Tildado otroEstado);
	
	Integer puntajeObtenido(Destildado otroEstado);
	
}
