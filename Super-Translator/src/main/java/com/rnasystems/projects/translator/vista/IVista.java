/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.vista;

import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public interface IVista {
    
    public void addActionListenerComponentes( JComponent actionListenerComponente);
    
    public ArrayList<JComponent> getInstanceActionListenerComponentes();    
    
    public void inicializaActionListenerComponentes();  
    
    public void inicializaConfiguraciones();      
    
}
