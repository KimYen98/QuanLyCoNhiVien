/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author STIREN
 */
public class fManagement extends javax.swing.JFrame {

    /**
     * Creates new form fManagement
     */
    Toolkit tk =Toolkit.getDefaultToolkit();
    public int getSizeX()
    {
        return (int)jDesktopPane1.getSize().getWidth();
    }
    public int getSizeY()
    {
        return (int)jDesktopPane1.getSize().getHeight();
    }
    public fManagement() {
        initComponents();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        int x=(int) tk.getScreenSize().getWidth();
        int y=(int)tk.getScreenSize().getHeight();  
        setSize(x, y);
        jDesktopPane1.setSize(x, y);
        jLabel1.setSize(x,y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemChild = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemStaffCategogy = new javax.swing.JMenuItem();
        jMenuItemStaff = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemSponsor = new javax.swing.JMenuItem();
        jMenuItemSponsorship = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemExpense = new javax.swing.JMenuItem();
        jMenuItemExpenseInfo = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemAdoptiveParent = new javax.swing.JMenuItem();
        jMenuItemAdoptInfo = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItemReportNumOfChild = new javax.swing.JMenuItem();
        jMenuItemReportFinance = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItemAccount = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PHẦN MỀM QUẢN LÝ CÔ NHI VIỆN");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anhbia.jpg"))); // NOI18N
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(0, 0, 880, 470);

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        jMenu1.setForeground(new java.awt.Color(0, 0, 204));
        jMenu1.setText("Trẻ");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItemChild.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemChild.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemChild.setText("Trẻ");
        jMenuItemChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemChildActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemChild);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 0, 204));
        jMenu2.setText("Nhân viên");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItemStaffCategogy.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemStaffCategogy.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemStaffCategogy.setText("Loại nhân viên");
        jMenuItemStaffCategogy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStaffCategogyActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemStaffCategogy);

        jMenuItemStaff.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemStaff.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemStaff.setText("Nhân viên");
        jMenuItemStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStaffActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemStaff);

        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(0, 0, 204));
        jMenu3.setText("Tài trợ");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItemSponsor.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemSponsor.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemSponsor.setText("Nhà tài trợ");
        jMenuItemSponsor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSponsorActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemSponsor);

        jMenuItemSponsorship.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemSponsorship.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemSponsorship.setText("Chương trình tài trợ");
        jMenuItemSponsorship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSponsorshipActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemSponsorship);

        jMenuBar1.add(jMenu3);

        jMenu4.setForeground(new java.awt.Color(0, 0, 204));
        jMenu4.setText("Chi tiêu");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItemExpense.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemExpense.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemExpense.setText("Chi tiêu");
        jMenuItemExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExpenseActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemExpense);

        jMenuItemExpenseInfo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemExpenseInfo.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemExpenseInfo.setText("Chi tiết chi tiêu");
        jMenuItemExpenseInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExpenseInfoActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemExpenseInfo);

        jMenuBar1.add(jMenu4);

        jMenu5.setForeground(new java.awt.Color(0, 0, 204));
        jMenu5.setText("Nhận trẻ");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItemAdoptiveParent.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemAdoptiveParent.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemAdoptiveParent.setText("Người nhận trẻ");
        jMenuItemAdoptiveParent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdoptiveParentActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemAdoptiveParent);

        jMenuItemAdoptInfo.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemAdoptInfo.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemAdoptInfo.setText("Chi tiết việc nhận trẻ");
        jMenuItemAdoptInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdoptInfoActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemAdoptInfo);

        jMenuBar1.add(jMenu5);

        jMenu7.setForeground(new java.awt.Color(0, 0, 204));
        jMenu7.setText("Báo cáo");
        jMenu7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItemReportNumOfChild.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemReportNumOfChild.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemReportNumOfChild.setText("Báo cáo sỉ số trẻ");
        jMenuItemReportNumOfChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReportNumOfChildActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemReportNumOfChild);

        jMenuItemReportFinance.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemReportFinance.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemReportFinance.setText("Báo cáo tài chính");
        jMenuItemReportFinance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReportFinanceActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemReportFinance);

        jMenuBar1.add(jMenu7);

        jMenu6.setForeground(new java.awt.Color(0, 0, 204));
        jMenu6.setText("Tài khoản");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItemAccount.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jMenuItemAccount.setForeground(new java.awt.Color(0, 0, 204));
        jMenuItemAccount.setText("Tài khoản");
        jMenuItemAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAccountActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemAccount);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemChildActionPerformed
        // TODO add your handling code here:
        fChild f = new fChild();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemChildActionPerformed

    private void jMenuItemStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStaffActionPerformed
        // TODO add your handling code here:
        fStaff f = new fStaff();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemStaffActionPerformed

    private void jMenuItemStaffCategogyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStaffCategogyActionPerformed
        // TODO add your handling code here:
        fStaffCategogy f = new fStaffCategogy();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemStaffCategogyActionPerformed

    private void jMenuItemSponsorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSponsorActionPerformed
        // TODO add your handling code here:
        fSponsor f = new fSponsor();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemSponsorActionPerformed

    private void jMenuItemSponsorshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSponsorshipActionPerformed
        // TODO add your handling code here:
        fSponsorship f = new fSponsorship();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemSponsorshipActionPerformed

    private void jMenuItemExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExpenseActionPerformed
        // TODO add your handling code here:
        fExpense f = new fExpense();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemExpenseActionPerformed

    private void jMenuItemExpenseInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExpenseInfoActionPerformed
        // TODO add your handling code here:
        fExpenseInfo f = new fExpenseInfo();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemExpenseInfoActionPerformed

    private void jMenuItemAdoptiveParentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdoptiveParentActionPerformed
        // TODO add your handling code here:
        fAdoptiveParent f = new fAdoptiveParent();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemAdoptiveParentActionPerformed

    private void jMenuItemAdoptInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdoptInfoActionPerformed
        // TODO add your handling code here:
        fAdoptInfo f = new fAdoptInfo();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemAdoptInfoActionPerformed

    private void jMenuItemReportNumOfChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReportNumOfChildActionPerformed
        // TODO add your handling code here:
        fReportNumOfChild f = new fReportNumOfChild();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemReportNumOfChildActionPerformed

    private void jMenuItemReportFinanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReportFinanceActionPerformed
        // TODO add your handling code here:
        fReportFinance f = new fReportFinance();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemReportFinanceActionPerformed

    private void jMenuItemAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAccountActionPerformed
        // TODO add your handling code here:
        fAccount f = new fAccount();
         f.setSize(this.getSizeX(), this.getSizeY());
        this.jDesktopPane1.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItemAccountActionPerformed

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
            java.util.logging.Logger.getLogger(fManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAccount;
    private javax.swing.JMenuItem jMenuItemAdoptInfo;
    private javax.swing.JMenuItem jMenuItemAdoptiveParent;
    private javax.swing.JMenuItem jMenuItemChild;
    private javax.swing.JMenuItem jMenuItemExpense;
    private javax.swing.JMenuItem jMenuItemExpenseInfo;
    private javax.swing.JMenuItem jMenuItemReportFinance;
    private javax.swing.JMenuItem jMenuItemReportNumOfChild;
    private javax.swing.JMenuItem jMenuItemSponsor;
    private javax.swing.JMenuItem jMenuItemSponsorship;
    private javax.swing.JMenuItem jMenuItemStaff;
    private javax.swing.JMenuItem jMenuItemStaffCategogy;
    // End of variables declaration//GEN-END:variables
}
