package github.avevlad.FlHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class MainGui {
    private JPanel panel;
    private JButton button1;
    private JTextField textField1;
    public final int frameWidth = 700;
    public final int frameHeight = 500;

    public MainGui() {
        actionListener();
    }

    public void run(String name, Image image) {
        setLookAndFeel();
        MainGui mainGui = new MainGui();
        Main main = new Main();
        final JFrame frame = new JFrame("MainGui");
        frame.setContentPane(mainGui.panel);
        frame.setTitle(name);
        frame.setIconImage(image);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = dim.width / 2 - mainGui.frameWidth / 2;
        int locationY = (int) (dim.height / 2 - mainGui.frameHeight / 1.5);
        frame.setLocation(locationX, locationY);
        frame.setSize(mainGui.frameWidth, mainGui.frameHeight);
        frame.setPreferredSize(new Dimension(mainGui.frameWidth, mainGui.frameHeight));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent e) {
                if (e.getNewState() == 1) {
                    frame.setVisible(false);
                }
            }
        });

        Tray tray = new Tray();
        tray.run(main.name, main.getIconImage("16"), frame);
    }

    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Unable to set LookAndFeel");
        }
    }

    public void actionListener() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "11111111111");
            }
        });
    }
}