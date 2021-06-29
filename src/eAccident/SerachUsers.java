/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eAccident;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author goodman
 */
public class SerachUsers {
    

    public static Statement stmt;
    public static PreparedStatement pstmt;
    public static Connection conn;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/accident", "rogers", "rogers81");
            stmt = conn.createStatement();
            pstmt = conn.prepareStatement("select officer_no,fName,lName,sex,nationality,date_of_birth,district,date_joined,district from officer where fName like ?");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchDatabaseRecords.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchDatabaseRecords.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static ResultSet pstmt(String fName) throws SQLException{
        pstmt.setString(1, "%"+fName +"%");
        return pstmt.executeQuery();
    }
    
}
