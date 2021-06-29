/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eAccident;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author goodman
 */
public class MainSerializable implements Serializable {

    String firstName;
    String lastName;
    String designation;
    String officer_no;
    String date_joined;
    String date_of_birth;
    String sex;
    String district;
    String nationality;
    String region;
    String place;
    String description;

    //String firstName;
    //String lastName;
    String tel;
    String email;

    public MainSerializable() {
        firstName = "";
        lastName = "";
        designation = "";
        officer_no = "";
        date_joined = "";
        date_of_birth = "";
        sex = "";
        district = "";
        nationality = "";
        region = "";
        place = "";
        description = "";

        //............User data............//
        tel = "";
        email = "";
    }

}
