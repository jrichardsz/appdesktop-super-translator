/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.main;

import com.rnasystems.api.linet.util.lookAndFeel.WindowUtilities;
import com.rnasystems.projects.translator.view.Translator;

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
        WindowUtilities.setNimbusLookAndFeel();
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Initialize();
                new Translator().setVisible(true);
            }
        });
    }
}
