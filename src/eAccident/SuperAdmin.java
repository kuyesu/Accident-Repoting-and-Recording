/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eAccident;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author goodman
 */
public class SuperAdmin extends javax.swing.JFrame {

    /**
     * Creates new form SuperAdmin
     */
    byte[] profile_pic;
    PreparedStatement pstmt;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    MainSerializable serial;
    ObjectOutputStream obwriter;
    ObjectInputStream obreader,isReader;
    Socket clientSocket;
    public SuperAdmin() throws IOException {
        go();
        initComponents();
        userspanel.setVisible(true);
        reportpanel.setVisible(false);
        databasepanel.setVisible(false);
        this.profile_pic = null;
        /*obwriter = null;
        obreader = null;
        clientSocket = null;
        serial = null;*/

    }

    //////////////////////////////////////
    public void go() {
        try {
            Socket clientSocket = new Socket("127.0.0.1", 5000);
            serial = new MainSerializable();

            obwriter = new ObjectOutputStream(clientSocket.getOutputStream());
            obreader = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Network Established");
            Thread t = new Thread(new SuperAdminRunnable());
            t.start();
            System.out.println("Got a connection");
        } catch (java.net.ConnectException e) {
            JOptionPane.showMessageDialog(null, "Connection failed");
        } catch (Exception e) {
        }
    }

    /////////////////////////////////////
    public class SuperAdminRunnable implements Runnable {

        @Override
        public void run() {

            try {
                while ((serial = (MainSerializable) obreader.readObject()) != null) {
                    /*firstfield.setText(serial.firstName);
                     lastfield.setText(serial.lastName);
                     desigfield.setTex t(serial.designation);
                     officeNofield.setText(serial.officer_no);
                     SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
                     sdf.format(dobfield.setDate(serial.date_of_birth));
                     //String emergency;
                     maleField.setActionCommand("Male");
                     femaleField.setActionCommand("Female");
                     genderfield.isSelected(serial.sex).toString();
                     //genderfield.setSelection(serial.sex).getActionCommand();
                     /*String emergency;

                     if (maleField.isSelected()) {
                     sex = "Male";
                     }
                     if (femaleField.isSelected()) {
                     sex = "Female";
                     }
                     
                     sdf.format(djfield.getDate());
                     districtfield.getSelectedItem(serial.district).toString();
                     nationalityfield.setSelectedItem(serial.nationality).toString();
                     //ImageIcon image = (ImageIcon) photofield.getIcon();
                     */
                    System.out.println("records sent");
                    go();
                }
            } catch (IOException ex) {
                Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    ////////////////////////////////////
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    void changedColor(JPanel hover, Color rand) {
        hover.setBackground(rand);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderfield = new javax.swing.ButtonGroup();
        innerpanel = new javax.swing.JPanel();
        databasepanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        data_table = new javax.swing.JTable();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        searchbtn = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        userspanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        cancel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        next = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        officeNofield = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        districtfield = new javax.swing.JComboBox<String>();
        jLabel58 = new javax.swing.JLabel();
        maleField = new javax.swing.JRadioButton();
        femaleField = new javax.swing.JRadioButton();
        submit = new javax.swing.JButton();
        firstfield = new javax.swing.JTextField();
        lastfield = new javax.swing.JTextField();
        desigfield = new javax.swing.JTextField();
        nationalityfield = new javax.swing.JComboBox<String>();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        djfield = new com.toedter.calendar.JDateChooser();
        jLabel61 = new javax.swing.JLabel();
        dobfield = new com.toedter.calendar.JDateChooser();
        upload_button = new javax.swing.JButton();
        photofield = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        reportpanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        cancel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        next1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        maleofficer = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        maleofficer1 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        categorycases = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        allregionscase = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        allreporters = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        allofficers = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        sidepanel = new javax.swing.JPanel();
        exit = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        users = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        dashboard = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        database1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        reports = new javax.swing.JPanel();
        report = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        innerpanel.setBackground(new java.awt.Color(255, 255, 255));
        innerpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(42, 129, 181)));
        innerpanel.setPreferredSize(new java.awt.Dimension(1100, 720));
        innerpanel.setLayout(new javax.swing.OverlayLayout(innerpanel));

        databasepanel.setBackground(new java.awt.Color(255, 255, 255));

        data_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Officer No.", "First Name", "Last Name", "sex", "Nationality", "Dato ofbirth", "District", "Date Joined"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        data_table.setSelectionBackground(new java.awt.Color(153, 153, 255));
        data_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(data_table);

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(42, 129, 181));
        jLabel63.setText("E-ACCIDENT SYSTEM");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(42, 129, 181));
        jLabel65.setText("Users Database");

