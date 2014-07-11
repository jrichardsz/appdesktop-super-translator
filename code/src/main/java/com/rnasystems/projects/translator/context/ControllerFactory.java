/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.context;

import com.rnasystems.projects.translator.controler.now.*;
import com.rnasystems.projects.translator.controler.start.*;
import com.rnasystems.projects.translator.controler.tts.*;
import com.rnasystems.projects.translator.view.impl.*;

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
