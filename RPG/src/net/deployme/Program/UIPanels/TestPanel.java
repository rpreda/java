package net.deployme.Program.UIPanels;
import javax.swing.*;
public class TestPanel extends javax.swing.JPanel {
    public TestPanel() {
        initComponents();
    }

    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jButton1)
                                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(jButton1)
                                .addContainerGap(134, Short.MAX_VALUE))
        );
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JOptionPane.showMessageDialog(null, "Hello swing!");
    }

    private javax.swing.JButton jButton1;
}
