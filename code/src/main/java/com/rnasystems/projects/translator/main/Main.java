/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.main;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import com.linet.api.swing.lookandfeel.WindowUtilities;
import com.rnasystems.projects.translator.context.ControllerFactory;
import com.rnasystems.projects.translator.core.SystemEnvironment;
import com.rnasystems.projects.translator.view.impl.TranslatorUI;

/**
 *
 * @author Richard Osmar Leon Ingaruca
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws Exception 
     */
    public static void main(String args[]) throws Exception {
        
    	SystemEnvironment.init();
    	/*
         * Set the Nimbus look and feel
         */
    	
        WindowUtilities.setNativeLookAndFeel();
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {
                	
                	TranslatorUI  translatorUI = new TranslatorUI();
                    translatorUI.setVisible(true);
                    
                    ControllerFactory controllerFactory = new ControllerFactory(translatorUI);
                    controllerFactory.init();
					
				} catch (Exception ex) {
					ex.printStackTrace();
					StringWriter errors = new StringWriter();
					ex.printStackTrace(new PrintWriter(errors));
					JOptionPane.showMessageDialog(null, "Error when launch app.\n"+errors.toString());
					System.exit(0);
				}
            }
        });
    }
}
