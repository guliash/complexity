package com.github.guliash.queries;

import java.util.ArrayList;

/**
 * Created by gulash on 03.08.15.
 */
public class NaiveSolver {

    private int[] array;
    private Query[] queries;

    public NaiveSolver(int[] array, Query[] queries) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        this.queries = queries;
    }

    public ArrayList<Integer> solve() {
        ArrayList<Integer> result = new ArrayList<>();
        for(Query query : queries) {
            if(query.type == 0) {
                int min = Integer.MAX_VALUE;
                for(int i = query.x; i <= query.y; i++) {
                    min = Math.min(array[i], min);
                }
                result.add(min);
            } else {
                array[query.x] = query.y;
            }
        }
        return result;
    }

}
