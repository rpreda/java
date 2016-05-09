package net.deployme.Program;
import net.deployme.Program.UIPanels.TestPanel;

import javax.swing.*;

public class MainWindow extends javax.swing.JFrame {
    public void changePanel(JPanel panel) {
        JPanel contents = (JPanel)getContentPane();
        contents.removeAll();
        contents.add(panel);
        contents.revalidate();
        contents.repaint();
        this.pack();
    }

    public MainWindow() {
        initComponents();
        changePanel(new TestPanel());//Here I load a test panel to see that the UI works
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        pack();
    }

    public static void main(String args[]) {
        /** Apply Nimbus theme if found **/
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {//what is a lambda function O.o?
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
