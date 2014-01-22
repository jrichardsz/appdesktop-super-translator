/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.context;

import java.io.File;

import com.gtranslate.context.TranslateEnvironment;
import com.linet.util.file.FileUtil;
import com.rnasystems.projects.translator.common.util.TranslatorConstants;
import com.rnasystems.projects.translator.common.util.TranslatorParameters;
import com.rnasystems.projects.translator.controler.now.ControllerNow;
import com.rnasystems.projects.translator.controler.start.ControllerStartStop;
import com.rnasystems.projects.translator.controler.tts.ControllerTTS;
import com.rnasystems.projects.translator.view.impl.TranslatorUI;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class ControllerFactory {

	public ControllerFactory(TranslatorUI translatorUI){
		this.translatorUI = translatorUI;
	}

    public void init() {
        controllerStartStop = new ControllerStartStop(translatorUI);
        cNow = new ControllerNow(translatorUI);
        controllerTTS = new ControllerTTS(translatorUI);
    }

    public ControllerStartStop getCautomaticTranslate() {
		return controllerStartStop;
	}

	public void setCautomaticTranslate(ControllerStartStop cautomaticTranslate) {
		this.controllerStartStop = cautomaticTranslate;
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

	protected TranslatorUI translatorUI;
    protected ControllerStartStop controllerStartStop;
    private ControllerNow cNow;
    private ControllerTTS controllerTTS;
}
