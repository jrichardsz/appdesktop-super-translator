/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.controler.inputtext;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import com.rnasystems.projects.translator.controler.Controler;
import com.rnasystems.projects.translator.view.impl.TranslatorUI;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class ControllerInputText extends Controler {

    public ControllerInputText(TranslatorUI vista) {
        super(vista);
    }
    
	@Override
	public void registerUIComponentsToActionListener(){		
		addActionListenerComponent(jTextFieldEnglish);
		addActionListenerComponent(jTextFieldSpanish);
	}

    public void assignInstancesOfView() {
        jTextFieldEnglish = ((TranslatorUI) view).getjTextFieldEnglish();
        jTextFieldSpanish = ((TranslatorUI) view).getjTextFieldSpanish();
    }

	@Override
	public void setup(){
		
	}
	
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jTextFieldEnglish) {
        	System.out.println("english");
        } else if (e.getSource() == jTextFieldSpanish) {
        	System.out.println("spanish");
        }
    }

    
    private JTextField jTextFieldEnglish;
    private JTextField jTextFieldSpanish;


}
