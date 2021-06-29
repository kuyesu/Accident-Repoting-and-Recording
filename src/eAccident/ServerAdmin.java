/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eAccident;

/**
 *
 * @author goodman
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class ServerAdmin {

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    ObjectOutputStream serverObjectStreamWriter;
    ObjectInputStream serverObjectStreamReader, isReader;

    ServerSocket s_socket;
    Socket clientSocket;
    MainSerializable obj;

    public ServerAdmin() {
        go();
    }

    public void go() {
        try {
            System.out.println("Please wait, setting up Server connections");
            s_socket = new ServerSocket(5000);
            obj = new MainSerializable();
            clientSocket = s_socket.accept();
            serverObjectStreamReader = new ObjectInputStream(clientSocket.getInputStream());
            serverObjectStreamWriter = new ObjectOutputStream(clientSocket.getOutputStream());
            Thread t = new Thread(new ServerRunnable());
            t.start();
            System.out.println("Server Connected");
        } catch (IOException e) {
        }
    }

    public class ServerRunnable implements Runnable {

        @Override
        public void run() {

            try {
                while ((obj = (MainSerializable) serverObjectStreamReader.readObject()) != null) {
                    System.out.println("Records received");
                    String firstName = obj.firstName;
                    String lastName = obj.lastName;
                    String designation = obj.designation;
                    String officer_no = obj.officer_no;
                    String date_joined = obj.date_joined;
                    String date_of_birth = obj.date_of_birth;
                    String sex = obj.sex;
                    String district = obj.district;
                    String nationality = obj.nationality;

                    go();

                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/accident", "rogers", "rogers81");
                    pstmt = conn.prepareStatement("insert into officer(fName,lName,designation,officer_no,date_of_birth,sex,date_joined,district,nationality) values(?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, firstName);
                    pstmt.setString(2, lastName);
                    pstmt.setString(3, designation);
                    pstmt.setString(4, officer_no);
                    pstmt.setString(5, date_of_birth);
                    pstmt.setString(6, sex);
                    pstmt.setString(7, date_joined);
                    pstmt.setString(8, district);
                    pstmt.setString(9, nationality);
                    //pstmt.setBytes(10, profile_pic);
                    pstmt.executeUpdate();
                    //JOptionPane.showMessageDialog( " Officer added successfully");

                    conn.close();

                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(SuperAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ServerAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
       ServerAdmin ss = new ServerAdmin();
       ss.go();
    }

}
