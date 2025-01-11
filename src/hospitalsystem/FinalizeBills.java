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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class FinalizeBills extends javax.swing.JFrame {

    private DoctorDashboard doctorDashboard;
    private AdminDashboard adminDashboard;
    private AccountingDashboard accountingDashboard;
    private PatientView patientview;
   
    public void addAdmission_Discharge(int id, String admission, String discharge) {
        String url = "jdbc:mysql://localhost:3306/hospitalsystem";
        String user = "root";
        String pass = "";
        
        String updateQuery = "UPDATE finalizebills SET date_admission = ?, date_discharge = ? WHERE patient_id = ?";
        
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            pstmt.setString(1, admission); 
            pstmt.setString(2, discharge);
            pstmt.setInt(3, id);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Table updated successfully.");
            } else {
                System.out.println("No rows were updated. Please check the ID.");
            }
            
        } catch (Exception e) {
        }

        
    }
    
    public FinalizeBills(DoctorDashboard doctorDashboard) {
        this.doctorDashboard = doctorDashboard;
        initComponents();
        PopulateComboBox();
    }

    // Constructor for Admins
    public FinalizeBills(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
        initComponents();
        PopulateComboBox();
    }
    
    // Constructor for Admins
    public FinalizeBills(AccountingDashboard accountingDashboard) {
        this.accountingDashboard = accountingDashboard;
        initComponents();
        PopulateComboBox();
    }
    public FinalizeBills() {
        initComponents();
        PopulateComboBox();
    }
    
    public void ClearValues() {
        jTextField2.setText("");
        jTextField1.setText("");
        jTextField4.setText("");

        jTextField5.setText("");
        jTextField15.setText("");
        jTextField3.setText("");

        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");

        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");

        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("");

        jTextField16.setText("");
    }

    private void AddBalance() {
        
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";

        String query1 = "SELECT patient_firstName, patient_lastName, final_total FROM finalizebills WHERE patient_id = ?";
        String query2 = "INSERT INTO patientbalances (patient_id, patient_firstName, patient_lastName, balance, outstanding_balance) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "patient_firstName = VALUES(patient_firstName), " +
                "patient_lastName = VALUES(patient_lastName), " +
                "balance = VALUES(balance), " +
                "outstanding_balance = VALUES(outstanding_balance)";


        try (Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
             PreparedStatement pstmt1 = con.prepareStatement(query1);
             PreparedStatement pstmt2 = con.prepareStatement(query2)) {

            String patientID = PatientID_combo.getSelectedItem().toString();
            pstmt1.setString(1, patientID);

            try (ResultSet rs = pstmt1.executeQuery()) {
                if (rs.next()) {
                    String patient_firstname = rs.getString("patient_firstName");
                    String patient_lastname = rs.getString("patient_lastName");
                    String patient_balance = rs.getString("final_total");

                    pstmt2.setString(1, patientID);
                    pstmt2.setString(2, patient_firstname);
                    pstmt2.setString(3, patient_lastname);
                    pstmt2.setString(4, patient_balance);
                    pstmt2.setString(5, patient_balance);

                    int rowsInserted = pstmt2.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Balance added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to add balance.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No records found for the selected patient ID.", "No Data", JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void SetValues() {
        double roomcharge_quantity = parseDoubleOrDefault(jTextField2.getText(), 0.0);
        double roomcharge_unit = parseDoubleOrDefault(jTextField1.getText(), 0.0);
        double roomcharge_total = parseDoubleOrDefault(jTextField4.getText(), 0.0);

        double roomcharge_finalTotal = roomcharge_quantity * roomcharge_unit;
        jTextField4.setText(String.valueOf(roomcharge_finalTotal));

        double physician_quantity = parseDoubleOrDefault(jTextField5.getText(), 0.0);
        double physician_price = parseDoubleOrDefault(jTextField15.getText(), 0.0);
        double physician_total = parseDoubleOrDefault(jTextField3.getText(), 0.0);

        double physician_finalTotal = physician_quantity * physician_price;
        jTextField3.setText(String.valueOf(physician_finalTotal));

        double labtest_quant = parseDoubleOrDefault(jTextField6.getText(), 0.0);
        double labtest_price = parseDoubleOrDefault(jTextField7.getText(), 0.0);
        double labtest_total = parseDoubleOrDefault(jTextField8.getText(), 0.0);

        double labtest_finalTotal = labtest_quant * labtest_price;
        jTextField8.setText(String.valueOf(labtest_finalTotal));

        double surgery_quantity = parseDoubleOrDefault(jTextField9.getText(), 0.0);
        double surgery_price = parseDoubleOrDefault(jTextField10.getText(), 0.0);
        double surgery_total = parseDoubleOrDefault(jTextField11.getText(), 0.0);

        double surgery_finalTotal = surgery_quantity * surgery_price;
        jTextField11.setText(String.valueOf(surgery_finalTotal));

        double nursing_quantity = parseDoubleOrDefault(jTextField12.getText(), 0.0);
        double nursing_price = parseDoubleOrDefault(jTextField13.getText(), 0.0);
        double nursing_total = parseDoubleOrDefault(jTextField14.getText(), 0.0);

        double nursing_finalTotal = nursing_quantity * nursing_price;
        jTextField14.setText(String.valueOf(nursing_finalTotal));

        double final_total = roomcharge_finalTotal + physician_finalTotal + labtest_finalTotal + surgery_finalTotal + nursing_finalTotal;
        jTextField16.setText(String.valueOf(final_total));
    }

    private double parseDoubleOrDefault(String value, double defaultValue) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private void UpdateValues() {
        
        String patID = PatientID_combo.getSelectedItem().toString();
        
        try {
            String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/hospitalsystem";
            String user = "root";
            String pass = "";
          
            String query = "SELECT * from finalizebills WHERE patient_ID = " + patID+ " ";
            
            Class.forName(JDBC_DRIVER);

            Connection connection = DriverManager.getConnection(url, user, pass);

            PreparedStatement prep = connection.prepareStatement(query);

            ResultSet resultSet = prep.executeQuery();

            while(resultSet.next()) {
                String patient_ID = resultSet.getString("patient_id");
                
                    if(patient_ID.equals(patID)) {
                        
                        String roomcharge_quant = resultSet.getString("roomcharge_quant");
                        String roomcharge_price = resultSet.getString("roomcharge_quant");
                        String roomcharge_total = resultSet.getString("roomcharge_quant");
                        
                        String physicianfee_quant = resultSet.getString("physicianfee_quant");
                        String physicianfee_price = resultSet.getString("physicianfee_price");
                        String physicianfee_total = resultSet.getString("physicianfee_total");
                        
                        String labtest_quant = resultSet.getString("labtest_quant");
                        String labtest_price = resultSet.getString("labtest_price");
                        String labtest_total = resultSet.getString("labtest_total");
                        
                        String surgery_quant = resultSet.getString("surgery_quant");
                        String surgery_price = resultSet.getString("surgery_price");
                        String surgery_total = resultSet.getString("surgery_total");
                        
                        String nursing_quant = resultSet.getString("nursing_quant");
                        String nursing_price = resultSet.getString("nursing_price");
                        String nursing_total = resultSet.getString("nursing_total");
                        String final_total = resultSet.getString("final_total");
                        
                        jTextField2.setText(roomcharge_quant);
                        jTextField1.setText(roomcharge_price);
                        jTextField4.setText(roomcharge_total);
                        
                        jTextField5.setText(physicianfee_quant);
                        jTextField15.setText(physicianfee_price);
                        jTextField3.setText(physicianfee_total);
                        
                        jTextField6.setText(labtest_quant);
                        jTextField7.setText(labtest_price);
                        jTextField8.setText(labtest_total);
                        
                        jTextField9.setText(surgery_quant);
                        jTextField10.setText(surgery_price);
                        jTextField11.setText(surgery_total);
                        
                        jTextField12.setText(nursing_quant);
                        jTextField13.setText(nursing_price);
                        jTextField14.setText(nursing_total);
                        
                        jTextField16.setText(final_total);

                    }
            }
            
        } catch (Exception e) {
            
        }
         
    }
    
    /*private void SetValues() {
        
        int roomcharge_quantity = parseIntOrDefault(jTextField2.getText(), 0);
        int roomcharge_unit = parseIntOrDefault(jTextField1.getText(), 0);
        int roomcharge_total = parseIntOrDefault(jTextField4.getText(), 0);

        int roomcharge_finalTotal = roomcharge_quantity * roomcharge_unit;
        jTextField4.setText(String.valueOf(roomcharge_finalTotal));

        int physician_quantity = parseIntOrDefault(jTextField5.getText(), 0);
        int physician_price = parseIntOrDefault(jTextField15.getText(), 0);
        int physician_total = parseIntOrDefault(jTextField3.getText(), 0);

        int physician_finalTotal = physician_quantity * physician_price;
        jTextField3.setText(String.valueOf(physician_finalTotal));

        int labtest_quant = parseIntOrDefault(jTextField6.getText(), 0);
        int labtest_price = parseIntOrDefault(jTextField7.getText(), 0);
        int labtest_total = parseIntOrDefault(jTextField8.getText(), 0);

        int labtest_finalTotal = labtest_quant * labtest_price;
        jTextField8.setText(String.valueOf(labtest_finalTotal));

        int surgery_quantity = parseIntOrDefault(jTextField9.getText(), 0);
        int surgery_price = parseIntOrDefault(jTextField10.getText(), 0);
        int surgery_total = parseIntOrDefault(jTextField11.getText(), 0);

        int surgery_finalTotal = surgery_quantity * surgery_price;
        jTextField11.setText(String.valueOf(surgery_finalTotal));

        int nursing_quantity = parseIntOrDefault(jTextField12.getText(), 0);
        int nursing_price = parseIntOrDefault(jTextField13.getText(), 0);
        int nursing_total = parseIntOrDefault(jTextField14.getText(), 0);

        int nursing_finalTotal = nursing_quantity * nursing_price;
        jTextField14.setText(String.valueOf(nursing_finalTotal));

        // Compute final total
        double final_total = roomcharge_finalTotal + physician_finalTotal + labtest_finalTotal + surgery_finalTotal + nursing_finalTotal;
        jTextField16.setText(String.valueOf(final_total));
        
}*/
    
    private void uploadValues() {
        String pat_id, pat_firstName, pat_lastName;
        int roomcharge_quant = 0, physicianfee_quant = 0, labtest_quant = 0, surgery_quant = 0, nursing_quant = 0;
        double roomcharge_price = 0.0, roomcharge_total = 0.0, physicianfee_price = 0.0, physicianfee_total = 0.0;
        double labtest_price = 0.0, labtest_total = 0.0, surgery_price = 0.0, surgery_total = 0.0;
        double nursing_price = 0.0, nursing_total = 0.0, final_total_reveal = 0.0;

        try {
            // Ensure Patient ID is selected
            pat_id = PatientID_combo.getSelectedItem() != null ? PatientID_combo.getSelectedItem().toString() : "";
            if (pat_id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a valid Patient ID.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Retrieve text input with validation
            pat_firstName = firstname.getText().trim();
            pat_lastName = lastname.getText().trim();

            // Parse all text fields safely
            roomcharge_quant = parseIntOrDefault(jTextField2.getText().trim(), 0);
            roomcharge_price = parseDoubleOrDefault(jTextField1.getText().trim(), 0.0);
            roomcharge_total = parseDoubleOrDefault(jTextField4.getText().trim(), 0.0);

            physicianfee_quant = parseIntOrDefault(jTextField5.getText().trim(), 0);
            physicianfee_price = parseDoubleOrDefault(jTextField15.getText().trim(), 0.0);
            physicianfee_total = parseDoubleOrDefault(jTextField3.getText().trim(), 0.0);

            labtest_quant = parseIntOrDefault(jTextField6.getText().trim(), 0);
            labtest_price = parseDoubleOrDefault(jTextField7.getText().trim(), 0.0);
            labtest_total = parseDoubleOrDefault(jTextField8.getText().trim(), 0.0);

            surgery_quant = parseIntOrDefault(jTextField9.getText().trim(), 0);
            surgery_price = parseDoubleOrDefault(jTextField10.getText().trim(), 0.0);
            surgery_total = parseDoubleOrDefault(jTextField11.getText().trim(), 0.0);

            nursing_quant = parseIntOrDefault(jTextField12.getText().trim(), 0);
            nursing_price = parseDoubleOrDefault(jTextField13.getText().trim(), 0.0);
            nursing_total = parseDoubleOrDefault(jTextField14.getText().trim(), 0.0);

            final_total_reveal = parseDoubleOrDefault(jTextField16.getText().trim(), 0.0);

            // SQL query
            String query = "INSERT INTO finalizebills (patient_id, patient_firstName, patient_lastName, roomcharge_quant, roomcharge_price, roomcharge_total, "
                    + "physicianfee_quant, physicianfee_price, physicianfee_total, labtest_quant, labtest_price, labtest_total, "
                    + "surgery_quant, surgery_price, surgery_total, nursing_quant, nursing_price, nursing_total, final_total) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE patient_firstName = VALUES(patient_firstName), "
                    + "patient_lastName = VALUES(patient_lastName), roomcharge_quant = VALUES(roomcharge_quant), "
                    + "roomcharge_price = VALUES(roomcharge_price), roomcharge_total = VALUES(roomcharge_total), "
                    + "physicianfee_quant = VALUES(physicianfee_quant), physicianfee_price = VALUES(physicianfee_price), "
                    + "physicianfee_total = VALUES(physicianfee_total), labtest_quant = VALUES(labtest_quant), "
                    + "labtest_price = VALUES(labtest_price), labtest_total = VALUES(labtest_total), "
                    + "surgery_quant = VALUES(surgery_quant), surgery_price = VALUES(surgery_price), "
                    + "surgery_total = VALUES(surgery_total), nursing_quant = VALUES(nursing_quant), "
                    + "nursing_price = VALUES(nursing_price), nursing_total = VALUES(nursing_total), final_total = VALUES(final_total);";

            // Database connection and execution
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem", "root", "");
                 PreparedStatement pstmt = con.prepareStatement(query)) {

                pstmt.setString(1, pat_id);
                pstmt.setString(2, pat_firstName);
                pstmt.setString(3, pat_lastName);
                pstmt.setInt(4, roomcharge_quant);
                pstmt.setDouble(5, roomcharge_price);
                pstmt.setDouble(6, roomcharge_total);
                pstmt.setInt(7, physicianfee_quant);
                pstmt.setDouble(8, physicianfee_price);
                pstmt.setDouble(9, physicianfee_total);
                pstmt.setInt(10, labtest_quant);
                pstmt.setDouble(11, labtest_price);
                pstmt.setDouble(12, labtest_total);
                pstmt.setInt(13, surgery_quant);
                pstmt.setDouble(14, surgery_price);
                pstmt.setDouble(15, surgery_total);
                pstmt.setInt(16, nursing_quant);
                pstmt.setDouble(17, nursing_price);
                pstmt.setDouble(18, nursing_total);
                pstmt.setDouble(19, final_total_reveal);

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data has been uploaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int parseIntOrDefault(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        PatientID_combo = new javax.swing.JComboBox<>();
        back_patientreg5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        patient_fullname = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        back_patientreg6 = new javax.swing.JButton();
        back_patientreg7 = new javax.swing.JButton();
        back_patientreg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        lastname = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(822, 761));
        setMinimumSize(new java.awt.Dimension(822, 761));
        setPreferredSize(new java.awt.Dimension(780, 850));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(24, 87, 115));
        jLabel4.setText("Finalize Bill");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 490, -1));

        PatientID_combo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        PatientID_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientID_comboActionPerformed(evt);
            }
        });
        getContentPane().add(PatientID_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 110, 30));

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
        getContentPane().add(back_patientreg5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 70, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(24, 87, 115));
        jLabel14.setText("MM/DD/YYYY");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 170, 40));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(24, 87, 115));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Date of Discharge:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 130, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(24, 87, 115));
        jLabel17.setText("Date of Issue:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 110, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(24, 87, 115));
        jLabel15.setText("Patient ID:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 80, 20));

        patient_fullname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        patient_fullname.setForeground(new java.awt.Color(24, 87, 115));
        patient_fullname.setText("Last Name, First Name");
        getContentPane().add(patient_fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 290, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(24, 87, 115));
        jLabel13.setText("Patient:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 100, 30));

        jPanel9.setBackground(new java.awt.Color(24, 87, 115));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(253, 253, 253));
        jLabel27.setText("Service/Item");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 104, Short.MAX_VALUE)
                    .addComponent(jLabel27)
                    .addGap(0, 105, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(jLabel27)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 280, 30));

        jPanel10.setBackground(new java.awt.Color(191, 229, 246));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(24, 87, 115));
        jLabel28.setText("Room Charges");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel28)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 280, 30));

        jPanel11.setBackground(new java.awt.Color(191, 229, 246));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(24, 87, 115));
        jLabel29.setText("Physician Fees");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel29)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 280, 30));

        jPanel12.setBackground(new java.awt.Color(191, 229, 246));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(24, 87, 115));
        jLabel30.setText("Laboratory Tests");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel30)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 280, 30));

        jPanel13.setBackground(new java.awt.Color(191, 229, 246));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(24, 87, 115));
        jLabel31.setText("Surgery");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel31)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 280, 30));

        jPanel7.setBackground(new java.awt.Color(191, 229, 246));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(24, 87, 115));
        jLabel25.setText("Nursing");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel25)
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 280, 30));

        jPanel8.setBackground(new java.awt.Color(24, 87, 115));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(253, 253, 253));
        jLabel26.setText("Quantity");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addGap(0, 26, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 100, 30));

        jPanel1.setBackground(new java.awt.Color(24, 87, 115));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(253, 253, 253));
        jLabel23.setText("Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 35, Short.MAX_VALUE)
                    .addComponent(jLabel23)
                    .addGap(0, 36, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(jLabel23)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 100, 30));

        jPanel2.setBackground(new java.awt.Color(24, 87, 115));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 720));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(24, 87, 115));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Date of Admission:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 140, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(24, 87, 115));
        jLabel18.setText("MM/DD/YYYY");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 170, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(24, 87, 115));
        jLabel19.setText("MM/DD/YYYY");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 160, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(24, 87, 115));
        jLabel21.setText("XXXXXX");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 110, 40));

        jTextField1.setBackground(new java.awt.Color(191, 229, 246));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(24, 87, 115));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0");
        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 100, 30));

        jTextField2.setBackground(new java.awt.Color(191, 229, 246));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(24, 87, 115));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("0");
        jTextField2.setBorder(null);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 100, 30));

        jTextField3.setBackground(new java.awt.Color(191, 229, 246));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(24, 87, 115));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("0");
        jTextField3.setBorder(null);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, 100, 30));

        jTextField4.setBackground(new java.awt.Color(191, 229, 246));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(24, 87, 115));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("0");
        jTextField4.setBorder(null);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, 100, 30));

        jTextField5.setBackground(new java.awt.Color(191, 229, 246));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(24, 87, 115));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("0");
        jTextField5.setBorder(null);
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 100, 30));

        jTextField6.setBackground(new java.awt.Color(191, 229, 246));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(24, 87, 115));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("0");
        jTextField6.setBorder(null);
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 100, 30));

        jTextField7.setBackground(new java.awt.Color(191, 229, 246));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(24, 87, 115));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("0");
        jTextField7.setBorder(null);
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 100, 30));

        jTextField8.setBackground(new java.awt.Color(191, 229, 246));
        jTextField8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(24, 87, 115));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("0");
        jTextField8.setBorder(null);
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, 100, 30));

        jTextField9.setBackground(new java.awt.Color(191, 229, 246));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(24, 87, 115));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("0");
        jTextField9.setBorder(null);
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 100, 30));

        jTextField10.setBackground(new java.awt.Color(191, 229, 246));
        jTextField10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(24, 87, 115));
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("0");
        jTextField10.setBorder(null);
        getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 100, 30));

        jTextField11.setBackground(new java.awt.Color(191, 229, 246));
        jTextField11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(24, 87, 115));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("0");
        jTextField11.setBorder(null);
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 100, 30));

        jTextField12.setBackground(new java.awt.Color(191, 229, 246));
        jTextField12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(24, 87, 115));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("0");
        jTextField12.setBorder(null);
        getContentPane().add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 100, 30));

        jTextField13.setBackground(new java.awt.Color(191, 229, 246));
        jTextField13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(24, 87, 115));
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setText("0");
        jTextField13.setBorder(null);
        getContentPane().add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, 100, 30));

        jTextField14.setBackground(new java.awt.Color(191, 229, 246));
        jTextField14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(24, 87, 115));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("0");
        jTextField14.setBorder(null);
        getContentPane().add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 100, 30));

        jTextField15.setBackground(new java.awt.Color(191, 229, 246));
        jTextField15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(24, 87, 115));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText("0");
        jTextField15.setBorder(null);
        getContentPane().add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 100, 30));

        jTextField16.setBackground(new java.awt.Color(191, 229, 246));
        jTextField16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(24, 87, 115));
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setText("0");
        jTextField16.setBorder(null);
        getContentPane().add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 540, 100, 30));

        jPanel6.setBackground(new java.awt.Color(24, 87, 115));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(253, 253, 253));
        jLabel24.setText("Unit/Price");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 21, Short.MAX_VALUE)
                    .addComponent(jLabel24)
                    .addGap(0, 22, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(jLabel24)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 100, 30));

        back_patientreg6.setBackground(new java.awt.Color(255, 102, 102));
        back_patientreg6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        back_patientreg6.setForeground(new java.awt.Color(255, 255, 255));
        back_patientreg6.setText("Finalize Bill");
        back_patientreg6.setBorder(null);
        back_patientreg6.setPreferredSize(new java.awt.Dimension(43, 16));
        back_patientreg6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_patientreg6ActionPerformed(evt);
            }
        });
        getContentPane().add(back_patientreg6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 610, 100, 30));

        back_patientreg7.setBackground(new java.awt.Color(24, 87, 115));
        back_patientreg7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        back_patientreg7.setForeground(new java.awt.Color(255, 255, 255));
        back_patientreg7.setText("Reveal Total");
        back_patientreg7.setBorder(null);
        back_patientreg7.setPreferredSize(new java.awt.Dimension(43, 16));
        back_patientreg7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_patientreg7ActionPerformed(evt);
            }
        });
        getContentPane().add(back_patientreg7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 540, 100, 30));

        back_patientreg.setBackground(new java.awt.Color(204, 204, 204));
        back_patientreg.setText("Back");
        back_patientreg.setBorder(null);
        back_patientreg.setPreferredSize(new java.awt.Dimension(43, 16));
        back_patientreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_patientregActionPerformed(evt);
            }
        });
        getContentPane().add(back_patientreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 50, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AdminBG (948 x 836 px) (2).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 970, 840));

        firstname.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        firstname.setForeground(new java.awt.Color(24, 87, 115));
        firstname.setText("MM/DD/YYYY");
        getContentPane().add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 160, 40));

        lastname.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lastname.setForeground(new java.awt.Color(24, 87, 115));
        lastname.setText("MM/DD/YYYY");
        getContentPane().add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 160, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PatientID_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientID_comboActionPerformed

    }//GEN-LAST:event_PatientID_comboActionPerformed

    private void back_patientreg5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientreg5ActionPerformed

        ClearValues();

        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";

        String patientID = PatientID_combo.getSelectedItem().toString();

        String query = "SELECT " +
                "    rp.patient_id, " +
                "    rp.patient_firstName, " +
                "    rp.patient_lastName, " +
                "    rp.patient_age, " +
                "    rp.patient_birthday, " +
                "    rp.patient_contact, " +
                "    rp.patient_address, " +
                "    rp.patient_ailment, " +
                "    rp.patient_type, " +
                "    rp.patient_blood, " +
                "    ip.inpatient_room AS room_number, " +
                "    ip.inpatient_admissiondate AS admission_date, " +
                "    ip.inpatient_admissiontime AS admission_time, " +
                "    ip.inpatient_allergies AS inpatient_allergies, " +
                "    ip.inpatient_chronic AS inpatient_chronic_conditions, " +
                "    ip.inpatient_physician AS inpatient_physician, " +
                "    op.outpatient_allergies AS outpatient_allergies, " +
                "    op.outpatient_chronic AS outpatient_chronic_conditions, " +
                "    op.outpatient_physician AS outpatient_physician " +
                "FROM " +
                "    registerpatient rp " +
                "LEFT JOIN " +
                "    inpatient ip ON rp.patient_id = ip.patient_id " +
                "LEFT JOIN " +
                "    outpatient op ON rp.patient_id = op.patient_id " +
                "WHERE " +
                "    rp.patient_id = ?";

        try (Connection connection = DriverManager.getConnection(SUrl, SUser, SPass);
             PreparedStatement prep = connection.prepareStatement(query)) {

            prep.setString(1, patientID);
            try (ResultSet resultSet = prep.executeQuery()) {

                if (resultSet.next()) {
                    String firstName = resultSet.getString("patient_firstName");
                    String lastName = resultSet.getString("patient_lastName");
                    
                    String type = resultSet.getString("patient_type");

                    firstname.setText(firstName);
                    lastname.setText(lastName);

                    String fullName = firstName + " " + lastName;
                    patient_fullname.setText(fullName);

                    String admissiondate = resultSet.getString("admission_date");
                    if (admissiondate != null) {
                        SimpleDateFormat originalFormat = new SimpleDateFormat("MM-dd-yyyy");
                        Date date = originalFormat.parse(admissiondate);
                        SimpleDateFormat newFormat = new SimpleDateFormat("MMMM dd, yyyy");

                        String newDateString = newFormat.format(date);
                        jLabel18.setText(newDateString);
                        String dateofadmission = jLabel18.getText();

                        // Get current date
                        Date currentDate = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
                        String dateToday = dateFormat.format(currentDate);

                        // Calculate days between
                        LocalDate startDate = LocalDate.parse(admissiondate, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                        LocalDate endDate = LocalDate.now();
                        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

                        jLabel14.setText(dateToday);
                        jLabel19.setText(dateToday);
                        jLabel21.setText(patientID);
                        jTextField2.setText(String.valueOf(daysBetween));
                        
                        
                        
                    } else if(admissiondate == null) {
                        Date currentDate = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
                        String dateToday = dateFormat.format(currentDate);
                        
                        jLabel19.setText(dateToday);
                        
                        jLabel21.setText(patientID);
                        
                        jLabel18.setText(type);
                        jLabel14.setText(type);
            
                    }

                    UpdateValues();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_back_patientreg5ActionPerformed

    private void back_patientreg6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientreg6ActionPerformed
    
        try {
            int response = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(response == JOptionPane.YES_OPTION) {
                
                uploadValues();
                
                ClearValues();
                AddBalance();
               
            } else if (response == JOptionPane.NO_OPTION) {

            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_back_patientreg6ActionPerformed

    private void back_patientreg7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientreg7ActionPerformed
        SetValues();
    }//GEN-LAST:event_back_patientreg7ActionPerformed

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
            java.util.logging.Logger.getLogger(FinalizeBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalizeBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalizeBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalizeBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalizeBills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> PatientID_combo;
    private javax.swing.JButton back_patientreg;
    public javax.swing.JButton back_patientreg5;
    public javax.swing.JButton back_patientreg6;
    public javax.swing.JButton back_patientreg7;
    private javax.swing.JLabel firstname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lastname;
    private javax.swing.JLabel patient_fullname;
    // End of variables declaration//GEN-END:variables
}
