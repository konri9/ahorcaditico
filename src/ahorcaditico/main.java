/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcaditico;
import javax.swing.JOptionPane;
import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.JFrame; // provides basic window features
import javax.swing.JLabel; // displays text and images
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; // loads images
import java.awt.Toolkit;
import java.io.File;
import java.util.Scanner;
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
        boolean juegue = true;
        Ahorcaditico jugador = new Ahorcaditico();
        JOptionPane.showInputDialog("Ingresa las palabras separadas por comas");
        //jugador = new Ahorcaditico("palabras.txt");
        Interfaz intf = new Interfaz();
        intf.setSize(1000, 1000); // set frame size
        int lebar = intf.getWidth()/2, tinggi = intf.getHeight()/2;
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width/2)-lebar;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-tinggi;
        intf.setLocation(x, y);
        intf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        intf.setVisible(true); // display frame
        while (juegue == true){
        juegue = jugador.playAgain();
        if (juegue == true) jugador.reinicieDatos();
        }
    }
}
