package edu.fiuba.algo3.modelo;

public abstract class EstadoOpcion {
	
	public abstract Boolean estado();
	
	public abstract Boolean mismoValor(EstadoOpcion otroEstado);
	
	public abstract Boolean mismoValor(Tildado otroEstado);
	
	public abstract Boolean mismoValor(Destildado otroEstado);
	
	public abstract Integer puntajeObtendido(EstadoOpcion otroEstado);
	
	public abstract Integer puntajeObtenido(Tildado otroEstado);
	
	public abstract Integer puntajeObtenido(Destildado otroEstado);
	
}
