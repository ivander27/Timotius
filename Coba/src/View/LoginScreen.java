/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.RegistrasiUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import Controller.Controller;
import javax.swing.JOptionPane;
/**
 *
 * @author Asus
 */
public class LoginScreen  extends JFrame implements ActionListener{
    JFrame Login;
    JLabel labelusername,labelpassword,labeljudul;
    JTextField fieldusername,fieldpassword,fieldemail;
    JButton confirmbutton,backbutton;
    
     public LoginScreen(){
        Login = new JFrame("Login");
        Login.setSize(400, 300);
        Login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Login.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Insert Data Dibawah ");
        labeljudul.setBounds(100, 10, 200, 30);
        
        labelusername = new JLabel("Name");
        labelusername.setBounds(45, 50, 100, 30);
        
        fieldusername = new JTextField();
        fieldusername.setBounds(150, 50, 200, 30);
        
        labelpassword = new JLabel("Password");
        labelpassword.setBounds(45, 100, 100, 30);
        
        fieldpassword = new JTextField();
        fieldpassword.setBounds(150, 100, 200, 30);        
        
        confirmbutton = new JButton("Confirm");
        confirmbutton.setBounds(45,150,300,30);
        confirmbutton.addActionListener(this);
        
        backbutton = new JButton("Back");
        backbutton.setBounds(250,200,100,30);
        backbutton.addActionListener(this);
        
        Login.add(labeljudul);
        Login.add(backbutton);
        Login.add(confirmbutton);
        Login.add(fieldusername);
        Login.add(labelusername);
        Login.add(labelpassword);
        Login.add(fieldpassword);
        Login.setLayout(null);
        Login.setVisible(true);
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
         String command = ae.getActionCommand();
        switch(command){
            case"Confirm":
                String name = fieldusername.getText();
                String password = fieldpassword.getText();
                String email = fieldemail.getText();
                ArrayList<RegistrasiUser> listuser = Controller.getAllusername();
                int cekname = Controller.cekDuplikatKode(name);
                if(name.equals("") && password.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }  else {
                    if(Controller.registrasi(name, password,email)){
                        JOptionPane.showMessageDialog(null, "Insert Berhasil!!");
                        Login.setVisible(false);
                        new MainMenu();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert gagal!!");
                        break;
                    }
                }
                case"Reset":
                Login.setVisible(false);
                new RegisterScreen();
                break;
                case"Back":
                Login.setVisible(false);
                new MainMenu();
                break;
            default:
                break;
        }
    }
}
