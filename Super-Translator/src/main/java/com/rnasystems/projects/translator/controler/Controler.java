/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.controler;

import com.rnasystems.projects.translator.vista.Vista;
import com.rnasystems.projects.translator.vista.main.VistaPrincipal;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
//import com.rnasystems.projects.translator.core.GoogleUtilTranslator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public abstract class Controler implements IControler,ActionListener{

    public Controler(VistaPrincipal vista) {
        this.vista = vista;
        insertaFuncionalidadActionListener();
        insertaReferenciasComponentes();
        initialize();
    }

    public void insertaFuncionalidadActionListener() {
        ArrayList<JComponent> actionListenerComponentes = vista.getActionListenerComponentes();
        for(JComponent jComponent : actionListenerComponentes){
            if( jComponent instanceof JButton){
               ((JButton)jComponent).addActionListener(this); 
            }else if( jComponent instanceof JTextField){
               ((JTextField)jComponent).addActionListener(this); 
            }
        }
    }   
        
    public Vista vista;
 
    
}
