/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eAccident;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author goodMan
 */
class User {
    private String firstName, lastName,designation,Id_no, district,region,gender;
    public User(String firstName,String lastName, String designation, String Id_no, String district,String region,String gender){
        this.firstName=firstName;
        this.lastName=lastName;
        this.designation=designation;
        this.Id_no=Id_no;
        this.district=district;
        this.gender=gender;
        this.region=region;
        
        
    }
    //getta metthod to return values
    public String getfirstName(){
        return firstName;
    }
    public String getlastName(){
        return lastName;
    }
    public String getdesignation(){
        return designation;
    }
    public String getId_no(){
        return Id_no;
    }
    public String getdistrict(){
        return district;
    }
    public String getgender(){
        return gender;
    }
   
    public String getregion(){
        return region;
    }
    
}


/*
 public ArrayList<User> userList(){
        ArrayList<User> usersList = new ArrayList<>();
        //Selecting from database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/e-accident-registration-and-reporting","rogers","rogers81");
            
            System.out.print("Successfully connected");
            String query = "SELECT Id_no,firstName,lastName,designation,gender,region,district FROM `e-accident-registration-and-reporting`.`add user`"; 
            System.out.print("Successfully connected");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            //System.out.print("Successfully connected");
            
            //Object user
            User user;
            while(rs.next()){
                user=new User(rs.getString("Id_no"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("designation"),rs.getString("gender"),rs.getString("region"),rs.getString("district"));
                //add user in the user list
                usersList.add(user);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Police_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Police_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersList;
    }
    
    ///Method to display in the JTable for all Officials
    public void show_user(){
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId_no();
            row[1]=list.get(i).getfirstName();
            row[2]=list.get(i).getlastName();
            row[3]=list.get(i).getdesignation();
            row[4]=list.get(i).getgender();
            row[5]=list.get(i).getregion();
            row[6]=list.get(i).getdistrict();
            model.addRow(row);
            
        }
    }
*/