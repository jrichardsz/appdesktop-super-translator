/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.view;

import com.rnasystems.api.linet.util.swing.JFrameUtil;
import com.rnasystems.api.linet.util.swing.SwingUtil;
import com.rnasystems.projects.translator.core.GoogleUtilTranslator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import javazoom.jl.player.Player;

/**
 *
 * @author Richard Osmar Leon Ingaruca
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form SuperJTextfield
     */
    public View() {

        initComponents();
        setTitle("Super Translator 1.0");
        setAlwaysOnTop(true);
        JFrameUtil.setIconApp(this);
        initialize();
        setAlwaysOnTop(true);
        SwingUtil.centrarJFrame(this);
        setSize(ancho_frame, alto_frame);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldEnglish = new javax.swing.JTextField();
        jTextFieldSpanish = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldSpanish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSpanishActionPerformed(evt);
            }
        });

        jButton1.setText("exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("start");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("now");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("clean");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setText("stop");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton4)
                .addComponent(jButton5)
                .addComponent(jButton3)
                .addComponent(jButton1)
                .addComponent(jButton2))
        );

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/rnasystems/projects/translator/images/ImgFlagUS.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/rnasystems/projects/translator/images/ImgFlagES.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSpanish, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(jTextFieldEnglish, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7)
                    .addComponent(jTextFieldSpanish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jTextFieldEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(1);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton2.setEnabled(false);
        jTextFieldEnglish.setText("");
        jTextFieldSpanish.setText("");
        timer.start();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton2.setEnabled(true);
        timer.stop();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            traduceSpanishNow();
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void traduceSpanishNow() throws Exception{
        String texto = jTextFieldSpanish.getText();
        texto = limpiaTexto(texto);
        try {
            jTextFieldEnglish.setText(GoogleUtilTranslator.translate(texto, "es", "en"));
            jTextFieldSpanish.setText(GoogleUtilTranslator.translate(texto, "en", "es"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTextFieldEnglish.setText("");
        jTextFieldSpanish.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        InputStream inputStream = null;
        Player player = null;
        try {
            String texto = jTextFieldEnglish.getText();
            texto = limpiaTexto(texto);
            try {
                inputStream = GoogleUtilTranslator.translateTTS(texto, "en");
            } catch (Exception ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            player = new Player(inputStream);
            player.play();
        } catch (Exception ex) {
             ex.printStackTrace();
        }  finally {
            try {
                inputStream.close();
                player.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextFieldSpanishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSpanishActionPerformed
        try {
            traduceSpanishNow();
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldSpanishActionPerformed

    public void initialize() {

        timer = new Timer(1000, new ActionListener() {

            @Override
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
                        texto = limpiaTexto(texto);
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

    public String limpiaTexto(String input) {
        return input.replace("’", "'");
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldEnglish;
    private javax.swing.JTextField jTextFieldSpanish;
    // End of variables declaration//GEN-END:variables
    private Timer timer;
    private boolean isFirst = false;
    private int ancho_frame = 330;
    private int alto_frame = 125;
}
