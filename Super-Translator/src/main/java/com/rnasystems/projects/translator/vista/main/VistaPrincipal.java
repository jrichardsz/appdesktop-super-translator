/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rnasystems.projects.translator.vista.main;

import com.linet.api.swing.JFrameUtil;
import com.linet.api.swing.SwingUtil;
import com.rnasystems.projects.translator.vista.Vista;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Richard Osmar Leon Ingaruca
 */
public class VistaPrincipal extends Vista {

    /**
     * Creates new form SuperJTextfield
     */
    public VistaPrincipal() {
        initComponents();
        inicializaActionListenerComponentes();
        inicializaConfiguraciones();
    }

    @Override
    public void inicializaConfiguraciones() {
        setAlwaysOnTop(true);
        JFrameUtil.setIconApp(this);
        SwingUtil.centrarJFrame(this);
        //resize
//        Rectangle d = jButtonIngles.getBounds();
//        int height = (int) d.getY() + (int) d.getHeight() + margen_gui;
//        setSize((int) getSize().getWidth(), height);
    }

    @Override
    public void inicializaActionListenerComponentes() {
        addActionListenerComponentes(jButtonStart);
        addActionListenerComponentes(jButtonNow);
        addActionListenerComponentes(jButtonStop);
        addActionListenerComponentes(jButtonEspaniol);
        addActionListenerComponentes(jButtonIngles);
        addActionListenerComponentes(jTextFieldEnglish);
        addActionListenerComponentes(jTextFieldSpanish);

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
        jButtonExit = new javax.swing.JButton();
        jButtonStart = new javax.swing.JButton();
        jButtonNow = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jButtonIngles = new javax.swing.JButton();
        jButtonEspaniol = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Super Translator 1.0");

        jButtonExit.setText("exit");
        jButtonExit.setToolTipText("Simplemente exit.");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonStart.setText("start");
        jButtonStart.setToolTipText("Una ves presionado este boton, cualquier texto que selecciones y copies se traducira automaticamente.");

        jButtonNow.setText("now");
        jButtonNow.setToolTipText("Este boton traducira el texto ingresado en el input espaniol");

        jButtonClean.setText("clean");
        jButtonClean.setToolTipText("Este boton limpia el texto de los 02 inputs.");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        jButtonStop.setText("stop");
        jButtonStop.setToolTipText("IMPORTANTE: Presionar este boton cuando no se use la aplicacion. De no hacerlo,  el clipboard del sistema se limpiara ciclicamente, lo que te impedira copiar textos.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButtonStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonNow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonClean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonNow)
                .addComponent(jButtonClean)
                .addComponent(jButtonStop)
                .addComponent(jButtonExit)
                .addComponent(jButtonStart))
        );

        jButtonIngles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/rnasystems/projects/translator/images/ImgFlagUS.png"))); // NOI18N
        jButtonIngles.setToolTipText("Este boton reproduce en forma de audio el texto de el input ingles.");

        jButtonEspaniol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/rnasystems/projects/translator/images/ImgFlagES.png"))); // NOI18N

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
                                .addComponent(jButtonIngles, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonEspaniol, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSpanish, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .addComponent(jTextFieldEnglish, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
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
                    .addComponent(jButtonEspaniol)
                    .addComponent(jTextFieldSpanish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonIngles)
                    .addComponent(jTextFieldEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jButtonExitActionPerformed
	
    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
       jTextFieldEnglish.setText("");   
       jTextFieldSpanish.setText("");   
    }//GEN-LAST:event_jButtonCleanActionPerformed

    public JButton getjButtonClean() {
        return jButtonClean;
    }

    public void setjButtonClean(JButton jButtonClean) {
        this.jButtonClean = jButtonClean;
    }

    public JButton getjButtonEspaniol() {
        return jButtonEspaniol;
    }

    public void setjButtonEspaniol(JButton jButtonEspaniol) {
        this.jButtonEspaniol = jButtonEspaniol;
    }

    public JButton getjButtonExit() {
        return jButtonExit;
    }

    public void setjButtonExit(JButton jButtonExit) {
        this.jButtonExit = jButtonExit;
    }

    public JButton getjButtonIngles() {
        return jButtonIngles;
    }

    public void setjButtonIngles(JButton jButtonIngles) {
        this.jButtonIngles = jButtonIngles;
    }

    public JButton getjButtonNow() {
        return jButtonNow;
    }

    public void setjButtonNow(JButton jButtonNow) {
        this.jButtonNow = jButtonNow;
    }

    public JTextField getjTextFieldEnglish() {
        return jTextFieldEnglish;
    }

    public void setjTextFieldEnglish(JTextField jTextFieldEnglish) {
        this.jTextFieldEnglish = jTextFieldEnglish;
    }

    public JTextField getjTextFieldSpanish() {
        return jTextFieldSpanish;
    }

    public void setjTextFieldSpanish(JTextField jTextFieldSpanish) {
        this.jTextFieldSpanish = jTextFieldSpanish;
    }

    public JButton getjButtonStart() {
        return jButtonStart;
    }

    public void setjButtonStart(JButton jButtonStart) {
        this.jButtonStart = jButtonStart;
    }

    public JButton getjButtonStop() {
        return jButtonStop;
    }

    public void setjButtonStop(JButton jButtonStop) {
        this.jButtonStop = jButtonStop;
    }
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonEspaniol;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonIngles;
    private javax.swing.JButton jButtonNow;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldEnglish;
    private javax.swing.JTextField jTextFieldSpanish;
    // End of variables declaration//GEN-END:variables
//    private Timer timer;
//    private boolean isFirst = false;
    private int margen_gui = 35;
}
