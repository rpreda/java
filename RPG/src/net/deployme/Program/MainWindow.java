package net.deployme.Program;
import net.deployme.Program.GameLogic.MainLogic;
import net.deployme.Program.UIPanels.*;
import javax.swing.*;

public class MainWindow extends javax.swing.JFrame {
    private static MainWindow instance = null;
    private JPanel currentContent = null;
    private MainLogic controller;

    public void notifyUser(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public MainLogic getController() {
        return controller;
    }

    public static MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
            instance.changePanel(new StartScreen());
            return instance;
        }
        return instance;
    }

    public void changePanel(JPanel panel) {
        controller = new MainLogic();
        JPanel contents = (JPanel)getContentPane();
        contents.removeAll();
        contents.add(panel);
        contents.revalidate();
        contents.repaint();
        currentContent = panel;//might not be needed
        this.pack();
    }
    private MainWindow() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        pack();
    }

    public static void main(String args[]) {
        //theme selection code
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
                MainWindow.getInstance().setVisible(true);
            }
        });
    }
}
