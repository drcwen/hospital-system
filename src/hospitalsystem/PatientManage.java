
package hospitalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PatientManage extends javax.swing.JFrame {
    
    String finalPatientType;
    
    public PatientManage() {
        initComponents();
        PopulateComboBox();
    }

    private void UpdateDataArchive() {
        
        String SUrl, SUser, SPass;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(formatter);
        
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = time.format(formatter1);
        
        String dateAndTime = formattedDate + " " + formattedTime;
        
        String sql = "INSERT INTO patientarchive (patient_id, patient_firstName, patient_lastName, " +
                "patient_age, patient_birthday, patient_contact, patient_allergies, patient_address, " + 
                "patient_ailment, patient_type, blood_type, chronic_conditions, person_emergency, " + 
                "contact_emergency, physician, room_number, admission_date, admission_time, action, date_of_action) " + 
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
            SUser = "root";
            SPass = "";

            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);

            PreparedStatement pstmt = con.prepareStatement(sql);
            
            String id = PatientID_combo.getSelectedItem().toString();
            String firstname = pati_firstName17.getText();
            String lastname = pati_lastName.getText();
            String age = pati_age.getText();
            String birthday = pati_birthday.getText();
            String contact_patient = pati_contact.getText();
            String allergies = pati_allergies.getText();
            String address = pati_address.getText();
            String ailment = pati_ailment.getText();
            String type = pati_type.getText();
            String blood_type = pati_bloodType.getText();
            String chronic_conditions = pati_chronicConditions.getText();
            String person_emergency = pati_personEmergency.getText();
            String contact_emergency = pati_contactEmergency.getText();
            String physician = pati_physician.getText();
            String room_number = pati_roomNum.getText();
            String admission_date = pati_admissionDate.getText();
            String admission_time = pati_admissionTime.getText();
            String action = "Updated";
            String dateOfAction = dateAndTime;
                    
            pstmt.setString(1, id);
            pstmt.setString(2, firstname);
            pstmt.setString(3, lastname);
            pstmt.setString(4, age);
            pstmt.setString(5, birthday);
            pstmt.setString(6, contact_patient);
            pstmt.setString(7, allergies);
            pstmt.setString(8, address);
            pstmt.setString(9, ailment);
            pstmt.setString(10, type);
            pstmt.setString(11, blood_type);
            pstmt.setString(12, chronic_conditions);
            pstmt.setString(13, person_emergency);
            pstmt.setString(14, contact_emergency);
            pstmt.setString(15, physician);
            pstmt.setString(16, room_number);
            pstmt.setString(17, admission_date);
            pstmt.setString(18, admission_time);
            pstmt.setString(19, action);
            pstmt.setString(20, dateOfAction);
            
            pstmt.executeUpdate();
            pstmt.close();
        
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void DeleteDataArchive() {
        
        String SUrl, SUser, SPass;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(formatter);
        
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = time.format(formatter1);
        
        String dateAndTime = formattedDate + " " + formattedTime;
        
        String sql = "INSERT INTO patientarchive (patient_id, patient_firstName, patient_lastName, " +
                "patient_age, patient_birthday, patient_contact, patient_allergies, patient_address, " + 
                "patient_ailment, patient_type, blood_type, chronic_conditions, person_emergency, " + 
                "contact_emergency, physician, room_number, admission_date, admission_time, action, date_of_action) " + 
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
            SUser = "root";
            SPass = "";

            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);

            PreparedStatement pstmt = con.prepareStatement(sql);
            
            String id = PatientID_combo.getSelectedItem().toString();
            String firstname = pati_firstName17.getText();
            String lastname = pati_lastName.getText();
            String age = pati_age.getText();
            String birthday = pati_birthday.getText();
            String contact_patient = pati_contact.getText();
            String allergies = pati_allergies.getText();
            String address = pati_address.getText();
            String ailment = pati_ailment.getText();
            String type = pati_type.getText();
            String blood_type = pati_bloodType.getText();
            String chronic_conditions = pati_chronicConditions.getText();
            String person_emergency = pati_personEmergency.getText();
            String contact_emergency = pati_contactEmergency.getText();
            String physician = pati_physician.getText();
            String room_number = pati_roomNum.getText();
            String admission_date = pati_admissionDate.getText();
            String admission_time = pati_admissionTime.getText();
            String action = "Deleted";
            String dateOfAction = dateAndTime;
                    
            pstmt.setString(1, id);
            pstmt.setString(2, firstname);
            pstmt.setString(3, lastname);
            pstmt.setString(4, age);
            pstmt.setString(5, birthday);
            pstmt.setString(6, contact_patient);
            pstmt.setString(7, allergies);
            pstmt.setString(8, address);
            pstmt.setString(9, ailment);
            pstmt.setString(10, type);
            pstmt.setString(11, blood_type);
            pstmt.setString(12, chronic_conditions);
            pstmt.setString(13, person_emergency);
            pstmt.setString(14, contact_emergency);
            pstmt.setString(15, physician);
            pstmt.setString(16, room_number);
            pstmt.setString(17, admission_date);
            pstmt.setString(18, admission_time);
            pstmt.setString(19, action);
            pstmt.setString(20, dateOfAction);
            
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

            String sql = "SELECT patient_id FROM registerpatient";

            Class.forName(JDBC_DRIVER);

            Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement prep = connection.prepareStatement(sql);

            ResultSet resultSet = prep.executeQuery();

            while (resultSet.next()) {
                String patientid = resultSet.getString("patient_id");
                
                PatientID_combo.addItem(patientid);
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

        jLabel6 = new javax.swing.JLabel();
        search_patientID = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PatientID_combo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        back_patientreg1 = new javax.swing.JButton();
        pati_contact = new javax.swing.JTextField();
        pati_allergies = new javax.swing.JTextField();
        pati_lastName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pati_age = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pati_birthday = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        pati_firstName5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        pati_address = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        pati_ailment = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        pati_type = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pati_personEmergency = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        pati_contactEmergency = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        pati_bloodType = new javax.swing.JTextField();
        pati_chronicConditions = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        pati_physician = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pati_roomNum = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        pati_admissionDate = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        pati_admissionTime = new javax.swing.JTextField();
        delete_patient = new javax.swing.JButton();
        update_patient = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        back_patientreg4 = new javax.swing.JButton();
        back_patientreg5 = new javax.swing.JButton();
        pati_firstName17 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(948, 836));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(24, 87, 115));
        jLabel6.setText("Contact");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 60, -1));

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "First Name", "Last Name", "Age", "Contact", "Address", "Ailment", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 610, 770, 90));

        PatientID_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        PatientID_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientID_comboActionPerformed(evt);
            }
        });
        getContentPane().add(PatientID_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 130, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(24, 87, 115));
        jLabel5.setText("Manage Patients");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 210, -1));

        back_patientreg1.setBackground(new java.awt.Color(204, 204, 204));
        back_patientreg1.setText("View");
        back_patientreg1.setBorder(null);
        back_patientreg1.setPreferredSize(new java.awt.Dimension(43, 16));
        back_patientreg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_patientreg1ActionPerformed(evt);
            }
        });
        getContentPane().add(back_patientreg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 70, 30));

        pati_contact.setBackground(new java.awt.Color(191, 229, 246));
        pati_contact.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_contact.setForeground(new java.awt.Color(24, 87, 115));
        pati_contact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_contact.setBorder(null);
        pati_contact.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_contact.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_contactActionPerformed(evt);
            }
        });
        getContentPane().add(pati_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 170, 30));

        pati_allergies.setBackground(new java.awt.Color(191, 229, 246));
        pati_allergies.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_allergies.setForeground(new java.awt.Color(24, 87, 115));
        pati_allergies.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_allergies.setBorder(null);
        pati_allergies.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_allergies.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_allergies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_allergiesActionPerformed(evt);
            }
        });
        getContentPane().add(pati_allergies, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, 150, 30));

        pati_lastName.setBackground(new java.awt.Color(191, 229, 246));
        pati_lastName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_lastName.setForeground(new java.awt.Color(24, 87, 115));
        pati_lastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_lastName.setToolTipText("");
        pati_lastName.setBorder(null);
        pati_lastName.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_lastName.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_lastNameActionPerformed(evt);
            }
        });
        getContentPane().add(pati_lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(24, 87, 115));
        jLabel7.setText("Edit/Delete Patient Details");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 340, -1));

        pati_age.setBackground(new java.awt.Color(191, 229, 246));
        pati_age.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_age.setForeground(new java.awt.Color(24, 87, 115));
        pati_age.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_age.setBorder(null);
        pati_age.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_age.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_ageActionPerformed(evt);
            }
        });
        getContentPane().add(pati_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 60, 30));

        jLabel8.setForeground(new java.awt.Color(24, 87, 115));
        jLabel8.setText("Allergies");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 70, -1));

        jLabel9.setForeground(new java.awt.Color(24, 87, 115));
        jLabel9.setText("Last Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 60, -1));

        jLabel10.setForeground(new java.awt.Color(24, 87, 115));
        jLabel10.setText("Age");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 60, -1));

        pati_birthday.setBackground(new java.awt.Color(191, 229, 246));
        pati_birthday.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_birthday.setForeground(new java.awt.Color(24, 87, 115));
        pati_birthday.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_birthday.setBorder(null);
        pati_birthday.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_birthday.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_birthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_birthdayActionPerformed(evt);
            }
        });
        getContentPane().add(pati_birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 80, 30));

        jLabel11.setForeground(new java.awt.Color(24, 87, 115));
        jLabel11.setText("Birthday");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 60, -1));

        pati_firstName5.setForeground(new java.awt.Color(102, 102, 102));
        pati_firstName5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        pati_firstName5.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_firstName5.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_firstName5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_firstName5ActionPerformed(evt);
            }
        });
        getContentPane().add(pati_firstName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 130, 30));

        jLabel12.setForeground(new java.awt.Color(24, 87, 115));
        jLabel12.setText("First Name");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 100, -1));

        pati_address.setBackground(new java.awt.Color(191, 229, 246));
        pati_address.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_address.setForeground(new java.awt.Color(24, 87, 115));
        pati_address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_address.setBorder(null);
        pati_address.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_address.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_addressActionPerformed(evt);
            }
        });
        getContentPane().add(pati_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 270, 30));

        jLabel13.setForeground(new java.awt.Color(24, 87, 115));
        jLabel13.setText("Address");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 60, -1));

        pati_ailment.setBackground(new java.awt.Color(191, 229, 246));
        pati_ailment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_ailment.setForeground(new java.awt.Color(24, 87, 115));
        pati_ailment.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_ailment.setBorder(null);
        pati_ailment.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_ailment.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_ailment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_ailmentActionPerformed(evt);
            }
        });
        getContentPane().add(pati_ailment, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 100, 30));

        jLabel14.setForeground(new java.awt.Color(24, 87, 115));
        jLabel14.setText("Ailment");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 60, -1));

        pati_type.setBackground(new java.awt.Color(191, 229, 246));
        pati_type.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_type.setForeground(new java.awt.Color(24, 87, 115));
        pati_type.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_type.setBorder(null);
        pati_type.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_type.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_typeActionPerformed(evt);
            }
        });
        getContentPane().add(pati_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 100, 30));

        jLabel15.setForeground(new java.awt.Color(24, 87, 115));
        jLabel15.setText("Type");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 60, -1));

        jLabel16.setForeground(new java.awt.Color(24, 87, 115));
        jLabel16.setText("Person for Emergency");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 130, -1));

        pati_personEmergency.setBackground(new java.awt.Color(191, 229, 246));
        pati_personEmergency.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_personEmergency.setForeground(new java.awt.Color(24, 87, 115));
        pati_personEmergency.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_personEmergency.setBorder(null);
        pati_personEmergency.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_personEmergency.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_personEmergency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_personEmergencyActionPerformed(evt);
            }
        });
        getContentPane().add(pati_personEmergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 150, 30));

        jLabel17.setForeground(new java.awt.Color(24, 87, 115));
        jLabel17.setText("Contact for Emergency");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 130, -1));

        pati_contactEmergency.setBackground(new java.awt.Color(191, 229, 246));
        pati_contactEmergency.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_contactEmergency.setForeground(new java.awt.Color(24, 87, 115));
        pati_contactEmergency.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_contactEmergency.setBorder(null);
        pati_contactEmergency.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_contactEmergency.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_contactEmergency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_contactEmergencyActionPerformed(evt);
            }
        });
        getContentPane().add(pati_contactEmergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 140, 30));

        jLabel18.setForeground(new java.awt.Color(24, 87, 115));
        jLabel18.setText("Blood Type");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 130, -1));

        pati_bloodType.setBackground(new java.awt.Color(191, 229, 246));
        pati_bloodType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_bloodType.setForeground(new java.awt.Color(24, 87, 115));
        pati_bloodType.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_bloodType.setBorder(null);
        pati_bloodType.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_bloodType.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_bloodType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_bloodTypeActionPerformed(evt);
            }
        });
        getContentPane().add(pati_bloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 110, 30));

        pati_chronicConditions.setBackground(new java.awt.Color(191, 229, 246));
        pati_chronicConditions.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_chronicConditions.setForeground(new java.awt.Color(24, 87, 115));
        pati_chronicConditions.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_chronicConditions.setBorder(null);
        pati_chronicConditions.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_chronicConditions.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_chronicConditions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_chronicConditionsActionPerformed(evt);
            }
        });
        getContentPane().add(pati_chronicConditions, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, 150, 30));

        jLabel19.setForeground(new java.awt.Color(24, 87, 115));
        jLabel19.setText("Chronic Conditions");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 130, -1));

        pati_physician.setBackground(new java.awt.Color(191, 229, 246));
        pati_physician.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_physician.setForeground(new java.awt.Color(24, 87, 115));
        pati_physician.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_physician.setBorder(null);
        pati_physician.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_physician.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_physician.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_physicianActionPerformed(evt);
            }
        });
        getContentPane().add(pati_physician, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 170, 30));

        jLabel20.setForeground(new java.awt.Color(24, 87, 115));
        jLabel20.setText("Physician");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 130, -1));

        jLabel21.setForeground(new java.awt.Color(24, 87, 115));
        jLabel21.setText("IP Room Num");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 80, -1));

        pati_roomNum.setBackground(new java.awt.Color(191, 229, 246));
        pati_roomNum.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_roomNum.setForeground(new java.awt.Color(24, 87, 115));
        pati_roomNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_roomNum.setBorder(null);
        pati_roomNum.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_roomNum.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_roomNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_roomNumActionPerformed(evt);
            }
        });
        getContentPane().add(pati_roomNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 80, 30));

        jLabel22.setForeground(new java.awt.Color(24, 87, 115));
        jLabel22.setText("IP Admission Date");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 100, -1));

        pati_admissionDate.setBackground(new java.awt.Color(191, 229, 246));
        pati_admissionDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_admissionDate.setForeground(new java.awt.Color(24, 87, 115));
        pati_admissionDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_admissionDate.setBorder(null);
        pati_admissionDate.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_admissionDate.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_admissionDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_admissionDateActionPerformed(evt);
            }
        });
        getContentPane().add(pati_admissionDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 100, 30));

        jLabel23.setForeground(new java.awt.Color(24, 87, 115));
        jLabel23.setText("IP Admission Time");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 370, 100, -1));

        pati_admissionTime.setBackground(new java.awt.Color(191, 229, 246));
        pati_admissionTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_admissionTime.setForeground(new java.awt.Color(24, 87, 115));
        pati_admissionTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_admissionTime.setBorder(null);
        pati_admissionTime.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_admissionTime.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_admissionTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_admissionTimeActionPerformed(evt);
            }
        });
        getContentPane().add(pati_admissionTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 400, 90, 30));

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
        getContentPane().add(delete_patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 80, 30));

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
        getContentPane().add(update_patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 80, 30));

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

        back_patientreg4.setBackground(new java.awt.Color(204, 204, 204));
        back_patientreg4.setText("Back");
        back_patientreg4.setBorder(null);
        back_patientreg4.setPreferredSize(new java.awt.Dimension(43, 16));
        back_patientreg4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_patientreg4ActionPerformed(evt);
            }
        });
        getContentPane().add(back_patientreg4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 50, 30));

        back_patientreg5.setBackground(new java.awt.Color(24, 87, 115));
        back_patientreg5.setForeground(new java.awt.Color(255, 255, 255));
        back_patientreg5.setText("Search");
        back_patientreg5.setBorder(null);
        back_patientreg5.setPreferredSize(new java.awt.Dimension(43, 16));
        back_patientreg5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_patientreg5ActionPerformed(evt);
            }
        });
        getContentPane().add(back_patientreg5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, 70, 30));

        pati_firstName17.setBackground(new java.awt.Color(191, 229, 246));
        pati_firstName17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pati_firstName17.setForeground(new java.awt.Color(24, 87, 115));
        pati_firstName17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pati_firstName17.setBorder(null);
        pati_firstName17.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        pati_firstName17.setMargin(new java.awt.Insets(4, 6, 4, 6));
        pati_firstName17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pati_firstName17ActionPerformed(evt);
            }
        });
        getContentPane().add(pati_firstName17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 130, 30));

        jLabel1.setBackground(new java.awt.Color(191, 229, 246));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AdminBG (948 x 836 px) (2).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 840));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_patientreg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientreg1ActionPerformed
        
        
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";
        int cc;

        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            String sql = "select * from registerpatient";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("patient_id"));
                String firstname = rs.getString("patient_firstName");
                String lastname = rs.getString("patient_lastName");
                String age = rs.getString("patient_age");
                String contact = rs.getString("patient_contact");
                String address = rs.getString("patient_address");
                String ailment = rs.getString("patient_ailment");
                String type = rs.getString("patient_type");

                String tbData[] = {id, firstname, lastname, age, contact, address, ailment, type};

                DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();

                tblModel.addRow(tbData);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_back_patientreg1ActionPerformed

    private void pati_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_contactActionPerformed

    private void pati_lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_lastNameActionPerformed

    private void pati_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_ageActionPerformed

    private void pati_allergiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_allergiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_allergiesActionPerformed

    private void pati_birthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_birthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_birthdayActionPerformed

    private void pati_firstName5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_firstName5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_firstName5ActionPerformed

    private void pati_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_addressActionPerformed

    private void pati_ailmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_ailmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_ailmentActionPerformed

    private void pati_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_typeActionPerformed

    private void pati_personEmergencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_personEmergencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_personEmergencyActionPerformed

    private void pati_contactEmergencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_contactEmergencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_contactEmergencyActionPerformed

    private void pati_bloodTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_bloodTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_bloodTypeActionPerformed

    private void pati_chronicConditionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_chronicConditionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_chronicConditionsActionPerformed

    private void pati_physicianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_physicianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_physicianActionPerformed

    private void pati_roomNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_roomNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_roomNumActionPerformed

    private void pati_admissionDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_admissionDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_admissionDateActionPerformed

    private void pati_admissionTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_admissionTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_admissionTimeActionPerformed

    private void delete_patientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_patientActionPerformed
        
        String patientID = PatientID_combo.getSelectedItem().toString();
    
        int response = JOptionPane.showConfirmDialog(this, "Are you sure to delete the data?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            String SUrl, SUser, SPass;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
                SUser = "root";
                SPass = "";

                Connection con = DriverManager.getConnection(SUrl, SUser, SPass);

                String query1 = "DELETE FROM registerpatient WHERE patient_id = ?";
                String query2 = "DELETE FROM inpatient WHERE patient_id = ?";
                String query3 = "DELETE FROM outpatient WHERE patient_id = ?";
                String query4 = "DELETE FROM finalizebills WHERE patient_id = ?";;

                DeleteDataArchive();
                
                PreparedStatement prep1 = con.prepareStatement(query1);
                prep1.setString(1, patientID);
                prep1.executeUpdate();

                PreparedStatement prep2 = con.prepareStatement(query2);
                prep2.setString(1, patientID);
                prep2.executeUpdate();

                PreparedStatement prep3 = con.prepareStatement(query3);
                prep3.setString(1, patientID);
                prep3.executeUpdate();
                
                PreparedStatement prep4 = con.prepareStatement(query4);
                prep4.setString(1, patientID);
                prep4.executeUpdate();

                JOptionPane.showMessageDialog(this, "Patient data successfully deleted.");

                prep1.close();
                prep2.close();
                prep3.close();
                prep4.close();
                con.close();

                pati_firstName17.setText("");
                pati_lastName.setText("");
                pati_personEmergency.setText("");
                pati_contactEmergency.setText("");
                pati_allergies.setText("");
                pati_chronicConditions.setText("");
                pati_physician.setText("");
                pati_admissionDate.setText("");
                pati_admissionTime.setText("");
                pati_allergies.setText("");
                pati_chronicConditions.setText("");
                pati_age.setText("");
                pati_birthday.setText("");
                pati_contact.setText("");
                pati_address.setText("");
                pati_ailment.setText("");
                pati_type.setText("");
                pati_bloodType.setText("");
                pati_roomNum.setText("");

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage());
            }
        }
        
    }//GEN-LAST:event_delete_patientActionPerformed

    private void search_patientIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_patientIDActionPerformed
    
        String patID = PatientID_combo.getSelectedItem().toString();
        String patient_ID, inOrOut;
        try {
            String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/hospitalsystem";
            String user = "root";
            String pass = "";

            String sql = "SELECT \n" +
            "    r.patient_id, \n" +
            "    r.patient_firstName, \n" +
            "    r.patient_lastName, \n" +
            "    r.patient_age, \n" +
            "    r.patient_birthday, \n" +
            "    r.patient_contact, \n" +
            "    r.patient_address, \n" +
            "    r.patient_ailment, \n" +
            "    r.patient_type, \n" +
            "    r.patient_blood,\n" +
            "    \n" +
            "    i.inpatient_contactEmer, \n" +
            "    i.inpatient_contactNumEmer, \n" +
            "    i.inpatient_room, \n" +
            "    i.inpatient_admissiondate, \n" +
            "    i.inpatient_admissiontime, \n" +
            "    i.inpatient_allergies AS inpatient_allergies, \n" +
            "    i.inpatient_chronic, \n" +
            "    i.inpatient_physician,\n" +
            "\n" +
            "    o.outpatient_contactEmer AS outpatient_contactEmer, \n" +
            "    o.outpatient_contactNumEmer AS outpatient_contactNumEmer, \n" +
            "    o.outpatient_allergies AS outpatient_allergies, \n" +
            "    o.outpatient_chronic, \n" +
            "    o.outpatient_physician\n" +
            "\n" +
            "FROM \n" +
            "    registerpatient r\n" +
            "\n" +
            "LEFT JOIN inpatient i ON r.patient_id = i.patient_id\n" +
            "LEFT JOIN outpatient o ON r.patient_id = o.patient_id;";
            

            Class.forName(JDBC_DRIVER);

            Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement prep = connection.prepareStatement(sql);

            ResultSet resultSet = prep.executeQuery();

            while(resultSet.next()) {
                patient_ID = resultSet.getString("patient_id");
                
                if(patient_ID.equals(patID)) {
                    inOrOut = resultSet.getString("patient_type");
                    
                    if("In Patient".equalsIgnoreCase(inOrOut)) {
                        
                        String roomNum = resultSet.getString("inpatient_room");
                        String date = resultSet.getString("inpatient_admissiondate");
                        String time = resultSet.getString("inpatient_admissiontime");
                        
                        String patient_allergies = resultSet.getString("inpatient_allergies");
                        String patient_chronic = resultSet.getString("inpatient_chronic");
                        String patient_physician = resultSet.getString("inpatient_physician");
                        
                        String patient_contactEmer = resultSet.getString("inpatient_contactEmer");
                        String patient_contactNumEmer = resultSet.getString("inpatient_contactNumEmer");

                        pati_roomNum.setText(roomNum);
                        pati_admissionDate.setText(date);
                        pati_admissionTime.setText(time);
                        
                        pati_allergies.setText(patient_allergies);
                        pati_chronicConditions.setText(patient_chronic);
                        pati_physician.setText(patient_physician);
                        
                        pati_personEmergency.setText(patient_contactEmer);
                        pati_contactEmergency.setText(patient_contactNumEmer);
                        
                    } else if("Out Patient".equalsIgnoreCase(inOrOut)) {
                        String patient_allergies = resultSet.getString("outpatient_allergies");
                        String patient_chronic = resultSet.getString("outpatient_chronic");
                        String patient_physician = resultSet.getString("outpatient_physician");
                        
                        String patient_contactEmer = resultSet.getString("outpatient_contactEmer");
                        String patient_contactNumEmer = resultSet.getString("outpatient_contactNumEmer");
                        
                        pati_allergies.setText(patient_allergies);
                        pati_chronicConditions.setText(patient_chronic);
                        pati_physician.setText(patient_physician);
                        
                        pati_personEmergency.setText(patient_contactEmer);
                        pati_contactEmergency.setText(patient_contactNumEmer);
                    }
                    
                    String patient_firstName = resultSet.getString("patient_firstName");
                    String patient_lastName = resultSet.getString("patient_lastName");
                    String patient_age = resultSet.getString("patient_age");
                    String patient_birthday = resultSet.getString("patient_birthday");
                    String patient_contact = resultSet.getString("patient_contact");
                    String patient_address = resultSet.getString("patient_address");
                    String patient_ailment = resultSet.getString("patient_ailment");
                    String patient_type = resultSet.getString("patient_type");
                    String patient_blood = resultSet.getString("patient_blood");
                    
                    
                    pati_firstName17.setText(patient_firstName);
                    pati_lastName.setText(patient_lastName);
                    pati_age.setText(patient_age);
                    pati_birthday.setText(patient_birthday);
                    pati_contact.setText(patient_contact);
                    pati_address.setText(patient_address);
                    pati_ailment.setText(patient_ailment);
                    pati_type.setText(patient_type);
                    pati_bloodType.setText(patient_blood);
                    
                    
                }
                
            }
            
        

        resultSet.close();
        prep.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
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
                
                Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
                
                String typeOfPatient = pati_type.getText();
                
                String patientID =  PatientID_combo.getSelectedItem().toString();   
                
                if(typeOfPatient.equals("In Patient")) {
                                    
                    String contactPerson = pati_personEmergency.getText();
                    String contactNumberPerson = pati_contactEmergency.getText();
                    String room = pati_roomNum.getText();
                    
                    String admissiondate = pati_admissionDate.getText();
                    String admissiontime = pati_admissionTime.getText();
                    
                    String allergies = pati_allergies.getText();
                    String chronic = pati_chronicConditions.getText();
                    String physician = pati_physician.getText();
                    
                    String firstname = pati_firstName17.getText();
                    String lastname = pati_lastName.getText();
                    
                    
                    String updateQuery = "UPDATE inpatient SET patient_firstName = ?, patient_lastName = ?, inpatient_contactEmer = ?, inpatient_contactNumEmer = ?, inpatient_room = ?, inpatient_admissiondate = ?, inpatient_admissiontime = ?, inpatient_allergies = ?, inpatient_chronic = ?, inpatient_physician = ? WHERE patient_id = ?";
                    
                    PreparedStatement inPatientStmt = con.prepareStatement(updateQuery);
                    
                    inPatientStmt.setString(1, firstname);
                    inPatientStmt.setString(2, lastname);
                    inPatientStmt.setString(3, contactPerson);
                    inPatientStmt.setString(4, contactNumberPerson);
                    inPatientStmt.setString(5, room);
                    inPatientStmt.setString(6, admissiondate);
                    inPatientStmt.setString(7, admissiontime);
                    inPatientStmt.setString(8, allergies);
                    inPatientStmt.setString(9, chronic);
                    inPatientStmt.setString(10, physician);
                    inPatientStmt.setString(11, patientID);
                    inPatientStmt.executeUpdate();
                    inPatientStmt.close();
                    
                    UpdateDataArchive();
                    
                } else if(typeOfPatient.equals("Out Patient")) {
                    
                    String firstname = pati_firstName17.getText();
                    String lastname = pati_lastName.getText();
                    String contactPerson = pati_personEmergency.getText();
                    String contactNumberPerson = pati_contactEmergency.getText();
                    String allergies = pati_allergies.getText();
                    String chronic = pati_chronicConditions.getText();
                    String physician = pati_physician.getText();

                    String updateQuery = "UPDATE outpatient SET patient_firstName = ?, patient_lastName = ?, outpatient_contactEmer = ?, outpatient_contactNumEmer = ?, outpatient_allergies = ?, outpatient_chronic = ?, outpatient_physician = ? WHERE patient_id = ?";
                    
                    PreparedStatement inPatientStmt = con.prepareStatement(updateQuery);
                    
                    inPatientStmt.setString(1, firstname);
                    inPatientStmt.setString(2, lastname);
                    inPatientStmt.setString(3, contactPerson);
                    inPatientStmt.setString(4, contactNumberPerson);
                    inPatientStmt.setString(5, allergies);
                    inPatientStmt.setString(6, chronic);
                    inPatientStmt.setString(7, physician);
                    inPatientStmt.setString(8, patientID);
                    
                    inPatientStmt.executeUpdate();
                    inPatientStmt.close();
                    
                    UpdateDataArchive();
                }

                String firstname = pati_firstName17.getText();
                String lastname = pati_lastName.getText();
                String age = pati_age.getText();
                String birthday = pati_birthday.getText();
                String contact = pati_contact.getText();
                
                String address = pati_address.getText();
                String ailment = pati_ailment.getText();
                String type = pati_type.getText();
                String blood = pati_bloodType.getText();
                
                String updateQuery = "UPDATE registerpatient SET patient_firstName = ?, patient_lastName = ?, patient_age = ?, patient_birthday = ?, patient_contact = ?, patient_address = ?, patient_ailment = ?, patient_type = ?, patient_blood = ? WHERE patient_id = ?";

                    
                PreparedStatement inPatientStmt = con.prepareStatement(updateQuery);

                inPatientStmt.setString(1, firstname);
                inPatientStmt.setString(2, lastname);
                inPatientStmt.setString(3, age);
                inPatientStmt.setString(4, birthday);
                inPatientStmt.setString(5, contact);
                inPatientStmt.setString(6, address);
                inPatientStmt.setString(7, ailment);
                inPatientStmt.setString(8, type);
                inPatientStmt.setString(9, blood);
                inPatientStmt.setString(10, patientID);

                inPatientStmt.executeUpdate();
                inPatientStmt.close();
                
                
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(response == JOptionPane.NO_OPTION) {
            
        } 

        pati_firstName17.setText("");
        pati_lastName.setText("");
        pati_personEmergency.setText("");
        pati_contactEmergency.setText("");
        pati_allergies.setText("");
        pati_chronicConditions.setText("");
        pati_physician.setText("");
        pati_admissionDate.setText("");
        pati_admissionTime.setText("");
        pati_allergies.setText("");
        pati_chronicConditions.setText("");
        pati_age.setText("");
        pati_birthday.setText("");
        pati_contact.setText("");
        pati_address.setText("");
        pati_ailment.setText("");
        pati_type.setText("");
        pati_bloodType.setText("");
        pati_roomNum.setText("");
        
    }//GEN-LAST:event_update_patientActionPerformed

    private void back_patientreg4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientreg4ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_back_patientreg4ActionPerformed

    private void back_patientreg5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientreg5ActionPerformed
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";

        String keyword = pati_firstName5.getText();
        
        String query = "SELECT * FROM registerpatient\n" +
        "WHERE patient_id LIKE '%" + keyword + "%' \n" +
        "   OR patient_firstName LIKE '%" + keyword + "%' \n" +
        "   OR patient_lastName LIKE '%" + keyword + "%' \n";
        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                
                model.setRowCount(0);
                
                String id = String.valueOf(rs.getInt("patient_id"));
                String firstname = rs.getString("patient_firstName");
                String lastname = rs.getString("patient_lastName");
                String age = rs.getString("patient_age");
                String contact = rs.getString("patient_contact");
                String address = rs.getString("patient_address");
                String ailment = rs.getString("patient_ailment");
                String type = rs.getString("patient_type");

                String tbData[] = {id, firstname, lastname, age, contact, address, ailment, type};

                model.addRow(tbData);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_back_patientreg5ActionPerformed

    private void pati_firstName17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pati_firstName17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pati_firstName17ActionPerformed

    private void PatientID_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientID_comboActionPerformed
    }//GEN-LAST:event_PatientID_comboActionPerformed

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
            java.util.logging.Logger.getLogger(PatientManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> PatientID_combo;
    private javax.swing.JButton back_patientreg1;
    private javax.swing.JButton back_patientreg4;
    private javax.swing.JButton back_patientreg5;
    private javax.swing.JButton delete_patient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pati_address;
    private javax.swing.JTextField pati_admissionDate;
    private javax.swing.JTextField pati_admissionTime;
    private javax.swing.JTextField pati_age;
    private javax.swing.JTextField pati_ailment;
    private javax.swing.JTextField pati_allergies;
    private javax.swing.JTextField pati_birthday;
    private javax.swing.JTextField pati_bloodType;
    private javax.swing.JTextField pati_chronicConditions;
    private javax.swing.JTextField pati_contact;
    private javax.swing.JTextField pati_contactEmergency;
    private javax.swing.JTextField pati_firstName17;
    private javax.swing.JTextField pati_firstName5;
    private javax.swing.JTextField pati_lastName;
    private javax.swing.JTextField pati_personEmergency;
    private javax.swing.JTextField pati_physician;
    private javax.swing.JTextField pati_roomNum;
    private javax.swing.JTextField pati_type;
    private javax.swing.JButton search_patientID;
    private javax.swing.JButton update_patient;
    // End of variables declaration//GEN-END:variables
}
