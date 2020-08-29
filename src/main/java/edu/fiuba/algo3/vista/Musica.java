package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.handlers.MusicaPlayInfinito;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.nio.file.Paths;

public class Musica {

    private static MediaPlayer mediaPlayer = null;
    private static boolean  estaPausado;

    public static void musicaPlaySinFin(String rutaArchivoMusica) {
        //if(mediaPlayer != null) { mediaPlayer.stop(); }
        Media media = new Media(Paths.get(rutaArchivoMusica).toUri().toString());
        mediaPlayer = new MediaPlayer(media);

        //LOOP MÚSICA
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));

        estaPausado = false;
        mediaPlayer.play();
    }

    public static void musicaPlay(String rutaArchivoMusica) {
        Media media = new Media(Paths.get(rutaArchivoMusica).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }


    public static void musicaPlayYDespuesPlayOtraInfinita(String ruta1, String ruta2) {
        Media media = new Media(Paths.get(ruta1).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> {
            Musica.musicaPlaySinFin(ruta2);
        });
    }



    public static void musicaPlayOPausa() {
        if (estaPausado) {
            musicaReanudar();
        } else {
            musicaPause();
        }
    }

    public static void musicaPause() {
        mediaPlayer.pause();
        estaPausado = true;
    }

    //Debe tener un archivo cargado antes desde musicaPlay
    public static void musicaReanudar() {
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        estaPausado = false;
    }

}
