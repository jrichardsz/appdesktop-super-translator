package com.rnasystems.projects.translator.core.deprecated;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rnasystems.projects.translator.common.util.TranslatorParameters;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author rleon
 * http://code.google.com/p/java-google-translate-text-to-speech/source/checkout
 */
public class NativeUtilTranslator {

    public static String toEnglishJson(String palabra) throws IOException, Exception {
        
        String output = "";
        
        if(palabra==null || palabra.equals("")){
            return null;
        }
        
        try {
            //http://translate.google.com/translate_t?langpair=es|en&text=CADENA
            // corregimos los espacion en blanco
            palabra = palabra.replaceAll(" ", "%20");
            //[18:16:51.601] GET http://translate.google.com.pe/translate_a/t?client=t&text=Hola%20como%20estas&hl=es&sl=es&tl=en&ie=UTF-8&oe=UTF-8&multires=1&otf=1&pc=1&ssel=0&tsel=0&sc=1 [HTTP/1.1 200 OK 170ms]            
            URL url = new URL("http://translate.google.com.pe/translate_a/t?client=t&text=" + palabra + "&hl=en&sl=en&tl=es&ie=UTF-8&oe=UTF-8&multires=1&ssel=0&tsel=0&sc=1");
            //URL url = new URL("http://translate.google.com/translate_t?langpair=es|en&text="+palabra);
            //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("chqprx05.cngfinancial.com", 8080));
            URLConnection conn = getURLConnection(url);
            //Mozilla/5.0 (Windows NT 6.1; WOW64; rv:14.0) Gecko/20100101 Firefox/14.0.1
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
   
            String str;
            
            while ((str = in.readLine()) != null) {                
                output+=str;
            }

            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return output;
    }
    
    
    
    private static URLConnection getURLConnection(URL url) throws IOException, Exception{
       
        String enable = TranslatorParameters.getProperty("enable.proxy");
        
        if(enable!=null && enable.equalsIgnoreCase("n")){
             return url.openConnection();
        }else {
            String proxy = TranslatorParameters.getProperty("http.proxy");
            String port = TranslatorParameters.getProperty("http.proxy.port");
            Proxy prox = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy, Integer.parseInt(port)));           
            return url.openConnection(prox);
        }
    }
    
    
    public static String translate(String palabra,String languajeIni,String languajeEnd) throws IOException, Exception {
        
        String output = "";
        
        if(palabra==null || palabra.equals("")){
            return null;
        }
        
        try {
            //http://translate.google.com/translate_t?langpair=es|en&text=CADENA
            // corregimos los espacio en blanco
            palabra = palabra.replaceAll(" ", "%20");
            //[18:16:51.601] GET http://translate.google.com.pe/translate_a/t?client=t&text=Hola%20como%20estas&hl=es&sl=es&tl=en&ie=UTF-8&oe=UTF-8&multires=1&otf=1&pc=1&ssel=0&tsel=0&sc=1 [HTTP/1.1 200 OK 170ms]            
            URL url = new URL("http://translate.google.com.pe/translate_a/t?client=t&text=" + palabra + "&hl="+languajeIni+"&sl="+languajeIni+"&tl="+languajeEnd+"&ie=UTF-8&oe=UTF-8&multires=1&ssel=0&tsel=0&sc=1");
            //URL url = new URL("http://translate.google.com/translate_t?langpair=es|en&text="+palabra);
            URLConnection conn = getURLConnection(url);
            //Mozilla/5.0 (Windows NT 6.1; WOW64; rv:14.0) Gecko/20100101 Firefox/14.0.1
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
   
            String str;
            
            while ((str = in.readLine()) != null) {                
                output+=str;
            }
            
            output = extraeSoloTraduccion(output);
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return output;
    }    
    
    public static InputStream translateTTS(String palabra,String languaje) throws IOException, Exception {
                
        InputStream output = null;
        int lengh = 0;
        
        if(palabra==null || palabra.equals("")){
            return null;
        }
        
        try {
            //http://translate.google.com/translate_t?langpair=es|en&text=CADENA
            // corregimos los espacio en blanco
            lengh = palabra.length();
            palabra = palabra.replaceAll(" ", "%20");
            //[18:16:51.601] GET http://translate.google.com.pe/translate_a/t?client=t&text=Hola%20como%20estas&hl=es&sl=es&tl=en&ie=UTF-8&oe=UTF-8&multires=1&otf=1&pc=1&ssel=0&tsel=0&sc=1 [HTTP/1.1 200 OK 170ms]            
            //URL url = new URL("http://translate.google.com.pe/translate_a/t?client=t&text=" + palabra + "&hl="+languajeIni+"&sl="+languajeIni+"&tl="+languajeEnd+"&ie=UTF-8&oe=UTF-8&multires=1&ssel=0&tsel=0&sc=1");
            URL url = new URL("http://translate.google.com.pe/translate_tts?ie=UTF-8&q="+palabra+"&tl="+languaje+"&total=1&idx=0&textlen="+lengh+"&prev=input");
            //URL url = new URL("http://translate.google.com/translate_t?langpair=es|en&text="+palabra);
            URLConnection conn = getURLConnection(url);
            //Mozilla/5.0 (Windows NT 6.1; WOW64; rv:14.0) Gecko/20100101 Firefox/14.0.1
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
           
            output = conn.getInputStream();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
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
    
    public static String cleanText(String input) {
        return input.replace("’", "'");
    }    

    public static boolean esValidoTexto(String text) {
        
        if(text!=null && !text.equals("")){
            return true;
        }else {
            return false;
        }
    }    
}
