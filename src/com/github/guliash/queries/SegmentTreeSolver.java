package com.github.guliash.queries;

import java.util.ArrayList;

/**
 * Created by gulash on 03.08.15.
 */
public class SegmentTreeSolver {

    private int[] array;
    private Query[] queries;

    public SegmentTreeSolver(int[] array, Query[] queries) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        this.array = array;
        this.queries = queries;
    }

    public ArrayList<Integer> solve() {
        SegmentTree st = new SegmentTree(array);
        ArrayList<Integer> result = new ArrayList<>();
        for(Query query : queries) {
            if(query.type == 0) {
                result.add(st.get(0, st.size - 1, query.x, query.y, 0));
            } else {
                st.update(0, st.size - 1, query.x, query.y, 0);
            }
        }
        return result;
    }

}
