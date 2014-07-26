package github.avevlad.FlHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tray {
    public void run(String name, Image image, final JFrame frame) {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        MouseAdapter mouseListener = new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) {
                    frame.setVisible(true);
                    frame.setExtendedState(JFrame.NORMAL);
                }
            }
        };
        final TrayIcon trayIcon;
        final SystemTray tray = SystemTray.getSystemTray();
        PopupMenu popup = menu(frame);
        trayIcon = new TrayIcon(image, name, popup);
        trayIcon.addMouseListener(mouseListener);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }

    public PopupMenu menu(final JFrame frame) {
        ActionListener exitListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        ActionListener openListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frame.setExtendedState(JFrame.NORMAL);
            }
        };
        final PopupMenu popup = new PopupMenu();
        MenuItem aboutItem = new MenuItem("Настройки");
        MenuItem openItem = new MenuItem("Открыть");
        MenuItem exitItem = new MenuItem("Выход");
        openItem.addActionListener(openListener);
        exitItem.addActionListener(exitListener);
        popup.add(aboutItem);
        popup.add(openItem);
        popup.addSeparator();
        popup.add(exitItem);
        return popup;
    }
}