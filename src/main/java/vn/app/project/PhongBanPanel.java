package vn.app.project;

import vn.app.project.dao.RewardDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vn.app.project.dao.DepartmentDAO;
import vn.app.project.dao.EmployeeDAO;
import vn.app.project.dto.Department;
import vn.app.project.dto.Employee;

public class PhongBanPanel extends javax.swing.JPanel {

    boolean isAdd = false;

    public PhongBanPanel() {
        initComponents();
        redesign();
        loadCombobox();
    }

    private void loadCombobox() {
        try {
            cboEmpModel = new DefaultComboBoxModel<>();
            var allEmpl = EmployeeDAO.getInstance().getAllEmployeeNotManager();
            for (Employee employee : allEmpl) {
                cboEmpModel.addElement(employee.getId() + " - " + employee.getFullName() + " - " + employee.getPosition());
            }
            cboMana.setModel(cboEmpModel);
        } catch (Exception ex) {
            Logger.getLogger(PhongBanPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearTextbox() {
        txtId.setText("");
        txtDes.setText("");
        txtName.setText("");
    }

    private void disableTextbox() {
        txtId.setEnabled(false);
        cboMana.setEnabled(false);
        txtDes.setEnabled(false);
        txtName.setEnabled(false);
    }

    private void enableTextbox() {
        cboMana.setEnabled(true);
        txtDes.setEnabled(true);
        txtName.setEnabled(true);
    }

    private void redesign() {
        tableModel = (DefaultTableModel) tblData.getModel();
        tableModel.setRowCount(0);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pos = tblData.rowAtPoint(e.getPoint());
                txtId.setText(tblData.getValueAt(pos, 0).toString());
                txtName.setText(tblData.getValueAt(pos, 1).toString());
                cboMana.setSelectedItem(tblData.getValueAt(pos, 2).toString());
                txtDes.setText(tblData.getValueAt(pos, 3).toString());

                btnDel.setEnabled(true);
                btnEdit.setEnabled(true);
                btnSave.setEnabled(false);
            }
        });
        fillData();
        disableTextbox();
        disableButton();
    }

    private void disableButton() {
        btnAdd.setEnabled(true);

        btnEdit.setEnabled(false);
        btnDel.setEnabled(false);
        btnSave.setEnabled(false);
    }

    private void enableButton() {
        btnAdd.setEnabled(false);

        btnEdit.setEnabled(false);
        btnDel.setEnabled(false);
        btnSave.setEnabled(true);
    }

    private void fillData() {
        // TODO Auto-generated method stub
        tableModel.setRowCount(0);
        try {
            for (var b : DepartmentDAO.getInstance().getAll()) {
                Object data[] = new Object[10];
                data[0] = b.getId();
                data[1] = b.getDepartmentName();
                data[3] = b.getDescription();
                data[2] = b.getEmployee().getId() + " - " + b.getEmployee().getFullName() + " - " + b.getEmployee().getPosition();
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
        // TODO Auto-generated catch block
    }

    private void reload() {
        fillData();
        disableButton();
        disableTextbox();
        clearTextbox();
        loadCombobox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        btnReload = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        cboMana = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(893, 600));
        setMinimumSize(new java.awt.Dimension(893, 600));
        setPreferredSize(new java.awt.Dimension(893, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(142, 250, 229));
        jPanel1.setPreferredSize(new java.awt.Dimension(893, 210));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mô tả:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 130, 30));

        txtId.setEnabled(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 310, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên phòng ban:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 130, 30));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 310, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Quản lý:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 130, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mã phòng ban:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 130, 30));

        txtDes.setColumns(20);
        txtDes.setRows(5);
        jScrollPane1.setViewportView(txtDes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 410, 100));

        btnReload.setText("Làm mới");
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });
        jPanel1.add(btnReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, -1, -1));

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        btnDel.setText("Xóa");
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });
        jPanel1.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, -1));

        btnEdit.setText("Sửa");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, -1, -1));

        btnSave.setText("Lưu");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, -1, -1));

        jPanel1.add(cboMana, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 310, 40));

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã phòng ban", "Tên phòng ban", "Quản lý", "Mô tả"
            }
        ));
        jScrollPane2.setViewportView(tblData);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        isAdd = true;
        clearTextbox();
        enableButton();
        enableTextbox();
        txtName.requestFocus();
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReloadMouseClicked
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_btnReloadMouseClicked

    private void btnDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelMouseClicked
        // TODO add your handling code here:
        if (!txtId.getText().isEmpty()) {
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                DepartmentDAO.getInstance().delete(Integer.parseInt(txtId.getText()));
                reload();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng ban muốn xóa", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        isAdd = false;
        enableButton();
        enableTextbox();
        txtName.requestFocus();
    }//GEN-LAST:event_btnEditMouseClicked
    private int getManagerId() {
        var text = cboMana.getSelectedItem().toString();
        var rs = text.split(" - ");
        return Integer.parseInt(rs[0].trim());
    }
    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        try {
            var item = new Department();
            item.setId(txtId.getText().isEmpty() ? 0 : Integer.valueOf(txtId.getText()));
            item.setDepartmentName(txtName.getText());
            item.setDescription(txtDes.getText());
            item.setManagerId(getManagerId());
            if (isAdd) {
                DepartmentDAO.getInstance().add(item);
                JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                DepartmentDAO.getInstance().update(item);
                JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            reload();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getCause(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveMouseClicked
    private javax.swing.DefaultComboBoxModel<String> cboEmpModel;
    private javax.swing.table.DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboMana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblData;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

}
