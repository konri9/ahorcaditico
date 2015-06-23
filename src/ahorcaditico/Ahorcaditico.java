/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcaditico;

import java.util.Scanner;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author konrad
 */
public class Ahorcaditico {

    //Variables globales
    boolean keepit = false;
    int chances = 6, indice = 0, posic = 0;
    char[] word, espacios, aciertos, fallos;
    int countF = 0, countA = 0, corrA;
    String palabra = "", spaces = "", draw;
    String[] palabras, usadas;

    //Constructor ordinario -> genera una partida con base en las palabras ingresadas por el usuario
    Ahorcaditico() {
        String datos = JOptionPane.showInputDialog("Ingresa las letras separadas por comas");
        palabras = datos.split(",");
    }

    void newGame() {
        palabra = palabras[(int) (Math.random() * (palabras.length - 0))];
        reinicieDatos();
        for (int i = 0; i < palabra.length(); i++) {
            word[i] = palabra.charAt(i);
        }
        for (int i = 0; i < word.length; i++) {
            espacios[i] = '_';
        }
        spacer();
        draw();
        // parser();
    }

    // Recibe un vector y un caracter
    // Retorna true si el caracter se encuentra en el vector
    boolean yala(char[] e, char l) {
        for (int i = 0; i < e.length; i++) {
            if (e[i] == l) {
                return true;
            }
        }
        return false;
    }
    
    boolean usadas(String w, String[] u){
        
        return false;
    }
    

    //Imprime la figura
    void draw() {
        String num = Integer.toString(countF);
        draw = "hangman" + num + ".png";
       // System.out.println(draw);
    }

    //Reimprime el dibujo y las oportunidades restantes
    void refresh() {
        spacer();
        draw();
    }

    //Llena un string con los espacios correspondientes
    void spacer() {
        spaces = "";
        for (int i = 0; i < espacios.length; i++) {
            spaces += espacios[i] + " ";
        }
    }

    //Busca en el char[] una letra especifica y la sustituye en los espacios las veces que aparezca
    //retorna true si el caracter ingresado esta en la palabra
    boolean xstLetra(char elec) {
        int cont = 0;
        for (int i = 0; i < word.length; i++) {
            if (elec == word[i]) {
                espacios[i] = word[i];
                cont++;
            }
        }
        if (cont > 0){
            if(!yala(aciertos,elec)) corrA += cont;
            return true;
        }
        return false;
    }

    //Analiza el caracter ingresado por el usuario
    //retorna true si el acierta, false caso contrario
    void analice(char letra) {
        boolean esta = false;
        if (xstLetra(letra)) {
            esta = yala(aciertos, letra);
            if (esta) {
                JOptionPane.showMessageDialog(null, "Error", "Ya acertaste esa letra!", JOptionPane.ERROR_MESSAGE);
            } else if (!esta) {
                aciertos[countA] = letra;
                countA++;
            }
        } else if (!xstLetra(letra)) {
            esta = yala(fallos, letra);
            if (esta) {
                JOptionPane.showMessageDialog(null, "Error", "Ya intentaste esa letra!", JOptionPane.ERROR_MESSAGE);
            } else if (!esta) {
                fallos[countF] = letra;
                countF++;
                chances--;
            }
        }
    }

    void rellenela() {
        for (int i = 0; i < word.length; i++) {
            espacios[i] = word[i];
        }
    }

    //Retorna true si el usuario gana, false en caso contrario
    boolean finish() {
        if (chances == 0) {
            JOptionPane.showMessageDialog(null, "Perdiste!\nLa palabra era: " + palabra);
            return true;
        } else if (corrA == word.length) {
            JOptionPane.showMessageDialog(null, "Ganaste", "Ganaste!!", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    //Ve si el usuario quiere jugar de nuevo
    boolean playAgain() {
        String el = JOptionPane.showInputDialog("Quieres jugar de nuevo?(si/no)");
        if (el.equals("si")) {
            newGame();
            return true;
        }
        if (el.equals("no")) {
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Advertencia", "Ingresa una opcion valida", JOptionPane.WARNING_MESSAGE);
            playAgain();
        }
        return false;
    }

//Reinicia todas las variables para una nueva partida
    void reinicieDatos() {
        chances = 6;
        posic = 0;
        countF = 0;
        countA = 0;
        corrA = 0;
        word = new char[palabra.length()];
        espacios = new char[palabra.length()];
        aciertos = new char[palabra.length()];
        fallos = new char[chances];
    }
}
