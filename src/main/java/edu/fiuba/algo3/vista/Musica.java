package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.handlers.MusicaPlayInfinito;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.nio.file.Paths;

public class Musica {

    private static MediaPlayer mediaPlayer = null;
    public static boolean estaMuteado = false;


    public static void musicaPlaySinFin(String rutaArchivoMusica) {
        Media media = new Media(Paths.get(rutaArchivoMusica).toUri().toString());
        mediaPlayer = new MediaPlayer(media);

        //LOOP MÚSICA
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));

        mediaPlayer.play();
        if(estaMuteado) mediaPlayer.pause();
    }

    public static void mutear() {
        musicaPause();
        estaMuteado = true;
    }

    public static void desMutear() {
        estaMuteado = false;
        musicaReanudar();
    }

    public static void musicaPlay(String rutaArchivoMusica) {
        Media media = new Media(Paths.get(rutaArchivoMusica).toUri().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        if(estaMuteado) mediaPlayer.pause();
    }

    public static void musicaPlayYDespuesPlayOtraInfinita(String ruta1, String ruta2) {
        if(estaMuteado) return;
        Media media = new Media(Paths.get(ruta1).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> {
            Musica.musicaPlaySinFin(ruta2);
        });
    }

    public static void musicaPause() {
        mediaPlayer.pause();
    }

    //Debe tener un archivo cargado antes desde musicaPlay
    public static void musicaReanudar() {
        if(estaMuteado) return;
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();
    }

}
