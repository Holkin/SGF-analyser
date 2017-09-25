package com.holkin.sgfanalyser.ui;

import com.holkin.sgfanalyser.model.Board;
import com.holkin.sgfanalyser.model.Stone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

@Component
public class BoardPanel extends JPanel {

    private final int padding = 20;
    private final int hoshiR = 2;
    private final int hoshiOff = 3;
    private final int lines = 18;

    @Autowired
    private Board boad;

    @PostConstruct
    public void init() {
        boad.place(Stone.BLACK, 3, 3).place(Stone.WHITE,3,2).place(Stone.WHITE, 18, 18).place(Stone.WHITE, 0, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        int size = Math.min(width - padding * 2, height - padding * 2);
        int step = size / lines;
        size = step * lines;
        drawBoard(size, 30, 20, g);
        int x = 30, y = 20;
        int stoneR = step/2 - 1;
        for (int i=0; i<boad.a().length; i++) {
            for (int j=0; j<boad.a().length; j++) {
                Stone stone = boad.a()[i][j];
                if (stone == Stone.WHITE) {
                    g.setColor(Color.white);
                }
                if (stone == Stone.BLACK) {
                    g.setColor(Color.black);
                }
                if (stone != null) {
                    g.fillOval(x + i*step - stoneR, y + j*step - stoneR, stoneR*2-1, stoneR*2-1);
                    g.setColor(Color.black);
                    g.drawOval(x + i*step - stoneR, y + j*step - stoneR, stoneR*2-1, stoneR*2-1);
                }
            }
        }
    }

    public void drawBoard(int size, int x, int y, Graphics g) {
        int step = size / lines;
        g.setColor(new Color(204, 153, 0));
        g.fillRect(x, y, size, size);
        g.setColor(Color.black);
        for (int i = 0; i <= lines; i++) {
            g.drawLine(x + i * step, y, x + i * step, y + size);
            g.drawLine(x, y + i * step, x + size, y + i * step);
        }
        for (int i = hoshiOff; i < lines; i += 6) {
            for (int j = hoshiOff; j < lines; j += 6) {
                g.fillOval(x + i*step - hoshiR, y + j*step - hoshiR, hoshiR*2, hoshiR*2);
            }
        }
    }
}
