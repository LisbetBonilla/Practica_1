package com.tiernoparla.Practica_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hamming_2 {

    public static void main(String[] args) {
        //MENSAJE******************************************************************
        System.out.println("Inserta los bits que quieras que tenga el mensaje"
                + " no mayor de 27: ");

        //VARIABLES---------------------------------------------------------------//   
        Scanner mens = new Scanner(System.in);
        int mens1 = mens.nextInt();

        int[] mensaje = new int[mens1];
        final int tam_arr = mensaje.length;
        Random rnd = new Random();

        int poten = 2;
        int bitpar = 0;

        hacerMensajeRandom(mensaje, rnd);

        System.out.println(Arrays.toString(mensaje));

        calcularBitpar(poten, bitpar, tam_arr);
        

        

    }//main

    public static int calcularBitpar(int poten, int bitpar, final int tam_arr) {
        while (Math.pow(poten, bitpar) < bitpar + (tam_arr + 1)) {
            bitpar++;
        }
         System.out.println("Los bits de pariedad para tu mensajes son: " 
                 + bitpar);
        return bitpar;
    }

    public static void hacerMensajeRandom(int[] mensaje, Random rnd) {
        for (int i = 0; i < mensaje.length; i++) {
            mensaje[i] = (rnd.nextBoolean()) ? 1 : 0;
        }//for
    }

}//public class
