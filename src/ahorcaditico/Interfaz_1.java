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
/**
 *
 * @author konrad
 */

// Segunda pantalla
public class Interfaz_1 extends JFrame {

    private final JLabel label1; // JLabel with just text
    private final JLabel label2; // JLabel constructed with text and icon  
    private final JLabel label3; // JLabel with added text and icon
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private JTextField textField1; // text field with set size
    private JTextField textField2; // text field constructed with text
 
    
    public Interfaz_1() {
        super("Ahorcaditico");
        setLayout(new FlowLayout()); // set frame layout
        
        textField1 = new JTextField();
        add(textField1);
        
        
        label1 = new JLabel("Te quedan 5 vidas");
        label1.setToolTipText("Cantidad de vidas restantes");
        
        add(label1); // add label1 to JFrame
        
// JLabel constructor with string, Icon and alignment arguments
        int num = 0;
        String hmn = "Ahorcado" + num + ".txt";
        Icon bug = new ImageIcon(getClass().getResource(hmn));
        label2 = new JLabel("Label with text and icon", bug, SwingConstants.LEFT);

        label2.setToolTipText("This is label2");
        add(label2); // add label2 to JFrame
       
        label3 = new JLabel(); // JLabel constructor no arguments

        label3.setText("Label with icon and text at bottom");
        label3.setIcon(bug); // add icon to JLabel

        label3.setHorizontalTextPosition(SwingConstants.CENTER);

        label3.setVerticalTextPosition(SwingConstants.BOTTOM);

        label3.setToolTipText("This is label3");
        add(label3); // add label3 to JFrame
       
    }
}
