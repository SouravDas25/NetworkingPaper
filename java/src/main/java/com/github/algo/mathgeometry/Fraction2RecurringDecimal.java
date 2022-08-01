package com.github.algo.mathgeometry;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Fraction2RecurringDecimal {

    private boolean isSequentialCount(String decimalPart, String repeatedPart, int startIndex) {
        for (int i = startIndex; i + repeatedPart.length() < decimalPart.length(); i += repeatedPart.length()) {
            String nextPart = decimalPart.substring(i, i + repeatedPart.length());
            if (!nextPart.equals(repeatedPart)) {
                return false;
            }
        }
        return true;
    }

    private String[] getRepeatingElement(String decimalPart) {
        for (int i = 0; i < decimalPart.length(); i++) {
            String fixedPart = decimalPart.substring(0, i);
            for (int j = 0; i + j < decimalPart.length(); j++) {
                String firstPart = decimalPart.substring(i, i + j + 1);
                String nextPart = decimalPart.substring(i + j + 1, Math.min(i + (2 * j) + 2, decimalPart.length()));
                if (firstPart.equals(nextPart) && isSequentialCount(decimalPart, firstPart, i)) {
                    return new String[]{fixedPart, firstPart};
                }
            }
        }
        return new String[]{"", decimalPart};
    }

    public String fractionToDecimal(int numerator, int denominator) {
        BigDecimal a = new BigDecimal(numerator);
        BigDecimal b = new BigDecimal(denominator);
        String s = a.divide(b, new MathContext(10000, RoundingMode.DOWN)).toPlainString();
        String[] split = s.split("\\.");
        if(split.length < 2) {
            return split[0];
        }
        String[] repeatingPart = getRepeatingElement(split[1]);
        try {
            if (Integer.parseInt(split[1]) == 0) {
                return split[0];
            }
        } catch (Exception e) {
            //do nothing
        }
        if (repeatingPart[1].length() == split[1].length()) {
            return s;
        }
        return split[0] + "." + repeatingPart[0] + "(" + repeatingPart[1] + ")";
    }

}
