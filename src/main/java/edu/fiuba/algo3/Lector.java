package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Preguntas.*;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Lector {
	private Factory factory;
	private String ruta;

	public Lector(String ruta) {
		this.ruta = ruta;
		this.factory = new Factory();
	}

	public LinkedList<Pregunta> obtenerPreguntas() throws IOException {
		String texto = Files.readString(Path.of(this.ruta));
		JsonObject jsonObject = JsonParser.parseString(texto).getAsJsonObject();
		return crearPreguntas(jsonObject);
	}

	private LinkedList<Pregunta> crearPreguntas(JsonObject jsonPreguntas) {
		JsonArray arrayPreguntas = jsonPreguntas.getAsJsonArray("preguntas");
		LinkedList<Pregunta> preguntas = new LinkedList<Pregunta>();

		for (JsonElement jsonPregunta : arrayPreguntas) {
			JsonElement jsonPreguntaAux = jsonPregunta;
			Pregunta pregunta = this.crearPregunta(jsonPreguntaAux.getAsJsonObject());
			preguntas.add(pregunta);
		}

		return preguntas;
	}

	private PreguntaBase crearPregunta(JsonObject jsonPregunta) {
		String tipoPregunta = jsonPregunta.get("tipoPregunta").getAsString();
		String textoPregunta = jsonPregunta.get("textoPregunta").getAsString();
		JsonArray arrayOpciones = jsonPregunta.getAsJsonArray("opciones");
		LinkedList<Opcion> opciones = new LinkedList<Opcion>();

		for (JsonElement jsonOpcion : arrayOpciones) {
			JsonElement jsonOpcionAux = jsonOpcion;
			Opcion opcion = this.crearOpcion(jsonOpcionAux.getAsJsonObject());
			opciones.add(opcion);
		}

		return this.factory.crearPregunta(tipoPregunta, textoPregunta, opciones);
	}

	private Opcion crearOpcion(JsonObject jsonOpcion) {
		String tipoOpcion = jsonOpcion.get("tipoOpcion").getAsString();
		String textoOpcion = jsonOpcion.get("textoOpcion").getAsString();

		return this.factory.crearOpcion(tipoOpcion, textoOpcion);
	}
}