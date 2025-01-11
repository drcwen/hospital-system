
package hospitalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


public class InPatientRegister extends javax.swing.JFrame {

    private int id;
    private String firstname, lastname;
    String physician;
    String fullName;
    
    public InPatientRegister(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        initComponents();
        PopulateComboBox();
    }
    
    public InPatientRegister() {
        initComponents();
    }

    private void PopulateComboBox() {
        
        try {
            String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
            String url = "jdbc:mysql://localhost:3306/hospitalsystem";
            String user = "root";
            String pass = "";
            String val = "Physician";

            String sql = "SELECT emp_firstName ,emp_lastName FROM employeeaccounts WHERE emp_department = ?";

            Class.forName(JDBC_DRIVER);

            Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, val);

            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {
                String physicianLastName = resultSet.getString("emp_lastName");
                String physicianFirstName = resultSet.getString("emp_firstName");
                fullName = physicianFirstName + " " + physicianLastName;

                physician_combo.addItem(fullName);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        back_patientreg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ip_contactEmergency = new javax.swing.JTextField();
        ip_contactEmer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ip_roomNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ip_admissionDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ip_admissionTime = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ip_allergies = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ip_chronicConditions = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        physician_combo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jLabel4.setText("In Patient Register");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 490, -1));

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
        jLabel1.setText("Person to Contact In Case of Emergency");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        ip_contactEmergency.setForeground(new java.awt.Color(102, 102, 102));
        ip_contactEmergency.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        ip_contactEmergency.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        ip_contactEmergency.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(ip_contactEmergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 240, 30));

        ip_contactEmer.setForeground(new java.awt.Color(102, 102, 102));
        ip_contactEmer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        ip_contactEmer.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        ip_contactEmer.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(ip_contactEmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 240, 30));

        jLabel5.setForeground(new java.awt.Color(24, 87, 115));
        jLabel5.setText("Room Number");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        ip_roomNumber.setForeground(new java.awt.Color(102, 102, 102));
        ip_roomNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        ip_roomNumber.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        ip_roomNumber.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(ip_roomNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 80, 30));

        jLabel2.setForeground(new java.awt.Color(24, 87, 115));
        jLabel2.setText("Contact Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        ip_admissionDate.setForeground(new java.awt.Color(102, 102, 102));
        ip_admissionDate.setDoubleBuffered(false);
        getContentPane().add(ip_admissionDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 120, 30));

        jLabel6.setForeground(new java.awt.Color(24, 87, 115));
        jLabel6.setText("Admission Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        jLabel7.setForeground(new java.awt.Color(24, 87, 115));
        jLabel7.setText("Admission Time");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, -1));

        ip_admissionTime.setForeground(new java.awt.Color(102, 102, 102));
        ip_admissionTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        ip_admissionTime.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        ip_admissionTime.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(ip_admissionTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 90, 30));

        jLabel8.setForeground(new java.awt.Color(24, 87, 115));
        jLabel8.setText("Attending Physician");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, -1));

        jLabel9.setForeground(new java.awt.Color(24, 87, 115));
        jLabel9.setText("Allergies (N/A if none)");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        ip_allergies.setForeground(new java.awt.Color(102, 102, 102));
        ip_allergies.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        ip_allergies.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        ip_allergies.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(ip_allergies, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 220, 30));

        jLabel10.setForeground(new java.awt.Color(24, 87, 115));
        jLabel10.setText("Chronic Conditions (N/A if none) ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        ip_chronicConditions.setForeground(new java.awt.Color(102, 102, 102));
        ip_chronicConditions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        ip_chronicConditions.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        ip_chronicConditions.setMargin(new java.awt.Insets(4, 6, 4, 6));
        getContentPane().add(ip_chronicConditions, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 220, 30));

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setText("Submit");
        jButton6.setBorder(null);
        jButton6.setPreferredSize(new java.awt.Dimension(43, 16));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 110, 40));

        physician_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        physician_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                physician_comboActionPerformed(evt);
            }
        });
        getContentPane().add(physician_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 200, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_patientregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientregActionPerformed

        this.setVisible(false);

    }//GEN-LAST:event_back_patientregActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        int response = JOptionPane.showConfirmDialog(this, "Are you sure about the datas presented?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(response == JOptionPane.YES_OPTION) {

            String SUrl, SUser, SPass;
            String query, contactEmer, contactNumEmer, room, admissiondate, admissiontime, allergies, chronic, physician;

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
                SUser = "root";
                SPass = "";

                Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
                Statement st = con.createStatement();

                if("".equals(ip_contactEmergency.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Emergency contact person is required", "Error",
                        JOptionPane.ERROR_MESSAGE);
                } else if("".equals(ip_contactEmer.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Emergency contact number is required", "Error",
                        JOptionPane.ERROR_MESSAGE);
                } else if("".equals(ip_roomNumber.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Room number is required", "Error",
                        JOptionPane.ERROR_MESSAGE);
                } else if(ip_admissionDate.getDate() == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "Admission date is required", "Error",
                        JOptionPane.ERROR_MESSAGE);
                } else if("".equals(ip_admissionTime.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Admission time is required", "Error",
                        JOptionPane.ERROR_MESSAGE);
                } else if("".equals(ip_allergies.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Allergies are required", "Error",
                        JOptionPane.ERROR_MESSAGE);
                } else if("".equals(ip_chronicConditions.getText())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Chronic condition is required", "Error",
                        JOptionPane.ERROR_MESSAGE);
                } else if("".equals(physician_combo.getSelectedItem())) {
                    JOptionPane.showMessageDialog(new JFrame(), "Physician is required", "Error",
                        JOptionPane.ERROR_MESSAGE);
                } else {

                    contactEmer = ip_contactEmergency.getText();
                    contactNumEmer = ip_contactEmer.getText();
                    room = ip_roomNumber.getText();

                    Date selectedDate = ip_admissionDate.getDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                    admissiondate = dateFormat.format(selectedDate);

                    admissiontime = ip_admissionTime.getText();
                    allergies = ip_allergies.getText();
                    chronic = ip_chronicConditions.getText();
                    physician = physician_combo.getSelectedItem().toString();

                    query = "INSERT INTO inpatient(patient_id, patient_firstName, patient_lastName, inpatient_contactEmer, inpatient_contactNumEmer, inpatient_room, inpatient_admissiondate, inpatient_admissiontime, inpatient_allergies, inpatient_chronic, inpatient_physician)"+
                    "VALUES('"+id+"', '"+firstname+"', '"+lastname+"', '"+contactEmer+"', '"+contactNumEmer+"', '"+room+"', '"+admissiondate+"', '"+admissiontime+"', '"+allergies+"', '"+chronic+"', '"+physician+"')";

                    System.out.print(id + firstname + lastname);
                    st.execute(query);

                    ip_contactEmergency.setText("");
                    ip_contactEmer.setText("");
                    ip_roomNumber.setText("");
                   
                    ip_admissionTime.setText("");
                    ip_allergies.setText("");
                    ip_chronicConditions.setText("");
                    physician_combo.setSelectedIndex(0);
 
                    showMessageDialog(null, "Successfully added!");

                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame(), "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if(response == JOptionPane.NO_OPTION) {

        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void physician_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_physician_comboActionPerformed

    }//GEN-LAST:event_physician_comboActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InPatientRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_patientreg;
    private com.toedter.calendar.JDateChooser ip_admissionDate;
    private javax.swing.JTextField ip_admissionTime;
    private javax.swing.JTextField ip_allergies;
    private javax.swing.JTextField ip_chronicConditions;
    private javax.swing.JTextField ip_contactEmer;
    private javax.swing.JTextField ip_contactEmergency;
    private javax.swing.JTextField ip_roomNumber;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> physician_combo;
    // End of variables declaration//GEN-END:variables
}
