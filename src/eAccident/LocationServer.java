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

/**
 *
 * @author goodman
 */
public class LocationServer {

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    ObjectOutputStream serverObjectStreamWriter;
    ObjectInputStream serverObjectStreamReader, isReader;

    ServerSocket s_socket;
    Socket clientSocket;
    MainSerializable obj;

    public LocationServer() {
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
                    String region  = obj.region;
                    String district = obj.district;
                    String place = obj.place;
                    String description = obj.description;

                    go();

                    Class.forName("com.mysql.jdbc.Driver");
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/accident", "rogers", "rogers81");
                    pstmt = conn.prepareStatement("insert into location(region,district,place,description,report_id) values(?,?,?,?,(select report_id from user_data WHERE report_id= (select MAX(report_id) from user_data)))");
                    System.out.print("Inserted Successfully");
                    pstmt.setString(1, region);
                    pstmt.setString(2, district);
                    pstmt.setString(3, place);
                    pstmt.setString(4, description);
                    pstmt.executeUpdate();

                    conn.close();

                    conn.close();

                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Location_Detail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Location_Detail.class.getName()).log(Level.SEVERE, null, ex);
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
        LocationServer ss = new LocationServer();
        ss.go();
    }

}
