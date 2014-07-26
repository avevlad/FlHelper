package github.avevlad.FlHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JFrame frame = new JFrame("MainGui");
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
    }

    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println(e);
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