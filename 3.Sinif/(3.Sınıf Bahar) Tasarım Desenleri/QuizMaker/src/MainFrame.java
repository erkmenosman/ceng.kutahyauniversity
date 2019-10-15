import java.sql.*;
import SinavOlustur.SinavOlusturView;
import SoruBankasi.SoruBankasiYonetimView;
import DersIslemleri.DersIslemleriView;

public class MainFrame extends javax.swing.JFrame {

 
    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        DosyaMenu = new javax.swing.JMenu();
        SoruBankasiOlusturmaMenu = new javax.swing.JMenuItem();
        SinavOlusturmaMenu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        Cikis = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1086, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 732, Short.MAX_VALUE)
        );

        DosyaMenu.setText("Quiz Maker");
        DosyaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DosyaMenuActionPerformed(evt);
            }
        });

        SoruBankasiOlusturmaMenu.setText("Soru Bankası Oluşturma");
        SoruBankasiOlusturmaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoruBankasiOlusturmaMenuActionPerformed(evt);
            }
        });
        DosyaMenu.add(SoruBankasiOlusturmaMenu);

        SinavOlusturmaMenu.setText("Sınav Oluşturma");
        SinavOlusturmaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SinavOlusturmaMenuActionPerformed(evt);
            }
        });
        DosyaMenu.add(SinavOlusturmaMenu);

        jMenuItem1.setText("Ders İşlemleri");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        DosyaMenu.add(jMenuItem1);

        Cikis.setText("Çıkış");
        Cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CikisActionPerformed(evt);
            }
        });
        DosyaMenu.add(Cikis);

        jMenuBar1.add(DosyaMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CikisActionPerformed
    System.exit(0);
    }//GEN-LAST:event_CikisActionPerformed

    private void DosyaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DosyaMenuActionPerformed

    }//GEN-LAST:event_DosyaMenuActionPerformed

    private void SinavOlusturmaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SinavOlusturmaMenuActionPerformed
        jDesktopPane1.add(SinavOlusturView.getObj());
        SinavOlusturView.getObj().setVisible(true);
    }//GEN-LAST:event_SinavOlusturmaMenuActionPerformed

    private void SoruBankasiOlusturmaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoruBankasiOlusturmaMenuActionPerformed

        jDesktopPane1.add(SoruBankasiYonetimView.getObj());
        SoruBankasiYonetimView.getObj().setVisible(true);

    }//GEN-LAST:event_SoruBankasiOlusturmaMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jDesktopPane1.add(DersIslemleriView.getObj());
        DersIslemleriView.getObj().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Cikis;
    private javax.swing.JMenu DosyaMenu;
    private javax.swing.JMenuItem SinavOlusturmaMenu;
    private javax.swing.JMenuItem SoruBankasiOlusturmaMenu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
