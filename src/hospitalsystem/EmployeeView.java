
package hospitalsystem;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class EmployeeView extends javax.swing.JFrame {

    private DoctorDashboard doctorDashboard;
    private AdminDashboard adminDashboard;
    
    
    public EmployeeView(DoctorDashboard doctorDashboard) {
        this.doctorDashboard = doctorDashboard;
        initComponents();
        
        //auto add values in table
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                
                search_employeeActionPerformed(null);
            }
        });
    }

    // Constructor for Admins
    public EmployeeView(AdminDashboard adminDashboard) {
        this.adminDashboard = adminDashboard;
        initComponents();
        
        //auto add values in table
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                
                search_employeeActionPerformed(null);
            }
        });
    }
    
    public EmployeeView() {
        initComponents();
        
        //auto add values in table
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                
                search_employeeActionPerformed(null);
            }
        });
        
    }
    
    public void tableFromDatabase() {
            String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
            String SUser = "root";
            String SPass = "";
            int cc;

            try {
                Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
                Statement st = con.createStatement();
                String sql = "select * from employeeaccounts";
                
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()) {
                    String id = String.valueOf(rs.getInt("emp_id"));
                    String firstname = rs.getString("emp_firstName");
                    String lastname = rs.getString("emp_lastName");
                    String department = rs.getString("emp_department");
                    
                    String tbData[] = {id, firstname, lastname, department};
                    
                    DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
                    
                    tblModel.addRow(tbData);
                }
                

                

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
            }
        


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        back_patientreg = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back_patientreg1 = new javax.swing.JButton();
        searchField_employee = new javax.swing.JTextField();
        search_employee = new javax.swing.JButton();
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
        jLabel4.setText("View Employees");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 490, -1));

        back_patientreg.setBackground(new java.awt.Color(204, 204, 204));
        back_patientreg.setText("View");
        back_patientreg.setBorder(null);
        back_patientreg.setPreferredSize(new java.awt.Dimension(43, 16));
        back_patientreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_patientregActionPerformed(evt);
            }
        });
        getContentPane().add(back_patientreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 60, 30));

        jTable1.setBackground(new java.awt.Color(191, 229, 246));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(24, 87, 115));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "First Name", "Last Name", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jTable1.setSelectionBackground(new java.awt.Color(24, 87, 115));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 600, 500));

        back_patientreg1.setBackground(new java.awt.Color(204, 204, 204));
        back_patientreg1.setText("Back");
        back_patientreg1.setBorder(null);
        back_patientreg1.setPreferredSize(new java.awt.Dimension(43, 16));
        back_patientreg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_patientreg1ActionPerformed(evt);
            }
        });
        getContentPane().add(back_patientreg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 50, 30));

        searchField_employee.setForeground(new java.awt.Color(102, 102, 102));
        searchField_employee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 142, 156)));
        searchField_employee.setDisabledTextColor(new java.awt.Color(126, 142, 156));
        searchField_employee.setMargin(new java.awt.Insets(4, 6, 4, 6));
        searchField_employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchField_employeeActionPerformed(evt);
            }
        });
        getContentPane().add(searchField_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 130, 20));

        search_employee.setBackground(new java.awt.Color(24, 87, 115));
        search_employee.setForeground(new java.awt.Color(255, 255, 255));
        search_employee.setText("Search");
        search_employee.setBorder(null);
        search_employee.setPreferredSize(new java.awt.Dimension(43, 16));
        search_employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_employeeActionPerformed(evt);
            }
        });
        getContentPane().add(search_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 70, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BG (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 708));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back_patientreg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientreg1ActionPerformed
        this.setVisible(false);

        if (doctorDashboard != null) {
            doctorDashboard.setVisible(true);
        } else if (adminDashboard != null) {
            adminDashboard.setVisible(true);
        }
    }//GEN-LAST:event_back_patientreg1ActionPerformed

    private void searchField_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchField_employeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchField_employeeActionPerformed

    private void search_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_employeeActionPerformed

        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";
        int cc;
        
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        
        String keywords = searchField_employee.getText();
        
        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            String sql = "SELECT * from employeeaccounts where emp_id LIKE '%" + keywords + "%' \n" +
        "   OR emp_firstName LIKE '%" + keywords + "%' \n" +
        "   OR emp_lastName LIKE '%" + keywords + "%' \n";

            ResultSet rs = st.executeQuery(sql);
            tblModel.setRowCount(0);
            
            while (rs.next()) {
                
                String id = String.valueOf(rs.getInt("emp_id"));
                String firstname = rs.getString("emp_firstName");
                String lastname = rs.getString("emp_lastName");
                String department = rs.getString("emp_department");

                String tbData[] = {id, firstname, lastname, department};

                tblModel.addRow(tbData);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    

    }//GEN-LAST:event_search_employeeActionPerformed

    private void back_patientregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_patientregActionPerformed
        String SUrl = "jdbc:mysql://localhost:3306/hospitalsystem";
        String SUser = "root";
        String SPass = "";
        int cc;

        try {
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            Statement st = con.createStatement();
            String sql = "select * from employeeaccounts";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("emp_id"));
                String firstname = rs.getString("emp_firstName");
                String lastname = rs.getString("emp_lastName");
                String department = rs.getString("emp_department");

                String tbData[] = {id, firstname, lastname, department};

                DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();

                tblModel.setRowCount((0));
                tblModel.addRow(tbData);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_patientreg;
    private javax.swing.JButton back_patientreg1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchField_employee;
    private javax.swing.JButton search_employee;
    // End of variables declaration//GEN-END:variables
}
