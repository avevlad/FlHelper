package github.avevlad.FlHelper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tray {
    public void run(String name, Image image) {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        MouseAdapter mouseListener = new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) {
                    System.out.println("OPEN WINDOW");
                }
            }
        };
        final TrayIcon trayIcon;
        final SystemTray tray = SystemTray.getSystemTray();
        PopupMenu popup = menu();
        trayIcon = new TrayIcon(image, name, popup);
        trayIcon.addMouseListener(mouseListener);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }

    public PopupMenu menu() {
        ActionListener exitListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        final PopupMenu popup = new PopupMenu();
        MenuItem aboutItem = new MenuItem("Настройки");
        MenuItem exitItem = new MenuItem("Выход");
        exitItem.addActionListener(exitListener);
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(exitItem);
        return popup;
    }
}