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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ahorcaditico jugador = new Ahorcaditico();
        String datos = jugador.leearch("palabras.txt");
        String[] palabras = jugador.dividePalabras(datos);
        boolean juegue = true;
        while (juegue == true){
        jugador.parser(palabras[(int)(Math.random() * (palabras.length - 0))]);
        juegue = jugador.playAgain();
        if (juegue == true) jugador.reinicieDatos();
        }
    }
}
