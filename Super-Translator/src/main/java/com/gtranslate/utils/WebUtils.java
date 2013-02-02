/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtranslate.utils;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */

import com.rnasystems.projects.translator.util.TranslatorParameters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;


public class WebUtils {

        public static String source(String urlSite) {
                StringBuilder result = new StringBuilder();

                URL url;
                URLConnection urlConn;

                try {
                        url = new URL(urlSite);
//                      urlConn = url.openConnection();
                        urlConn = getURLConnection(url);                       
//                      urlConn.addRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
                        urlConn.addRequestProperty("User-Agent","Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
                        Reader reader = new InputStreamReader(urlConn.getInputStream(),"utf-8");
                        BufferedReader br = new BufferedReader(reader);

                        int byteRead;
                        while ((byteRead = br.read()) != -1)
                                result.append((char) byteRead);

                } catch (MalformedURLException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return result.toString();
        }
        
    // method that enables the use of proxies in the Google Translate API  
    private static URLConnection getURLConnection(URL url){
       
        try{            
            String enable = TranslatorParameters.getProperty("enable.proxy");
        
        if(enable!=null && enable.equalsIgnoreCase("n")){
             return url.openConnection();
        }else {
            String proxy = TranslatorParameters.getProperty("http.proxy");
            String port = TranslatorParameters.getProperty("http.proxy.port");
            Proxy prox = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy, Integer.parseInt(port)));           
            return url.openConnection(prox);
        }
        }catch(IOException e){
            return null;
        }catch(Exception e){
            return null;
        }  
    }        

}


