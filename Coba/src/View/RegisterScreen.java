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
import javax.swing.JPasswordField;
/**
 *
 * @author Asus
 */
public class RegisterScreen extends JFrame implements ActionListener{
    JFrame registrasi;
    JLabel labelusername,labeljudul,labelemail,labelpassword;
    JPasswordField fieldpassword;
    JTextField fieldusername,fieldemail;
    JButton confirmbutton,backbutton;
    
    public RegisterScreen(){
        registrasi = new JFrame("Registrasi");
        registrasi.setSize(400, 450);
        registrasi.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        registrasi.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Insert Data Dibawah ");
        labeljudul.setBounds(100, 10, 200, 30);
        
        labelusername = new JLabel("Name");
        labelusername.setBounds(45, 50, 100, 30);
        
        fieldusername = new JTextField();
        fieldusername.setBounds(150, 50, 200, 30);
        
        labelpassword = new JLabel("Password");
        labelpassword.setBounds(45, 100, 100, 30);
        
        fieldpassword = new JPasswordField();
        fieldpassword.setBounds(150, 100, 200, 30); 
        
        labelemail = new JLabel("Email");
        labelemail.setBounds(45,150,100,30);        
        
        fieldemail = new JTextField();
        fieldemail.setBounds(150,150,200,30);
                
        confirmbutton = new JButton("Confirm");
        confirmbutton.setBounds(45,200,300,30);
        confirmbutton.addActionListener(this);
        
        backbutton = new JButton("Back");
        backbutton.setBounds(250,250,100,30);
        backbutton.addActionListener(this);
        
        registrasi.add(labeljudul);
        registrasi.add(backbutton);
        registrasi.add(confirmbutton);
        registrasi.add(fieldusername);
        registrasi.add(labelusername);
        registrasi.add(labelpassword);
        registrasi.add(fieldpassword);
        registrasi.add(labelemail);
        registrasi.add(fieldemail);
        registrasi.setLayout(null);
        registrasi.setVisible(true);
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
                } else if(cekname > 0){
                    JOptionPane.showMessageDialog(null, "Kode Sudah Terpakai!!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    if(Controller.registrasi(name, password,email)){
                        JOptionPane.showMessageDialog(null, "Insert Berhasil!!");
                        registrasi.setVisible(false);
                        new MainMenu();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert gagal!!");
                        break;
                    }
                }
                case"Back":
                registrasi.setVisible(false);
                new MainMenu();
                break;
            default:
                break;
        }
    }
    
}
