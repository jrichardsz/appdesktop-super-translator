/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.main;

import com.rnasystems.api.linet.util.archivos.ArchivoUtil;
import com.rnasystems.projects.translator.controler.now.CNow;
import com.rnasystems.projects.translator.controler.start.CAutomaticTranslate;
import com.rnasystems.projects.translator.util.TranslatorParameters;
import com.rnasystems.projects.translator.vista.main.VistaPrincipal;
import java.io.File;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class ObjectFactory {

    public void execute() {
        TranslatorParameters.initializePath(ArchivoUtil.getPathDirectorioEjecucion() + File.separator + "config" + File.separator + "config.properties");
        inicializaVista();
        inicializaControlers();
    }

    public void inicializaControlers() {
        cautomaticTranslate = new CAutomaticTranslate(vistaPrincipal);
        cNow = new CNow(vistaPrincipal);
    }

    public void inicializaVista() {

//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {

                if (vistaPrincipal == null) {
                    vistaPrincipal = new VistaPrincipal();
                    vistaPrincipal.setVisible(true);
                }
//            }
//        });

    }
    protected VistaPrincipal vistaPrincipal;
    protected CAutomaticTranslate cautomaticTranslate;
    private CNow cNow;
}
