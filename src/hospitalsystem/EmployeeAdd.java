/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalsystem;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


public class EmployeeAdd extends javax.swing.JFrame {

    private String selectedDepartment;
    
    private DoctorDashboard doctorDashboard;
    private AdminDashboard adminDashboard;
    
    
    public EmployeeAdd(DoctorDashboard doctorDashboard) {
        this.doctorDashboard = doctorDashboard;
        initComponents();
    }

    // Constructor for Admins
    public EmployeeAdd(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
        initComponents();
    }
    public EmployeeAdd() {
        initComponents();
    }
    
    public int getIdFromEmployee() {
        String SUrl, SUser, SPass;
        String getIdQuery = "SELECT emp_id FROM employeeaccounts ORDER BY emp_id DESC LIMIT 1";
        int lastIdFromQuery = -1;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
            SUser = "root";
            SPass = "";
           
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            PreparedStatement preparedStatement = con.prepareStatement(getIdQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                lastIdFromQuery = resultSet.getInt("emp_id");
            }
            
            resultSet.close();
            preparedStatement.close();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving employee ID.");
        }
        
        return lastIdFromQuery;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        back_patientreg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        firstName_emp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lastName_emp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        email_emp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password_emp = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        selectDepartment_emp = new javax.swing.JComboBox<>();
        addEmployee = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 87, 115));
        jLabel4.setText("Add Employee");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 490, -1));

        jPanel1.setBackground(new java.awt.Color(24, 87, 115));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 650));

        back_patientreg.setBackground(new java.awt.Color(204, 204, 204));
        back_patientreg.setText("Back");
        back_patientreg.setBorder(null);
        back_patientreg.setPreferredSize(new java.awt.Dimension(43, 16));
        back_patientreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_patientregActionPerformed(evt);
            }
        });
        getContentPane().add(back_patientreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 50, 30));

        jLabel1.setForeground(new java.awt.Color(24, 87, 115));
        jLabel1.setText("Department/Job");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        firstName_emp.setBackground(new java.awt.Color(191, 229, 246));
        firstName_emp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        firstName_emp.setForeground(new java.awt.Color(24, 87, 115));
        firstName_emp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        firstName_emp.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 2, 4, 2));
        firstName_emp.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        firstName_emp.setMargin(new java.awt.Insets(4, 6, 4, 6));
        firstName_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstName_empActionPerformed(evt);
            }
        });
        getContentPane().add(firstName_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 240, 30));

        jLabel5.setForeground(new java.awt.Color(24, 87, 115));
        jLabel5.setText("Last Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        lastName_emp.setBackground(new java.awt.Color(191, 229, 246));
        lastName_emp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lastName_emp.setForeground(new java.awt.Color(24, 87, 115));
        lastName_emp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lastName_emp.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 2, 4, 2));
        lastName_emp.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        lastName_emp.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(lastName_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 250, 30));

        jLabel2.setForeground(new java.awt.Color(24, 87, 115));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));

        email_emp.setBackground(new java.awt.Color(191, 229, 246));
        email_emp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        email_emp.setForeground(new java.awt.Color(24, 87, 115));
        email_emp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        email_emp.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 2, 4, 2));
        email_emp.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        email_emp.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(email_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 240, 30));

        jLabel3.setForeground(new java.awt.Color(24, 87, 115));
        jLabel3.setText("Email");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        password_emp.setBackground(new java.awt.Color(191, 229, 246));
        password_emp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        password_emp.setForeground(new java.awt.Color(24, 87, 115));
        password_emp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        password_emp.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 2, 4, 2));
        getContentPane().add(password_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 250, 30));

        jLabel6.setForeground(new java.awt.Color(24, 87, 115));
        jLabel6.setText("First Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        selectDepartment_emp.setBackground(new java.awt.Color(191, 229, 246));
        selectDepartment_emp.setEditable(true);
        selectDepartment_emp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        selectDepartment_emp.setForeground(new java.awt.Color(24, 87, 115));
        selectDepartment_emp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department", "Admin Department", "Doctor Department", "Accounting Department", "Physician" }));
        selectDepartment_emp.setBorder(null);
        selectDepartment_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDepartment_empActionPerformed(evt);
            }
        });
        getContentPane().add(selectDepartment_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 240, 30));

        addEmployee.setBackground(new java.awt.Color(24, 87, 115));
        addEmployee.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addEmployee.setForeground(new java.awt.Color(191, 229, 246));
        addEmployee.setText("Add Employee");
        addEmployee.setBorder(null);
        addEmployee.setPreferredSize(new java.awt.Dimension(43, 16));
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(addEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 110, 40));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG (1).png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_patientregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientregActionPerformed

        this.setVisible(false);

        if (doctorDashboard != null) {
            doctorDashboard.setVisible(true);
        } else if (adminDashboard != null) {
            adminDashboard.setVisible(true);
        }
        
    }//GEN-LAST:event_back_patientregActionPerformed

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed
       
        
        String SUrl, SUser, SPass;
        int lastIdFromQuery;
        String emp_firstName, emp_lastName, emp_email, emp_password, emp_department, query;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
            SUser = "root";
            SPass = "";
            
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            
            if("".equals(firstName_emp.getText())) {
                JOptionPane.showMessageDialog(new JFrame(),  "First name is required", "Error", 
                        JOptionPane.ERROR_MESSAGE);
            } else if("".equals(lastName_emp.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Last name is required", "Error", 
                        JOptionPane.ERROR_MESSAGE);
            } else if("".equals(email_emp.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Email is required", "Error", 
                        JOptionPane.ERROR_MESSAGE);
            } else if("".equals(password_emp.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error", 
                        JOptionPane.ERROR_MESSAGE);
            } else {
                
                emp_firstName = firstName_emp.getText();
                emp_lastName = lastName_emp.getText();
                emp_email = email_emp.getText();
                emp_password = password_emp.getText();
                emp_department = selectDepartment_emp.getSelectedItem().toString();
                
                lastIdFromQuery = getIdFromEmployee();
                lastIdFromQuery = lastIdFromQuery + 1;
                
                query = "INSERT INTO employeeaccounts(emp_id, emp_firstName, emp_lastName, emp_department, emp_email, emp_password)"+
                        "VALUES('"+lastIdFromQuery+"', '"+emp_firstName+"', '"+emp_lastName+"', '"+emp_department+"', '"+emp_email+"', '"+emp_password+"')";
            
                st.execute(query);
                
                firstName_emp.setText("");
                lastName_emp.setText("");
                selectDepartment_emp.setSelectedIndex(0);
                email_emp.setText("");
                password_emp.setText("");
                
                showMessageDialog(null, "Account has been created successfully!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_addEmployeeActionPerformed

    private void selectDepartment_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDepartment_empActionPerformed
        selectedDepartment = (String) selectDepartment_emp.getSelectedItem();
    }//GEN-LAST:event_selectDepartment_empActionPerformed

    private void firstName_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstName_empActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstName_empActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmployee;
    private javax.swing.JButton back_patientreg;
    private javax.swing.JLabel bg;
    private javax.swing.JTextField email_emp;
    private javax.swing.JTextField firstName_emp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastName_emp;
    private javax.swing.JPasswordField password_emp;
    private javax.swing.JComboBox<String> selectDepartment_emp;
    // End of variables declaration//GEN-END:variables
}
