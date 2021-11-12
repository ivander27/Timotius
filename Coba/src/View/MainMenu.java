/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Asus
 */
public class MainMenu extends JFrame implements ActionListener{
    JFrame frame_main;
    JButton registerbutton,lihatdatabutton,loginbutton,updatebutton;
    JLabel label_atas;
    public MainMenu(){
        frame_main = new JFrame();
        frame_main.setSize(400, 300);
        frame_main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame_main.setLocationRelativeTo(null);
        
        label_atas = new JLabel("Quis Pbo");
        label_atas.setBounds(170, 20, 100, 30);
        
        loginbutton = new JButton("Login");
        loginbutton.setBounds(45, 60, 300, 30);
        loginbutton.addActionListener(this);
        registerbutton = new JButton("Registrasi");
        registerbutton.setBounds(45, 100, 300, 30);
        registerbutton.addActionListener(this);
        lihatdatabutton = new JButton("Lihat Data");
        lihatdatabutton.setBounds(45, 140, 300, 30);
        lihatdatabutton.addActionListener(this);
        updatebutton = new JButton("Update Data");
        updatebutton.setBounds(45, 180, 300, 30);
        updatebutton.addActionListener(this);       
        
        frame_main.add(label_atas);
        frame_main.add(registerbutton);
        frame_main.add(lihatdatabutton);
        frame_main.add(loginbutton);
        frame_main.add(updatebutton);
        frame_main.setLayout(null);
        frame_main.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case "Login":
                frame_main.setVisible(false);
                new LoginScreen();
                break;
            case "Registrasi":
                frame_main.setVisible(false);
                new RegisterScreen();
                break;
            case "Lihat Data":
                frame_main.setVisible(false);
                new AllDataScreen();
                break;       
            case "Update":
                frame_main.setVisible(false);
                new UpdateScreen();
                break;         
        }
    }
}
