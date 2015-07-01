/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcaditico;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author konrad
 */
public class main {

    /**
     * @param args the command line arguments
     */
    //add exception for repeated words
   public static void main(String[] args) {
        
         Interfaz intf = new Interfaz();
         intf.getContentPane().setBackground(Color.white);
         intf.setSize(600, 500); // set frame size
         int lebar = intf.getWidth()/2, tinggi = intf.getHeight()/2;
         int x = (Toolkit.getDefaultToolkit().getScreenSize().width/2)-lebar;
         int y = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-tinggi;
         intf.setLocation(150, 200);
         intf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         intf.setVisible(true); // display frame       
         intf.parser();
    }
   
}
