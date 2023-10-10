package vn.app.project;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Image;
import javax.swing.ImageIcon;


public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        redesign();
    }
    
    private void redesign() {
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/close.png"));
        Image image = imageIcon.getImage();
        int labelWidth = btnExit.getWidth();
        int labelHeight = btnExit.getHeight();
        Image scaledImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        btnExit.setIcon(scaledIcon);
        
        pnContent.add(new NhanVienPanel(), BorderLayout.CENTER);
        pnContent.repaint();
        pnContent.revalidate();
        
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnSlide = new javax.swing.JPanel();
        btnMnEmployee = new javax.swing.JButton();
        btnMnRecuit = new javax.swing.JButton();
        btnMnSalary = new javax.swing.JButton();
        btnMnReward = new javax.swing.JButton();
        btnSearchEmp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pnTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        pnContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 700));

        pnSlide.setBackground(new java.awt.Color(219, 82, 9));
        pnSlide.setPreferredSize(new java.awt.Dimension(220, 618));

        btnMnEmployee.setBackground(new java.awt.Color(227, 193, 100));
        btnMnEmployee.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnMnEmployee.setForeground(new java.awt.Color(22, 82, 166));
        btnMnEmployee.setText("Quản lý nhân viên");
        btnMnEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMnEmployeeMouseClicked(evt);
            }
        });

        btnMnRecuit.setBackground(new java.awt.Color(227, 193, 100));
        btnMnRecuit.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnMnRecuit.setForeground(new java.awt.Color(22, 82, 166));
        btnMnRecuit.setText("Quản lý phòng ban");
        btnMnRecuit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMnRecuitMouseClicked(evt);
            }
        });

        btnMnSalary.setBackground(new java.awt.Color(227, 193, 100));
        btnMnSalary.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnMnSalary.setForeground(new java.awt.Color(22, 82, 166));
        btnMnSalary.setText("Quản lý lương");
        btnMnSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMnSalaryMouseClicked(evt);
            }
        });

        btnMnReward.setBackground(new java.awt.Color(227, 193, 100));
        btnMnReward.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnMnReward.setForeground(new java.awt.Color(22, 82, 166));
        btnMnReward.setText("Quản lý khen thưởng");
        btnMnReward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMnRewardMouseClicked(evt);
            }
        });

        btnSearchEmp.setBackground(new java.awt.Color(227, 193, 100));
        btnSearchEmp.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnSearchEmp.setForeground(new java.awt.Color(22, 82, 166));
        btnSearchEmp.setText("Tra cứu nhân viên");
        btnSearchEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchEmpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnSlideLayout = new javax.swing.GroupLayout(pnSlide);
        pnSlide.setLayout(pnSlideLayout);
        pnSlideLayout.setHorizontalGroup(
            pnSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMnSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMnReward, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(btnMnRecuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearchEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnSlideLayout.setVerticalGroup(
            pnSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSlideLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnMnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnMnRecuit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnMnSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnMnReward, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnSearchEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        getContentPane().add(pnSlide, java.awt.BorderLayout.LINE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnTop.setBackground(new java.awt.Color(255, 177, 94));
        pnTop.setPreferredSize(new java.awt.Dimension(909, 70));

        jLabel1.setBackground(new java.awt.Color(245, 134, 15));
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(22, 82, 166));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ NHÂN SỰ - CÔNG TY AVAS GROUP");

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(pnTop, java.awt.BorderLayout.NORTH);

        pnContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnContent.setPreferredSize(new java.awt.Dimension(893, 600));
        pnContent.setLayout(new java.awt.BorderLayout());
        jPanel1.add(pnContent, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        // TODO add your handling code here:
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnMnRewardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMnRewardMouseClicked
        // TODO add your handling code here:
        pnContent.removeAll();
        
        pnContent.add(new NhanThuongPanel(), BorderLayout.CENTER);
        pnContent.repaint();
        pnContent.revalidate();
    }//GEN-LAST:event_btnMnRewardMouseClicked

    private void btnMnEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMnEmployeeMouseClicked
        // TODO add your handling code here:
        pnContent.removeAll();
        
        pnContent.add(new NhanVienPanel(), BorderLayout.CENTER);
        pnContent.repaint();
        pnContent.revalidate();
    }//GEN-LAST:event_btnMnEmployeeMouseClicked

    private void btnMnRecuitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMnRecuitMouseClicked
        // TODO add your handling code here:
        pnContent.removeAll();
        
        pnContent.add(new PhongBanPanel(), BorderLayout.CENTER);
        pnContent.repaint();
        pnContent.revalidate();
    }//GEN-LAST:event_btnMnRecuitMouseClicked

    private void btnMnSalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMnSalaryMouseClicked
        // TODO add your handling code here:
        pnContent.removeAll();
        
        pnContent.add(new LuongPanel(), BorderLayout.CENTER);
        pnContent.repaint();
        pnContent.revalidate();
    }//GEN-LAST:event_btnMnSalaryMouseClicked

    private void btnSearchEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchEmpMouseClicked
        // TODO add your handling code here:
        pnContent.removeAll();
        
        pnContent.add(new TimKiemPanel(), BorderLayout.CENTER);
        pnContent.repaint();
        pnContent.revalidate();
    }//GEN-LAST:event_btnSearchEmpMouseClicked
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMnEmployee;
    private javax.swing.JButton btnMnRecuit;
    private javax.swing.JButton btnMnReward;
    private javax.swing.JButton btnMnSalary;
    private javax.swing.JButton btnSearchEmp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnContent;
    private javax.swing.JPanel pnSlide;
    private javax.swing.JPanel pnTop;
    // End of variables declaration//GEN-END:variables

}
