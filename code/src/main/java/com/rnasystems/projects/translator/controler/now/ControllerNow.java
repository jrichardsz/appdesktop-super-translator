/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.controler.now;

import java.awt.event.ActionEvent;
import java.io.IOException;

import com.rnasystems.projects.translator.controler.Controler;
import com.rnasystems.projects.translator.core.GoogleUtilTranslator;
import com.rnasystems.projects.translator.core.NativeUtilTranslator;
import com.rnasystems.projects.translator.view.impl.TranslatorUI;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class ControllerNow extends Controler {

    public ControllerNow(TranslatorUI vista) {
        super(vista);
    }

    public void assignInstancesOfView() {
        jButtonNow = ((TranslatorUI) view).getjButtonNow();
        jTextFieldEnglish = ((TranslatorUI) view).getjTextFieldEnglish();
        jTextFieldSpanish = ((TranslatorUI) view).getjTextFieldSpanish();

    }
    
	@Override
	public void registerUIComponentsToActionListener(){
		addActionListenerComponent(jButtonNow);
		addActionListenerComponent(jTextFieldEnglish);
		addActionListenerComponent(jTextFieldSpanish);		
	}

    public void setup() {
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButtonNow) {
            try {
                String spanishText = jTextFieldSpanish.getText();
                String englishText = jTextFieldEnglish.getText();
                
                if(NativeUtilTranslator.esValidoTexto(spanishText)&& NativeUtilTranslator.esValidoTexto(englishText)){
                    jTextFieldEnglish.setText("Write in a single input, Spanish or English");
                    jTextFieldSpanish.setText("Escribe en un solo input, español o ingles");
                }else if(NativeUtilTranslator.esValidoTexto(spanishText)){
                    traduceSpanishNow();
                }else if(NativeUtilTranslator.esValidoTexto(englishText)){
                    traduceEnglishNow();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if (e.getSource() == jTextFieldEnglish) {
            try {
                traduceEnglishNow();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if (e.getSource() == jTextFieldSpanish) {
            try {
                traduceSpanishNow();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void traduceSpanishNow() throws Exception {
        String text = jTextFieldSpanish.getText();
        text = GoogleUtilTranslator.cleanText(text);
        try {
            jTextFieldEnglish.setText(GoogleUtilTranslator.translate(text, "es", "en"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    
    private void traduceEnglishNow() throws Exception {
        String texto = jTextFieldEnglish.getText();
        texto = GoogleUtilTranslator.cleanText(texto);
        try {
            jTextFieldSpanish.setText(GoogleUtilTranslator.translate(texto, "en", "es"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }  
    
    private javax.swing.JButton jButtonNow;
    private javax.swing.JTextField jTextFieldEnglish;
    private javax.swing.JTextField jTextFieldSpanish;

}
