/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalsystem;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class DischargedPatients extends javax.swing.JFrame {

    /**
     * Creates new form DischargedPatients
     */
    public DischargedPatients() {
        initComponents();
        setEditable();
    }
    
    private void setEditable() {
        patient_id.setEditable(false);
        patient_firstname.setEditable(false);
        patient_lastname.setEditable(false);
        patient_age.setEditable(false);
        patient_ailment.setEditable(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField_allPatients1 = new javax.swing.JTextField();
        discharge_button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        view_allpatients = new javax.swing.JButton();
        searchField_allPatients = new javax.swing.JTextField();
        search_allPatient = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        patient_firstname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        patient_lastname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        patient_age = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        patient_ailment = new javax.swing.JTextField();
        patient_id = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        search_allPatient2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        back_patientreg = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(780, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchField_allPatients1.setForeground(new java.awt.Color(102, 102, 102));
        searchField_allPatients1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchField_allPatients1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        searchField_allPatients1.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        searchField_allPatients1.setMargin(new java.awt.Insets(4, 6, 4, 6));
        searchField_allPatients1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchField_allPatients1ActionPerformed(evt);
            }
        });
        getContentPane().add(searchField_allPatients1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 110, 20));

        discharge_button.setBackground(new java.awt.Color(24, 87, 115));
        discharge_button.setForeground(new java.awt.Color(255, 255, 255));
        discharge_button.setText("Discharge this patient");
        discharge_button.setBorder(null);
        discharge_button.setPreferredSize(new java.awt.Dimension(43, 16));
        discharge_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discharge_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(discharge_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 160, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 87, 115));
        jLabel4.setText("Discharge Patients");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 490, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "First Name", "Last Name", "Discharge Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 600, 120));

        view_allpatients.setBackground(new java.awt.Color(204, 204, 204));
        view_allpatients.setText("View Discharged Patients");
        view_allpatients.setBorder(null);
        view_allpatients.setPreferredSize(new java.awt.Dimension(43, 16));
        view_allpatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_allpatientsActionPerformed(evt);
            }
        });
        getContentPane().add(view_allpatients, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 170, 30));

        searchField_allPatients.setForeground(new java.awt.Color(102, 102, 102));
        searchField_allPatients.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        searchField_allPatients.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        searchField_allPatients.setMargin(new java.awt.Insets(4, 6, 4, 6));
        searchField_allPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchField_allPatientsActionPerformed(evt);
            }
        });
        getContentPane().add(searchField_allPatients, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, 130, 20));

        search_allPatient.setBackground(new java.awt.Color(24, 87, 115));
        search_allPatient.setForeground(new java.awt.Color(255, 255, 255));
        search_allPatient.setText("Search");
        search_allPatient.setBorder(null);
        search_allPatient.setPreferredSize(new java.awt.Dimension(43, 16));
        search_allPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_allPatientActionPerformed(evt);
            }
        });
        getContentPane().add(search_allPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 70, 20));

        jLabel12.setForeground(new java.awt.Color(24, 87, 115));
        jLabel12.setText("Enter Patient ID:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 100, 20));

        patient_firstname.setBackground(new java.awt.Color(191, 229, 246));
        patient_firstname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        patient_firstname.setForeground(new java.awt.Color(24, 87, 115));
        patient_firstname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        patient_firstname.setBorder(null);
        patient_firstname.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        patient_firstname.setMargin(new java.awt.Insets(4, 6, 4, 6));
        patient_firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_firstnameActionPerformed(evt);
            }
        });
        getContentPane().add(patient_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 130, 30));

        jLabel9.setForeground(new java.awt.Color(24, 87, 115));
        jLabel9.setText("Last Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 60, -1));

        patient_lastname.setBackground(new java.awt.Color(191, 229, 246));
        patient_lastname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        patient_lastname.setForeground(new java.awt.Color(24, 87, 115));
        patient_lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        patient_lastname.setToolTipText("");
        patient_lastname.setBorder(null);
        patient_lastname.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        patient_lastname.setMargin(new java.awt.Insets(4, 6, 4, 6));
        patient_lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_lastnameActionPerformed(evt);
            }
        });
        getContentPane().add(patient_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 130, 30));

        jLabel10.setForeground(new java.awt.Color(24, 87, 115));
        jLabel10.setText("Age");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 60, -1));

        patient_age.setBackground(new java.awt.Color(191, 229, 246));
        patient_age.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        patient_age.setForeground(new java.awt.Color(24, 87, 115));
        patient_age.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        patient_age.setBorder(null);
        patient_age.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        patient_age.setMargin(new java.awt.Insets(4, 6, 4, 6));
        patient_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_ageActionPerformed(evt);
            }
        });
        getContentPane().add(patient_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 60, 30));

        jLabel14.setForeground(new java.awt.Color(24, 87, 115));
        jLabel14.setText("Ailment");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 60, -1));

        patient_ailment.setBackground(new java.awt.Color(191, 229, 246));
        patient_ailment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        patient_ailment.setForeground(new java.awt.Color(24, 87, 115));
        patient_ailment.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        patient_ailment.setBorder(null);
        patient_ailment.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        patient_ailment.setMargin(new java.awt.Insets(4, 6, 4, 6));
        patient_ailment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_ailmentActionPerformed(evt);
            }
        });
        getContentPane().add(patient_ailment, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 100, 30));

        patient_id.setBackground(new java.awt.Color(191, 229, 246));
        patient_id.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        patient_id.setForeground(new java.awt.Color(24, 87, 115));
        patient_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        patient_id.setBorder(null);
        patient_id.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        patient_id.setMargin(new java.awt.Insets(4, 6, 4, 6));
        patient_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_idActionPerformed(evt);
            }
        });
        getContentPane().add(patient_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 100, 30));

        jLabel15.setForeground(new java.awt.Color(24, 87, 115));
        jLabel15.setText("Patient ID");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 60, -1));

        jPanel3.setBackground(new java.awt.Color(24, 87, 115));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 790));

        search_allPatient2.setBackground(new java.awt.Color(24, 87, 115));
        search_allPatient2.setForeground(new java.awt.Color(255, 255, 255));
        search_allPatient2.setText("Search");
        search_allPatient2.setBorder(null);
        search_allPatient2.setPreferredSize(new java.awt.Dimension(43, 16));
        search_allPatient2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_allPatient2ActionPerformed(evt);
            }
        });
        getContentPane().add(search_allPatient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 70, 20));

        jLabel13.setForeground(new java.awt.Color(24, 87, 115));
        jLabel13.setText("First Name");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 100, -1));

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

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void view_allpatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_allpatientsActionPerformed
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";
        int cc;

        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();

        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            String sql = "select * from dischargepatient";

            ResultSet rs = st.executeQuery(sql);

            tblModel.setRowCount(0);

            while (rs.next()) {

                String id = String.valueOf(rs.getInt("patient_id"));
                String firstname = rs.getString("patient_firstName");
                String lastname = rs.getString("patient_lastName");
                String date = rs.getString("discharge_date");

                String tbData[] = {id, firstname, lastname, date};

                tblModel.addRow(tbData);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_view_allpatientsActionPerformed

    private void searchField_allPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchField_allPatientsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchField_allPatientsActionPerformed

    private void search_allPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_allPatientActionPerformed
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String keyword = searchField_allPatients.getText();

        String query = "SELECT * FROM dischargepatient\n" +
        "WHERE patient_id LIKE '%" + keyword + "%' \n" +
        "   OR patient_firstName LIKE '%" + keyword + "%' \n" +
        "   OR patient_lastName LIKE '%" + keyword + "%' \n";

        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                model.setRowCount(0);

                String id = String.valueOf(rs.getInt("patient_id"));
                String firstname = rs.getString("patient_firstName");
                String lastname = rs.getString("patient_lastName");

                String tbData[] = {id, firstname, lastname};

                model.addRow(tbData);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_search_allPatientActionPerformed

    private void searchField_allPatients1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchField_allPatients1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchField_allPatients1ActionPerformed

    private void discharge_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discharge_buttonActionPerformed
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";

        String patientID = patient_id.getText();
        String firstname = patient_firstname.getText();
        String lastname = patient_lastname.getText();
        
        LocalDate today = LocalDate.now(); // Get today's date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = today.format(formatter);

        String query = "SELECT * FROM patientbalances WHERE patient_id = ?";
        String updateQuery = "UPDATE registerpatient SET patient_type = ? WHERE patient_id = ?";
        String deleteQuery = "DELETE FROM inpatient WHERE patient_id = ?";
        
        String addQuery = "INSERT INTO dischargepatient (patient_id, patient_firstName, patient_lastName, discharge_date) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass)) {
            PreparedStatement selectStatement = con.prepareStatement(query);
            selectStatement.setString(1, patientID);
            ResultSet rs = selectStatement.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("outstanding_balance");

                if (balance == 0.0) {
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure to discharge the patient?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        PreparedStatement updateStatement = con.prepareStatement(updateQuery);
                        updateStatement.setString(1, "Discharged");
                        updateStatement.setString(2, patientID);
                        int rowsUpdated = updateStatement.executeUpdate();

                        PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
                        deleteStatement.setString(1, patientID);
                        int rowsDeleted = deleteStatement.executeUpdate();
                        
                        PreparedStatement addStatement = con.prepareStatement(addQuery);
                        
                        addStatement.setString(1, patientID);
                        addStatement.setString(2, firstname);
                        addStatement.setString(3, lastname);
                        addStatement.setString(4, formattedDate);
                        int rowsAdded = addStatement.executeUpdate();
                        

                        if (rowsUpdated > 0 && rowsDeleted > 0 && rowsAdded > 0) {
                            JOptionPane.showMessageDialog(null, "Patient is discharged!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Discharge canceled.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The patient has a remaining balance of " + balance + ". Please clear the balance before discharge.", "Balance Due", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Patient not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_discharge_buttonActionPerformed

    private void patient_firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_firstnameActionPerformed

    private void patient_lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_lastnameActionPerformed

    private void patient_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_ageActionPerformed

    private void patient_ailmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_ailmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_ailmentActionPerformed

    private void patient_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_idActionPerformed

    private void search_allPatient2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_allPatient2ActionPerformed
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";

        String keyword = searchField_allPatients1.getText();

        String query = "SELECT * FROM registerpatient " +
        "WHERE patient_id = " + keyword + "";

        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                String id = String.valueOf(rs.getInt("patient_id"));
                
                String type = rs.getString("patient_type");
                
                patient_id.setText("");
                patient_firstname.setText("");
                patient_lastname.setText("");
                patient_age.setText("");
                patient_ailment.setText("");
                    
                if(type.equals("In Patient")) {
                    
                    String firstname = rs.getString("patient_firstName");
                    String lastname = rs.getString("patient_lastName");
                    String age = rs.getString("patient_age");
                    String ailment = rs.getString("patient_ailment");
                    
                    patient_id.setText(id);
                    patient_firstname.setText(firstname);
                    patient_lastname.setText(lastname);
                    patient_age.setText(age);
                    patient_ailment.setText(ailment);
                    
                } else if(type.equals("Out Patient")) {
                    
                    JOptionPane.showMessageDialog(null, "Patient is Out Patient!", "Information", JOptionPane.INFORMATION_MESSAGE);

                } else if(type.equals("Discharged")) {
                    JOptionPane.showMessageDialog(null, "Patient is Discharged!", "Information", JOptionPane.INFORMATION_MESSAGE);
                   
                }
                
               
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_search_allPatient2ActionPerformed

    private void back_patientregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientregActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_back_patientregActionPerformed

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
            java.util.logging.Logger.getLogger(DischargedPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DischargedPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DischargedPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DischargedPatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DischargedPatients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_patientreg;
    private javax.swing.JButton discharge_button;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField patient_age;
    private javax.swing.JTextField patient_ailment;
    private javax.swing.JTextField patient_firstname;
    private javax.swing.JTextField patient_id;
    private javax.swing.JTextField patient_lastname;
    private javax.swing.JTextField searchField_allPatients;
    private javax.swing.JTextField searchField_allPatients1;
    private javax.swing.JButton search_allPatient;
    private javax.swing.JButton search_allPatient2;
    private javax.swing.JButton view_allpatients;
    // End of variables declaration//GEN-END:variables
}
