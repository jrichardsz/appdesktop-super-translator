/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.main;

import com.linet.util.file.FileUtil;
import com.rnasystems.projects.translator.controler.now.CNow;
import com.rnasystems.projects.translator.controler.start.CAutomaticTranslate;
//import com.rnasystems.projects.translator.controler.tts.CTts;
import com.rnasystems.projects.translator.util.TranslatorParameters;
import com.rnasystems.projects.translator.vista.main.VistaPrincipal;
import java.io.File;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class ObjectFactory {

    public void execute() {
        TranslatorParameters.initializePath(FileUtil.getPathFromWhereApplicationIsRunning() + File.separator + "config" + File.separator + "config.properties");
        inicializaVista();
        inicializaControlers();
    }

    public void inicializaControlers() {
        cautomaticTranslate = new CAutomaticTranslate(vistaPrincipal);
        cNow = new CNow(vistaPrincipal);
//        cTts = new CTts(vistaPrincipal);
    }

    public void inicializaVista() {

        if (vistaPrincipal == null) {
            vistaPrincipal = new VistaPrincipal();
            vistaPrincipal.setVisible(true);
        }
    }
    
    protected VistaPrincipal vistaPrincipal;
    protected CAutomaticTranslate cautomaticTranslate;
    private CNow cNow;
//    private CTts cTts;
}
