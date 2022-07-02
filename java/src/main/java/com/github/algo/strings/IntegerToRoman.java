package com.github.algo.strings;

import java.util.*;

public class IntegerToRoman {
    static Map<Integer, Character> romanNumbers = new HashMap<>();
    static List<Integer> factors = Arrays.asList(1000, 500, 100, 50, 10, 5, 1);
    static Map<Integer, Integer> subFactors = new HashMap<>();

    static {
        romanNumbers.put(1, 'I');
        romanNumbers.put(5, 'V');
        romanNumbers.put(10, 'X');
        romanNumbers.put(50, 'L');
        romanNumbers.put(100, 'C');
        romanNumbers.put(500, 'D');
        romanNumbers.put(1000, 'M');
        subFactors.put(5, 1);
        subFactors.put(10, 1);
        subFactors.put(50, 10);
        subFactors.put(100, 10);
        subFactors.put(500, 100);
        subFactors.put(1000, 100);
    }

    boolean isSubFact(Integer num, Integer factor) {
        return subFactors.containsKey(factor) && num - (num % subFactors.get(factor)) + subFactors.get(factor) == factor;
    }

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < factors.size(); i++) {
                Integer factor = factors.get(i);
                if (num >= factor) {
                    int count = num / factor;
                    num = num % factor;
                    Character ch = romanNumbers.get(factor);
                    roman.append(String.valueOf(ch).repeat(Math.max(0, count)));
                    break;
                }
                if (this.isSubFact(num, factor)) {
                    roman.append(romanNumbers.get(subFactors.get(factor)));
                    roman.append(romanNumbers.get(factor));
                    num = num % subFactors.get(factor);
                    break;
                }
            }
//            System.out.println(num + ", " + roman.toString());
        }
        return roman.toString();
    }

}
