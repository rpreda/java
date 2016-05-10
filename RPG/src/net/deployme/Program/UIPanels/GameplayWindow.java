package net.deployme.Program.UIPanels;

import net.deployme.Characters.Hero.BaseHero;
import net.deployme.GameComponents.GameMap;
import net.deployme.Program.MainWindow;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class GameplayWindow extends javax.swing.JPanel implements Observer {

    private javax.swing.JLabel avgDamage;
    private javax.swing.JButton down;
    private javax.swing.JLabel enemyInfo;
    private javax.swing.JButton fight;
    private javax.swing.JButton flee;
    private javax.swing.JLabel hitpoints;
    private javax.swing.JLabel itemsList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton left;
    private javax.swing.JButton right;
    private javax.swing.JButton up;
    private int[][] mapImage;
    private int mapSize;
    private final int circleRadius = 30;
    private final int yAxisOffset = 200;
    private final int xAxisOffset = 10;
    private final int lineDistance = 10;
    private final int inBetweenDistance = 10;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (mapImage != null) {
            int y = yAxisOffset;
            for (int i = 0; i < mapSize; i++) {
                int x = xAxisOffset;
                for (int j = 0; j < mapSize; j++) {
                    switch (mapImage[i][j]) {
                        case 1:
                            g.setColor(Color.RED);
                            break;
                        case 2:
                            g.setColor(Color.cyan);
                            break;
                        case 3:
                            g.setColor(Color.green);
                            break;
                        default:
                            g.setColor(Color.white);
                            break;
                    }
                    g.fillOval(x, y, circleRadius, circleRadius);
                    x += circleRadius + inBetweenDistance;
                }
                y += circleRadius + lineDistance;
            }
        }
    }

    public void update(Observable observable, Object data) {
        if (observable instanceof GameMap) {
            GameMap map = (GameMap) observable;
            if (map.won)
                MainWindow.getInstance().notifyUser("WIN");
            hitpoints.setText(Integer.toString(((BaseHero)map.player.getEntity()).getHitpoints()));
            avgDamage.setText(Integer.toString(((BaseHero)map.player.getEntity()).dealDamage()));
            mapSize = map.getMapSize();
            mapImage = map.imageMap();
        }
        this.repaint();
    }

    public void showFightFlee() {
        fight.setVisible(true);
        flee.setVisible(true);
    }

    public void hideFightFlee() {
        fight.setVisible(false);
        flee.setVisible(false);
    }

    public void hideMove() {
        up.setVisible(false);
        down.setVisible(false);
        left.setVisible(false);
        right.setVisible(false);
    }

    public void showMove() {
        up.setVisible(true);
        down.setVisible(true);
        left.setVisible(true);
        right.setVisible(true);
    }

    public GameplayWindow() {
        initComponents();
        this.hideFightFlee();
    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        avgDamage = new javax.swing.JLabel();
        itemsList = new javax.swing.JLabel();
        hitpoints = new javax.swing.JLabel();
        up = new javax.swing.JButton();
        down = new javax.swing.JButton();
        right = new javax.swing.JButton();
        left = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fight = new javax.swing.JButton();
        flee = new javax.swing.JButton();
        enemyInfo = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Hitpoints:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("Items:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setText("Average damage:");

        avgDamage.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        itemsList.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        hitpoints.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        up.setText("Up");
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });

        down.setText("Down");
        down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downActionPerformed(evt);
            }
        });

        right.setText("Right");
        right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightActionPerformed(evt);
            }
        });

        left.setText("Left");
        left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel4.setText("Enemy info:");

        fight.setText("Fight");
        fight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fightActionPerformed(evt);
            }
        });

        flee.setText("Flee");
        flee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fleeActionPerformed(evt);
            }
        });

        enemyInfo.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(left)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(down)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(right))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(9, 9, 9)
                                                                                .addComponent(up)))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(itemsList)
                                                        .addComponent(avgDamage)
                                                        .addComponent(hitpoints)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(enemyInfo))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(fight)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(flee)))))
                                .addContainerGap(238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(hitpoints))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(itemsList))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(avgDamage))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(up)
                                        .addComponent(jLabel4)
                                        .addComponent(enemyInfo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(down)
                                        .addComponent(left)
                                        .addComponent(right)
                                        .addComponent(fight)
                                        .addComponent(flee))
                                .addContainerGap(344, Short.MAX_VALUE))
        );
    }

    private void upActionPerformed(java.awt.event.ActionEvent evt) {
       MainWindow.getInstance().getController().movePlayer(1);
    }

    private void leftActionPerformed(java.awt.event.ActionEvent evt) {
        MainWindow.getInstance().getController().movePlayer(3);
    }

    private void downActionPerformed(java.awt.event.ActionEvent evt) {
        MainWindow.getInstance().getController().movePlayer(2);
    }

    private void rightActionPerformed(java.awt.event.ActionEvent evt) {
        MainWindow.getInstance().getController().movePlayer(4);
    }

    private void fightActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void fleeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

}
