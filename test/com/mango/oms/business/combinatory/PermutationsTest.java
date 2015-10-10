package com.mango.oms.business.combinatory;

import com.mango.oms.business.combinatory.impl.OriginalPermutations;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class PermutationsTest {


    OriginalPermutations permutations = new OriginalPermutations();

    @Test
    public void shouldCalculateBasicPermutations3x2() throws Exception {

        List<WArray> actual = wrap(this.permutations.getPermutations(new int[]{5, 7, 4}, 2));

        assertThat(actual.size(), is(6));
        assertThat(actual, hasItem(new WArray(new int[]{2, 0, 0})));
        assertThat(actual, hasItem(new WArray(new int[]{1, 1, 0})));
        assertThat(actual, hasItem(new WArray(new int[]{0, 2, 0})));
        assertThat(actual, hasItem(new WArray(new int[]{1, 0, 1})));
        assertThat(actual, hasItem(new WArray(new int[]{0, 1, 1})));
        assertThat(actual, hasItem(new WArray((new int[]{0, 0, 2}))));

    }

    @Test
    public void shouldCalculateBasic2x1() throws Exception {
        List<WArray> actual = wrap(this.permutations.getPermutations(new int[]{5, 7}, 1));
        assertThat(actual.size(), is(2));
        assertThat(actual, hasItem(new WArray(new int[]{0, 1})));
        assertThat(actual, hasItem(new WArray(new int[]{1, 0})));


    }

    @Test
    public void shouldCalculateSearchingForIssuesFor2x0() throws Exception {
        List<int[]> actual = this.permutations.getPermutations(new int[]{5, 7, 4}, 0);
        assertThat(actual.size(), is(0));

    }

    @Test
    public void shouldCalculateSearchingForIssuesFor2x1WithZeroes() throws Exception {
        List<WArray> actual = wrap(this.permutations.getPermutations(new int[]{0, 2}, 1));
        assertThat(actual.size(), is(1));
        assertThat(actual, contains(new WArray(new int[]{0, 1})));

    }

    private List<WArray> wrap(List<int[]> unwrapped) {
        ArrayList<WArray> wrapped = new ArrayList<WArray>();
        for (int[] array: unwrapped) {
            wrapped.add(new WArray(array));
        }
        return wrapped;
    }

    public class WArray {
        private final int[] wrapped;

        public WArray(int[] wrapped) {
            this.wrapped = wrapped;
        }


        public int[] get() {
            return wrapped;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WArray that = (WArray) o;

            return Arrays.equals(wrapped, that.wrapped);

        }

        @Override
        public int hashCode() {
            return wrapped != null ? Arrays.hashCode(wrapped) : 0;
        }
    }}