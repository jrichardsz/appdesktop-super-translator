/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.controler.now;

import com.rnasystems.projects.translator.controler.Controler;
import com.rnasystems.projects.translator.core.GoogleUtilTranslator;
import com.rnasystems.projects.translator.core.UtilTranslator;
import com.rnasystems.projects.translator.vista.main.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class CNow extends Controler {

    public CNow(VistaPrincipal vista) {
        super(vista);
    }

    public void insertaReferenciasComponentes() {
        jButtonNow = ((VistaPrincipal) vista).getjButtonNow();
        jTextFieldEnglish = ((VistaPrincipal) vista).getjTextFieldEnglish();
        jTextFieldSpanish = ((VistaPrincipal) vista).getjTextFieldSpanish();

    }

    public void initialize() {
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButtonNow) {
            try {
                String spanishText = jTextFieldSpanish.getText();
                String englishText = jTextFieldEnglish.getText();
                
                if(UtilTranslator.esValidoTexto(spanishText)&& UtilTranslator.esValidoTexto(englishText)){
                    jTextFieldEnglish.setText("Write in a single input, Spanish or English");
                    jTextFieldSpanish.setText("Escribe en un solo input, español o ingles");
                }else if(UtilTranslator.esValidoTexto(spanishText)){
                    traduceSpanishNow();
                }else if(UtilTranslator.esValidoTexto(englishText)){
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
        String texto = jTextFieldSpanish.getText();
        texto = UtilTranslator.limpiaTexto(texto);
        try {
            jTextFieldEnglish.setText(GoogleUtilTranslator.translate(texto, "es", "en"));
            jTextFieldSpanish.setText(GoogleUtilTranslator.translate(texto, "en", "es"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    
    private void traduceEnglishNow() throws Exception {
        String texto = jTextFieldEnglish.getText();
        texto = UtilTranslator.limpiaTexto(texto);
        try {
            jTextFieldEnglish.setText(GoogleUtilTranslator.translate(texto, "es", "en"));
            jTextFieldSpanish.setText(GoogleUtilTranslator.translate(texto, "en", "es"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    private javax.swing.JButton jButtonNow;
    private javax.swing.JTextField jTextFieldEnglish;
    private javax.swing.JTextField jTextFieldSpanish;
}
