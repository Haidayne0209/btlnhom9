package vn.app.project;

import java.awt.HeadlessException;
import vn.app.project.dao.EmployeeDAO;
import vn.app.project.dto.Employee;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vn.app.project.dao.DepartmentDAO;

public class NhanVienPanel extends javax.swing.JPanel {

    private boolean isAdd = false;

    public NhanVienPanel() {
        initComponents();
        redesign();
//        fillCombobox();
    }

    private void clearTextbox() {
        txtId.setText("");
        txtAddress.setText("");
        txtFullname.setText("");
        txtPhone.setText("");
        txtPosition.setText("");
    }

    private void disableTextbox() {
        txtAddress.setEnabled(false);
        cboDept.setEnabled(false);
        txtFullname.setEnabled(false);
        txtId.setEnabled(false);
        txtPhone.setEnabled(false);
        txtPosition.setEnabled(false);
        cboGender.setEnabled(false);
    }

    private void enableTextbox() {
        txtAddress.setEnabled(true);
        cboDept.setEnabled(true);
        txtFullname.setEnabled(true);
        txtPhone.setEnabled(true);
        txtPosition.setEnabled(true);
        cboGender.setEnabled(true);
    }

    private void redesign() {
        tableModel = (DefaultTableModel) tblData.getModel();
        tableModel.setRowCount(0);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pos = tblData.rowAtPoint(e.getPoint());
                txtId.setText(tblData.getValueAt(pos, 0).toString());
                txtFullname.setText(tblData.getValueAt(pos, 1).toString());
                cboDept.setSelectedItem(tblData.getValueAt(pos, 2).toString());
                txtAddress.setText(tblData.getValueAt(pos, 3).toString());
                txtPhone.setText(tblData.getValueAt(pos, 4).toString());
                cboGender.setSelectedItem(tblData.getValueAt(pos, 5).toString());
                txtPosition.setText(tblData.getValueAt(pos, 6).toString());

                btnDel.setEnabled(true);
                btnEdit.setEnabled(true);
                btnSave.setEnabled(false);
            }
        });
        fillData();
        fillCombobox();
        disableTextbox();
        disableButton();
    }

    private void fillCombobox() {
        cboDeptModel = new DefaultComboBoxModel<>();
        try {
            for (var object : DepartmentDAO.getInstance().getAll()) {
                cboDeptModel.addElement(object.getId() + " - " + object.getDepartmentName());
            }
            cboDept.setModel(cboDeptModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);

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
            for (Employee b : EmployeeDAO.getInstance().getAll()) {
                Object data[] = new Object[10];
                data[0] = b.getId();
                data[1] = b.getFullName();
                data[2] = b.getDepartment().getDepartmentName()== null ? "" : b.getDepartmentId() + " - " + b.getDepartment().getDepartmentName();
                data[3] = b.getAddress();
                data[4] = b.getPhone();
                data[5] = b.getGender();
                data[6] = b.getPosition();
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
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboGender = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        cboDept = new javax.swing.JComboBox<>();
        scrollData = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(893, 600));
        setMinimumSize(new java.awt.Dimension(893, 600));
        setPreferredSize(new java.awt.Dimension(893, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(129, 214, 247));
        jPanel1.setMaximumSize(new java.awt.Dimension(893, 250));
        jPanel1.setMinimumSize(new java.awt.Dimension(893, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(893, 200));
        jPanel1.setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã nhân viên:");

        txtId.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên nhân viên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Phòng ban:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Địa chỉ:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Giới tính:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Vị trí công việc:");

        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        btnDel.setText("Xóa");
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });

        btnSave.setText("Lưu");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnReload.setText("Làm mới");
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboDept, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPhone)
                            .addComponent(txtPosition)
                            .addComponent(cboGender, 0, 287, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(79, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFullname)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
                            .addComponent(txtPosition)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboDept, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Phòng ban", "Địa chỉ", "Số điện thoại", "Giới tính", "Vị trí công việc"
            }
        ));
        scrollData.setViewportView(tblData);
        if (tblData.getColumnModel().getColumnCount() > 0) {
            tblData.getColumnModel().getColumn(0).setResizable(false);
            tblData.getColumnModel().getColumn(1).setResizable(false);
            tblData.getColumnModel().getColumn(2).setResizable(false);
            tblData.getColumnModel().getColumn(3).setResizable(false);
            tblData.getColumnModel().getColumn(4).setResizable(false);
            tblData.getColumnModel().getColumn(5).setResizable(false);
            tblData.getColumnModel().getColumn(6).setResizable(false);
        }

        add(scrollData, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        isAdd = true;
        enableTextbox();
        clearTextbox();
        enableButton();
        txtFullname.requestFocus();

    }//GEN-LAST:event_btnAddMouseClicked
    private Integer getDeptId() {
        var text = cboDept.getSelectedItem();
        if (text == null) {
            return null;
        }
        var rs = text.toString().split("-");
        return Integer.valueOf(rs[0].trim());
    }

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        try {
            var emp = new Employee();
            emp.setAddress(txtAddress.getText());
            emp.setDepartmentId(getDeptId());
            emp.setFullName(txtFullname.getText());
            emp.setGender(cboGender.getSelectedItem().toString());
            emp.setId(txtId.getText().isEmpty() ? 0 : Integer.valueOf(txtId.getText()));
            emp.setPhone(txtPhone.getText());
            emp.setPosition(txtPosition.getText());
            if (isAdd) {
                var isSuccess = EmployeeDAO.getInstance().add(emp);
                if (isSuccess) {
                    JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                if (EmployeeDAO.getInstance().update(emp)) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            reload();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveMouseClicked
    private void reload() {
        fillData();
        clearTextbox();
        disableButton();
        disableTextbox();
    }
    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        isAdd = false;
        enableButton();
        enableTextbox();
        txtFullname.requestFocus();
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelMouseClicked
        if (!txtId.getText().isEmpty()) {
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                EmployeeDAO.getInstance().delete(Integer.parseInt(txtId.getText()));
                reload();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên muốn xóa", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDelMouseClicked

    private void btnReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReloadMouseClicked
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_btnReloadMouseClicked
    private javax.swing.DefaultComboBoxModel<String> cboDeptModel;
    private javax.swing.table.DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboDept;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollData;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPosition;
    // End of variables declaration//GEN-END:variables
}
