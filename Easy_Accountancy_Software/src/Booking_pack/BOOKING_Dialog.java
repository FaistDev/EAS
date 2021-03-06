/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking_pack;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Ben
 */
public class BOOKING_Dialog extends javax.swing.JDialog {

    private BOOKING_BS object = null;
    private boolean finished = false;

    public BOOKING_BS getObject() {
        return object;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setValues(BOOKING_BS bs) {
        etDate.setText(bs.getDate().format(DateTimeFormatter.ofPattern("DD.MM.yyyy")));
        etText.setText(bs.getText());
        etAccountShould.setText(bs.getAccountShould());
        etAccountHave.setText(bs.getAccountHave());
        etAmountShould.setText(String.format("%.2f", bs.getAmountShould()));
        etAmountHave.setText(String.format("%.2f", bs.getAmountHave()));
    }

    /**
     * Creates new form BOOKING_Dialog
     */
    public BOOKING_Dialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        etDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        etText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        etAccountShould = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        etAccountHave = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        etAmountShould = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        etAmountHave = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(7, 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Datum:");
        getContentPane().add(jLabel1);
        getContentPane().add(etDate);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Anmerkung:");
        getContentPane().add(jLabel2);
        getContentPane().add(etText);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Konto Soll:");
        getContentPane().add(jLabel3);
        getContentPane().add(etAccountShould);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Konto Haben:");
        getContentPane().add(jLabel4);
        getContentPane().add(etAccountHave);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Betrag Soll:");
        getContentPane().add(jLabel5);
        getContentPane().add(etAmountShould);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Betrag Haben:");
        getContentPane().add(jLabel6);
        getContentPane().add(etAmountHave);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Speichern");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Abbrechen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LocalDate date = null;
        try {
            date = LocalDate.parse(etDate.getText(), DateTimeFormatter.ofPattern("DD.MM.yyyy"));
            try {
                object = new BOOKING_BS(date, etText.getText(), etAccountShould.getText(), etAccountHave.getText(), Double.parseDouble(etAmountShould.getText()), Double.parseDouble(etAmountHave.getText()));
                finished = true;
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Falsche Geldformatierung");
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Falsche Datumsformatierung");
            System.out.println(e.getMessage());
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        finished = false;
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(BOOKING_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BOOKING_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BOOKING_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BOOKING_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BOOKING_Dialog dialog = new BOOKING_Dialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField etAccountHave;
    private javax.swing.JTextField etAccountShould;
    private javax.swing.JTextField etAmountHave;
    private javax.swing.JTextField etAmountShould;
    private javax.swing.JTextField etDate;
    private javax.swing.JTextField etText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
