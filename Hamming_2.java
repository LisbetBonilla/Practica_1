package com.tiernoparla.Practica_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hamming_2 {

    public static void main(String[] args) {

        System.out.println("Inserta los bits que quieras que tenga el mensaje"
                + " no mayor de 27: ");

        //VARIABLES-----------------------------------------------------------//   
        Scanner mens = new Scanner(System.in);
        int mens1 = mens.nextInt();

        int[] mensaje = new int[mens1];
        final int tam_mens1 = mensaje.length;
        Random rnd = new Random();

        final int POTEN = 2;
        int bitpar = 0;
        
        //MENSAJE***************************************************************
        hacerMensajeRandom(mensaje, rnd);
        System.out.println(Arrays.toString(mensaje));

        //SENDER****************************************************************
        
        bitpar = calcularBitspar(POTEN, bitpar, tam_mens1);
        System.out.println("Los bits de pariedad que usaremos son: " + bitpar);
        
        final int TAM_MENS2 = tam_mens1 + (bitpar + 1);

        System.out.println("El tamaño del array nuevo + bitpar es de :" 
                + TAM_MENS2);
        int[] mens2 = new int[TAM_MENS2];


    }//main

    public static int calcularBitspar(final int POTEN, int bitpar, 
            final int tam_mens1) {
        while (Math.pow(POTEN, bitpar) < bitpar + tam_mens1 + 1) {
            bitpar++;
        }//while  
        return bitpar;
    }

    public static void hacerMensajeRandom(int[] mensaje, Random rnd) {
        for (int i = 0; i < mensaje.length; i++) {
            mensaje[i] = (rnd.nextBoolean()) ? 1 : 0;
        }//for
    }

}//public class
