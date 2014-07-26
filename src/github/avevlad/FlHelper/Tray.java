package github.avevlad.FlHelper;

import java.awt.*;

public class Tray {
    public static void run(String name, Image image) {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon;
        final SystemTray tray = SystemTray.getSystemTray();
        MenuItem aboutItem = new MenuItem("Настройки");
        MenuItem exitItem = new MenuItem("Выход");
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(exitItem);
        trayIcon = new TrayIcon(image, name, popup);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }
}