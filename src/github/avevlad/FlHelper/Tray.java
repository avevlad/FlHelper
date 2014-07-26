package github.avevlad.FlHelper;

import java.awt.*;

public class Tray {
    public void run(String name, Image image) {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final TrayIcon trayIcon;
        final SystemTray tray = SystemTray.getSystemTray();
        PopupMenu popup = menu();
        trayIcon = new TrayIcon(image, name, popup);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }

    public PopupMenu menu() {
        final PopupMenu popup = new PopupMenu();
        MenuItem aboutItem = new MenuItem("Настройки");
        MenuItem exitItem = new MenuItem("Выход");
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(exitItem);
        return popup;
    }
}