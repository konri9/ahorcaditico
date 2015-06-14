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
        Ahorcaditico jugador = new Ahorcaditico();
        String datos = jugador.leearch("palabras.txt");
        datos = JOptionPane.showInputDialog("Ingresa las palabras separadas por comas");
        //jugador.analizex();
        String[] palabras = jugador.dividePalabras(datos);
        boolean juegue = true;
        while (juegue == true){
        jugador.parser(palabras[(int)(Math.random() * (palabras.length - 0))]);
        juegue = jugador.playAgain();
        if (juegue == true) jugador.reinicieDatos();
        }
    }
}
