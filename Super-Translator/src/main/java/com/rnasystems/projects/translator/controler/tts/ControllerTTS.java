/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.controler.tts;

import java.awt.event.ActionEvent;

import com.rnasystems.projects.translator.controler.Controler;
import com.rnasystems.projects.translator.core.GoogleUtilTranslator;
import com.rnasystems.projects.translator.view.impl.TranslatorUI;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class ControllerTTS extends Controler {

    public ControllerTTS(TranslatorUI vista) {
        super(vista);
    }

    public void assignInstancesOfView() {
        jButtonEspaniol = ((TranslatorUI) view).getjButtonEspaniol();
        jButtonIngles = ((TranslatorUI) view).getjButtonIngles();
        jTextFieldEnglish = ((TranslatorUI) view).getjTextFieldEnglish();
        jTextFieldSpanish = ((TranslatorUI) view).getjTextFieldSpanish();

    }

	@Override
	public void registerUIComponentsToActionListener(){
		addActionListenerComponent(jButtonEspaniol);
		addActionListenerComponent(jButtonIngles);
	}

    public void setup() {
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButtonEspaniol) {
           playSpanish();
        }else if (e.getSource() == jButtonIngles) {
           playEnglish();
        }
    }
    
    public void playSpanish(){
    	try {
			GoogleUtilTranslator.executeTTS(jTextFieldSpanish.getText(), "es");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }
    
    public void playEnglish(){
    	try {
			GoogleUtilTranslator.executeTTS(jTextFieldEnglish.getText(), "en");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }
    
    private javax.swing.JButton jButtonEspaniol;
    private javax.swing.JButton jButtonIngles;
    private javax.swing.JTextField jTextFieldEnglish;
    private javax.swing.JTextField jTextFieldSpanish;

}
