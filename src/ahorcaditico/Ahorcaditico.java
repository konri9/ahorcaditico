/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcaditico;

/**
 *
 * @author konrad
 */
public class Ahorcaditico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int indicePalabra;
        Metodos me = new Metodos();
        String datos = me.leearch("palabras.txt");
        String[] palabras = me.dividePalabras(datos);
        boolean juegue = true;
        while (juegue == true){
        indicePalabra = me.eligePalabra(palabras);
        me.parser(palabras[indicePalabra]);
        juegue = me.playAgain();
        if (juegue == true) me.reinicieDatos();
        }
    }

}
