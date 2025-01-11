
package hospitalsystem;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PatientView extends javax.swing.JFrame {


    private DoctorDashboard doctorDashboard;
    private AdminDashboard adminDashboard;
    private PatientView patientview;
    private AccountingDashboard accountingDashboard;
   
    
    public PatientView(DoctorDashboard doctorDashboard) {
        this.doctorDashboard = doctorDashboard;
        initComponents();
        
        //clicks button for values in patient view
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                
                view_allpatientsActionPerformed(null);
            }
        });
    }

    public PatientView(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
        initComponents();
        
        //clicks button for values in patient view
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                
                view_allpatientsActionPerformed(null);
            }
        });
    }
    
    public PatientView(AccountingDashboard accountingDashboard) {
        this.accountingDashboard = accountingDashboard;
        initComponents();
        
        //clicks button for values in patient view
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                
                view_allpatientsActionPerformed(null);
            }
        });
    }
    
    public PatientView() {
        initComponents();
        
        //clicks button for values in patient view
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                
                view_allpatientsActionPerformed(null);
            }
        });
      
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back_patientreg = new javax.swing.JButton();
        view_allpatients = new javax.swing.JButton();
        searchField_allPatients = new javax.swing.JTextField();
        search_allPatient = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

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
        jLabel4.setText("View Patients");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 490, -1));

        jTable1.setBackground(new java.awt.Color(191, 229, 246));
        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(24, 87, 115));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(35);
        jTable1.setSelectionBackground(new java.awt.Color(24, 87, 115));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 600, 510));

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

        view_allpatients.setBackground(new java.awt.Color(204, 204, 204));
        view_allpatients.setText("View");
        view_allpatients.setBorder(null);
        view_allpatients.setPreferredSize(new java.awt.Dimension(43, 16));
        view_allpatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_allpatientsActionPerformed(evt);
            }
        });
        getContentPane().add(view_allpatients, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 60, 30));

        searchField_allPatients.setForeground(new java.awt.Color(102, 102, 102));
        searchField_allPatients.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        searchField_allPatients.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        searchField_allPatients.setMargin(new java.awt.Insets(4, 6, 4, 6));
        searchField_allPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchField_allPatientsActionPerformed(evt);
            }
        });
        getContentPane().add(searchField_allPatients, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 130, 20));

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
        getContentPane().add(search_allPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 70, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Patients", "In Patient", "Out Patient", "Discharged" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 708));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inPatientSearch(DefaultTableModel model, String keyword) {
    String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
    String SUser = "root";
    String SPass = "";

    String keywords = searchField_allPatients.getText();
    
    DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
    
        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            String sql = "SELECT \n" +
                "    inpatient.inpatient_count,\n" +
                "    inpatient.patient_id,\n" +
                "    inpatient.patient_firstName AS inpatient_firstName,\n" +
                "    inpatient.patient_lastName AS inpatient_lastName,\n" +
                "    inpatient.inpatient_contactEmer,\n" +
                "    inpatient.inpatient_contactNumEmer,\n" +
                "    inpatient.inpatient_room,\n" +
                "    inpatient.inpatient_admissiondate,\n" +
                "    inpatient.inpatient_admissiontime,\n" +
                "    inpatient.inpatient_allergies,\n" +
                "    inpatient.inpatient_chronic,\n" +
                "    inpatient.inpatient_physician,\n" +
                "    registerpatient.patient_firstName AS registerpatient_firstName,\n" +
                "    registerpatient.patient_lastName AS registerpatient_lastName,\n" +
                "    registerpatient.patient_age,\n" +
                "    registerpatient.patient_birthday,\n" +
                "    registerpatient.patient_contact,\n" +
                "    registerpatient.patient_address,\n" +
                "    registerpatient.patient_ailment,\n" +
                "    registerpatient.patient_type,\n" +
                "    registerpatient.patient_blood\n" +
                "FROM \n" +
                "    registerpatient\n" +
                "RIGHT JOIN \n" +
                "    inpatient\n" +
                "ON \n" +
                "    registerpatient.patient_id = inpatient.patient_id\n" + 
                "WHERE \n" +
                "    registerpatient.patient_id LIKE '%" + keywords + "%' \n" +
                "    OR inpatient.patient_firstName LIKE '%" + keywords + "%' \n" +
                "    OR inpatient.patient_lastName LIKE '%" + keywords + "%';";

            ResultSet rs = st.executeQuery(sql);

            tblModel.setRowCount(0);

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("patient_id"));
                String firstname = rs.getString("inpatient_firstName");
                String lastname = rs.getString("inpatient_lastName");
                String ailment = rs.getString("patient_ailment");
                String room = rs.getString("inpatient_room");
                String time = rs.getString("inpatient_admissiontime");
                String date = rs.getString("inpatient_admissiondate");

                String tbData[] = {id, firstname, lastname, ailment, room, date, time};

                tblModel.addRow(tbData);

                model = tblModel;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void outPatientSearch(DefaultTableModel model, String keyword) {
    String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
    String SUser = "root";
    String SPass = "";
    int cc;

    DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
    
    String keywords = searchField_allPatients.getText();
    
    try {
        Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
        Statement st = con.createStatement();
        String sql = "SELECT \n" +
            "    outpatient.outpatient_count,\n" +
            "    outpatient.patient_id,\n" +
            "    outpatient.patient_firstName AS outpatient_firstName,\n" +
            "    outpatient.patient_lastName AS outpatient_lastName,\n" +
            "    outpatient.outpatient_contactEmer,\n" +
            "    outpatient.outpatient_contactNumEmer,\n" +
            "    outpatient.outpatient_allergies,\n" +
            "    outpatient.outpatient_chronic,\n" +
            "    outpatient.outpatient_physician,\n" +
            "    registerpatient.patient_firstName AS registerpatient_firstName,\n" +
            "    registerpatient.patient_lastName AS registerpatient_lastName,\n" +
            "    registerpatient.patient_age,\n" +
            "    registerpatient.patient_birthday,\n" +
            "    registerpatient.patient_contact,\n" +
            "    registerpatient.patient_address,\n" +
            "    registerpatient.patient_ailment,\n" +
            "    registerpatient.patient_type,\n" +
            "    registerpatient.patient_blood\n" +
            "FROM \n" +
            "    registerpatient\n" +
            "RIGHT JOIN \n" +
            "    outpatient\n" +
            "ON \n" +
            "    registerpatient.patient_id = outpatient.patient_id\n" +
            "WHERE \n" +
            "    registerpatient.patient_id LIKE '%" + keywords + "%' \n" +
            "    OR outpatient.patient_firstName LIKE '%" + keywords + "%' \n" +
            "    OR outpatient.patient_lastName LIKE '%" + keywords + "%';"; 

        ResultSet rs = st.executeQuery(sql);
        tblModel.setRowCount(0);
        
        while (rs.next()) {
            String id = String.valueOf(rs.getInt("patient_id"));
            String firstname = rs.getString("outpatient_firstName");
            String lastname = rs.getString("outpatient_lastName");
            String ailment = rs.getString("patient_ailment");
            String physician = rs.getString("outpatient_physician");

            String tbData[] = {id, firstname, lastname, ailment, physician};
            
            tblModel.addRow(tbData);
            
            model = tblModel;
        }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void dischargePatientSearch(DefaultTableModel model, String keyword) {
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";
        int cc;

        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        
        String keywords = searchField_allPatients.getText();
        
        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            String sql = "SELECT * from dischargepatient where patient_id LIKE '%" + keywords + "%' \n" +
        "   OR patient_firstName LIKE '%" + keywords + "%' \n" +
        "   OR patient_lastName LIKE '%" + keywords + "%' \n";

            ResultSet rs = st.executeQuery(sql);

            tblModel.setRowCount(0);
            
            while (rs.next()) {
                
                String id = String.valueOf(rs.getInt("patient_id"));
                String firstname = rs.getString("patient_firstName");
                String lastname = rs.getString("patient_lastName");
                String dischargeDate = rs.getString("discharge_date");

                String tbData[] = {id, firstname, lastname, dischargeDate};
                
                tblModel.addRow(tbData);
                
                model = tblModel;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void allPatientSearch(DefaultTableModel model, String keyword) {
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";
        int cc;

        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        
        String keywords = searchField_allPatients.getText();
        
        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();

            String sql2 = "select * from registerpatient where patient_id LIKE '%" + keywords + "%' \n" +
        "   OR patient_firstName LIKE '%" + keywords + "%' \n" +
        "   OR patient_lastName LIKE '%" + keywords + "%' \n";

            ResultSet rs2 = st.executeQuery(sql2);

            tblModel.setRowCount(0);
            
            while (rs2.next()) {
                String id = String.valueOf(rs2.getInt("patient_id"));
                String firstname = rs2.getString("patient_firstName");
                String lastname = rs2.getString("patient_lastName");
                String ailment = rs2.getString("patient_ailment");
                String age = rs2.getString("patient_age");
                String type = rs2.getString("patient_type");

                String tbData[] = {id, firstname, lastname, ailment, age, type};

                tblModel.addRow(tbData);
                
                model = tblModel;
                keyword = keywords;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void dischargePatient(DefaultTableModel model) {
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";
        int cc;

        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        
        
        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            String sql = "SELECT * from dischargepatient";

            ResultSet rs = st.executeQuery(sql);

            tblModel.setRowCount(0);
            
            while (rs.next()) {
                
                String id = String.valueOf(rs.getInt("patient_id"));
                String firstname = rs.getString("patient_firstName");
                String lastname = rs.getString("patient_lastName");
                String dischargeDate = rs.getString("discharge_date");

                String tbData[] = {id, firstname, lastname, dischargeDate};
                
                tblModel.addRow(tbData);
                
                model = tblModel;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void outPatient(DefaultTableModel model) {
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";
        int cc;

        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        
        
        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            String sql = "SELECT \n" +
                "    outpatient.outpatient_count,\n" +
                "    outpatient.patient_id,\n" +
                "    outpatient.patient_firstName AS outpatient_firstName,\n" +
                "    outpatient.patient_lastName AS outpatient_lastName,\n" +
                "    outpatient.outpatient_contactEmer,\n" +
                "    outpatient.outpatient_contactNumEmer,\n" +
                "    outpatient.outpatient_allergies,\n" +
                "    outpatient.outpatient_chronic,\n" +
                "    outpatient.outpatient_physician,\n" +
                "    registerpatient.patient_firstName AS registerpatient_firstName,\n" +
                "    registerpatient.patient_lastName AS registerpatient_lastName,\n" +
                "    registerpatient.patient_age,\n" +
                "    registerpatient.patient_birthday,\n" +
                "    registerpatient.patient_contact,\n" +
                "    registerpatient.patient_address,\n" +
                "    registerpatient.patient_ailment,\n" +
                "    registerpatient.patient_type,\n" +
                "    registerpatient.patient_blood\n" +
                "FROM \n" +
                "    registerpatient\n" +
                "RIGHT JOIN \n" +
                "    outpatient\n" +
                "ON \n" +
                "    registerpatient.patient_id = outpatient.patient_id;";

            ResultSet rs = st.executeQuery(sql);

            tblModel.setRowCount(0);
            
            while (rs.next()) {
                
                String id = String.valueOf(rs.getInt("patient_id"));
                String firstname = rs.getString("outpatient_firstName");
                String lastname = rs.getString("outpatient_lastName");
                String ailment = rs.getString("patient_ailment");
                String physician = rs.getString("outpatient_physician");

                String tbData[] = {id, firstname, lastname, ailment, physician};
                
                tblModel.addRow(tbData);
                
                model = tblModel;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void allPatient(DefaultTableModel model) {
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";
        int cc;

        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        
        
        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            String sql = "select * from registerpatient";

            ResultSet rs = st.executeQuery(sql);

            tblModel.setRowCount(0);
            
            while (rs.next()) {
                
                String id = String.valueOf(rs.getInt("patient_id"));
                String firstname = rs.getString("patient_firstName");
                String lastname = rs.getString("patient_lastName");
                String ailment = rs.getString("patient_ailment");
                String age = rs.getString("patient_age");
                String type = rs.getString("patient_type");

                String tbData[] = {id, firstname, lastname, ailment, age, type};

                

                tblModel.addRow(tbData);
                
                model = tblModel;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void inPatient(DefaultTableModel model) {
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";
        int cc;

        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        
        
        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            String sql = "SELECT \n" +
                "    inpatient.inpatient_count,\n" +
                "    inpatient.patient_id,\n" +
                "    inpatient.patient_firstName AS inpatient_firstName,\n" +
                "    inpatient.patient_lastName AS inpatient_lastName,\n" +
                "    inpatient.inpatient_contactEmer,\n" +
                "    inpatient.inpatient_contactNumEmer,\n" +
                "    inpatient.inpatient_room,\n" +
                "    inpatient.inpatient_admissiondate,\n" +
                "    inpatient.inpatient_admissiontime,\n" +
                "    inpatient.inpatient_allergies,\n" +
                "    inpatient.inpatient_chronic,\n" +
                "    inpatient.inpatient_physician,\n" +
                "    registerpatient.patient_firstName AS registerpatient_firstName,\n" +
                "    registerpatient.patient_lastName AS registerpatient_lastName,\n" +
                "    registerpatient.patient_age,\n" +
                "    registerpatient.patient_birthday,\n" +
                "    registerpatient.patient_contact,\n" +
                "    registerpatient.patient_address,\n" +
                "    registerpatient.patient_ailment,\n" +
                "    registerpatient.patient_type,\n" +
                "    registerpatient.patient_blood\n" +
                "FROM \n" +
                "    registerpatient\n" +
                "RIGHT JOIN \n" +
                "    inpatient\n" +
                "ON \n" +
                "    registerpatient.patient_id = inpatient.patient_id;";

            ResultSet rs = st.executeQuery(sql);

            tblModel.setRowCount(0);
            
            while (rs.next()) {
                
                String id = String.valueOf(rs.getInt("patient_id"));
                String firstname = rs.getString("inpatient_firstName");
                String lastname = rs.getString("inpatient_lastName");
                String ailment = rs.getString("patient_ailment");
                String room = rs.getString("inpatient_room");
                String time = rs.getString("inpatient_admissiontime");
                String date = rs.getString("inpatient_admissiondate");

                String tbData[] = {id, firstname, lastname, ailment, room, date, time};

                

                tblModel.addRow(tbData);
                
                model = tblModel;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void back_patientregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientregActionPerformed

        this.setVisible(false);

        if (doctorDashboard != null) {
            doctorDashboard.setVisible(true);
        } else if (adminDashboard != null) {
            adminDashboard.setVisible(true);
        } else if(accountingDashboard != null) {
            accountingDashboard.setVisible(true);
        }

    }//GEN-LAST:event_back_patientregActionPerformed

    private void view_allpatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_allpatientsActionPerformed
        
        String value = jComboBox1.getSelectedItem().toString();
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        if(value.equals("All Patients")) {
            
            model.setRowCount(0);
            model.setColumnCount(0);
            
            model.addColumn("Patient ID");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Ailment");
            model.addColumn("Age");
            model.addColumn("Patient Type");    
            
            allPatient(model);
        
        } else if(value.equals("In Patient")) {
            
            model.setRowCount(0);
            model.setColumnCount(0);
            
            model.addColumn("Patient ID");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Ailment");
            model.addColumn("Room");
            model.addColumn("Admission Date"); 
            model.addColumn("Admission Time"); 
            
            inPatient(model);
            
        } else if(value.equals("Out Patient")) {
            
            model.setRowCount(0);
            model.setColumnCount(0);
            
            model.addColumn("Patient ID");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Ailment");
            model.addColumn("Physician");
            
            outPatient(model);
            
        } else if(value.equals("Discharged")) {
            
            model.setRowCount(0);
            model.setColumnCount(0);
            
            model.addColumn("Patient ID");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Discharge Date");
            
            dischargePatient(model);

        }
    }//GEN-LAST:event_view_allpatientsActionPerformed

    private void searchField_allPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchField_allPatientsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchField_allPatientsActionPerformed

    private void search_allPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_allPatientActionPerformed

        String keywords = searchField_allPatients.getText();
        String value = jComboBox1.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        if(value.equals("All Patients")) {
            allPatientSearch(model, keywords);
        } else if(value.equals("Discharged")) {
            dischargePatientSearch(model, keywords);
        } else if(value.equals("In Patient")) {
            inPatientSearch(model, keywords);
        } else if(value.equals("Out Patient")) {
            outPatientSearch(model, keywords);
        }
             
    }//GEN-LAST:event_search_allPatientActionPerformed

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
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_patientreg;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchField_allPatients;
    private javax.swing.JButton search_allPatient;
    private javax.swing.JButton view_allpatients;
    // End of variables declaration//GEN-END:variables
}
