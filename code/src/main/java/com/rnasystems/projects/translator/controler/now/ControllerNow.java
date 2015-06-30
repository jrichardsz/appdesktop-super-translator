/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.controler.now;

import java.awt.event.*;
import java.io.*;

import com.rnasystems.projects.translator.common.util.*;
import com.rnasystems.projects.translator.controler.*;
import com.rnasystems.projects.translator.core.*;
import com.rnasystems.projects.translator.snippet.*;
import com.rnasystems.projects.translator.view.impl.*;

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
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
            check503CodeError(e);
        }
    } 
    
    private void traduceEnglishNow() throws Exception {
        String texto = jTextFieldEnglish.getText();
        texto = GoogleUtilTranslator.cleanText(texto);
        try {
            jTextFieldSpanish.setText(GoogleUtilTranslator.translate(texto, "en", "es"));
        } catch (IOException ex) {
            System.out.println(ex.getCause().getMessage());
            check503CodeError(ex);
        }
    }  
    
    private void check503CodeError(Exception e) throws Exception{
    	String coderrror503 = TranslatorParameters.getProperty(TranslatorConstants.GOOGLE_CAPTCHA);
    	if(e.getCause().getMessage().contains(coderrror503)){
    		GoogleHttpCodeError503 codeError503 = new GoogleHttpCodeError503();
    		codeError503.resolve(view,e);
    	}  
    }
    
    private javax.swing.JButton jButtonNow;
    private javax.swing.JTextField jTextFieldEnglish;
    private javax.swing.JTextField jTextFieldSpanish;

}
