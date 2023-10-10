package vn.app.project;

import vn.app.project.dao.EmployeeDAO;
import vn.app.project.dto.Employee;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TimKiemPanel extends javax.swing.JPanel {

    /**
     * Creates new form SearchEmp
     */
    public TimKiemPanel() {
        initComponents();
        redesign();
    }

    private void redesign() {
        tableModel = (DefaultTableModel) tblData.getModel();
        tableModel.setRowCount(0);
        
        fillData();
    }

    private void fillData() {
        // TODO Auto-generated method stub
        tableModel.setRowCount(0);
        try {
            for (Employee b : EmployeeDAO.getInstance().getAll(txtSearch.getText())) {
                Object data[] = new Object[10];
                data[0] = b.getId();
                data[1] = b.getFullName();
                data[2] = b.getAddress();
                data[3] = b.getPhone();
                data[4] = b.getGender();
                data[5] = b.getPosition();
                data[6] = b.getDepartment().getDepartmentName();
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
        // TODO Auto-generated catch block
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(893, 600));
        setMinimumSize(new java.awt.Dimension(893, 600));
        setPreferredSize(new java.awt.Dimension(893, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(131, 210, 222));
        jPanel1.setPreferredSize(new java.awt.Dimension(893, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tìm kiếm:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 520, 40));

        btnSearch.setText("Tìm kiếm");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 110, 40));

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Địa chỉ", "Số điện thoại", "Giới tính", "Vị trị công việc", "Phòng ban"
            }
        ));
        jScrollPane1.setViewportView(tblData);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
        fillData();
    }//GEN-LAST:event_btnSearchMouseClicked

    private javax.swing.table.DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
