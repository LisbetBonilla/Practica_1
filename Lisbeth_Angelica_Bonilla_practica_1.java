package com.tiernoparla.Practica_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lisbeth_Angelica_Bonilla_practica_1 {

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

        int expo = 0;
        int contador_mens = 0;
        int cont1 = 0;
        cont1 = 0;

        //MENSAJE***************************************************************
        hacerMensajeRandom(mensaje, rnd);
        System.out.println(Arrays.toString(mensaje));

        //SENDER****************************************************************
        bitpar = calcularBitspar(POTEN, bitpar, tam_mens1);
        System.out.println("Los bits de pariedad que usaremos son: " + bitpar);

        final int TAM_MENS2 = tam_mens1 + (bitpar + 1);

        System.out.println("El tamaño delmensaje nuevo es de : " + TAM_MENS2);
        int[] mens2 = new int[TAM_MENS2];

        señaloPosicionesDePotencia2(mens2, POTEN, expo, mensaje, contador_mens);

        cont1 = contar0Y1(mens2, cont1);
        
        System.out.println(" ");
        
        ubicaBitspar(mens2, cont1);

    }//main

    public static void ubicaBitspar(int[] mens2, int cont1) {
        for (int i = 1; i < mens2.length; i++) {
            if (mens2[i] == 1) {
                cont1++;
            }//if
        }//cierre for

        if ((cont1 % 2) == 0) {
            mens2[0] = 0;
        }//cierre if
        else {
            mens2[0] = 1;
        }//cierre
        System.out.println("El Bit global es: " + mens2[0]);
    }

    public static int contar0Y1(int[] mens2, int cont1) {
        for (int x = 1; x < mens2.length; x++) {
            for (int z = 1; z < mens2.length; z++) {
                if (mens2[x] == 2 && (x & z) != 0 && mens2[z] == 1) {
                    cont1++;
                }//if
            }//for2
            if (mens2[x] == 2 && cont1 % 2 == 1) {
                mens2[x] = 1;
                cont1 = 0;
            } else if (mens2[x] == 2 && cont1 % 2 != 1) {
                mens2[x] = 0;
                cont1 = 0;
            }//else if
            System.out.print(mens2[x]);
        }//for
        return cont1;
    }

    public static void señaloPosicionesDePotencia2(int[] mens2, final int POTEN,
            int expo, int[] mensaje, int contador_mens) {
        for (int i = 1; i < mens2.length; i++) {
            if (Math.pow(POTEN, expo) != i) {
                mens2[i] = mensaje[contador_mens];
                contador_mens++;
            }//if
            else {
                mens2[i] = 2;
                expo++;
            }//else
        }//for
    }

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
