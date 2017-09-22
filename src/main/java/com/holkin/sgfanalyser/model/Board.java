package com.holkin.sgfanalyser.model;

import org.springframework.stereotype.Component;

@Component
public class Board {
    private int len = 17 + 1 + 17 + 1 + 17;
    private int line1 = 17;
    private int line2 = 35;
    private Stone[][] a = new Stone[len][len];

    public Board place(Stone s, int x, int y) {
        int dx1 = x - line1;
        int dx2 = line1 - x;
        int dy1 = y - line1;
        int dy2 = line1 - y;

//        a[line1 - dx1][line1 + y] = s;
        a[line1 + x][line1 + y] = s;
        return this;
    }

    public Stone[][] a() {
        return a;
    }
}
