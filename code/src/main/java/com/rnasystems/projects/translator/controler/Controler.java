
package com.rnasystems.projects.translator.controler;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import com.rnasystems.projects.translator.view.View;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public abstract class Controler implements IControler,ActionListener{
	
    public Controler(View translatorUI) {
        this.view = translatorUI;
        assignInstancesOfView();
        initializeFunctionalityActionListener();
        setup();
    }

	public void addActionListenerComponent(JComponent actionListenerComponent) {      
		
		if(actionListenerComponentes==null){
			actionListenerComponentes = new ArrayList<JComponent>();
		}
		
		actionListenerComponentes.add(actionListenerComponent);
    }
    
    public void initializeFunctionalityActionListener() {
    	
    	registerUIComponentsToActionListener();
    	
        for(JComponent jComponent : actionListenerComponentes){
        	if(jComponent instanceof JButton){
        		 ((JButton)jComponent).addActionListener(this); 
        	}else if(jComponent instanceof JTextField){
        		((JTextField)jComponent).addActionListener(this);
        	}else if(jComponent instanceof JCheckBox){
        		((JCheckBox)jComponent).addActionListener(this);
        	}
        }
    }   
        
    public View view;
	private ArrayList<JComponent> actionListenerComponentes; 
    
}
