/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.context;

import java.io.File;

import com.gtranslate.context.TranslatorEnvironmentUtil;
import com.linet.util.file.FileUtil;
import com.rnasystems.projects.translator.common.util.TranslatorConstants;
import com.rnasystems.projects.translator.common.util.TranslatorParameters;
import com.rnasystems.projects.translator.controler.now.ControllerNow;
import com.rnasystems.projects.translator.controler.start.ControllerStartStop;
import com.rnasystems.projects.translator.controler.tts.ControllerTTS;
import com.rnasystems.projects.translator.view.impl.VistaPrincipal;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class ControllerFactory {

    public void execute() throws Exception {
        TranslatorParameters.initializePath(FileUtil.getPathFromWhereApplicationIsRunning() + File.separator + "config" + File.separator + "config.properties");
        initializeParametersTranslator();
        inicializaVista();
        inicializaControlers();
    }
    
    public void initializeParametersTranslator() throws Exception{
    	String enableProxy = TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_ENABLE_PROXY);
    	String proxy = TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_PROXY);
    	String port= TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_PORT);
    	String googleTranslateText = TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_GOOGLE_TRANSLATE_TEXT);
    	String googleTranslateAudio = TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_GOOGLE_TRANSLATE_AUDIO);
    	String googleTranslateDetect = TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_GOOGLE_TRANSLATE_DETECT);
    	String locale = TranslatorParameters.getProperty(TranslatorConstants.TRANSLATE_LOCALE);
    	
    	TranslatorEnvironmentUtil.initialize(enableProxy, proxy, port, googleTranslateText, googleTranslateAudio, googleTranslateDetect, locale);
    }

    public void inicializaControlers() {
        cautomaticTranslate = new ControllerStartStop(vistaPrincipal);
        cNow = new ControllerNow(vistaPrincipal);
        controllerTTS = new ControllerTTS(vistaPrincipal);
    }

    public void inicializaVista() {

        if (vistaPrincipal == null) {
            vistaPrincipal = new VistaPrincipal();
            vistaPrincipal.setVisible(true);
        }
    }

    public ControllerStartStop getCautomaticTranslate() {
		return cautomaticTranslate;
	}

	public void setCautomaticTranslate(ControllerStartStop cautomaticTranslate) {
		this.cautomaticTranslate = cautomaticTranslate;
	}

	public ControllerNow getcNow() {
		return cNow;
	}

	public void setcNow(ControllerNow cNow) {
		this.cNow = cNow;
	}

	public ControllerTTS getControllerTTS() {
		return controllerTTS;
	}

	public void setControllerTTS(ControllerTTS controllerTTS) {
		this.controllerTTS = controllerTTS;
	}




	protected VistaPrincipal vistaPrincipal;
    protected ControllerStartStop cautomaticTranslate;
    private ControllerNow cNow;
    private ControllerTTS controllerTTS;
}
