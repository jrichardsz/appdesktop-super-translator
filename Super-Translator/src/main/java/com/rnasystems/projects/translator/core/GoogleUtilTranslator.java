/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gtranslate.Audio;
import com.gtranslate.Translator;
import com.gtranslate.context.TranslatorEnvironmentUtil;
import com.rnasystems.projects.translator.util.TranslatorParameters;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class GoogleUtilTranslator {
	
	private static Translator translate;
	
	static {
		
		try {
			
			String enableProxy = TranslatorParameters.getProperty("enable.proxy");
			String proxy = TranslatorParameters.getProperty("enable.proxy");
			String port = TranslatorParameters.getProperty("enable.proxy");
			String googleTranslateText = TranslatorParameters.getProperty("enable.proxy");
			String googleTranslateAudio = TranslatorParameters.getProperty("enable.proxy");
			String googleTranslateDetect = TranslatorParameters.getProperty("enable.proxy");
			String locale = TranslatorParameters.getProperty("enable.proxy");
			
			TranslatorEnvironmentUtil.initialize(enableProxy, proxy, port, googleTranslateText, googleTranslateAudio, googleTranslateDetect, locale);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public static Translator getInstance(){
		
		if(translate==null){
			translate = new Translator();
		}
		
		return translate;
		
	}

    public static String translate(String palabra, String languajeIni, String languajeEnd) throws IOException, Exception {

        String output = "";

        if (palabra == null || palabra.equals("")) {
            return null;
        }
        
        Translator translate = getInstance();
        output = translate.translate(palabra, languajeIni, languajeEnd);
        output = extraeSoloTraduccion(output);
        return output;
    }

    private static String extraeSoloTraduccion(String input) {

        if (input == null) {
            return null;
        }

        Pattern pattern = Pattern.compile("[\\[]{3}\"{1}[^\"]+");
        Matcher matcher = pattern.matcher(input);
        String buscado = null;

        if (matcher.find()) {
            buscado = matcher.group();
        }
        //afinamos lo encontrado
        if (buscado == null) {
            return null;
        }

        pattern = Pattern.compile("[\\[]{3}\"{1}");
        matcher = pattern.matcher(buscado);

        if (matcher.find()) {
            buscado = matcher.replaceAll("");
        }
        return buscado;
    }

    public static InputStream translateTTS(String palabra, String languaje) throws IOException, Exception {

        Audio audio = Audio.getInstance();
        InputStream sound = audio.getAudio(palabra, languaje);
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

    public static void main2(String args[]) throws IOException, Exception {
        System.out.println(GoogleUtilTranslator.translate("", null, null));
    }
}
