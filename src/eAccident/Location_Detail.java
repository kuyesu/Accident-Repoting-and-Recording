/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eAccident;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author goodMan
 */
public class Location_Detail extends javax.swing.JFrame {

    PreparedStatement pstmt;
    Connection con;
    MainSerializable serial;
    ObjectOutputStream obwriter;
    ObjectInputStream obreader, isReader;
    Socket clientSocket;

    /**
     * Creates new form User_Data
     */
    public Location_Detail() {
        //go();
        initComponents();
    }

   /* public void go() {
        try {
            Socket clientSocket = new Socket("127.0.0.1", 5000);
            serial = new MainSerializable();

            obwriter = new ObjectOutputStream(clientSocket.getOutputStream());
            obreader = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Network Established");
            Thread t = new Thread(new UserDataRunnable());
            t.start();
            System.out.println("Got a connection");
        } catch (java.net.ConnectException e) {
            JOptionPane.showMessageDialog(null, "Connection failed");
        } catch (Exception e) {
        }
    }

    /////////////////////////////////////
    public class UserDataRunnable implements Runnable {

        @Override
        public void run() {

            try {
                while ((serial = (MainSerializable) obreader.readObject()) != null) {

                    System.out.println("records sent");
                    go();
                }
            } catch (IOException ex) {
                Logger.getLogger(Location_Detail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Location_Detail.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }*/ 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        placeField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        nextto = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        districtField = new javax.swing.JComboBox<String>();
        regionField = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        descField = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jPanel1.setMaximumSize(new java.awt.Dimension(700, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(14, 14, 193));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 30, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("System");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 70, 50));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Registration and Reporting");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 230, 50));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("e-Accident");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 140, 50));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 0, 0));
        jLabel22.setText("Location Detail");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 280, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 0, 0));
        jLabel23.setText(" Region         : ");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 0, 0));
        jLabel24.setText(" District         : ");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 0, 0));
        jLabel25.setText(" Place Name : ");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 0, 0));
        jLabel26.setText(" Any discription");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 140, 30));

        placeField.setForeground(new java.awt.Color(51, 0, 0));
        placeField.setBorder(null);
        placeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeFieldActionPerformed(evt);
            }
        });
        jPanel7.add(placeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 210, 20));
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 210, 30));

        jPanel3.setBackground(new java.awt.Color(51, 0, 0));
        jPanel3.setForeground(new java.awt.Color(51, 0, 0));

        nextto.setBackground(new java.awt.Color(255, 255, 255));
        nextto.setForeground(new java.awt.Color(51, 0, 0));
        nextto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nexttoActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(51, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(nextto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 420, 80));

        districtField.setEditable(true);
        districtField.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        districtField.setForeground(new java.awt.Color(51, 0, 0));
        districtField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mbarara", "Abim", "Apac", "Arua", "Entebbe", "Fort Portal", "Hoima", "Nebbi", "Masind", "Gulu", "Omoro", "Kampala", "Wakiso", "Mukono", "Mbarara", "Mbale", "Kitgum", "", "", "" }));
        districtField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jPanel7.add(districtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 210, 30));

        regionField.setEditable(true);
        regionField.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        regionField.setForeground(new java.awt.Color(0, 51, 51));
        regionField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Western", "Central", "Mid Western", "Eastern", "Northern", "West Nile" }));
        regionField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        regionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionFieldActionPerformed(evt);
            }
        });
        jPanel7.add(regionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 210, 30));

        descField.setColumns(20);
        descField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descField.setForeground(new java.awt.Color(51, 0, 0));
        descField.setRows(5);
        descField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jScrollPane1.setViewportView(descField);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 230, 80));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 420, 390));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("Together We SAVE LIVES !");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 310, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        //dispose();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void placeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placeFieldActionPerformed

    private void regionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regionFieldActionPerformed

    private void nexttoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nexttoActionPerformed

        String region = regionField.getSelectedItem().toString();
        String district = districtField.getSelectedItem().toString();
        String place = placeField.getText();
        String description = descField.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/accident", "rogers", "rogers81");
            pstmt = con.prepareStatement("insert into location(region,district,place,description,report_id) values(?,?,?,?,(select report_id from user_data WHERE report_id= (select MAX(report_id) from user_data)))");
            System.out.print("Inserted Successfully");
            pstmt.setString(1, region);
            pstmt.setString(2, district);
            pstmt.setString(3, place);
            pstmt.setString(4, description);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Recorded");
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Location_Detail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Location_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.dispose();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Incidence incidence = new Incidence();
        incidence.setVisible(true);
    }//GEN-LAST:event_nexttoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        User_Data userdata = new User_Data();
        userdata.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Location_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Location_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Location_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Location_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Location_Detail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descField;
    private javax.swing.JComboBox<String> districtField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextto;
    private javax.swing.JTextField placeField;
    private javax.swing.JComboBox<String> regionField;
    // End of variables declaration//GEN-END:variables
}