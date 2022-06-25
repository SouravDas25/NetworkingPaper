package com.github.algo.strings;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        List<StringBuilder> lines = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lines.add(new StringBuilder());
        }
        int lineNo = -1, diff = 1;
        for (final char ch : s.toCharArray()) {
            lineNo += diff;
            if (lineNo == -1) {
                lines.get(0).append(ch);
            } else {
                lines.get(lineNo).append(ch);
            }
            if (lineNo == numRows - 1 || lineNo + diff < 0) {
                diff = -diff;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(lines.get(i).toString());
        }
        return sb.toString();
    }

}
