/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import Controller.Controller;
import Model.RegistrasiUser;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author Asus
 */
public class AllDataScreen extends JFrame implements ActionListener {
    JFrame listusername;
    String[][] data;
    String[] kolom = {"username","password","Email"};
    JTable tabelJur;
    JLabel labelusername,labelpassword,labelemail,labeluser,labelpass,labelem;
    String username = "";
    String password = "";
    String email = "";
    JComboBox listuser;
    JButton backbutton;
   
    public AllDataScreen(){
        listusername = new JFrame("Daftar User");
        listusername.setSize(500, 500);
        listusername.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        listusername.setLocationRelativeTo(null);
        
        labeluser = new JLabel("Username");
        labeluser.setBounds(25, 20, 200, 30);
        labelpass = new JLabel("password");
        labelpass.setBounds(25, 50, 500, 30);
        labelem = new JLabel("email");
        labelem.setBounds(25,70,800,30);
        ArrayList<RegistrasiUser> listusr = Controller.getAllusername();
         for(int i = 0; i < listusr.size(); i++){
            username += listusr.get(i).getName() + " ";
            password += listusr.get(i).getPassword() + " ";
            email += listusr.get(i).getEmail()+" ";
        labelusername = new JLabel(username);
        labelusername.setBounds(100, 20, 200, 30);
        labelpassword = new JLabel(password);
        labelpassword.setBounds(100, 50, 500, 30);
        labelemail = new JLabel(email);
        labelemail.setBounds(100,70,800,30);
        
        backbutton = new JButton("Back");
        backbutton.setBounds(80, 100, 300, 30);
        backbutton.addActionListener(this);
        
        listusername.add(labelusername);
        listusername.add(labelpassword);
        listusername.add(labelemail);
        listusername.add(labeluser);
        listusername.add(labelpass);
        listusername.add(labelem);
        
        listusername.setLayout(null);
        listusername.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
          listusername.setVisible(false);
          new MainMenu();              
        }
}

