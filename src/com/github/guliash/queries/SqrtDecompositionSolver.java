package com.github.guliash.queries;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by gulash on 03.08.15.
 */
public class SqrtDecompositionSolver {

    int[] array;
    Query[] queries;

    public SqrtDecompositionSolver(int[] array, Query[] queries) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        this.queries = queries;
    }

    public ArrayList<Integer> solve() {
        int n = array.length;
        int sqrt = (int)Math.sqrt(n) + 1;
        int countOfBlocks = n % sqrt == 0 ? n / sqrt : n / sqrt + 1;
        int[] blocks = new int[countOfBlocks];
        int leftBorder, rightBorder, leftBlock, rightBlock;
        Arrays.fill(blocks, Integer.MAX_VALUE);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < countOfBlocks; i++) {
            leftBorder = i * sqrt;
            rightBorder = Math.min(n, leftBorder + sqrt);
            for(int j = leftBorder; j < rightBorder; j++) {
                blocks[i] = Math.min(blocks[i], array[j]);
            }
        }
        for(Query query : queries) {
            if(query.type == 0) {
                leftBlock = query.x / sqrt;
                rightBlock = query.y / sqrt;
                leftBorder = query.x;
                rightBorder = Math.min((leftBlock + 1) * sqrt, query.y + 1);
                int min = Integer.MAX_VALUE;
                for(int i = leftBorder; i < rightBorder; i++) {
                    min = Math.min(min, array[i]);
                }
                ++leftBlock;
                for(int i = leftBlock; i < rightBlock; i++) {
                    min = Math.min(blocks[i], min);
                }
                leftBorder = Math.max(rightBlock * sqrt, query.x);
                rightBorder = query.y;
                for(int i = leftBorder; i <= rightBorder; i++) {
                    min = Math.min(array[i], min);
                }
                result.add(min);
            } else {
                int block = query.x / sqrt;
                array[query.x] = query.y;
                leftBorder = block * sqrt;
                rightBorder = Math.min(leftBorder + sqrt, n);
                blocks[block] = Integer.MAX_VALUE;
                for(int j = leftBorder; j < rightBorder; j++) {
                    blocks[block] = Math.min(blocks[block], array[j]);
                }
            }
        }
        return result;
    }

}