        jPanel24.setBackground(new java.awt.Color(42, 129, 181));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(42, 129, 181));
        jLabel66.setText("Registration and Reporting");

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbtn.setBorder(null);
        searchbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchbtnMouseReleased(evt);
            }
        });
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        jPanel13.add(searchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 190, 20));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searchbox.png"))); // NOI18N
        jPanel13.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 220, 42));

        jLabel64.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(42, 129, 181));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_search_23px.png"))); // NOI18N
        jLabel64.setText("Search");
        jLabel64.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel13.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 100, 30));

        javax.swing.GroupLayout databasepanelLayout = new javax.swing.GroupLayout(databasepanel);
        databasepanel.setLayout(databasepanelLayout);
        databasepanelLayout.setHorizontalGroup(
            databasepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databasepanelLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, databasepanelLayout.createSequentialGroup()
                .addContainerGap(373, Short.MAX_VALUE)
                .addGroup(databasepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, databasepanelLayout.createSequentialGroup()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, databasepanelLayout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(databasepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(databasepanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(databasepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(databasepanelLayout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(802, Short.MAX_VALUE)))
        );
        databasepanelLayout.setVerticalGroup(
            databasepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databasepanelLayout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(databasepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(656, 656, 656))
            .addGroup(databasepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, databasepanelLayout.createSequentialGroup()
                    .addContainerGap(140, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(databasepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(databasepanelLayout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(686, Short.MAX_VALUE)))
        );

        innerpanel.add(databasepanel);

        userspanel.setBackground(new java.awt.Color(255, 255, 255));
        userspanel.setPreferredSize(new java.awt.Dimension(1200, 720));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelMouseExited(evt);
            }
        });
        cancel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cancel");
        cancel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 110, 20));

        jPanel7.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 120, 30));

        next.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextMouseExited(evt);
            }
        });
        next.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Next >");
        next.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 110, 20));

        jPanel7.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 120, 30));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 102, 204)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 102, 153));
        jLabel41.setText("Last Name :");
        jPanel10.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 96, 110, 23));

        jLabel42.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 102, 153));
        jLabel42.setText("First Name :");
        jPanel10.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 36, 110, 23));

        jLabel43.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 102, 153));
        jLabel43.setText("Designation :");
        jPanel10.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 152, 110, 23));

        jLabel44.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 102, 153));
        jLabel44.setText("Officer No:");
        jPanel10.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 221, 110, 23));

        jLabel45.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 102, 153));
        jLabel45.setText("Gender");
        jPanel10.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 110, 23));

        officeNofield.setBackground(new java.awt.Color(197, 227, 247));
        officeNofield.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        officeNofield.setForeground(new java.awt.Color(0, 51, 51));
        officeNofield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        officeNofield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                officeNofieldActionPerformed(evt);
            }
        });
        jPanel10.add(officeNofield, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 220, 30));
        jPanel10.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 260, 10));
        jPanel10.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 260, 10));
        jPanel10.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 260, 10));
        jPanel10.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 260, 10));

        districtfield.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        districtfield.setForeground(new java.awt.Color(0, 102, 153));
        districtfield.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mbarara", "Abim", "Apac", "Arua", "Entebbe", "Fort Portal", "Hoima", "Nebbi", "Masind", "Gulu", "Omoro", "Kampala", "Wakiso", "Mukono", "Mbarara", "Mbale", "Kitgum", "", "", "" }));
        districtfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 216, 216)));
        districtfield.setOpaque(false);
        districtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                districtfieldActionPerformed(evt);
            }
        });
        jPanel10.add(districtfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 140, -1));

        jLabel58.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 102, 153));
        jLabel58.setText("District :");
        jPanel10.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 110, 23));

        maleField.setBackground(new java.awt.Color(197, 227, 247));
        genderfield.add(maleField);
        maleField.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        maleField.setForeground(new java.awt.Color(0, 102, 153));
        maleField.setText("Male");
        jPanel10.add(maleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        femaleField.setBackground(new java.awt.Color(197, 227, 247));
        genderfield.add(femaleField);
        femaleField.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        femaleField.setForeground(new java.awt.Color(0, 102, 153));
        femaleField.setText("Female");
        jPanel10.add(femaleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        submit.setBackground(new java.awt.Color(0, 102, 153));
        submit.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Submit");
        submit.setBorder(null);
        submit.setBorderPainted(false);
        submit.setDefaultCapable(false);
        submit.setFocusPainted(false);
        submit.setOpaque(false);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel10.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 80, 30));

        firstfield.setBackground(new java.awt.Color(197, 227, 247));
        firstfield.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        firstfield.setForeground(new java.awt.Color(0, 51, 51));
        firstfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel10.add(firstfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 220, 30));

        lastfield.setBackground(new java.awt.Color(197, 227, 247));
        lastfield.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lastfield.setForeground(new java.awt.Color(0, 51, 51));
        lastfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel10.add(lastfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 220, 30));

        desigfield.setBackground(new java.awt.Color(197, 227, 247));
        desigfield.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        desigfield.setForeground(new java.awt.Color(0, 51, 51));
        desigfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        desigfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desigfieldActionPerformed(evt);
            }
        });
        jPanel10.add(desigfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 220, 30));

        nationalityfield.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        nationalityfield.setForeground(new java.awt.Color(0, 102, 153));
        nationalityfield.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mbarara", "Abim", "Apac", "Arua", "Entebbe", "Fort Portal", "Hoima", "Nebbi", "Masind", "Gulu", "Omoro", "Kampala", "Wakiso", "Mukono", "Mbarara", "Mbale", "Kitgum", "", "", "" }));
        nationalityfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 216, 216)));
        nationalityfield.setOpaque(false);
        jPanel10.add(nationalityfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 140, -1));

        jLabel59.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 102, 153));
        jLabel59.setText("Date Joined");
        jPanel10.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 110, 23));

        jLabel60.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 102, 153));
        jLabel60.setText("Photo");
        jPanel10.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 110, 23));

        djfield.setToolTipText("Chose Date");
        jPanel10.add(djfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 160, 30));

        jLabel61.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 102, 153));
        jLabel61.setText("Date Joined");
        jPanel10.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 110, 23));

        dobfield.setToolTipText("Chose Date");
        jPanel10.add(dobfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 180, 30));

        upload_button.setBackground(new java.awt.Color(197, 227, 247));
        upload_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        upload_button.setForeground(new java.awt.Color(0, 51, 51));
        upload_button.setIcon(new javax.swing.ImageIcon("C:\\Users\\goodMan\\Documents\\NetBeansProjects\\e-Accident-Pro-Version\\src\\main\\java\\com\\mycompany\\eaccident\\pro\\eAccident\\images\\icons8_upload_to_the_cloud_18px_2.png")); // NOI18N
        upload_button.setText("Upoload");
        upload_button.setActionCommand("upload");
        upload_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_buttonActionPerformed(evt);
            }
        });
        jPanel10.add(upload_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, -1, 30));

        photofield.setBackground(new java.awt.Color(255, 255, 255));
        photofield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel10.add(photofield, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 190, 160));

        jLabel62.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 102, 153));
        jLabel62.setText("Nationality");
        jPanel10.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 110, 23));

        jLabel13.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jLabel13.setText("Click \"Next\" to Add more officers in the System or \"Cancel\" to exit if you are done");

        jLabel14.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jLabel14.setText("You can add the details of the Officers, including their passwords. Please remember the integrity of the data of the officers.");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(42, 129, 181));
        jLabel53.setText("E-ACCIDENT SYSTEM");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(42, 129, 181));
        jLabel54.setText("Registration and Reporting");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(42, 129, 181));
        jLabel57.setText("Register User");

        jPanel19.setBackground(new java.awt.Color(42, 129, 181));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout userspanelLayout = new javax.swing.GroupLayout(userspanel);
        userspanel.setLayout(userspanelLayout);
        userspanelLayout.setHorizontalGroup(
            userspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userspanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(userspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userspanelLayout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userspanelLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))))
            .addGroup(userspanelLayout.createSequentialGroup()
                .addGroup(userspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userspanelLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addGroup(userspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(userspanelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(145, 145, 145)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userspanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userspanelLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 30, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        userspanelLayout.setVerticalGroup(
            userspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userspanelLayout.createSequentialGroup()
                .addGroup(userspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(userspanelLayout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(userspanelLayout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        innerpanel.add(userspanel);

        reportpanel.setBackground(new java.awt.Color(255, 255, 255));
        reportpanel.setPreferredSize(new java.awt.Dimension(1100, 630));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancel1.setBackground(new java.awt.Color(204, 204, 204));
        cancel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        cancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel1MouseExited(evt);
            }
        });
        cancel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Cancel");
        cancel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 110, 20));

        jPanel8.add(cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 120, 30));

        next1.setBackground(new java.awt.Color(204, 204, 204));
        next1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        next1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                next1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                next1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                next1MouseExited(evt);
            }
        });
        next1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Next >");
        next1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 80, 20));

        jPanel8.add(next1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 140, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(80, 0, 0, 0, new java.awt.Color(204, 204, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(42, 129, 181));
        jLabel37.setText("System Users");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 150, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("photo");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, 160));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("photo");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 160, 160));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel2.setText("Operation");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 150, -1));

        jLabel4.setText("in the year");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 60, 20));

        jLabel5.setText("REG No :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel10.setText("Name :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));

        jLabel20.setText("Sex :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, -1));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vertical.png"))); // NOI18N
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 20, 140));

        jLabel22.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel22.setText("Officer Information");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        jLabel23.setText("Nationality :");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, -1));

        jLabel24.setText("Name :");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 90, -1));

        jLabel25.setText("Started working with the Police from ");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 190, 20));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_pdf_18px_1.png"))); // NOI18N
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 440, 160));

        button1.setLabel("Next >");
        jPanel2.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, 130, 30));

        button2.setLabel("< Back");
        jPanel2.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, 130, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(42, 129, 181));
        jLabel34.setText("E-ACCIDENT SYSTEM");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(42, 129, 181));
        jLabel35.setText("Registration and Reporting");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(42, 129, 181));
        jLabel36.setText("Users Reports");

        jPanel17.setBackground(new java.awt.Color(54, 33, 89));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(42, 129, 181));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(80, 0, 0, 0, new java.awt.Color(204, 204, 255)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(42, 129, 181));
        jLabel38.setText("Generate Reports");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 170, 30));

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(42, 129, 181));
        jLabel26.setText("Female Officers ");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 110, 30));

        jLabel29.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(42, 129, 181));
        jLabel29.setText("Reporters Details");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 110, 30));

        jLabel31.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(42, 129, 181));
        jLabel31.setText("Regions ");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 110, 30));

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(42, 129, 181));
        jLabel33.setText("accidents");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 110, 30));

        jLabel40.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(42, 129, 181));
        jLabel40.setText("Category of ");
        jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 110, 30));

        maleofficer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        maleofficer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maleofficerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                maleofficerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                maleofficerMouseExited(evt);
            }
        });

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_pdf_35px.png"))); // NOI18N

        javax.swing.GroupLayout maleofficerLayout = new javax.swing.GroupLayout(maleofficer);
        maleofficer.setLayout(maleofficerLayout);
        maleofficerLayout.setHorizontalGroup(
            maleofficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maleofficerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        maleofficerLayout.setVerticalGroup(
            maleofficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, maleofficerLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel48)
                .addContainerGap())
        );

        jPanel3.add(maleofficer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 60, 60));

        jLabel50.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(42, 129, 181));
        jLabel50.setText("Male offices");
        jPanel3.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 110, 30));

        jLabel52.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(42, 129, 181));
        jLabel52.setText("System Users");
        jPanel3.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 110, 30));

        maleofficer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        maleofficer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maleofficer1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                maleofficer1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                maleofficer1MouseExited(evt);
            }
        });

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_pdf_35px.png"))); // NOI18N

        javax.swing.GroupLayout maleofficer1Layout = new javax.swing.GroupLayout(maleofficer1);
        maleofficer1.setLayout(maleofficer1Layout);
        maleofficer1Layout.setHorizontalGroup(
            maleofficer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(maleofficer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        maleofficer1Layout.setVerticalGroup(
            maleofficer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, maleofficer1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addContainerGap())
        );

        jPanel3.add(maleofficer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 60, 60));

        categorycases.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        categorycases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categorycasesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                categorycasesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                categorycasesMouseExited(evt);
            }
        });

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_pdf_35px.png"))); // NOI18N

        javax.swing.GroupLayout categorycasesLayout = new javax.swing.GroupLayout(categorycases);
        categorycases.setLayout(categorycasesLayout);
        categorycasesLayout.setHorizontalGroup(
            categorycasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categorycasesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        categorycasesLayout.setVerticalGroup(
            categorycasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categorycasesLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel67)
                .addContainerGap())
        );

        jPanel3.add(categorycases, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 60, 60));

        allregionscase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        allregionscase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allregionscaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                allregionscaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                allregionscaseMouseExited(evt);
            }
        });

        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_pdf_35px.png"))); // NOI18N

        javax.swing.GroupLayout allregionscaseLayout = new javax.swing.GroupLayout(allregionscase);
        allregionscase.setLayout(allregionscaseLayout);
        allregionscaseLayout.setHorizontalGroup(
            allregionscaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allregionscaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        allregionscaseLayout.setVerticalGroup(
            allregionscaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allregionscaseLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel68)
                .addContainerGap())
        );

        jPanel3.add(allregionscase, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 60, 60));

        allreporters.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        allreporters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allreportersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                allreportersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                allreportersMouseExited(evt);
            }
        });

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_pdf_35px.png"))); // NOI18N

        javax.swing.GroupLayout allreportersLayout = new javax.swing.GroupLayout(allreporters);
        allreporters.setLayout(allreportersLayout);
        allreportersLayout.setHorizontalGroup(
            allreportersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allreportersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        allreportersLayout.setVerticalGroup(
            allreportersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allreportersLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel69)
                .addContainerGap())
        );

        jPanel3.add(allreporters, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 60, 60));

        allofficers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        allofficers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allofficersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                allofficersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                allofficersMouseExited(evt);
            }
        });

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_pdf_35px.png"))); // NOI18N

        javax.swing.GroupLayout allofficersLayout = new javax.swing.GroupLayout(allofficers);
        allofficers.setLayout(allofficersLayout);
        allofficersLayout.setHorizontalGroup(
            allofficersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allofficersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        allofficersLayout.setVerticalGroup(
            allofficersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allofficersLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel70)
                .addContainerGap())
        );

        jPanel3.add(allofficers, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 60, 60));

        jPanel18.setBackground(new java.awt.Color(42, 129, 181));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout reportpanelLayout = new javax.swing.GroupLayout(reportpanel);
        reportpanel.setLayout(reportpanelLayout);
        reportpanelLayout.setHorizontalGroup(
            reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportpanelLayout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(342, 342, 342))
            .addGroup(reportpanelLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(reportpanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(145, 145, 145)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(reportpanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(reportpanelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(233, 233, 233)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        reportpanelLayout.setVerticalGroup(
            reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportpanelLayout.createSequentialGroup()
                .addGroup(reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(reportpanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(250, 250, 250)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(reportpanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
        );

        innerpanel.add(reportpanel);

        getContentPane().add(innerpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, 720));

        sidepanel.setBackground(new java.awt.Color(42, 129, 181));
        sidepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(42, 129, 181)));
        sidepanel.setPreferredSize(new java.awt.Dimension(250, 720));
        sidepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setBackground(new java.awt.Color(42, 129, 181));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        exit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_exit_23px.png"))); // NOI18N
        jLabel6.setText("Exit");
        exit.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 150, -1));

        sidepanel.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 250, 40));

        users.setBackground(new java.awt.Color(42, 129, 181));
        users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usersMouseExited(evt);
            }
        });
        users.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_team_23px.png"))); // NOI18N
        jLabel8.setText("Users");
        users.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, -1));

        sidepanel.add(users, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 250, 40));

        logout.setBackground(new java.awt.Color(42, 129, 181));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_shutdown_23px.png"))); // NOI18N
        jLabel9.setText("Log out");
        logout.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, -1));

        sidepanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 250, 40));

        dashboard.setBackground(new java.awt.Color(42, 129, 181));
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardMouseExited(evt);
            }
        });
        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_home_23px.png"))); // NOI18N
        jLabel11.setText("Home");
        dashboard.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 150, -1));

        sidepanel.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 250, 40));

        database1.setBackground(new java.awt.Color(42, 129, 181));
        database1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                database1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                database1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                database1MouseExited(evt);
            }
        });
        database1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_database_23px_1.png"))); // NOI18N
        jLabel16.setText("Database");
        database1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, -1));

        sidepanel.add(database1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 250, 40));

        reports.setBackground(new java.awt.Color(42, 129, 181));
        reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportsMouseExited(evt);
            }
        });
        reports.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        report.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        report.setForeground(new java.awt.Color(255, 255, 255));
        report.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_submit_document_23px.png"))); // NOI18N
        report.setText("Report");
        reports.add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, -1));

        sidepanel.add(reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 250, 40));

        getContentPane().add(sidepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseEntered
        changedColor(dashboard, new Color(20, 95, 140));
    }//GEN-LAST:event_dashboardMouseEntered

    private void dashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseExited
        changedColor(dashboard, new Color(43, 129, 181));
    }//GEN-LAST:event_dashboardMouseExited

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked
        userspanel.setVisible(false);
        reportpanel.setVisible(true);
        databasepanel.setVisible(false);
    }//GEN-LAST:event_dashboardMouseClicked

    private void usersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseEntered
        changedColor(users, new Color(20, 95, 140));
    }//GEN-LAST:event_usersMouseEntered

    private void usersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseExited
        changedColor(users, new Color(43, 129, 181));
    }//GEN-LAST:event_usersMouseExited

    private void usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseClicked
        userspanel.setVisible(true);
        reportpanel.setVisible(false);
        databasepanel.setVisible(false);
    }//GEN-LAST:event_usersMouseClicked

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        changedColor(logout, new Color(20, 95, 140));
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        changedColor(logout, new Color(43, 129, 181));
    }//GEN-LAST:event_logoutMouseExited

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_exitMouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        changedColor(exit, new Color(20, 95, 140));
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        changedColor(exit, new Color(43, 129, 181));
    }//GEN-LAST:event_exitMouseExited

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBorder(white_border);
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBorder(default_border);
    }//GEN-LAST:event_cancelMouseExited

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        try {
            String RESULT = "ACCOUNTING_AND_FINANCE_STUDENTS.pdf";

            Document document = new Document(PageSize.A5.rotate());
            try {
                PdfWriter.getInstance(document, new FileOutputStream(RESULT));//Need to write in a table
            } catch (DocumentException ex) {

            } catch (FileNotFoundException ex) {

            }

            document.open();

            PdfPTable table = new PdfPTable(3);//create table with 2 columns

            table.addCell("REG_NUMBER");
            table.addCell("FIRST_NAME");
            table.addCell("LAST_NAME");
            //table.addCell("age");

            /*table.addCell("REGISTRATION_NUMBER");
             table.addCell(rs.getString("FIRST_NAME"));
             table.addCell(rs.getString("LAST_NAME"));
             //table.addCell(rs.getString("age"));*/
            document.add(table);
            document.close();

            if (Desktop.isDesktopSupported()) {
                try {
                    File myfile = new File("ACCOUNTING_AND_FINANCE_STUDENTS.pdf");
                    Desktop.getDesktop().open(myfile);
                } catch (IOException ex) {
                }
            }
            document.close();//close a pdf document

        } catch (DocumentException ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_nextMouseClicked

    private void nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseEntered
        next.setBorder(white_border);
    }//GEN-LAST:event_nextMouseEntered

    private void nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseExited
        next.setBorder(default_border);
    }//GEN-LAST:event_nextMouseExited

    private void officeNofieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_officeNofieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_officeNofieldActionPerformed

    private void desigfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desigfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desigfieldActionPerformed

    Border white_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(0, 102, 153));
    Border default_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(64, 43, 100));
    private void districtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_districtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_districtfieldActionPerformed

    private void upload_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_buttonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(photofield.getWidth(), photofield.getHeight(), Image.SCALE_SMOOTH));
        photofield.setIcon(imageIcon);
        try {
            File image = new File(filename);

            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
                profile_pic = bos.toByteArray();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_upload_buttonActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        serial.firstName = firstfield.getText();
        serial.lastName = lastfield.getText();
        serial.designation = desigfield.getText();
        serial.officer_no = officeNofield.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        serial.date_of_birth = sdf.format(dobfield.getDate());
        maleField.setActionCommand("Male");
        femaleField.setActionCommand("Female");
        serial.sex = genderfield.getSelection().getActionCommand();
        serial.date_joined = sdf.format(djfield.getDate());
        serial.district = districtfield.getSelectedItem().toString();
        try {

            obwriter.writeObject(serial);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Null pointer");
        } catch (IOException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_submitActionPerformed

    private void database1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_database1MouseClicked
        userspanel.setVisible(false);
        reportpanel.setVisible(false);
        databasepanel.setVisible(true);
    }//GEN-LAST:event_database1MouseClicked

    private void database1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_database1MouseEntered
        changedColor(database1, new Color(20, 95, 140));
    }//GEN-LAST:event_database1MouseEntered

    private void database1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_database1MouseExited
        changedColor(database1, new Color(43, 129, 181));
    }//GEN-LAST:event_database1MouseExited

    private void reportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseClicked
        userspanel.setVisible(false);
        reportpanel.setVisible(true);
        databasepanel.setVisible(false);
    }//GEN-LAST:event_reportsMouseClicked

    private void reportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseEntered
        changedColor(reports, new Color(20, 95, 140));
    }//GEN-LAST:event_reportsMouseEntered

    private void reportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseExited
        changedColor(reports, new Color(43, 129, 181));
    }//GEN-LAST:event_reportsMouseExited

    private void cancel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1MouseClicked

    private void cancel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseEntered
        cancel.setBorder(white_border);
    }//GEN-LAST:event_cancel1MouseEntered

    private void cancel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel1MouseExited
        cancel.setBorder(default_border);
    }//GEN-LAST:event_cancel1MouseExited

    private void next1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next1MouseClicked
        try {
            String RESULT = "ACCOUNTING_AND_FINANCE_STUDENTS.pdf";

            Document document = new Document(PageSize.A5.rotate());
            try {
                PdfWriter.getInstance(document, new FileOutputStream(RESULT));//Need to write in a table
            } catch (DocumentException ex) {

            } catch (FileNotFoundException ex) {

            }

            document.open();

            PdfPTable table = new PdfPTable(3);//create table with 2 columns

            table.addCell("REG_NUMBER");
            table.addCell("FIRST_NAME");
            table.addCell("LAST_NAME");
            //table.addCell("age");

            /*table.addCell("REGISTRATION_NUMBER");
             table.addCell(rs.getString("FIRST_NAME"));
             table.addCell(rs.getString("LAST_NAME"));
             //table.addCell(rs.getString("age"));*/
            document.add(table);
            document.close();

            if (Desktop.isDesktopSupported()) {
                try {
                    File myfile = new File("ACCOUNTING_AND_FINANCE_STUDENTS.pdf");
                    Desktop.getDesktop().open(myfile);
                } catch (IOException ex) {
                }
            }
            document.close();//close a pdf document

        } catch (DocumentException ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);

        }

    }//GEN-LAST:event_next1MouseClicked

    private void next1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next1MouseEntered
        next.setBorder(white_border);
    }//GEN-LAST:event_next1MouseEntered

    private void next1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next1MouseExited
        next.setBorder(default_border);
    }//GEN-LAST:event_next1MouseExited

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed

    }//GEN-LAST:event_searchbtnActionPerformed

    private void maleofficerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maleofficerMouseClicked
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost/accident", "rogers", "rogers81");
            stmt = conn.createStatement();

            String result = "officers.pdf";

            Document doc = new Document(PageSize.A4.rotate());

            try {
                PdfWriter.getInstance(doc, new FileOutputStream(result));

            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            doc.open();

            ///////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////
            Paragraph para = new Paragraph("All Users ", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));

            para.setSpacingAfter(15);
            para.setSpacingBefore(15);
            para.setIndentationLeft(210);
            /*
             para.setSpacingAfter(20);
             para.setIndentationLeft(200);
                
             Paragraph pr = new Paragraph("[PIMS]");
             pr.setIndentationLeft(20);
             */
            /*
                
             FREE SPACE FOR SPACING
                
             */

            Paragraph space = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));

            space.setSpacingAfter(5);
            space.setSpacingBefore(6);

            //String source = "C:\\Users\\DELL i5\\Desktop\\jCal\\pimsLogo4.jpeg";
            //String src = "C:\\Users\\DELL i5\\Documents\\NetBeansProjects\\PrisonersInformationManagementSystem\\src\\prisonersInfo\\Images\\pimsLogo4.jpeg";
            String logo = "policelogo.jpeg";
            String UGflag = "flag.png";
            Image img = Image.getInstance(logo);
            img.scaleToFit(75, 75);
            img.setSpacingAfter(4);
            Image img1 = Image.getInstance(UGflag);
            img1.setSpacingBefore(5);
            img1.setAlignment(1);
            img.setIndentationLeft(330);

            PdfPTable table = new PdfPTable(5);

            try {
                //query = "select * from Prisoner";
                //query = "select concat(fName,\" \",sName) as full_name,gender,age,cell_cell_id from prisoner;";
                String query = "select concat(fName,\" \",lName) as full_name,officer_no as id,designation,nationality,district from officer";
                rs = stmt.executeQuery(query);

                PdfPCell nmCell = new PdfPCell();
                nmCell.setBorder(0);
                Phrase pnm = new Phrase("NAME");
                pnm.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                nmCell.addElement(pnm);
                table.addCell(nmCell);
                /*
                 PdfPCell genderCell = new PdfPCell();
                 Phrase pgn = new Phrase("GENDER");
                 pgn.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD,15));
                 genderCell.addElement(pgn);
                 table.addCell(genderCell);
                 */

                /*
                 PdfPCell sexCell = new PdfPCell();
                 Phrase sex = new Phrase("SEX");
                 sex.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD,15));
                 sexCell.addElement(sex);
                 table.addCell(sexCell);*/
                PdfPCell cidCell = new PdfPCell();
                cidCell.setBorder(0);
                Phrase cid = new Phrase("ID NO");
                cid.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                cidCell.addElement(cid);
                table.addCell(cidCell);

                PdfPCell designationCell = new PdfPCell();
                designationCell.setBorder(0);
                Phrase designation = new Phrase("DESIGNATION");
                designation.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                designationCell.addElement(designation);
                table.addCell(designationCell);

                PdfPCell nationalityCell = new PdfPCell();
                nationalityCell.setBorder(0);
                Phrase nationality = new Phrase("NATIONALITY");
                nationality.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                nationalityCell.addElement(nationality);
                table.addCell(nationalityCell);

                PdfPCell districtCell = new PdfPCell();
                districtCell.setBorder(0);
                Phrase district = new Phrase("DISTRICT");
                district.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                districtCell.addElement(district);
                table.addCell(districtCell);

                while (rs.next()) {
                    //table.addCell(rs.getString("prisoner_id"));
                    //table.addCell(rs.getString("fName"));
                    //table.addCell(rs.getString("sName"));

                    table.addCell(rs.getString("full_name"));

                    //table.addCell(rs.getString("gender"));
                    //table.addCell(rs.getString("Photo"));
                    //table.addCell(rs.getString("sex"));
                    table.addCell(rs.getString("id"));
                    //table.addCell(rs.getString("officer_no"));
                    table.addCell(rs.getString("designation"));
                    table.addCell(rs.getString("nationality"));
                    table.addCell(rs.getString("district"));
                }
                /*
                 doc.add(pr);
                 doc.add(img);             
                 doc.add(para);
                 doc.add(table);
                    
                 PdfPTable footTable = new PdfPTable(1);
                 PdfPCell footerCell = new PdfPCell();
                 Phrase footer = new Phrase("Generated by Martin Ssendyowa");
                 //footerCell.addElement(footer);
                 footerCell.setPhrase(footer);
                 footerCell.setBorder(0);
                 footTable.addCell(footerCell);
                 //footTable.setSpacingBefore(doc.bottom());
                 footTable.setSpacingBefore(doc.bottomMargin());
                 footTable.setHorizontalAlignment(90);
                 */
                //doc.add(iconTable);
                doc.add(img);
                doc.add(space);
                doc.add(img1);

                Paragraph prline = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA, 24));
                prline.setIndentationLeft(doc.leftMargin());
                prline.setIndentationRight(doc.rightMargin());
                doc.add(prline);

                doc.add(para);
                doc.add(table);
                    //doc.addTitle("All Prisoners' Cases");

                //footer
                PdfPTable footTable = new PdfPTable(1);
                PdfPCell footerCell = new PdfPCell();
                Phrase footer = new Phrase("Report generated by: Kuyeso Rogers");
                // automatically attach name depending on user login i.e can use login as inner class
                //add time and date when report is generated

                footerCell.setPhrase(footer);
                footerCell.setBorder(0);

                //Calendar cal = Calendar.getInstance();
                Date gendate = new Date();
                Phrase gen = new Phrase("Date: " + gendate);
                PdfPCell footerCell2 = new PdfPCell();
                footerCell2.addElement(gen);
                footerCell2.setBorder(0);
                //footTable.addCell(footerCell);
                //footTable.setSpacingBefore(doc.bottom());

                footTable.addCell(footerCell);
                footTable.addCell(footerCell2);

                footTable.setSpacingBefore(doc.bottomMargin());
                footTable.setHorizontalAlignment(100);
                footTable.setSpacingBefore(50);

                doc.add(footTable);

                doc.close();

                if (Desktop.isDesktopSupported()) {
                    File fpdf = new File(result);
                    Desktop.getDesktop().open(fpdf);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (BadElementException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_maleofficerMouseClicked

    private void maleofficerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maleofficerMouseEntered
        maleofficer.setBorder(white_border);
    }//GEN-LAST:event_maleofficerMouseEntered

    private void maleofficerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maleofficerMouseExited
        maleofficer.setBorder(default_border);
    }//GEN-LAST:event_maleofficerMouseExited

    private void searchbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbtnMouseReleased
        String firstName = searchbtn.getText();
        DefaultTableModel dtm = (DefaultTableModel) data_table.getModel();
        //showing and searching according to text given
        int r = data_table.getRowCount();

        while (r-- > 0) {
            dtm.removeRow(r);
        }

        try {
            rs = SerachUsers.pstmt(firstName);
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                //using vector to insert row
                java.util.Vector v = new java.util.Vector();
                v.add(rs.getInt("officer_no"));
                v.add(rs.getString("fName"));
                v.add(rs.getString("lName"));
                v.add(rs.getString("sex"));
                v.add(rs.getString("nationality"));
                v.add(rs.getString("date_of_birth"));
                v.add(rs.getString("district"));
                v.add(rs.getString("date_joined"));

                dtm.addRow(v);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Police_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchbtnMouseReleased

    private void maleofficer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maleofficer1MouseClicked
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost/accident", "rogers", "rogers81");
            stmt = conn.createStatement();

            String result = "officers.pdf";

            Document doc = new Document(PageSize.A4.rotate());

            try {
                PdfWriter.getInstance(doc, new FileOutputStream(result));

            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            doc.open();

            ///////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////
            Paragraph para = new Paragraph("Male Officers ", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));

            para.setSpacingAfter(15);
            para.setSpacingBefore(15);
            para.setIndentationLeft(210);

            Paragraph space = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));

            space.setSpacingAfter(5);
            space.setSpacingBefore(6);

            //String source = "C:\\Users\\DELL i5\\Desktop\\jCal\\pimsLogo4.jpeg";
            //String src = "C:\\Users\\DELL i5\\Documents\\NetBeansProjects\\PrisonersInformationManagementSystem\\src\\prisonersInfo\\Images\\pimsLogo4.jpeg";
            String logo = "policelogo.jpeg";
            String UGflag = "flag.png";
            Image img = Image.getInstance(logo);
            img.scaleToFit(75, 75);
            img.setSpacingAfter(4);
            Image img1 = Image.getInstance(UGflag);
            img1.setSpacingBefore(5);
            img1.setAlignment(1);
            img.setIndentationLeft(330);

            PdfPTable table = new PdfPTable(5);

            try {
                //query = "select * from Prisoner";
                //query = "select concat(fName,\" \",sName) as full_name,gender,age,cell_cell_id from prisoner;";
                String query = "select concat(fName,\" \",lName) as full_name,officer_no as id,designation,nationality,district from officer where sex = \"Male\"";
                rs = stmt.executeQuery(query);

                PdfPCell nmCell = new PdfPCell();
                nmCell.setBorder(0);
                Phrase pnm = new Phrase("NAME");
                pnm.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                nmCell.addElement(pnm);
                table.addCell(nmCell);
                /*
                 PdfPCell genderCell = new PdfPCell();
                 Phrase pgn = new Phrase("GENDER");
                 pgn.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD,15));
                 genderCell.addElement(pgn);
                 table.addCell(genderCell);
                 */

                /*
                 PdfPCell sexCell = new PdfPCell();
                 Phrase sex = new Phrase("SEX");
                 sex.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD,15));
                 sexCell.addElement(sex);
                 table.addCell(sexCell);*/
                PdfPCell cidCell = new PdfPCell();
                cidCell.setBorder(0);
                Phrase cid = new Phrase("ID NO");
                cid.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                cidCell.addElement(cid);
                table.addCell(cidCell);

                PdfPCell designationCell = new PdfPCell();
                designationCell.setBorder(0);
                Phrase designation = new Phrase("DESIGNATION");
                designation.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                designationCell.addElement(designation);
                table.addCell(designationCell);

                PdfPCell nationalityCell = new PdfPCell();
                nationalityCell.setBorder(0);
                Phrase nationality = new Phrase("NATIONALITY");
                nationality.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                nationalityCell.addElement(nationality);
                table.addCell(nationalityCell);

                PdfPCell districtCell = new PdfPCell();
                districtCell.setBorder(0);
                Phrase district = new Phrase("DISTRICT");
                district.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                districtCell.addElement(district);
                table.addCell(districtCell);

                while (rs.next()) {

                    table.addCell(rs.getString("full_name"));
                    table.addCell(rs.getString("sex"));
                    table.addCell(rs.getString("id"));
                    //table.addCell(rs.getString("officer_no"));
                    table.addCell(rs.getString("designation"));
                    table.addCell(rs.getString("nationality"));
                    table.addCell(rs.getString("district"));
                }

                //doc.add(iconTable);
                doc.add(img);
                doc.add(space);
                doc.add(img1);

                Paragraph prline = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA, 24));
                prline.setIndentationLeft(doc.leftMargin());
                prline.setIndentationRight(doc.rightMargin());
                doc.add(prline);

                doc.add(para);
                doc.add(table);
                    //doc.addTitle("All Prisoners' Cases");

                //footer
                PdfPTable footTable = new PdfPTable(1);
                PdfPCell footerCell = new PdfPCell();
                Phrase footer = new Phrase("Report generated by: Kuyeso Rogers");
                // automatically attach name depending on user login i.e can use login as inner class
                //add time and date when report is generated

                footerCell.setPhrase(footer);
                footerCell.setBorder(0);

                //Calendar cal = Calendar.getInstance();
                Date gendate = new Date();
                Phrase gen = new Phrase("Date: " + gendate);
                PdfPCell footerCell2 = new PdfPCell();
                footerCell2.addElement(gen);
                footerCell2.setBorder(0);
                //footTable.addCell(footerCell);
                //footTable.setSpacingBefore(doc.bottom());

                footTable.addCell(footerCell);
                footTable.addCell(footerCell2);

                footTable.setSpacingBefore(doc.bottomMargin());
                footTable.setHorizontalAlignment(100);
                footTable.setSpacingBefore(50);

                doc.add(footTable);

                doc.close();

                if (Desktop.isDesktopSupported()) {
                    File fpdf = new File(result);
                    Desktop.getDesktop().open(fpdf);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (BadElementException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_maleofficer1MouseClicked

    private void maleofficer1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maleofficer1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_maleofficer1MouseEntered

    private void maleofficer1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maleofficer1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_maleofficer1MouseExited

    private void categorycasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categorycasesMouseClicked
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost/accident", "rogers", "rogers81");
            stmt = conn.createStatement();

            String result = "category.pdf";

            Document doc = new Document(PageSize.A4.rotate());

            try {
                PdfWriter.getInstance(doc, new FileOutputStream(result));

            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            doc.open();

            ///////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////
            Paragraph para = new Paragraph("Accident by Category", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));

            para.setSpacingAfter(15);
            para.setSpacingBefore(15);
            para.setIndentationLeft(270);
            /*
             para.setSpacingAfter(20);
             para.setIndentationLeft(200);
                
             Paragraph pr = new Paragraph("[PIMS]");
             pr.setIndentationLeft(20);
             */
            /*
                
             FREE SPACE FOR SPACING
                
             */

            Paragraph space = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));

            space.setSpacingAfter(5);
            space.setSpacingBefore(6);

            //String source = "C:\\Users\\DELL i5\\Desktop\\jCal\\pimsLogo4.jpeg";
            //String src = "C:\\Users\\DELL i5\\Documents\\NetBeansProjects\\PrisonersInformationManagementSystem\\src\\prisonersInfo\\Images\\pimsLogo4.jpeg";
            String logo = "policelogo.jpeg";
            String UGflag = "flag.png";
            Image img = Image.getInstance(logo);
            img.scaleToFit(75, 75);
            img.setSpacingAfter(4);
            Image img1 = Image.getInstance(UGflag);
            img1.setSpacingBefore(5);
            img1.setAlignment(1);
            img.setIndentationLeft(330);

            PdfPTable table = new PdfPTable(4);

            try {
                //query = "select * from Prisoner";
                //query = "select concat(fName,\" \",sName) as full_name,gender,age,cell_cell_id from prisoner;";
                String query = "select incidence_id as id,category,injury,district from incidence,location";
                rs = stmt.executeQuery(query);

                PdfPCell nmCell = new PdfPCell();
                nmCell.setBorder(0);
                Phrase pnm = new Phrase("Inc. Id");
                pnm.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                nmCell.addElement(pnm);
                table.addCell(nmCell);

                PdfPCell cidCell = new PdfPCell();
                cidCell.setBorder(0);
                Phrase cid = new Phrase("Category");
                cid.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                cidCell.addElement(cid);
                table.addCell(cidCell);

                PdfPCell designationCell = new PdfPCell();
                designationCell.setBorder(0);
                Phrase designation = new Phrase("Injury");
                designation.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                designationCell.addElement(designation);
                table.addCell(designationCell);

                PdfPCell nationalityCell = new PdfPCell();
                nationalityCell.setBorder(0);
                Phrase nationality = new Phrase("district");
                nationality.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                nationalityCell.addElement(nationality);
                table.addCell(nationalityCell);

                while (rs.next()) {

                    table.addCell(rs.getString("id"));

                    table.addCell(rs.getString("category"));
                    table.addCell(rs.getString("injury"));
                    table.addCell(rs.getString("district"));
                }

                doc.add(img);
                doc.add(space);
                doc.add(img1);

                Paragraph prline = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA, 24));
                prline.setIndentationLeft(doc.leftMargin());
                prline.setIndentationRight(doc.rightMargin());
                doc.add(prline);

                doc.add(para);
                doc.add(table);
                    //doc.addTitle("All Prisoners' Cases");

                //footer
                PdfPTable footTable = new PdfPTable(1);
                PdfPCell footerCell = new PdfPCell();
                Phrase footer = new Phrase("Report generated by: Kuyeso Rogers");
                // automatically attach name depending on user login i.e can use login as inner class
                //add time and date when report is generated

                footerCell.setPhrase(footer);
                footerCell.setBorder(0);

                //Calendar cal = Calendar.getInstance();
                Date gendate = new Date();
                Phrase gen = new Phrase("Date: " + gendate);
                PdfPCell footerCell2 = new PdfPCell();
                footerCell2.addElement(gen);
                footerCell2.setBorder(0);
                //footTable.addCell(footerCell);
                //footTable.setSpacingBefore(doc.bottom());

                footTable.addCell(footerCell);
                footTable.addCell(footerCell2);

                footTable.setSpacingBefore(doc.bottomMargin());
                footTable.setHorizontalAlignment(100);
                footTable.setSpacingBefore(100);

                doc.add(footTable);

                doc.close();

                if (Desktop.isDesktopSupported()) {
                    File fpdf = new File(result);
                    Desktop.getDesktop().open(fpdf);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (BadElementException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_categorycasesMouseClicked

    private void categorycasesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categorycasesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_categorycasesMouseEntered

    private void categorycasesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categorycasesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_categorycasesMouseExited

    private void allregionscaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allregionscaseMouseClicked
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost/accident", "rogers", "rogers81");
            stmt = conn.createStatement();

            String result = "category.pdf";

            Document doc = new Document(PageSize.A4.rotate());

            try {
                PdfWriter.getInstance(doc, new FileOutputStream(result));

            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            doc.open();

            ///////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////
            Paragraph para = new Paragraph("Accident by Regions", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));

            para.setSpacingAfter(15);
            para.setSpacingBefore(15);
            para.setIndentationLeft(270);
            /*
             para.setSpacingAfter(20);
             para.setIndentationLeft(200);
                
             Paragraph pr = new Paragraph("[PIMS]");
             pr.setIndentationLeft(20);
             */
            /*
                
             FREE SPACE FOR SPACING
                
             */

            Paragraph space = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));

            space.setSpacingAfter(5);
            space.setSpacingBefore(6);

            //String source = "C:\\Users\\DELL i5\\Desktop\\jCal\\pimsLogo4.jpeg";
            //String src = "C:\\Users\\DELL i5\\Documents\\NetBeansProjects\\PrisonersInformationManagementSystem\\src\\prisonersInfo\\Images\\pimsLogo4.jpeg";
            String logo = "policelogo.jpeg";
            String UGflag = "flag.png";
            Image img = Image.getInstance(logo);
            img.scaleToFit(75, 75);
            img.setSpacingAfter(4);
            Image img1 = Image.getInstance(UGflag);
            img1.setSpacingBefore(5);
            img1.setAlignment(1);
            img.setIndentationLeft(330);

            PdfPTable table = new PdfPTable(4);

            try {
                //query = "select * from Prisoner";
                //query = "select concat(fName,\" \",sName) as full_name,gender,age,cell_cell_id from prisoner;";
                String query = "select location_id as id,region,category,injury from incidence,location";
                rs = stmt.executeQuery(query);

                PdfPCell nmCell = new PdfPCell();
                nmCell.setBorder(0);
                Phrase pnm = new Phrase("Location. Id");
                pnm.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                nmCell.addElement(pnm);
                table.addCell(nmCell);

                PdfPCell cidCell = new PdfPCell();
                cidCell.setBorder(0);
                Phrase cid = new Phrase("Region");
                cid.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                cidCell.addElement(cid);
                table.addCell(cidCell);

                PdfPCell designationCell = new PdfPCell();
                designationCell.setBorder(0);
                Phrase designation = new Phrase("Category");
                designation.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                designationCell.addElement(designation);
                table.addCell(designationCell);

                while (rs.next()) {

                    table.addCell(rs.getString("id"));

                    table.addCell(rs.getString("region"));
                    table.addCell(rs.getString("category"));

                }

                doc.add(img);
                doc.add(space);
                doc.add(img1);

                Paragraph prline = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA, 24));
                prline.setIndentationLeft(doc.leftMargin());
                prline.setIndentationRight(doc.rightMargin());
                doc.add(prline);

                doc.add(para);
                doc.add(table);
                    //doc.addTitle("All Prisoners' Cases");

                //footer
                PdfPTable footTable = new PdfPTable(1);
                PdfPCell footerCell = new PdfPCell();
                Phrase footer = new Phrase("Report generated by: Kuyeso Rogers");
                // automatically attach name depending on user login i.e can use login as inner class
                //add time and date when report is generated

                footerCell.setPhrase(footer);
                footerCell.setBorder(0);

                //Calendar cal = Calendar.getInstance();
                Date gendate = new Date();
                Phrase gen = new Phrase("Date: " + gendate);
                PdfPCell footerCell2 = new PdfPCell();
                footerCell2.addElement(gen);
                footerCell2.setBorder(0);
                //footTable.addCell(footerCell);
                //footTable.setSpacingBefore(doc.bottom());

                footTable.addCell(footerCell);
                footTable.addCell(footerCell2);

                footTable.setSpacingBefore(doc.bottomMargin());
                footTable.setHorizontalAlignment(100);
                footTable.setSpacingBefore(100);

                doc.add(footTable);

                doc.close();

                if (Desktop.isDesktopSupported()) {
                    File fpdf = new File(result);
                    Desktop.getDesktop().open(fpdf);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (BadElementException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_allregionscaseMouseClicked

    private void allregionscaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allregionscaseMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_allregionscaseMouseEntered

    private void allregionscaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allregionscaseMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_allregionscaseMouseExited

    private void allreportersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allreportersMouseClicked
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost/accident", "rogers", "rogers81");
            stmt = conn.createStatement();

            String result = "category.pdf";

            Document doc = new Document(PageSize.A4.rotate());

            try {
                PdfWriter.getInstance(doc, new FileOutputStream(result));

            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            doc.open();

            ///////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////
            Paragraph para = new Paragraph("Reporters of Accident", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));

            para.setSpacingAfter(15);
            para.setSpacingBefore(15);
            para.setIndentationLeft(270);
            /*
             para.setSpacingAfter(20);
             para.setIndentationLeft(200);
                
             Paragraph pr = new Paragraph("[PIMS]");
             pr.setIndentationLeft(20);
             */
            /*
                
             FREE SPACE FOR SPACING
                
             */

            Paragraph space = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));

            space.setSpacingAfter(5);
            space.setSpacingBefore(6);

            //String source = "C:\\Users\\DELL i5\\Desktop\\jCal\\pimsLogo4.jpeg";
            //String src = "C:\\Users\\DELL i5\\Documents\\NetBeansProjects\\PrisonersInformationManagementSystem\\src\\prisonersInfo\\Images\\pimsLogo4.jpeg";
            String logo = "policelogo.jpeg";
            String UGflag = "flag.png";
            Image img = Image.getInstance(logo);
            img.scaleToFit(75, 75);
            img.setSpacingAfter(4);
            Image img1 = Image.getInstance(UGflag);
            img1.setSpacingBefore(5);
            img1.setAlignment(1);
            img.setIndentationLeft(330);

            PdfPTable table = new PdfPTable(5);

            try {
                //query = "select * from Prisoner";
                //query = "select concat(fName,\" \",sName) as full_name,gender,age,cell_cell_id from prisoner;";
                String query = "select concat(firstName,\" \",lastName) as full_name,tel,email,incidence_id as id,category from user_data,incidence,location";
                rs = stmt.executeQuery(query);

                PdfPCell nmCell = new PdfPCell();
                nmCell.setBorder(0);
                Phrase pnm = new Phrase("Name");
                pnm.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                nmCell.addElement(pnm);
                table.addCell(nmCell);

                PdfPCell cidCell = new PdfPCell();
                cidCell.setBorder(0);
                Phrase cid = new Phrase("Tel");
                cid.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                cidCell.addElement(cid);
                table.addCell(cidCell);

                PdfPCell designationCell = new PdfPCell();
                designationCell.setBorder(0);
                Phrase designation = new Phrase("email");
                designation.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                designationCell.addElement(designation);
                table.addCell(designationCell);

                PdfPCell nationalityCell = new PdfPCell();
                nationalityCell.setBorder(0);
                Phrase nationality = new Phrase("Inc. No");
                nationality.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                nationalityCell.addElement(nationality);
                table.addCell(nationalityCell);

                PdfPCell districtCell = new PdfPCell();
                districtCell.setBorder(0);
                Phrase district = new Phrase("Category");
                district.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                districtCell.addElement(district);
                table.addCell(districtCell);

                while (rs.next()) {

                    table.addCell(rs.getString("full_name"));

                    table.addCell(rs.getString("tel"));
                    table.addCell(rs.getString("email"));
                    table.addCell(rs.getString("id"));
                    table.addCell(rs.getString("category"));

                }

                doc.add(img);
                doc.add(space);
                doc.add(img1);

                Paragraph prline = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA, 24));
                prline.setIndentationLeft(doc.leftMargin());
                prline.setIndentationRight(doc.rightMargin());
                doc.add(prline);

                doc.add(para);
                doc.add(table);
                    //doc.addTitle("All Prisoners' Cases");

                //footer
                PdfPTable footTable = new PdfPTable(1);
                PdfPCell footerCell = new PdfPCell();
                Phrase footer = new Phrase("Report generated by: Kuyeso Rogers");
                // automatically attach name depending on user login i.e can use login as inner class
                //add time and date when report is generated

                footerCell.setPhrase(footer);
                footerCell.setBorder(0);

                //Calendar cal = Calendar.getInstance();
                Date gendate = new Date();
                Phrase gen = new Phrase("Date: " + gendate);
                PdfPCell footerCell2 = new PdfPCell();
                footerCell2.addElement(gen);
                footerCell2.setBorder(0);
                //footTable.addCell(footerCell);
                //footTable.setSpacingBefore(doc.bottom());

                footTable.addCell(footerCell);
                footTable.addCell(footerCell2);

                footTable.setSpacingBefore(doc.bottomMargin());
                footTable.setHorizontalAlignment(100);
                footTable.setSpacingBefore(100);

                doc.add(footTable);

                doc.close();

                if (Desktop.isDesktopSupported()) {
                    File fpdf = new File(result);
                    Desktop.getDesktop().open(fpdf);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (BadElementException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_allreportersMouseClicked

    private void allreportersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allreportersMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_allreportersMouseEntered

    private void allreportersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allreportersMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_allreportersMouseExited

    private void allofficersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allofficersMouseClicked
        try {
            Class.forName("com.mysql.jdbc.Driver"); //register the driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost/accident", "rogers", "rogers81");
            stmt = conn.createStatement();

            String result = "officers.pdf";

            Document doc = new Document(PageSize.A4.rotate());

            try {
                PdfWriter.getInstance(doc, new FileOutputStream(result));

            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            doc.open();

            ///////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////
            Paragraph para = new Paragraph("Female Officers ", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));

            para.setSpacingAfter(15);
            para.setSpacingBefore(15);
            para.setIndentationLeft(210);
            /*
             para.setSpacingAfter(20);
             para.setIndentationLeft(200);
                
             Paragraph pr = new Paragraph("[PIMS]");
             pr.setIndentationLeft(20);
             */
            /*
                
             FREE SPACE FOR SPACING
                
             */

            Paragraph space = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));

            space.setSpacingAfter(5);
            space.setSpacingBefore(6);

            //String source = "C:\\Users\\DELL i5\\Desktop\\jCal\\pimsLogo4.jpeg";
            //String src = "C:\\Users\\DELL i5\\Documents\\NetBeansProjects\\PrisonersInformationManagementSystem\\src\\prisonersInfo\\Images\\pimsLogo4.jpeg";
            String logo = "policelogo.jpeg";
            String UGflag = "flag.png";
            Image img = Image.getInstance(logo);
            img.scaleToFit(75, 75);
            img.setSpacingAfter(4);
            Image img1 = Image.getInstance(UGflag);
            img1.setSpacingBefore(5);
            img1.setAlignment(1);
            img.setIndentationLeft(330);

            PdfPTable table = new PdfPTable(5);

            try {
                //query = "select * from Prisoner";
                //query = "select concat(fName,\" \",sName) as full_name,gender,age,cell_cell_id from prisoner;";
                String query = "select concat(fName,\" \",lName) as full_name,officer_no as id,designation,nationality,district from officer where sex = \"Female\"";
                rs = stmt.executeQuery(query);

                PdfPCell nmCell = new PdfPCell();
                nmCell.setBorder(0);
                Phrase pnm = new Phrase("NAME");
                pnm.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                nmCell.addElement(pnm);
                table.addCell(nmCell);
                /*
                 PdfPCell genderCell = new PdfPCell();
                 Phrase pgn = new Phrase("GENDER");
                 pgn.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD,15));
                 genderCell.addElement(pgn);
                 table.addCell(genderCell);
                 */

                /*
                 PdfPCell sexCell = new PdfPCell();
                 Phrase sex = new Phrase("SEX");
                 sex.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD,15));
                 sexCell.addElement(sex);
                 table.addCell(sexCell);*/
                PdfPCell cidCell = new PdfPCell();
                cidCell.setBorder(0);
                Phrase cid = new Phrase("ID NO");
                cid.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                cidCell.addElement(cid);
                table.addCell(cidCell);

                PdfPCell designationCell = new PdfPCell();
                designationCell.setBorder(0);
                Phrase designation = new Phrase("DESIGNATION");
                designation.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                designationCell.addElement(designation);
                table.addCell(designationCell);

                PdfPCell nationalityCell = new PdfPCell();
                nationalityCell.setBorder(0);
                Phrase nationality = new Phrase("NATIONALITY");
                nationality.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                nationalityCell.addElement(nationality);
                table.addCell(nationalityCell);

                PdfPCell districtCell = new PdfPCell();
                districtCell.setBorder(0);
                Phrase district = new Phrase("DISTRICT");
                district.setFont(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
                districtCell.addElement(district);
                table.addCell(districtCell);

                while (rs.next()) {
                    //table.addCell(rs.getString("prisoner_id"));
                    //table.addCell(rs.getString("fName"));
                    //table.addCell(rs.getString("sName"));

                    table.addCell(rs.getString("full_name"));

                    //table.addCell(rs.getString("gender"));
                    //table.addCell(rs.getString("Photo"));
                    //table.addCell(rs.getString("sex"));
                    table.addCell(rs.getString("id"));
                    //table.addCell(rs.getString("officer_no"));
                    table.addCell(rs.getString("designation"));
                    table.addCell(rs.getString("nationality"));
                    table.addCell(rs.getString("district"));
                }
                /*
                 doc.add(pr);
                 doc.add(img);             
                 doc.add(para);
                 doc.add(table);
                    
                 PdfPTable footTable = new PdfPTable(1);
                 PdfPCell footerCell = new PdfPCell();
                 Phrase footer = new Phrase("Generated by Martin Ssendyowa");
                 //footerCell.addElement(footer);
                 footerCell.setPhrase(footer);
                 footerCell.setBorder(0);
                 footTable.addCell(footerCell);
                 //footTable.setSpacingBefore(doc.bottom());
                 footTable.setSpacingBefore(doc.bottomMargin());
                 footTable.setHorizontalAlignment(90);
                 */
                //doc.add(iconTable);
                doc.add(img);
                doc.add(space);
                doc.add(img1);

                Paragraph prline = new Paragraph("", FontFactory.getFont(FontFactory.HELVETICA, 24));
                prline.setIndentationLeft(doc.leftMargin());
                prline.setIndentationRight(doc.rightMargin());
                doc.add(prline);

                doc.add(para);
                doc.add(table);
                    //doc.addTitle("All Prisoners' Cases");

                //footer
                PdfPTable footTable = new PdfPTable(1);
                PdfPCell footerCell = new PdfPCell();
                Phrase footer = new Phrase("Report generated by: Kuyeso Rogers");
                // automatically attach name depending on user login i.e can use login as inner class
                //add time and date when report is generated

                footerCell.setPhrase(footer);
                footerCell.setBorder(0);

                //Calendar cal = Calendar.getInstance();
                Date gendate = new Date();
                Phrase gen = new Phrase("Date: " + gendate);
                PdfPCell footerCell2 = new PdfPCell();
                footerCell2.addElement(gen);
                footerCell2.setBorder(0);
                //footTable.addCell(footerCell);
                //footTable.setSpacingBefore(doc.bottom());

                footTable.addCell(footerCell);
                footTable.addCell(footerCell2);

                footTable.setSpacingBefore(doc.bottomMargin());
                footTable.setHorizontalAlignment(100);
                footTable.setSpacingBefore(50);

                doc.add(footTable);

                doc.close();

                if (Desktop.isDesktopSupported()) {
                    File fpdf = new File(result);
                    Desktop.getDesktop().open(fpdf);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                ex.printStackTrace();
                //Logger.getLogger(Prisoner.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (BadElementException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_allofficersMouseClicked

    private void allofficersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allofficersMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_allofficersMouseEntered

    private void allofficersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allofficersMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_allofficersMouseExited

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
            java.util.logging.Logger.getLogger(SuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuperAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SuperAdmin().setVisible(true);
                    //ServerAdmin server = new ServerAdmin();
                    
                } catch (IOException ex) {
                    Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allofficers;
    private javax.swing.JPanel allregionscase;
    private javax.swing.JPanel allreporters;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JPanel cancel;
    private javax.swing.JPanel cancel1;
    private javax.swing.JPanel categorycases;
    private javax.swing.JPanel dashboard;
    private javax.swing.JTable data_table;
    private javax.swing.JPanel database1;
    private javax.swing.JPanel databasepanel;
    private javax.swing.JTextField desigfield;
    private javax.swing.JComboBox<String> districtfield;
    private com.toedter.calendar.JDateChooser djfield;
    private com.toedter.calendar.JDateChooser dobfield;
    private javax.swing.JPanel exit;
    private javax.swing.JRadioButton femaleField;
    private javax.swing.JTextField firstfield;
    private javax.swing.ButtonGroup genderfield;
    private javax.swing.JPanel innerpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lastfield;
    private javax.swing.JPanel logout;
    private javax.swing.JRadioButton maleField;
    private javax.swing.JPanel maleofficer;
    private javax.swing.JPanel maleofficer1;
    private javax.swing.JComboBox<String> nationalityfield;
    private javax.swing.JPanel next;
    private javax.swing.JPanel next1;
    private javax.swing.JTextField officeNofield;
    private javax.swing.JLabel photofield;
    private javax.swing.JLabel report;
    private javax.swing.JPanel reportpanel;
    private javax.swing.JPanel reports;
    private javax.swing.JTextField searchbtn;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JButton submit;
    private javax.swing.JButton upload_button;
    private javax.swing.JPanel users;
    private javax.swing.JPanel userspanel;
    // End of variables declaration//GEN-END:variables
}
