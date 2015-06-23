/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcaditico;

import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.JFrame; // provides basic window features
import javax.swing.JLabel; // displays text and images
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; // loads images
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author konrad
 */

// Pantalla de Inicio
public class Interfaz extends JFrame {

    JLabel oportunidades, espacios, hangman;    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private JTextField textField1; // text field with set size
    private JTextField textField2; // text field constructed with text
    String chanx, spa;
    boolean another;
    Ahorcaditico ah;

    public Interfaz() {
        super("Ahorcaditico");
        setLayout(new FlowLayout()); // set frame layout
        ah = new Ahorcaditico();
        ah.newGame();
        chanx = "Te quedan " + Integer.toString(ah.chances) +" chances";
     //   another = ah.keepit;
        oportunidades = new JLabel(chanx);
        oportunidades.setHorizontalTextPosition(SwingConstants.LEFT);
        oportunidades.setVerticalTextPosition(SwingConstants.BOTTOM);
        oportunidades.setToolTipText("Cantidad de vidas restantes");
        add(oportunidades);
       
        espacios = new JLabel(ah.spaces);//, SwingConstants.LEFT);
        espacios.setFont(new Font("Serif", Font.PLAIN, 54));
        espacios.setHorizontalTextPosition(SwingConstants.CENTER);
        espacios.setVerticalTextPosition(SwingConstants.BOTTOM);
        espacios.setToolTipText("Espacios restantes por adivinar");
        add(espacios); // add label2 to JFrame
        
        Icon hng = new ImageIcon(getClass().getResource(ah.draw));
        hangman = new JLabel(hng);
        add(hangman);
        
    }
  
     //Este metodo toma el control para interactuar con el usuario
    void parser() {
        rebuild();
        boolean endit = false;
        String choice;
        while (!endit) {
            choice = JOptionPane.showInputDialog("Adivina la plalabra");
            if (choice.equals(ah.palabra)) {
                ah.rellenela();
                rebuild();
                JOptionPane.showMessageDialog(null, "Ya Ganaste -.-");
                break;
            }
            char letra = choice.charAt(0);
            ah.analice(letra);
          //  choice = JOptionPane.showInputDialog("Sigue intentando");
           // letra = choice.charAt(0);
            //seg = ah.analice(letra);
            ah.refresh();
            rebuild();
            endit = ah.finish();
        }
        
        if(ah.playAgain()){
            ah.newGame();
            parser();
        }
    }
    
    void rebuild(){
         chanx = "Te quedan " + Integer.toString(ah.chances) +" chances";
         oportunidades.setText(chanx);
         spa = ah.spaces;
         System.out.println("Los espacios son "+spa);
         espacios.setText(spa);
         //espacios.setIcon(new ImageIcon(getClass().getResource(ah.draw)));
        System.out.println(ah.draw);
        hangman.setIcon(new ImageIcon(getClass().getResource(ah.draw)));
        
      
    }

}

