/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.controler.tts;

import java.awt.event.ActionEvent;

import com.rnasystems.projects.translator.controler.Controler;
import com.rnasystems.projects.translator.core.GoogleUtilTranslator;
import com.rnasystems.projects.translator.view.impl.VistaPrincipal;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class ControllerTTS extends Controler {

    public ControllerTTS(VistaPrincipal vista) {
        super(vista);
    }

    public void assignInstancesOfView() {
        jButtonEspaniol = ((VistaPrincipal) view).getjButtonEspaniol();
        jButtonIngles = ((VistaPrincipal) view).getjButtonIngles();
        jTextFieldEnglish = ((VistaPrincipal) view).getjTextFieldEnglish();
        jTextFieldSpanish = ((VistaPrincipal) view).getjTextFieldSpanish();

    }

    public void initialize() {
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
