package com.github.guliash.queries;

/**
 * Created by gulash on 03.08.15.
 */
public class SegmentTree {

    int b[], size;

    public SegmentTree(int[] a) {
        int n = a.length;
        size = 1;
        while(size < n) {
            size <<= 1;
        }
        b = new int[size * 2 - 1];
        for(int i = size - 1; i < size - 1 + n; i++) {
            b[i] = a[i - size + 1];
        }
        for(int i = size - 1 + n; i < b.length; i++) {
            b[i] = Integer.MAX_VALUE;
        }
        for(int i = size - 2; i >= 0; i--) {
            b[i] = Math.min(b[2 * i + 1], b[2 * i + 2]);
        }
    }

    public int get(int t_l, int t_r, int q_l, int q_r, int node) {
        if(q_l > q_r) {
            return Integer.MAX_VALUE;
        }
        if(t_l == q_l && t_r == q_r) {
            return b[node];
        }
        int mid = t_l + (t_r - t_l) / 2;
        return Math.min(get(t_l, mid, q_l, Math.min(mid, q_r), 2 * node + 1),
                get(mid + 1, t_r, Math.max(mid + 1, q_l), q_r, 2 * node + 2));
    }

    public void update(int t_l, int t_r, int pos, int val, int node) {
        if(t_r == t_l) {
            b[node] = val;
            return;
        }
        int mid = t_l + (t_r - t_l) / 2;
        if(pos <= mid) {
            update(t_l, mid, pos, val, 2 * node + 1);
        } else {
            update(mid + 1, t_r, pos, val, 2 * node + 2);
        }
        b[node] = Math.min(b[2 * node + 1], b[2 * node + 2]);
    }

}
