/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.main;

import com.linet.api.swing.lookandfeel.WindowUtilities;

/**
 *
 * @author Richard Osmar Leon Ingaruca
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        WindowUtilities.setNativeLookAndFeel();
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new ObjectFactory().execute();
//                VistaPrincipal vistaPrincipal = new VistaPrincipal();
//                vistaPrincipal.setVisible(true);
            }
        });
    }
}
