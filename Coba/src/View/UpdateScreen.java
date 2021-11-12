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
public class UpdateScreen extends JFrame implements ActionListener{
    JFrame Update;
    JLabel labelusername,labeljudul;
    JTextField fieldusername;
    JButton deletebutton;
    
    public UpdateScreen(){
        Update = new JFrame("Registrasi");
        Update.setSize(400, 300);
        Update.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Update.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Insert Data Dibawah ");
        labeljudul.setBounds(100, 10, 200, 30);
        
        labelusername = new JLabel("Username");
        labelusername.setBounds(45, 50, 100, 30);
        
        fieldusername = new JTextField();
        fieldusername.setBounds(150, 50, 200, 30);
        
        deletebutton = new JButton("Delete");
        deletebutton.setBounds(45,150,300,30);
        deletebutton.addActionListener(this);
        
        Update.add(labeljudul);
        Update.add(deletebutton);
        Update.add(fieldusername);
        Update.add(labelusername);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"Update":
                String username = fieldusername.getText();
                ArrayList<RegistrasiUser> listuser = Controller.getAllusername();
                if(username.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    if(Controller.delete(username)){
                        JOptionPane.showMessageDialog(null, "Delete Berhasil!!");
                        Update.setVisible(false);
                        new MainMenu();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Delete gagal!!");
                        break;
                    }
                }
               
        }
    }
}
