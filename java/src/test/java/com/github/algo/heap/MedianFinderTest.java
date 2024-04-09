package com.github.algo.heap;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    @Test
    void addNum() {
        MedianFinder mf = new MedianFinder();
        Random random = new Random();

        Deque<Integer> input = new LinkedList<>();
        input.addAll(Arrays.asList(97, 10, 71));

        List<Integer> nums = new ArrayList<>();
        while (!input.isEmpty()) {
            int num = input.removeFirst();
            mf.addNum(num);
            nums.add(num);
            System.out.println("Adding num: " + num);
            System.out.println("Median : " + mf.findMedian());
            assertEquals(findMedian(nums), mf.findMedian());
            System.out.println(nums);
        }

    }

    @Test
    void randomTest() {
        MedianFinder mf = new MedianFinder();
        Random random = new Random();

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            int randomNumber = random.nextInt(100 - 1 + 1) + 1;
            mf.addNum(randomNumber);
            nums.add(randomNumber);
            System.out.println("Adding num: " + randomNumber);
            System.out.println("Median : " + mf.findMedian());
            System.out.println(nums);
            assertEquals(findMedian(nums), mf.findMedian());
        }

    }

    public static double findMedian(List<Integer> array) {
//        Arrays.sort(array);
        array.sort(Integer::compareTo);

        int length = array.size();

        if (length % 2 == 0) {
            // If length is even, median is the average of middle two elements
            int middleIndex1 = length / 2 - 1;
            int middleIndex2 = length / 2;
            return (array.get(middleIndex1) + array.get(middleIndex2)) / 2.0;
        } else {
            // If length is odd, median is the middle element
            int middleIndex = length / 2;
            return array.get(middleIndex);
        }
    }
}