/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.core;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import com.gtranslate.Translator;
import com.rnasystems.projects.translator.util.TranslatorParameters;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class GoogleUtilTranslator {

    public static String translate(String palabra, String languajeIni, String languajeEnd) throws IOException, Exception {

        String output = "";

        if (palabra == null || palabra.equals("")) {
            return null;
        }

        Translator translate = Translator.getInstance();
        output = translate.translate(palabra, languajeIni, languajeEnd);

        return output;
    }

     public static InputStream translateTTS(String palabra,String languaje) throws IOException, Exception {
         
         Audio audio = Audio.getInstance();
         InputStream sound  = audio.getAudio(palabra, languaje);
         return sound;
     }    
    
    private static URLConnection getURLConnection(URL url) throws IOException, Exception {

        String enable = TranslatorParameters.getProperty("enable.proxy");

        if (enable != null && enable.equalsIgnoreCase("n")) {
            return url.openConnection();
        } else {
            String proxy = TranslatorParameters.getProperty("http.proxy");
            String port = TranslatorParameters.getProperty("http.proxy.port");
            Proxy prox = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy, Integer.parseInt(port)));
            return url.openConnection(prox);
        }
    }

    public static void main(String args[]) throws IOException, Exception {
        System.out.println(GoogleUtilTranslator.translate("", null, null));
    }
}
