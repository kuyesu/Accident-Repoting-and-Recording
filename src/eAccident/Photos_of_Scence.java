/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eAccident;

import java.awt.Container;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author goodMan
 */
public class Photos_of_Scence extends javax.swing.JFrame {
    
    String filename;
    byte[] incidence_image;
    byte[] incidence_image1;
    Connection con;
    PreparedStatement pstmt;
   
    /**
     * Creates new form User_Data
     */
    public Photos_of_Scence() {
        initComponents();
        this.incidence_image =null;
        this.incidence_image1 =null;  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        buttonSend = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        upload_button = new javax.swing.JButton();
        img_label = new javax.swing.JLabel();
        img_label1 = new javax.swing.JLabel();
        upload_button1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jPanel1.setMaximumSize(new java.awt.Dimension(700, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(14, 14, 193));
        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\goodMan\\Documents\\NetBeansProjects\\eAccident-pro\\src\\main\\java\\com\\mycompany\\eaccident\\pro\\eAccident\\Images\\close3.png")); // NOI18N
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
        jLabel22.setText("Photos of Scene");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 130, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 0, 0));
        jLabel26.setText("  Upload 1");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 140, 30));

        jPanel3.setBackground(new java.awt.Color(51, 0, 0));
        jPanel3.setForeground(new java.awt.Color(51, 0, 0));

        buttonSend.setBackground(new java.awt.Color(255, 255, 255));
        buttonSend.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        buttonSend.setForeground(new java.awt.Color(51, 0, 0));
        buttonSend.setText("SEND");
        buttonSend.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setForeground(new java.awt.Color(51, 0, 0));
        backButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\goodMan\\Documents\\NetBeansProjects\\e-Accident-Pro-Version\\src\\main\\java\\com\\mycompany\\eaccident\\pro\\eAccident\\images\\icons8_reply_arrow_25px.png")); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(buttonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 420, 80));

        upload_button.setBackground(new java.awt.Color(51, 0, 0));
        upload_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        upload_button.setForeground(new java.awt.Color(255, 255, 255));
        upload_button.setIcon(new javax.swing.ImageIcon("C:\\Users\\goodMan\\Documents\\NetBeansProjects\\e-Accident-Pro-Version\\src\\main\\java\\com\\mycompany\\eaccident\\pro\\eAccident\\images\\icons8_upload_to_the_cloud_18px_2.png")); // NOI18N
        upload_button.setText("Upoload");
        upload_button.setActionCommand("upload");
        upload_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_buttonActionPerformed(evt);
            }
        });
        jPanel7.add(upload_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 30));

        img_label.setBackground(new java.awt.Color(255, 255, 255));
        img_label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel7.add(img_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 240, 140));

        img_label1.setBackground(new java.awt.Color(255, 255, 255));
        img_label1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel7.add(img_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 240, 140));

        upload_button1.setBackground(new java.awt.Color(51, 0, 0));
        upload_button1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        upload_button1.setForeground(new java.awt.Color(255, 255, 255));
        upload_button1.setIcon(new javax.swing.ImageIcon("C:\\Users\\goodMan\\Documents\\NetBeansProjects\\e-Accident-Pro-Version\\src\\main\\java\\com\\mycompany\\eaccident\\pro\\eAccident\\images\\icons8_upload_to_the_cloud_18px_2.png")); // NOI18N
        upload_button1.setText("Upoload");
        upload_button1.setActionCommand("upload");
        upload_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_button1ActionPerformed(evt);
            }
        });
        jPanel7.add(upload_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 0, 0));
        jLabel28.setText("  Upload 1");
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 140, 30));

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

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendActionPerformed
      ImageIcon photo1 = (ImageIcon) img_label.getIcon();
      ImageIcon photo2 = (ImageIcon) img_label1.getIcon();
      
       try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/accident","rogers","rogers81");
            pstmt = con.prepareStatement("insert into photos(photo1, photo2,incidence_id) values(?,?,(select incidence_id from incidence WHERE incidence_id= (select MAX(incidence_id) from incidence)))");
            
            //int image_data = Integer.parseInt(String.valueOf(image.length()));
            //incidence_image = new byte[image_data];
            pstmt.setBytes(1, incidence_image1);
            pstmt.setBytes(2, incidence_image);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Recorded");
            con.close();
            
            }catch (ClassNotFoundException ex) {
            Logger.getLogger(Location_Detail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Location_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.dispose();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        User_Data data = new User_Data();
        data.setVisible(true);
    }//GEN-LAST:event_buttonSendActionPerformed

    private void upload_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_buttonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        
        
        ImageIcon imageIcon = new ImageIcon (new ImageIcon(filename).getImage().getScaledInstance(img_label.getWidth(), img_label.getHeight(),Image.SCALE_SMOOTH)); 
        img_label.setIcon(imageIcon);
        try{
            File image = new File(filename);
            
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum=fis.read(buf))!=-1;){
                bos.write(buf, 0, readNum);
                incidence_image1 = bos.toByteArray();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_upload_buttonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Incidence incidence = new Incidence();
        incidence.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void upload_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_button1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        
        
        ImageIcon imageIcon = new ImageIcon (new ImageIcon(filename).getImage().getScaledInstance(img_label1.getWidth(), img_label1.getHeight(),Image.SCALE_SMOOTH)); 
        img_label1.setIcon(imageIcon);
        try{
            File image = new File(filename);
            
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum=fis.read(buf))!=-1;){
                bos.write(buf, 0, readNum);
                incidence_image = bos.toByteArray();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_upload_button1ActionPerformed

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
            java.util.logging.Logger.getLogger(Photos_of_Scence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Photos_of_Scence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Photos_of_Scence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Photos_of_Scence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Photos_of_Scence().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonSend;
    private javax.swing.JLabel img_label;
    private javax.swing.JLabel img_label1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton upload_button;
    private javax.swing.JButton upload_button1;
    // End of variables declaration//GEN-END:variables
}
