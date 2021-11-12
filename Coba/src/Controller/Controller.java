/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RegistrasiUser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static ArrayList<RegistrasiUser> getAllusername() {
        ArrayList<RegistrasiUser> user = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RegistrasiUser usr = new RegistrasiUser();
                usr.setName(rs.getString("name"));
                usr.setPassword(rs.getString("password"));
                usr.setEmail(rs.getString("email"));
                user.add(usr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);           
    }
    public static boolean registrasi(String name, String password,String email){
        conn.connect();
        String query = "INSERT INTO user VALUES (?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return(false);
    }
    
    public static int cekDuplikatKode(String name){
        conn.connect();
        int total = 0;
        String query = "SELECT name FROM user WHERE name = '" + name + "'";
        ArrayList<RegistrasiUser> listusername = new ArrayList<>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RegistrasiUser usr = new RegistrasiUser();
                usr.setName(rs.getString("name"));
                listusername.add(usr);
            }
            total = listusername.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
     public static boolean delete(String name){
        conn.connect();
        String query =  "DELETE FROM user WHERE username = ?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.executeUpdate();
            return(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return(false);
    }
     public static boolean login(String name,String password){
        return false;
        
    }
}
