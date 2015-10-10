package com.mango.oms.business.combinatory;

import java.util.List;

public interface Permutations {
    // Permutaciones de elementos en stock que sumen amount
    //	X + Y + ... = amount, siendo X>0 y X<=stock[i]
    List<int[]> getPermutations(int[] stock, int amount);
}
