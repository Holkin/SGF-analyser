package com.holkin.sgfanalyser.ui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class Window extends JFrame {
    public Window(BoardPanel board) {
        this.add(board);
        this.setTitle("SGF");
        this.setPreferredSize(new Dimension(600, 600));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
