/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcaditico;

import java.util.Scanner;
import java.io.File;
import java.util.Random;

/**
 *
 * @author konrad
 */
public class Ahorcaditico {
    
boolean endgame = false;
    int chances = 6;
    int indice = 0;
    int posic = 0;
    char[] curr;
    char[] espacios;
    char[] aciertos;
    char[] fallos;
    int countF = 0;
    int countA = 0;


    /*Lee el archivo de texto que contiene todas las palabras*/
    String leearch(String str) {
        File file = new File(str);
        str = "";
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                str += sc.nextLine();
            }
            sc.close();
        } catch (Exception e) {
            System.out.print("No se encontro el archivo de las palabras!");
        }
        return str;
    }

    /* Recibe los datos en un string y retorna un vector con las palabras*/
    String[] dividePalabras(String data) {
        String[] words = data.split(",");
        return words;
    }

    /*Rellena un array de caracteres con la palabra*/
    void rellenador(String w) {
        curr = new char[w.length()];
        espacios = new char[curr.length];
        aciertos = new char[curr.length];
        fallos = new char[chances];
        for (int i = 0; i < w.length(); i++) {
            curr[i] = w.charAt(i);
        }
        for (int i = 0; i < curr.length; i++) {
            espacios[i] = '_';
        }

    }

    /*Imprime los espacios*/
    void spacer() {
        for (int j = 0; j < espacios.length; j++) {
            System.out.print(espacios[j] + " ");
        }
        System.out.println("");
    }

    /*Imprime la figura*/
    void printFig(int fail) {
        String num = Integer.toString(fail);
        String str = "Ahorcado" + num + ".txt";
        File file = new File(str);
        str = "";
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                str += sc.nextLine();
                str += "\n";
            }
            sc.close();
        } catch (Exception e) {
            System.out.print("No se encontro el archivo");
        }
        System.out.println(str);
    }

    /*Este metodo reimprime el dibujo y las oportunidades restantes*/
    void refresh(int num, boolean r, int pos) {
        System.out.println("\t\tOportunidades:" + chances);
        spacer();
        printFig(num);
    }

    /*Busca en el char[] una letra especifica y la sustituye en los espacios las veces que aparezca
     ---> retorna true si el caracter ingresado esta en la palabra*/
    boolean xstLetra(char elec) {
        int cont = 0;
        for (int i = 0; i < curr.length; i++) {
            if (elec == curr[i]) {
               espacios[i] = curr[i];
               cont++;
            }
        }
        if (cont > 0) {
            countA += cont-1;
            return true;
        }
        return false;
    }

    /*Analiza el caracter ingresado por el usuario*/
    boolean analice(char letra) {
        boolean s = true;
        if (xstLetra(letra) == true) {

            for (int i = 0; i < aciertos.length; i++) {
                if (aciertos[i] == letra) {
                    System.out.println("Ya intentaste esa letra, prueba otra");
                    s = false;
                }
            }
            if (s == true) {
                aciertos[countA] = letra;
                countA++;
            }
        } else if (xstLetra(letra) == false) {
            for (int i = 0; i < fallos.length; i++) {
                if (fallos[i] == letra) {
                    System.out.println("Ya intentaste esa letra, prueba otra");
                    s = false;
                }
            }
            if (s == true) {
                fallos[countF] = letra;
                countF++;
                chances--;

            }
        }
        return s;
    }

    /*Este metodo toma el control para interactuar con el usuario*/
    void parser(String pal) {
        System.out.println("Bienvenido a Ahorcaditico\n");
        rellenador(pal);
        boolean res = false;
        char letra = ' ';
        String choice = "";
        refresh(countF, res, posic);
        Scanner sc = new Scanner(System.in);
        while (endgame == false) {
            choice = sc.next();
            if (choice.equals(pal)) {
                endgame = true;
                System.out.println("Ya ganaste! -.-");
                           break;
            }
          
            letra = choice.charAt(0);
            res = analice(letra);
            while (res == false) {
                choice = sc.next();
                letra = choice.charAt(0);
                res = analice(letra);
            }
            refresh(countF, res, posic);
            endgame = ganador(pal);
        }
    }

    boolean ganador(String palabr) {
        if (chances == 0) {
            System.out.println("Perdiste!");
            System.out.println("La palabra era: " + palabr);
            return true;
        } else if (countA == curr.length) {
            System.out.println("Ganaste!!");
            return true;
        }
        return false;
    }

    boolean playAgain() {
        System.out.println("Quieres jugar de nuevo?(si/no)");
        Scanner sc = new Scanner(System.in);
        boolean corr = false, dele = true;
        while (corr == false) {
            String el = sc.next();
            switch (el) {
                case "si":
                    corr = true;
                    break;
                case "no":
                    dele = false;
                    corr = true;
                    break;
                default:
                    System.out.println("Ingresa una opcion valida");
                    break;
            }
        }
        return dele;
    }

    void reinicieDatos() {
        endgame = false;
        chances = 6;
        indice = 0;
        posic = 0;
        countF = 0;
        countA = 0;

    }
}

