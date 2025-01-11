/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PayBill extends javax.swing.JFrame {


    private DoctorDashboard doctorDashboard;
    private AdminDashboard adminDashboard;
    private AccountingDashboard accountingDashboard;
    private PatientView patientview;
    
    public PayBill(DoctorDashboard doctorDashboard) {
        this.doctorDashboard = doctorDashboard;
        initComponents();
    }

    public PayBill(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
        initComponents();
    }
    
    public PayBill(AccountingDashboard accountingDashboard) {
        this.accountingDashboard = accountingDashboard;
        initComponents();
    }
    public PayBill() {
        initComponents();
        UneditableField();

    }
    
    private void UneditableField() {
        patient_firstname.setEditable(false);
        patient_lastname.setEditable(false);
        patient_ID.setEditable(false);
        amountToPay.setEditable(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        balanceText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        search_patientID = new javax.swing.JTextField();
        search_allPatient2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        search_allPatient3 = new javax.swing.JButton();
        back_patientreg = new javax.swing.JButton();
        amountToPay = new javax.swing.JTextField();
        patient_firstname = new javax.swing.JTextField();
        patient_lastname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        patient_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(191, 229, 246));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(24, 87, 115));
        jLabel13.setText("Outstanding Balance:");

        balanceText.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        balanceText.setForeground(new java.awt.Color(24, 87, 115));
        balanceText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balanceText.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(balanceText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel13)
                .addGap(29, 29, 29)
                .addComponent(balanceText, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 300, 230));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 87, 115));
        jLabel4.setText("Pay Bill");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 410, -1));

        jLabel12.setForeground(new java.awt.Color(24, 87, 115));
        jLabel12.setText("Enter Patient ID:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 100, 20));

        search_patientID.setForeground(new java.awt.Color(102, 102, 102));
        search_patientID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        search_patientID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        search_patientID.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        search_patientID.setMargin(new java.awt.Insets(4, 6, 4, 6));
        search_patientID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_patientIDActionPerformed(evt);
            }
        });
        getContentPane().add(search_patientID, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 110, 20));

        search_allPatient2.setBackground(new java.awt.Color(24, 87, 115));
        search_allPatient2.setForeground(new java.awt.Color(255, 255, 255));
        search_allPatient2.setText("Pay");
        search_allPatient2.setBorder(null);
        search_allPatient2.setPreferredSize(new java.awt.Dimension(43, 16));
        search_allPatient2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_allPatient2ActionPerformed(evt);
            }
        });
        getContentPane().add(search_allPatient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 100, 30));

        jLabel9.setForeground(new java.awt.Color(24, 87, 115));
        jLabel9.setText("Last Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 60, -1));

        jPanel4.setBackground(new java.awt.Color(24, 87, 115));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 60, 640));

        jLabel14.setForeground(new java.awt.Color(24, 87, 115));
        jLabel14.setText("First Name");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 100, -1));

        jLabel10.setForeground(new java.awt.Color(24, 87, 115));
        jLabel10.setText("Amount to pay:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 90, -1));

        search_allPatient3.setBackground(new java.awt.Color(24, 87, 115));
        search_allPatient3.setForeground(new java.awt.Color(255, 255, 255));
        search_allPatient3.setText("Search");
        search_allPatient3.setBorder(null);
        search_allPatient3.setPreferredSize(new java.awt.Dimension(43, 16));
        search_allPatient3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_allPatient3ActionPerformed(evt);
            }
        });
        getContentPane().add(search_allPatient3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 70, 20));

        back_patientreg.setBackground(new java.awt.Color(204, 204, 204));
        back_patientreg.setText("Back");
        back_patientreg.setBorder(null);
        back_patientreg.setPreferredSize(new java.awt.Dimension(43, 16));
        back_patientreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_patientregActionPerformed(evt);
            }
        });
        getContentPane().add(back_patientreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 50, 30));

        amountToPay.setBackground(new java.awt.Color(191, 229, 246));
        amountToPay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        amountToPay.setForeground(new java.awt.Color(24, 87, 115));
        amountToPay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amountToPay.setBorder(null);
        getContentPane().add(amountToPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 220, 30));

        patient_firstname.setBackground(new java.awt.Color(191, 229, 246));
        patient_firstname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        patient_firstname.setForeground(new java.awt.Color(24, 87, 115));
        patient_firstname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        patient_firstname.setBorder(null);
        patient_firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_firstnameActionPerformed(evt);
            }
        });
        getContentPane().add(patient_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 220, 30));

        patient_lastname.setBackground(new java.awt.Color(191, 229, 246));
        patient_lastname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        patient_lastname.setForeground(new java.awt.Color(24, 87, 115));
        patient_lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        patient_lastname.setBorder(null);
        getContentPane().add(patient_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 220, 30));

        jLabel15.setForeground(new java.awt.Color(24, 87, 115));
        jLabel15.setText("Patient ID");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 100, -1));

        patient_ID.setBackground(new java.awt.Color(191, 229, 246));
        patient_ID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        patient_ID.setForeground(new java.awt.Color(24, 87, 115));
        patient_ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        patient_ID.setBorder(null);
        patient_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_IDActionPerformed(evt);
            }
        });
        getContentPane().add(patient_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 220, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void search_patientIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_patientIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_patientIDActionPerformed

    private void search_allPatient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_allPatient2ActionPerformed
        
        String SUrl, SUser, SPass, query;
        
        String patientID = patient_ID.getText();
        
        double payment = Double.parseDouble(amountToPay.getText());
        
        double balance = Double.parseDouble(balanceText.getText());
        
        double outstandingBalance = balance - payment;
        
        String stringFormat = String.valueOf(outstandingBalance);
        
        //Date today
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = today.format(formatter);
        
        query = "UPDATE patientbalances \n" +
                "SET outstanding_balance = ? \n" +
                "WHERE patient_id = ?;";
        
        String sql = "INSERT INTO receipt (patient_id, patient_firstName, patient_lastName, payment_price, balance, dateOfPayment) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
            SUser = "root";
            SPass = "";

            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            PreparedStatement pstmt = con.prepareStatement(query);
            PreparedStatement pstmt2 = con.prepareStatement(sql);
            
            pstmt.setString(1, stringFormat);
            pstmt.setString(2, patientID);
            
            String fname = patient_firstname.getText();
            String lname = patient_lastname.getText();
            String paid = amountToPay.getText();
            
            pstmt2.setString(1, patientID);
            pstmt2.setString(2, fname);
            pstmt2.setString(3, lname);
            pstmt2.setString(4, paid);
            pstmt2.setDouble(5, outstandingBalance);
            pstmt2.setString(6, formattedDate);
   
            int rowsAffected = pstmt.executeUpdate();
            int rowsAdded = pstmt2.executeUpdate();

            if (rowsAffected > 0 && rowsAdded > 0) {
                JOptionPane.showMessageDialog(this, "Update successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No matching record found to update.", "Update Failed", JOptionPane.WARNING_MESSAGE);
            }
            
            amountToPay.setText("");

            search_allPatient3ActionPerformed(evt);
            
            
                     
        } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame(), "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_search_allPatient2ActionPerformed

    private void search_allPatient3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_allPatient3ActionPerformed

        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";

        String patientID = search_patientID.getText();

        String query = "SELECT * FROM patientbalances " +
        "WHERE patient_id = " + patientID + "";

        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                String id = String.valueOf(rs.getInt("patient_id"));
                String firstname = rs.getString("patient_firstName");
                String lastname = rs.getString("patient_lastName");
                double balance = Double.parseDouble(rs.getString("balance"));
                double outstanding = Double.parseDouble(rs.getString("outstanding_balance"));
                
                patient_firstname.setText(firstname);
                patient_lastname.setText(lastname);
                balanceText.setText(String.valueOf(outstanding));
                patient_ID.setText(patientID);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_search_allPatient3ActionPerformed

    private void back_patientregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientregActionPerformed

        this.setVisible(false);

        if (doctorDashboard != null) {
            doctorDashboard.setVisible(true);
        } else if (adminDashboard != null) {
            adminDashboard.setVisible(true);
        } else if (accountingDashboard != null) {
            accountingDashboard.setVisible(true);
        }

    }//GEN-LAST:event_back_patientregActionPerformed

    private void patient_firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_firstnameActionPerformed

    private void patient_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_IDActionPerformed

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
            java.util.logging.Logger.getLogger(PayBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountToPay;
    private javax.swing.JButton back_patientreg;
    private javax.swing.JLabel balanceText;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField patient_ID;
    private javax.swing.JTextField patient_firstname;
    private javax.swing.JTextField patient_lastname;
    private javax.swing.JButton search_allPatient2;
    private javax.swing.JButton search_allPatient3;
    private javax.swing.JTextField search_patientID;
    // End of variables declaration//GEN-END:variables
}
