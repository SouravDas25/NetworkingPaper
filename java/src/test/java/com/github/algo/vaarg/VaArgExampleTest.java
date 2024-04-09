package com.github.algo.vaarg;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

enum DAY {MON, TUE, WED, THU, FRI, SAT, SUN}

record KIOL(String name, int b) {
    KIOL(String name, int b) {
        this.name = name;
        this.b = b;
    }

    public KIOL() {
        this("", 0);
    }

    public boolean isValid() {
        return false;
    }
}

class VaArgExampleTest {

    @Test
    void print() {
//        VaArgExample.print(1, 2, 3, "Apple");
//
//        Object[] intArray = {1, 2, 3, 4, 5};
//        // unwraps if exact match is found
//        VaArgExample.print(intArray);
//
//        final int j;
//        j = 0;
//
//        DAY day = DAY.TUE;
//
//        String toDay = switch (day) {
//            case MON -> "Monday";
//            case TUE -> "Tuesday";
//            case WED -> {
//                yield "Wednesday";
//            }
//            case THU -> "Thursday";
//            case FRI -> "Friday";
//            case SAT -> "Saturday";
//            case SUN -> "Sunday";
//        };
//
//        System.out.println(toDay);
//
//        Number[] numbers = new Number[2]; // Creating an array of Integers but declared as Number[]
//        numbers[0] = 10; // Storing an Integer object in the array
//        numbers[1] = 3.14; // Storing a Double object in the array
//
//
//        VaArgExample.print((Object[]) numbers);
//
//        KIOL ad = new KIOL();
//        String string = ad.name() + ad.b();
//
//        VaArgExample.print(ad);

        Runnable[] runnables = new Runnable[5];
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            runnables[i] = () -> {
                System.out.println(finalI);
            };
        }
        for (int i = 0; i < 5; i++) {
            runnables[i].run();
        }
    }
}