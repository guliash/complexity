package com.github.guliash.queries;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        int m = 10000000;
        int n = 10000000;
        Query[] queries = new Query[m];
        for(int i = 0; i < m; i++) {
            int x, y, type;
            type = rnd.nextBoolean() ? 0 : 1;
            if(type == 0) {
                x = rnd.nextInt(n);
                y = x + rnd.nextInt(n - x);
            } else {
                x = rnd.nextInt(n);
                y = rnd.nextInt(n);
            }
            queries[i] = new Query(x, y, type);
        }
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(n);
        }
        long start = System.currentTimeMillis();
        ArrayList<Integer> segmentResult = new SegmentTreeSolver(array, queries).solve();
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        ArrayList<Integer> sqrtResult = new SqrtDecompositionSolver(array, queries).solve();
        System.out.println(System.currentTimeMillis() - start);
    }
}
