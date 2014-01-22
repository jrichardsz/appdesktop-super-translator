/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.core;

import java.io.IOException;

import com.gtranslate.Audio;
import com.gtranslate.Translator;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class GoogleUtilTranslator {
	
	private static Translator translate;
	private static Audio audio;
	
    public static String cleanText(String input) {
        return input.replace("’", "'");
    }    
	
	public static Translator getTranslatorInstance(){
		
		if(translate==null){
			translate = new Translator();
		}
		
		return translate;
		
	}

	public static Audio getAudioInstance(){
		
		if(audio==null){
			audio = new Audio();
		}
		
		return audio;
		
	}

    public static String translate(String palabra, String languajeIni, String languajeEnd) throws IOException, Exception {

        String output = "";

        if (palabra == null || palabra.equals("")) {
            return null;
        }
        
        Translator translate = getTranslatorInstance();
        output = translate.translate(palabra, languajeIni, languajeEnd);
        
        return output;
    }

    public static void executeTTS(String palabra, String languaje) throws IOException, Exception {

        Audio audio = getAudioInstance();
//        audio.play(palabra, languaje);
    }
}
