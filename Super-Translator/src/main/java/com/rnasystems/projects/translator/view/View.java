/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.view;

import javax.swing.JFrame;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public abstract class View extends JFrame implements IView {

	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	
	public View(){
		initComponents();
		setup();
	}

}
