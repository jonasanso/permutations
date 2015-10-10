package com.mango.oms.business.combinatory.impl;

import com.mango.oms.business.combinatory.Permutations;

import java.util.*;

public class RecursivePermutations implements Permutations {

    public List<int[]> getPermutations(int[] stock, int amount) {
        if (amount == 0)
            return new ArrayList<>();
        else
            return filter(recursivePermutations(stock, amount), amount);
    }

    public List<int[]> recursivePermutations(int[] stock, int amount) {
        switch (stock.length){
            case 0 :
                return trivial(0);
            case 1 :
                return trivial(Math.min(stock[0], amount));
            default:
                return reduce(stock[0], tail(stock), amount);
        }
    }

    private List<int[]> trivial(int stock) {
        ArrayList<int[]> res = new ArrayList<>();
        res.add(new int[]{stock});
        return res;
    }

    private List<int[]> reduce(int head, int[] tail, int amount) {
        ArrayList<int[]> all = new ArrayList<>();

        int[] headRange = range(Math.min(head, amount));
        for (int firstStock : headRange) {
            List<int[]> permutations = recursivePermutations(tail, amount - firstStock);
            List<int[]> combined = combine(firstStock, permutations, tail.length);
            all.addAll(combined);
        }


        return all;
    }

    private List<int[]> filter(List<int[]> permutations, int amount) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] permutation : permutations) {
            if (sum(permutation) == amount)
                res.add(permutation);
        }

        return res;
    }

    private int sum(int[] permutation) {
        int res = 0;
        for (int el : permutation) {
            res+= el;
        }

        return res;
    }

    //TODO: Very poor imlmemtation
    private int[] range(int max) {
        int[] res = new int[max + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i;

        }
        return res;
    }

    private List<int[]> combine(int firstStock, List<int[]> permutations, int lenght) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] permutation : permutations) {
          res.add(prepend(firstStock, permutation));
        }
        return res;

    }

    private int[] prepend(int firstStock, int[] permutation) {
        int[] res = new int[permutation.length + 1];
        res[0] = firstStock;
        System.arraycopy(permutation, 0, res, 1, permutation.length);
        return res;
    }


    private int[] tail(int[] stock) {
        return Arrays.copyOfRange(stock, 1, stock.length);
    }
}
