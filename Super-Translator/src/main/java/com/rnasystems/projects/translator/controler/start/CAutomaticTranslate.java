/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.controler.start;

import com.rnasystems.projects.translator.controler.Controler;
import com.rnasystems.projects.translator.core.GoogleUtilTranslator;
import com.rnasystems.projects.translator.vista.main.VistaPrincipal;
//import com.rnasystems.projects.translator.core.GoogleUtilTranslator;
import com.rnasystems.projects.translator.core.UtilTranslator;
import javax.swing.Timer;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class CAutomaticTranslate extends Controler {

    public CAutomaticTranslate(VistaPrincipal vista) {
        super(vista);
    }

    public void insertaReferenciasComponentes() {
        jTextFieldEnglish = ((VistaPrincipal) vista).getjTextFieldEnglish();
        jTextFieldSpanish = ((VistaPrincipal) vista).getjTextFieldSpanish();
        jButtonStart = ((VistaPrincipal) vista).getjButtonStart();
        jButtonStop = ((VistaPrincipal) vista).getjButtonStop();
    }

    public void initialize() {

        inicializaTimer();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButtonStart) {
            jButtonStart.setEnabled(false);
            jTextFieldEnglish.setText("");
            jTextFieldSpanish.setText("");
            timer.start();
        } else if (e.getSource() == jButtonStop) {
            jButtonStart.setEnabled(true);
            timer.stop();
        }
    }

    public void inicializaTimer() {
        timer = new Timer(1000, new ActionListener() {

           
            public void actionPerformed(ActionEvent e) {
                try {
                    // Se obtiene el Clipboard y su contenido
                    Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                    Transferable t = cb.getContents(this);

                    // Construimos el DataFlavor correspondiente a String.
                    DataFlavor dataFlavorStringJava = new DataFlavor(
                            "application/x-java-serialized-object; class=java.lang.String");

                    // Si el dato se puede obtener como String, lo obtenemos y
                    // lo
                    // sacamos por la estándar out.
                    if (t.isDataFlavorSupported(dataFlavorStringJava)) {
                        String texto = (String) t.getTransferData(dataFlavorStringJava);
                        texto = UtilTranslator.limpiaTexto(texto);
                        if (texto != null && !texto.equals("")) {

                            if (isFirst) {
                                jTextFieldEnglish.setText(GoogleUtilTranslator.translate(texto, "es", "en"));
                                jTextFieldSpanish.setText(GoogleUtilTranslator.translate(texto, "en", "es"));
                                clear();
                            } else {
                                isFirst = true;
                                clear();
                            }


                        }
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });

        timer.stop();
    }



    public void clear() {
        try {

            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.setContents(new Transferable() {

                public DataFlavor[] getTransferDataFlavors() {
                    return new DataFlavor[0];
                }

                public boolean isDataFlavorSupported(DataFlavor flavor) {
                    return false;
                }

                public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
                    throw new UnsupportedFlavorException(flavor);
                }
            }, null);
        } catch (IllegalStateException e) {
        }
    }
    private JTextField jTextFieldEnglish;
    private JTextField jTextFieldSpanish;
    private JButton jButtonStart;
    private JButton jButtonStop;
    private Timer timer;
    private boolean isFirst = false;
}
