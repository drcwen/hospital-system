/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalsystem;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class EmployeeManage extends javax.swing.JFrame {
    
    private DoctorDashboard doctorDashboard;
    private AdminDashboard adminDashboard;
    
    
    public EmployeeManage(DoctorDashboard doctorDashboard) {
        this.doctorDashboard = doctorDashboard;
        initComponents();
        PopulateComboBox();
    }

   
    public EmployeeManage(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
        initComponents();
        PopulateComboBox();
    }

    public EmployeeManage() {
        initComponents();
        PopulateComboBox();
    }

    public void UpdateDataArchive() {
        String SUrl, SUser, SPass;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(formatter);
        
        String sql = "INSERT INTO employeearchive (emp_id, emp_firstName, emp_lastName, " +
                "department, username, password, action, date_of_action) " + 
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
            SUser = "root";
            SPass = "";

            java.sql.Connection con = DriverManager.getConnection(SUrl, SUser, SPass);

            PreparedStatement pstmt = con.prepareStatement(sql);
            
            String id = empID_combo.getSelectedItem().toString();
            String firstname = emp_firstname.getText();
            String lastname = emp_lastname.getText();
            String department = emp_department.getText();
            String email = emp_email.getText();
            String password = emp_password.getText();
            String action = "Update";
            
            pstmt.setString(1, id);
            pstmt.setString(2, firstname);
            pstmt.setString(3, lastname);
            pstmt.setString(4, department);
            pstmt.setString(5, email);
            pstmt.setString(6, password);
            pstmt.setString(7, action);
            pstmt.setString(8, formattedDate);
            
            pstmt.executeUpdate();
            pstmt.close();
            
        } catch (Exception e) {
          e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void DeleteDataArchive() {
        String SUrl, SUser, SPass;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(formatter);
        
        String sql = "INSERT INTO employeearchive (emp_id, emp_firstName, emp_lastName, " +
                "department, username, password, action, date_of_action) " + 
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
            SUser = "root";
            SPass = "";

            java.sql.Connection con = DriverManager.getConnection(SUrl, SUser, SPass);

            PreparedStatement pstmt = con.prepareStatement(sql);
            
            String id = empID_combo.getSelectedItem().toString();
            String firstname = emp_firstname.getText();
            String lastname = emp_lastname.getText();
            String department = emp_department.getText();
            String email = emp_email.getText();
            String password = emp_password.getText();
            String action = "Delete";
            
            pstmt.setString(1, id);
            pstmt.setString(2, firstname);
            pstmt.setString(3, lastname);
            pstmt.setString(4, department);
            pstmt.setString(5, email);
            pstmt.setString(6, password);
            pstmt.setString(7, action);
            pstmt.setString(8, formattedDate);
            
            pstmt.executeUpdate();
            pstmt.close();
            
        } catch (Exception e) {
          e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void PopulateComboBox() {

        try {
            String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/hospitalsystem";
            String user = "root";
            String pass = "";

            String sql = "SELECT emp_id FROM employeeaccounts";

            Class.forName(JDBC_DRIVER);

            java.sql.Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement prep = connection.prepareStatement(sql);

            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {
                String employeeIDs = resultSet.getString("emp_id");
                
                empID_combo.addItem(employeeIDs);
            }


            resultSet.close();
            prep.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        empID_combo = new javax.swing.JComboBox<>();
        search_patientID = new javax.swing.JButton();
        update_patient = new javax.swing.JButton();
        delete_patient = new javax.swing.JButton();
        back_patientreg4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        emp_firstname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        emp_lastname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        emp_ID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        emp_email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        emp_password = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        emp_department = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(780, 696));
        setMinimumSize(new java.awt.Dimension(780, 696));
        setPreferredSize(new java.awt.Dimension(780, 696));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(24, 87, 115));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 600));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 87, 115));
        jLabel4.setText("Manage Employees");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 490, -1));

        empID_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        empID_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empID_comboActionPerformed(evt);
            }
        });
        getContentPane().add(empID_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 130, 30));

        search_patientID.setBackground(new java.awt.Color(24, 87, 115));
        search_patientID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        search_patientID.setForeground(new java.awt.Color(255, 255, 255));
        search_patientID.setText("Search");
        search_patientID.setBorder(null);
        search_patientID.setPreferredSize(new java.awt.Dimension(43, 16));
        search_patientID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_patientIDActionPerformed(evt);
            }
        });
        getContentPane().add(search_patientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 70, 30));

        update_patient.setBackground(new java.awt.Color(24, 87, 115));
        update_patient.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        update_patient.setForeground(new java.awt.Color(255, 255, 255));
        update_patient.setText("Update");
        update_patient.setBorder(null);
        update_patient.setPreferredSize(new java.awt.Dimension(43, 16));
        update_patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_patientActionPerformed(evt);
            }
        });
        getContentPane().add(update_patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 80, 30));

        delete_patient.setBackground(new java.awt.Color(24, 87, 115));
        delete_patient.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        delete_patient.setForeground(new java.awt.Color(255, 255, 255));
        delete_patient.setText("Delete");
        delete_patient.setBorder(null);
        delete_patient.setPreferredSize(new java.awt.Dimension(43, 16));
        delete_patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_patientActionPerformed(evt);
            }
        });
        getContentPane().add(delete_patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 80, 30));

        back_patientreg4.setBackground(new java.awt.Color(204, 204, 204));
        back_patientreg4.setText("Back");
        back_patientreg4.setBorder(null);
        back_patientreg4.setPreferredSize(new java.awt.Dimension(43, 16));
        back_patientreg4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_patientreg4ActionPerformed(evt);
            }
        });
        getContentPane().add(back_patientreg4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 70, 30));

        jLabel12.setForeground(new java.awt.Color(24, 87, 115));
        jLabel12.setText("First Name");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 100, -1));

        emp_firstname.setBackground(new java.awt.Color(191, 229, 246));
        emp_firstname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emp_firstname.setForeground(new java.awt.Color(24, 87, 115));
        emp_firstname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emp_firstname.setBorder(null);
        emp_firstname.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        emp_firstname.setMargin(new java.awt.Insets(4, 6, 4, 6));
        emp_firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_firstnameActionPerformed(evt);
            }
        });
        getContentPane().add(emp_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 130, 30));

        jLabel9.setForeground(new java.awt.Color(24, 87, 115));
        jLabel9.setText("Last Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 60, -1));

        emp_lastname.setBackground(new java.awt.Color(191, 229, 246));
        emp_lastname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emp_lastname.setForeground(new java.awt.Color(24, 87, 115));
        emp_lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emp_lastname.setToolTipText("");
        emp_lastname.setBorder(null);
        emp_lastname.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        emp_lastname.setMargin(new java.awt.Insets(4, 6, 4, 6));
        emp_lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_lastnameActionPerformed(evt);
            }
        });
        getContentPane().add(emp_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 130, 30));

        jLabel13.setForeground(new java.awt.Color(24, 87, 115));
        jLabel13.setText("Patient ID");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 100, -1));

        emp_ID.setBackground(new java.awt.Color(191, 229, 246));
        emp_ID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emp_ID.setForeground(new java.awt.Color(24, 87, 115));
        emp_ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emp_ID.setBorder(null);
        emp_ID.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        emp_ID.setMargin(new java.awt.Insets(4, 6, 4, 6));
        emp_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_IDActionPerformed(evt);
            }
        });
        getContentPane().add(emp_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 80, 30));

        jLabel15.setForeground(new java.awt.Color(24, 87, 115));
        jLabel15.setText("Email");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 100, -1));

        emp_email.setBackground(new java.awt.Color(191, 229, 246));
        emp_email.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emp_email.setForeground(new java.awt.Color(24, 87, 115));
        emp_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emp_email.setBorder(null);
        emp_email.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        emp_email.setMargin(new java.awt.Insets(4, 6, 4, 6));
        emp_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_emailActionPerformed(evt);
            }
        });
        getContentPane().add(emp_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 230, 30));

        jLabel10.setForeground(new java.awt.Color(24, 87, 115));
        jLabel10.setText("Password");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 60, -1));

        emp_password.setBackground(new java.awt.Color(191, 229, 246));
        emp_password.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emp_password.setForeground(new java.awt.Color(24, 87, 115));
        emp_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emp_password.setToolTipText("");
        emp_password.setBorder(null);
        emp_password.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        emp_password.setMargin(new java.awt.Insets(4, 6, 4, 6));
        emp_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(emp_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 130, 30));

        jLabel11.setForeground(new java.awt.Color(24, 87, 115));
        jLabel11.setText("Department");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 80, -1));

        emp_department.setBackground(new java.awt.Color(191, 229, 246));
        emp_department.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emp_department.setForeground(new java.awt.Color(24, 87, 115));
        emp_department.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emp_department.setToolTipText("");
        emp_department.setBorder(null);
        emp_department.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        emp_department.setMargin(new java.awt.Insets(4, 6, 4, 6));
        emp_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_departmentActionPerformed(evt);
            }
        });
        getContentPane().add(emp_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 190, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -120, 930, 930));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void empID_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empID_comboActionPerformed

    }//GEN-LAST:event_empID_comboActionPerformed

    private void search_patientIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_patientIDActionPerformed

        String employee_ID = empID_combo.getSelectedItem().toString();

        try {
            String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/hospitalsystem";
            String user = "root";
            String pass = "";

            String sql = "SELECT * FROM employeeaccounts WHERE emp_id = " + employee_ID + "";

            Class.forName(JDBC_DRIVER);

            java.sql.Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement prep = connection.prepareStatement(sql);

            ResultSet resultSet = prep.executeQuery();

            while(resultSet.next()) {
                 
                String firstname = resultSet.getString("emp_firstName");
                String lastname = resultSet.getString("emp_lastName");
                String department = resultSet.getString("emp_department");
                String email = resultSet.getString("emp_email");
                String password = resultSet.getString("emp_password");
                
                emp_ID.setText(employee_ID);
                emp_firstname.setText(firstname);
                emp_lastname.setText(lastname);
                emp_department.setText(department);
                emp_email.setText(email);
                emp_password.setText(password);
                        
            }
            
            
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_search_patientIDActionPerformed

    private void update_patientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_patientActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure to update the data?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    
        if(response == JOptionPane.YES_OPTION) {
            String SUrl, SUser, SPass;
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
                SUser = "root";
                SPass = "";
                
                String firstname, lastname, department, email, password;
                
                firstname = emp_firstname.getText();
                lastname = emp_lastname.getText();
                department = emp_department.getText();
                email = emp_email.getText();
                password = emp_password.getText();
                
                String employeeID = empID_combo.getSelectedItem().toString();
                
                java.sql.Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
                
                String updateQuery = "UPDATE employeeaccounts SET emp_firstName = ?, emp_lastName = ?, emp_department = ?, emp_email = ?, emp_password = ? WHERE emp_id = ?";

                    
                PreparedStatement emp_account = con.prepareStatement(updateQuery);

                emp_account.setString(1, firstname);
                emp_account.setString(2, lastname);
                emp_account.setString(3, department);
                emp_account.setString(4, email);
                emp_account.setString(5, password);
                emp_account.setString(6, employeeID);
                emp_account.executeUpdate();
                emp_account.close();
                
                UpdateDataArchive();
                
                JOptionPane.showMessageDialog(null, "Employee updated!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
            } catch(Exception e) {
                
            }
        }


    }//GEN-LAST:event_update_patientActionPerformed

    private void delete_patientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_patientActionPerformed
        String employee_ID = empID_combo.getSelectedItem().toString();
    
        int response = JOptionPane.showConfirmDialog(this, "Are you sure to delete the data?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            String SUrl, SUser, SPass;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
                SUser = "root";
                SPass = "";

                java.sql.Connection con = DriverManager.getConnection(SUrl, SUser, SPass);

                String query1 = "DELETE FROM employeeaccounts WHERE emp_id = " + employee_ID + "";
                
                DeleteDataArchive();
                
                PreparedStatement prep1 = con.prepareStatement(query1);              
                int rowsAffected = prep1.executeUpdate();
                
                if(rowsAffected > 0) {
                    emp_ID.setText("");
                    emp_firstname.setText("");
                    emp_lastname.setText("");
                    emp_department.setText("");
                    emp_email.setText("");
                    emp_password.setText("");
                }
            } catch (Exception e) {
          
            }
        }

    }//GEN-LAST:event_delete_patientActionPerformed

    private void back_patientreg4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientreg4ActionPerformed
        this.setVisible(false);
        
        if (doctorDashboard != null) {
            doctorDashboard.setVisible(true);
        } else if (adminDashboard != null) {
            adminDashboard.setVisible(true);
        }
    }//GEN-LAST:event_back_patientreg4ActionPerformed

    private void emp_firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_firstnameActionPerformed

    private void emp_lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_lastnameActionPerformed

    private void emp_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_IDActionPerformed

    private void emp_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_emailActionPerformed

    private void emp_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_passwordActionPerformed

    private void emp_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_departmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_departmentActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_patientreg4;
    private javax.swing.JButton delete_patient;
    private javax.swing.JComboBox<String> empID_combo;
    private javax.swing.JTextField emp_ID;
    private javax.swing.JTextField emp_department;
    private javax.swing.JTextField emp_email;
    private javax.swing.JTextField emp_firstname;
    private javax.swing.JTextField emp_lastname;
    private javax.swing.JTextField emp_password;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton search_patientID;
    private javax.swing.JButton update_patient;
    // End of variables declaration//GEN-END:variables
}
