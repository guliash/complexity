package com.github.guliash.queries;

import java.util.Arrays;

/**
 * Created by gulash on 06.08.15.
 */
public class Algos {

    public static void main(String[] args) {
        int[] a = new int[] {2, 3, 1, 4, 10, 5};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
        a = new int[] {2, 3, 1, 4, 10, 5};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
        a = new int[] {2, 3, 1, 4, 10, 5};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(int[] a) {
        int n = a.length;
        for(int i = 1; i < n; i++) {
            int val = a[i];
            int j = i - 1;
            while(j >= 0 && a[j] > val) {
                a[j + 1] = a[j];
                --j;
            }
            a[j + 1] = val;
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void mergeSort(int[] a) {
        int n = a.length;
        int[] b = new int[n + 2];
        mergeSortRec(a, b, 0, n - 1);
    }

    public static void mergeSortRec(int[] a, int[] b, int l, int r) {
        if(l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSortRec(a, b, l, mid);
        mergeSortRec(a, b, mid + 1, r);
        merge(a, b, l, mid, r);
    }

    public static void merge(int[] a, int[] b, int l, int mid, int r) {
        for(int i = l; i <= mid; i++) {
            b[i] = a[i];
        }
        b[mid + 1] = Integer.MAX_VALUE;
        for(int i = mid + 1; i <= r; i++) {
            b[i + 1] = a[i];
        }
        b[r + 2] = Integer.MAX_VALUE;
        int f, s;
        f = l; s = mid + 2;
        for(int i = l; i <= r; i++) {
            if(b[f] <= b[s]) {
                a[i] = b[f++];
            } else {
                a[i] = b[s++];
            }
        }
    }

}
