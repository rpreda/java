package net.deployme.Program.UIPanels;

import java.awt.*;

public class DrawTest extends javax.swing.JPanel {

    public DrawTest() {
        initComponents();
    }

    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(100, 100, 30, 30);
        g.setColor(Color.CYAN);
        g.fillOval(100, 140, 30, 30);
    }
}