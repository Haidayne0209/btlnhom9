package vn.app.project;

import vn.app.project.dao.DepartmentDAO;
import vn.app.project.dao.EmployeeDAO;
import vn.app.project.dao.SalaryDAO;
import vn.app.project.dto.Employee;
import vn.app.project.dto.Salary;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LuongPanel extends javax.swing.JPanel {

    boolean isAdd = false;
    Locale vnLocale = new Locale("vi", "VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(vnLocale);

    public LuongPanel() {
        initComponents();
        redesign();
    }

    private void clearTextbox() {
        txtId.setText("");
        txtAmount.setText("");
        txtDes.setText("");
        txtDate.setText("");
    }

    private void disableTextbox() {
        txtId.setEnabled(false);
        txtAmount.setEditable(false);
        txtDate.setEditable(false);
        txtDes.setEditable(false);
        cboEmp.setEnabled(false);
    }

    private void enableTextbox() {
        txtId.setEnabled(true);
        txtAmount.setEditable(true);
        txtDate.setEditable(true);
        txtDes.setEditable(true);
        cboEmp.setEnabled(true);
    }

    private void redesign() {
        tableModel = (DefaultTableModel) tblData.getModel();
        tableModel.setRowCount(0);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pos = tblData.rowAtPoint(e.getPoint());
                txtId.setText(tblData.getValueAt(pos, 0).toString());
                cboEmp.setSelectedItem(tblData.getValueAt(pos, 1).toString());
                txtAmount.setText(tblData.getValueAt(pos, 2).toString());
                txtDate.setText(tblData.getValueAt(pos, 3).toString());
                txtDes.setText(tblData.getValueAt(pos, 4).toString());

                btnDel.setEnabled(true);
                btnEdit.setEnabled(true);
                btnSave.setEnabled(false);
            }
        });
        loadCombobox();
        fillData();
        disableTextbox();
        disableButton();
    }

    private void loadCombobox() {
        try {
            cboEmpModel = new DefaultComboBoxModel<>();
            var allEmpl = EmployeeDAO.getInstance().getAll();
            for (Employee employee : allEmpl) {
                cboEmpModel.addElement(employee.getId() + " - " + employee.getFullName() + " - " + employee.getPosition());
            }
            cboEmp.setModel(cboEmpModel);
        } catch (Exception ex) {
            Logger.getLogger(NhanThuongPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            for (var b : SalaryDAO.getInstance().getAll()) {
                Object data[] = new Object[10];
                data[0] = b.getId();
                data[1] = String.format("%s - %s - %s",
                        b.getEmployee().getId(),
                        b.getEmployee().getFullName(),
                        b.getEmployee().getPosition());
                data[2] = nf.format(b.getSalaryAmount());
                data[3] = b.getSalaryDate();
                data[4] = b.getDetail();
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
        jLabel3 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        cboEmp = new javax.swing.JComboBox<>();
        btnReload = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(893, 600));
        setMinimumSize(new java.awt.Dimension(893, 600));
        setPreferredSize(new java.awt.Dimension(893, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(221, 237, 128));
        jPanel1.setPreferredSize(new java.awt.Dimension(893, 210));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Chi tiết");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 110, 30));

        txtId.setEditable(false);
        txtId.setEnabled(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 320, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nhân viên:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Số tiền:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, 30));
        jPanel1.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 320, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày nhận:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 110, 30));
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 320, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mã nhận lương:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        txtDes.setColumns(20);
        txtDes.setRows(5);
        jScrollPane1.setViewportView(txtDes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 400, -1));

        jPanel1.add(cboEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 320, 40));

        btnReload.setText("Làm mới");
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });
        jPanel1.add(btnReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 90, 30));

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 70, 30));

        btnEdit.setText("Sửa");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 60, 30));

        btnDel.setText("Xóa");
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });
        jPanel1.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 60, 30));

        btnSave.setText("Lưu");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 60, 30));

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhận lương", "Nhân viên", "Số tiền", "Ngày nhận", "Mô tả"
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
        txtAmount.requestFocus();
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        isAdd = false;
        enableButton();
        enableTextbox();
        txtAmount.requestFocus();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelMouseClicked
        // TODO add your handling code here:
        if (!txtId.getText().isEmpty()) {
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                SalaryDAO.getInstance().delete(Integer.parseInt(txtId.getText()));
                reload();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bản lương muốn xóa", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelMouseClicked

    private void btnReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReloadMouseClicked
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_btnReloadMouseClicked
    private int getEmpId() {
        String text = cboEmp.getSelectedItem().toString();
        var rs = text.split("-");
        return Integer.parseInt(rs[0].trim());
    }
    
    private Double getPrice() {
        try {
            String priceText = txtAmount.getText();
            return nf.parse(priceText).doubleValue();
        } catch (ParseException e) {
        }
        try {
            return Double.valueOf(txtAmount.getText());
        } catch (NumberFormatException e) {
        }
        return Double.valueOf(0);
    }
    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        try {
            var item = new Salary();
            item.setId(txtId.getText().isEmpty() ? 0 : Integer.valueOf(txtId.getText()));
            item.setEmployeeId(getEmpId());
            item.setSalaryAmount(getPrice());
            item.setDetail(txtDes.getText());
            item.setSalaryDate(txtDate.getText());

            if (isAdd) {
                SalaryDAO.getInstance().add(item);
                JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                SalaryDAO.getInstance().update(item);
                JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
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
    private javax.swing.JComboBox<String> cboEmp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

}
