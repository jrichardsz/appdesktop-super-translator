package com.rnasystems.projects.translator.temp;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rleon
 */
import java.net.*;
import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PruebaAudio {

    public static void main(String[] args) throws IOException, InterruptedException, JavaLayerException {
       
//        CargarAudioYReproducir  audioYReproducir = new CargarAudioYReproducir();
//        AudioClip sonido1, sonido2, sonidoActual;  
//        sonido1 = audioYReproducir.getSonido1();
//        sonido1.play();
//        AudioUtil.playAudio("C:\\Users\\rleon\\AppData\\Local\\Temp\\musica.wav");
////        
        try {
            //URL url = new URL("http://www.google.com/search?q=example");
            //URL url = new URL("http://translate.google.com.pe/#es/en/hola");
            //URL url = new URL("http://translate.google.com.pe/translate_a/t?client=t&text=HOLA&hl=es&sl=es&tl=en&ie=UTF-8&oe=UTF-8&multires=1&ssel=0&tsel=0&sc=1");
            URL url = new URL("http://translate.google.com.pe/translate_tts?ie=UTF-8&q=mother&tl=en&total=1&idx=0&textlen=6&prev=input");
            
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("chqprx05.cngfinancial.com", 8080));
            
            URLConnection conn = url.openConnection(proxy);
            
            //Mozilla/5.0 (Windows NT 6.1; WOW64; rv:14.0) Gecko/20100101 Firefox/14.0.1
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
            
            new Player(conn.getInputStream()).play();
//            File wav = ArchivoUtil.inputStreamToTempFile(conn.getInputStream(), "musica_");    
//            
//            System.out.println("cmd "+System.getProperty("java.io.tmpdir")+wav.getName());
//            Process p = Runtime.getRuntime().exec("cmd "+System.getProperty("java.io.tmpdir")+wav.getName());
////            AudioUtil.playAudio(wav);
////            p.destroy();
////            wav.delete();

            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}