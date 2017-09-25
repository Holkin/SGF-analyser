package com.holkin.sgfanalyser.model;

import org.springframework.stereotype.Component;

@Component
public class Board {
    private int len = 17 + 1 + 17 + 1 + 17;
    private int line1 = 17;
    private int line2 = 35;
    private Stone[][] a = new Stone[len][len];

    public Board place(Stone s, int x, int y) {
        int dx1 = x;
        int dy1 = y;
        x += line1;
        y += line1;
        int dx2 = line2 - x;
        int dy2 = line2 - y;
        placeStone(s, x, y);
        placeStone(s, line1 - dx1, y);
        placeStone(s, line2 + dx2, y);
        placeStone(s, x, line1 - dy1);
        placeStone(s, x, line2 + dy2);
        return this;
    }

    private void placeStone(Stone s, int x, int y) {
        if (Math.min(x, y) > 0 && Math.max(x, y) < a.length) {
            a[x][y] = s;
        }
    }

    public Stone[][] a() {
        Stone[][] result = new Stone[19][19];
        int centerSrc = len/2;
        int centerDst = 19/2;
        for (int i=0; i<=centerDst; i++) {
            for (int j=0; j<=centerDst; j++) {
                result[centerDst + i][centerDst + j] = a[centerSrc + i][centerSrc + j];
                result[centerDst + i][centerDst - j] = a[centerSrc + i][centerSrc - j];
                result[centerDst - i][centerDst + j] = a[centerSrc - i][centerSrc + j];
                result[centerDst - i][centerDst - j] = a[centerSrc - i][centerSrc - j];
            }
        }
        return result;
    }
}
