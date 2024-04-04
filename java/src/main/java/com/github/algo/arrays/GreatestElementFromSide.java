package com.github.algo.arrays;

public class GreatestElementFromSide {
    public int[] replaceElements(int[] arr) {
        int highest = -1;
        int[] output = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            output[i] = highest;
            if(arr[i] > highest) {
                highest = arr[i];
            }
        }
        return output;
    }
}
