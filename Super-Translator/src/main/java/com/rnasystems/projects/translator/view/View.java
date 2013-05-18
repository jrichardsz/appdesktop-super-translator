/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.view;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public abstract class View extends JFrame implements IView {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void addActionListenerComponentes(JComponent actionListenerComponente) {        
        getInstanceActionListenerComponentes().add(actionListenerComponente);
    }

    public ArrayList<JComponent> getInstanceActionListenerComponentes() {
        if (actionListenerComponentes == null) {
            actionListenerComponentes = new ArrayList<JComponent>();
            return actionListenerComponentes;
        } else {
            return actionListenerComponentes;
        }
    }


    public ArrayList<JComponent> getActionListenerComponentes() {
        return actionListenerComponentes;
    }

    public void setActionListenerComponentes(ArrayList<JComponent> actionListenerComponentes) {
        this.actionListenerComponentes = actionListenerComponentes;
    }
    public ArrayList<JComponent> actionListenerComponentes = null;

}
