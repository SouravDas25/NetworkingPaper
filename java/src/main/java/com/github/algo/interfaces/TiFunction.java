package com.github.algo.interfaces;

public interface TiFunction<R, O1, O2, O3> {
    R apply(O1 operand1, O2 operand2, O3 operand3);
}
