package com.github.algo.mathgeometry;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Fraction2RecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        sb.append(n / d);

        if (n % d == 0) {
            return sb.toString();
        }

        sb.append(".");
        Map<Long, Integer> seen = new HashMap<>();

        for (long r = n % d; r > 0; r %= d) {
            if (seen.containsKey(r)) {
                sb.insert(seen.get(r), "(");
                sb.append(")");
                break;
            }
            seen.put(r, sb.length());
            r *= 10;
            sb.append(r / d);
        }

        return sb.toString();
    }

}
