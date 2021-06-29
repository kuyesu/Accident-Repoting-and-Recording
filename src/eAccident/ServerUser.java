/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eAccident;

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

/**
 *
 * @author goodman
 */
public class ServerUser {

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    ObjectOutputStream serverObjectStreamWriter;
    ObjectInputStream serverObjectStreamReader, isReader;

    ServerSocket s_socket;
    Socket clientSocket;
    MainSerializable obj;

    public ServerUser() {
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
                    String tel = obj.tel;
                    String email = obj.email;

                    go();

                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/accident", "rogers", "rogers81");
                    pstmt = conn.prepareStatement("insert into user_data(firstName,lastName,tel,email) values(?,?,?,?)");
                    pstmt.setString(1, firstName);
                    pstmt.setString(2, lastName);
                    pstmt.setString(3, tel);
                    pstmt.setString(4, email);
                    pstmt.executeUpdate();
                    

                    conn.close();

                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(User_Data.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(User_Data.class.getName()).log(Level.SEVERE, null, ex);
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
        ServerUser ss = new ServerUser();
        ss.go();
    }

}
