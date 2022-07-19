package com.github.algo.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        LinkedList<List<Integer>> output = new LinkedList<>();
        output.add(Arrays.asList(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> previousList = output.getLast();
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                int now = j < previousList.size() ? previousList.get(j) : 0;
                int previous = j - 1 < 0 ? 0 : previousList.get(j - 1);
                list.add(now + previous);
            }
            output.add(list);
        }
        return output;
    }

}
