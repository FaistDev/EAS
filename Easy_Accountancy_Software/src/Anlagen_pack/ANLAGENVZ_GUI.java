package Anlagen_pack;

import Anlagen_pack.ANLAGENVZ_Renderer;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthias
 */
public class ANLAGENVZ_GUI extends javax.swing.JFrame {

    private ANLAGENVZ_BL model = new ANLAGENVZ_BL();
    private ANLAGENVZ_Renderer renderer = new ANLAGENVZ_Renderer();
    private static int year;
    /**
     * Creates new form GUI
     */
    public ANLAGENVZ_GUI() {
        initComponents();
        this.jtTable.setModel(model);
        this.jtTable.setDefaultRenderer(Object.class, renderer);
        int year= 2019;
        for(int i = 120; i>0 ;i--)
        {
            
            this.cbBox.addItem(year);
            year-=1;
        }
        year = (int) this.cbBox.getSelectedItem();
    }
    
    
    public static int getYear()
    {
        return year;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbYear = new javax.swing.JLabel();
        cbBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTable = new javax.swing.JTable();
        btAdd = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btLoad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Anlagenverzeichnis");

        lbYear.setText("Jahr:");

        cbBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAction(evt);
            }
        });

        jtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtTable);

        btAdd.setText("Hinzufügen");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btDelete.setText("Löschen");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btSave.setText("Speichern");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btLoad.setText("Laden");
        btLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(btAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btLoad)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSave)
                    .addComponent(btLoad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onAction(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onAction
    {//GEN-HEADEREND:event_onAction
        year = (int) this.cbBox.getSelectedItem();
        model.update();
    }//GEN-LAST:event_onAction

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        ANLAGENVZ_AddDlg dlg = new ANLAGENVZ_AddDlg(this, true);
        dlg.setVisible(true);
        if(dlg.isOk()){
            ANLAGENVZ_Anlage a = dlg.getAnlage();
            model.add(a);
        }
    }//GEN-LAST:event_btAddActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int[] idx = jtTable.getSelectedRows();
        model.delete(idx);
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
            // TODO add your handling code here:
            model.save(new File("anlagen.bin"));
        } catch (Exception ex) {
            Logger.getLogger(ANLAGENVZ_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoadActionPerformed
        try {
            // TODO add your handling code here:
            model.load(new File("anlagen.bin"));
        } catch (Exception ex) {
            Logger.getLogger(ANLAGENVZ_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.update();
    }//GEN-LAST:event_btLoadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ANLAGENVZ_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ANLAGENVZ_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ANLAGENVZ_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ANLAGENVZ_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ANLAGENVZ_GUI().setVisible(true);
            }
        });
        
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btLoad;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox<Integer> cbBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtTable;
    private javax.swing.JLabel lbYear;
    // End of variables declaration//GEN-END:variables
}
