
package hospitalsystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;


public class PatientRegister extends javax.swing.JFrame {

    private DoctorDashboard doctorDashboard;
    private AdminDashboard adminDashboard;
    
    public PatientRegister(DoctorDashboard doctorDashboard) {
        this.doctorDashboard = doctorDashboard;
        initComponents();
    }

    public PatientRegister(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
        initComponents();
    }
    
    public PatientRegister() {
        initComponents();
    }
    
    public int getIdFromEmployee() {
        String SUrl, SUser, SPass;
        String getIdQuery = "SELECT patient_id FROM registerpatient ORDER BY patient_id DESC LIMIT 1";
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
                lastIdFromQuery = resultSet.getInt("patient_id");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pati_firstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pati_lastName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pati_age = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pati_birthday = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        pati_contact = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        pati_address = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        pati_ailment = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        pati_type = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        pati_blood = new javax.swing.JComboBox<>();
        back_patientreg = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(779, 729));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 87, 115));
        jLabel4.setText("Register Patient");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 490, -1));

        jLabel1.setForeground(new java.awt.Color(24, 87, 115));
        jLabel1.setText("First Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        pati_firstName.setForeground(new java.awt.Color(102, 102, 102));
        pati_firstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        pati_firstName.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_firstName.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(pati_firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 240, 30));

        jLabel5.setForeground(new java.awt.Color(24, 87, 115));
        jLabel5.setText("Last Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        pati_lastName.setForeground(new java.awt.Color(102, 102, 102));
        pati_lastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        pati_lastName.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_lastName.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(pati_lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 250, 30));

        jLabel6.setForeground(new java.awt.Color(24, 87, 115));
        jLabel6.setText("Birthday");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));

        pati_age.setForeground(new java.awt.Color(102, 102, 102));
        pati_age.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        pati_age.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_age.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(pati_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 110, 30));

        jLabel9.setForeground(new java.awt.Color(24, 87, 115));
        jLabel9.setText("Age");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        pati_birthday.setForeground(new java.awt.Color(102, 102, 102));
        pati_birthday.setDoubleBuffered(false);
        getContentPane().add(pati_birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 140, 30));

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setText("Add Patient");
        jButton6.setBorder(null);
        jButton6.setPreferredSize(new java.awt.Dimension(43, 16));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 110, 40));

        jLabel11.setForeground(new java.awt.Color(24, 87, 115));
        jLabel11.setText("Contact Number");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        pati_contact.setForeground(new java.awt.Color(102, 102, 102));
        pati_contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        pati_contact.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_contact.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(pati_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 220, 30));

        jLabel12.setForeground(new java.awt.Color(24, 87, 115));
        jLabel12.setText("Address");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        pati_address.setForeground(new java.awt.Color(102, 102, 102));
        pati_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        pati_address.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_address.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(pati_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 510, 30));

        jLabel13.setForeground(new java.awt.Color(24, 87, 115));
        jLabel13.setText("Patient's Ailment");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        pati_ailment.setForeground(new java.awt.Color(102, 102, 102));
        pati_ailment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        pati_ailment.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_ailment.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(pati_ailment, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 160, 30));

        jLabel14.setForeground(new java.awt.Color(24, 87, 115));
        jLabel14.setText("Patient Type");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, -1, -1));

        pati_type.setForeground(new java.awt.Color(102, 102, 102));
        pati_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "In Patient", "Out Patient" }));
        pati_type.setBorder(null);
        pati_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_typeActionPerformed(evt);
            }
        });
        getContentPane().add(pati_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 120, 30));

        jLabel15.setForeground(new java.awt.Color(24, 87, 115));
        jLabel15.setText("Patient Blood Type");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, -1, -1));

        pati_blood.setForeground(new java.awt.Color(102, 102, 102));
        pati_blood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        pati_blood.setBorder(null);
        getContentPane().add(pati_blood, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 120, 30));

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

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        int response = JOptionPane.showConfirmDialog(this, "Are you sure about the datas presented?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(response == JOptionPane.YES_OPTION) {
            
            String SUrl, SUser, SPass;
            int lastIdFromQuery;
            String pat_id, pat_firstName, pat_lastName, pat_age, pat_birthday, pat_contact, pat_address, pat_ailment, pat_type, pat_blood;
            String query;
            
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
                SUser = "root";
                SPass = "";

                Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
                Statement st = con.createStatement();

                if("".equals(pati_firstName.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Last name is required", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                } else if("".equals(pati_lastName.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Email is required", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                } else if("".equals(pati_age.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                } else if("".equals(pati_contact.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                } else if("".equals(pati_address.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                } else if("".equals(pati_ailment.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    pat_firstName = pati_firstName.getText();
                    pat_lastName = pati_lastName.getText();
                    pat_age = pati_age.getText();
                    
                    Date selectedDate = pati_birthday.getDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                    pat_birthday = dateFormat.format(selectedDate);
                    
                    pat_contact = pati_contact.getText();
                    pat_address = pati_address.getText();
                    pat_ailment = pati_ailment.getText();
                    pat_type = pati_type.getSelectedItem().toString();
                    pat_blood = pati_blood.getSelectedItem().toString();

                    lastIdFromQuery = getIdFromEmployee();
                    lastIdFromQuery = lastIdFromQuery + 1;

                    query = "INSERT INTO registerpatient(patient_id, patient_firstName, patient_lastName, patient_age, patient_birthday, patient_contact, patient_address, patient_ailment, patient_type, patient_blood)"+
                            "VALUES('"+lastIdFromQuery+"', '"+pat_firstName+"', '"+pat_lastName+"', '"+pat_age+"', '"+pat_birthday+"', '"+pat_contact+"', '"+pat_address+"', '"+pat_ailment+"', '"+pat_type+"', '"+pat_blood+"')";

                    st.execute(query);
                    
                    pati_firstName.setText("");
                    pati_lastName.setText("");
                    pati_age.setText("");
                    pati_contact.setText("");
                    pati_address.setText("");
                    pati_ailment.setText("");
                    pati_type.setSelectedIndex(0);
                    pati_blood.setSelectedIndex(0);
                    
                    showMessageDialog(null, "Account has been created successfully!");
                    
                    if (pat_type.equals("In Patient")) {
                        InPatientRegister inpatients = new InPatientRegister(lastIdFromQuery, pat_firstName, pat_lastName);
                        inpatients.setVisible(true);
                    } else if (pat_type.equals("Out Patient")) {
                        OutPatientRegister outpatients = new OutPatientRegister(lastIdFromQuery, pat_firstName, pat_lastName);
                        outpatients.setVisible(true);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame(), "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
     
        } else if(response == JOptionPane.NO_OPTION) {
            
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void back_patientregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientregActionPerformed
        
        this.setVisible(false);

        if (doctorDashboard != null) {
            doctorDashboard.setVisible(true);
            
        } else if (adminDashboard != null) {
            adminDashboard.setVisible(true);
        }
        
    }//GEN-LAST:event_back_patientregActionPerformed

    private void pati_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_typeActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_patientreg;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField pati_address;
    private javax.swing.JTextField pati_age;
    private javax.swing.JTextField pati_ailment;
    private com.toedter.calendar.JDateChooser pati_birthday;
    private javax.swing.JComboBox<String> pati_blood;
    private javax.swing.JTextField pati_contact;
    private javax.swing.JTextField pati_firstName;
    private javax.swing.JTextField pati_lastName;
    private javax.swing.JComboBox<String> pati_type;
    // End of variables declaration//GEN-END:variables
}
