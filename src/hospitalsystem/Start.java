
package hospitalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
import java.sql.*;


public class Start extends javax.swing.JFrame {

    public Start() {
        initComponents();
        
        this.setTitle("General Hospital");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(778, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(246, 246, 246));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(10, 162, 137));
        jLabel1.setText("SIGN IN");

        username.setBackground(new java.awt.Color(191, 229, 246));
        username.setForeground(new java.awt.Color(24, 87, 115));
        username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 2, 4, 2));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(68, 68, 68));
        jLabel3.setText("Username");

        password.setBackground(new java.awt.Color(191, 229, 246));
        password.setForeground(new java.awt.Color(24, 87, 115));
        password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        password.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 2, 4, 2));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(68, 68, 68));
        jLabel4.setText("Password");

        jButton1.setBackground(new java.awt.Color(10, 162, 137));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(246, 246, 246));
        jButton1.setText("Login");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(username)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 350, 610));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LoginBG.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 780, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String userName = username.getText();
        String passWord = password.getText();
        boolean successful = false;
        
        try {
            String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/hospitalsystem";
            String user = "root";
            String pass = "";
            
            String doctor, physician, accounting, admin;
            
            String sql = "SELECT emp_email, emp_password, emp_department FROM employeeaccounts";
            
            Class.forName(JDBC_DRIVER);

            Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement prep = connection.prepareStatement(sql);
            ResultSet resultSet = prep.executeQuery();
            
            if (userName.contains("@pascualhospital.com") || userName.contains(".com")) {
                while(resultSet.next()) {
                    String email = resultSet.getString("emp_email");
                    String password = resultSet.getString("emp_password");
                    String department = resultSet.getString("emp_department");

                    if(email.equals(userName) && password.equals(passWord)) {
                        successful = true;

                        if(department.equalsIgnoreCase("Doctor Department")) {
                            DoctorDashboard doctor1 = new DoctorDashboard();
                            doctor1.setVisible(true);
                            this.setVisible(false);
                        } else if(department.equals("Accounting Department")) {
                            AccountingDashboard acc1 = new AccountingDashboard();
                            acc1.setVisible(true);
                            this.setVisible(false);
                        } else if(department.equals("Physician")) {
                            DoctorDashboard doctor1 = new DoctorDashboard();
                            doctor1.setVisible(true);
                            this.setVisible(false);
                        } else if(department.equals("Admin Department")) {
                            AdminDashboard admin1 = new AdminDashboard();
                            admin1.setVisible(true);
                            this.setVisible(false);
                        }       
                        break;
                    }       
                }

                if(!successful) {
                    JOptionPane.showMessageDialog(this, "Invalid username or password.");
                }

                resultSet.close();
                prep.close();
                connection.close();
            
            } else {
                JOptionPane.showMessageDialog(this, "Enter a valid email.");
            }
            
            resultSet.close();
            prep.close();
            connection.close();
            
        } catch (Exception e) {
             e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
