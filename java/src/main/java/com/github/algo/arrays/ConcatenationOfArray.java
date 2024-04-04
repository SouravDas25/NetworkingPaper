package com.github.algo.arrays;

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
//        int multiply = 2;
        int[] output = new int[nums.length * 2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < multiply; j++) {
//                output[j * nums.length + i] = nums[i];
//            }
//        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = nums[i];
            output[nums.length + i] = nums[i];
        }
        return output;
    }
}
