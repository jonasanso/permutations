package com.mango.oms.business.combinatory.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    // Permutaciones de elementos en stock que sumen amount
    //	X + Y + ... = amount, siendo X>0 y X<=stock[i]
    public List<int[]> getPermutations(int[] stock, int amount) {
        // Si hay stock y el amount >0
        //	entonces calulamos las permutaciones
        if (stock != null && amount > 0) {

            // En función de la longitud del stock aplicamos
            //	diferentes algoritmos
            if (stock.length == 2)
                return getPermutationsTwo(stock, amount);
            if (stock.length == 3)
                return getPermutationsThree(stock, amount);
        }

        return new ArrayList<int[]>();
    }


    // Permutaciones de elementos en stock que sumen amount
    //	stock[0] + stock[1] = amount
    private List<int[]> getPermutationsTwo(int[] stock, int amount) {
        List<int[]> result = new ArrayList<int[]>();

        // Si no hay stock retornamos una lista vacía
        if (null == stock || 0 == stock.length)
            return result;

        int [] n= new int[stock.length];

        // Asignamos valores a X entre 0 y amount
        //	calculamos Y = amount -X
        for (int i = 0; i <= amount; i++) {
            n[1] = i;
            n[0] = amount - n[1];

            // Descartamos valores de X o Y negativos
            if (n[0] < 0 || n[1] < 0)
                continue;
                // Descartamos valores de X o Y superiores al stock
            else if (n[0] > stock[0] || n[1] > stock[1])
                continue;

            result.add(Arrays.copyOf(n, n.length));
        }

        return result;
    }


    // Permutaciones de elementos en stock que sumen amount
    //	stock[0] + stock[1] + stock[2] = amount
    private List<int[]> getPermutationsThree(int[] stock, int amount) {
        List<int[]> result = new ArrayList<int[]>();

        // Si no hay stock retornamos una lista vacía
        if (null == stock || 0 == stock.length)
            return result;

        int [] n= new int[stock.length];

        // Asignamos valores a X y a Yentre 0 y amount
        //	calculamos Z = amount - X - Y
        for (int j = 0; j <= amount; j++) {
            n[2] = j;
            for (int i = 0; i <= amount; i++) {
                n[1] = i;
                n[0] = amount - n[1] - n[2];

                // Descartamos valores negativos
                if (n[0] < 0 || n[1] < 0 || n[2] <0)
                    continue;
                    // // Descartamos valores superiores al stock
                else if (n[0] > stock[0] || n[1] > stock[1] || n[2] > stock[2])
                    continue;

                result.add(Arrays.copyOf(n, n.length));
            }
        }

        return result;
    }

}