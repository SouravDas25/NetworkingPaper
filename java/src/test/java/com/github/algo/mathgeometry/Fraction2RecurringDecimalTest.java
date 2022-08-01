package com.github.algo.mathgeometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Fraction2RecurringDecimalTest {

    @Test
    void fractionToDecimal() {
        Fraction2RecurringDecimal fraction2RecurringDecimal = new Fraction2RecurringDecimal();
        String sb = fraction2RecurringDecimal.fractionToDecimal(1, 6);
        System.out.println(sb);
        sb = fraction2RecurringDecimal.fractionToDecimal(4, 33);
        System.out.println(sb);
        sb = fraction2RecurringDecimal.fractionToDecimal(4, 333);
        System.out.println(sb);
        sb = fraction2RecurringDecimal.fractionToDecimal(1, 2);
        System.out.println(sb);
        sb = fraction2RecurringDecimal.fractionToDecimal(2, 1);
        System.out.println(sb);
        sb = fraction2RecurringDecimal.fractionToDecimal(1, 333);
        System.out.println(sb);
        sb = fraction2RecurringDecimal.fractionToDecimal(22, 7);
        System.out.println(sb);
        sb = fraction2RecurringDecimal.fractionToDecimal(1, 17);
        System.out.println(sb);
    }
}