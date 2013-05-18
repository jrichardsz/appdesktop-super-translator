/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.controler;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

import com.rnasystems.projects.translator.view.View;
import com.rnasystems.projects.translator.view.impl.VistaPrincipal;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public abstract class Controler implements IControler,ActionListener{

    public Controler(VistaPrincipal vista) {
        this.view = vista;
        insertFunctionalityActionListener();
        assignInstancesOfView();
        initialize();
    }

    public void insertFunctionalityActionListener() {
        ArrayList<JComponent> actionListenerComponentes = view.getActionListenerComponentes();
        for(JComponent jComponent : actionListenerComponentes){
            if( jComponent instanceof JButton){
               ((JButton)jComponent).addActionListener(this); 
            }else if( jComponent instanceof JTextField){
               ((JTextField)jComponent).addActionListener(this); 
            }
        }
    }   
        
    public View view;
 
    
}
