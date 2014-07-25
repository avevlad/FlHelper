package github.avevlad.FlHelper;

import java.awt.*;
import java.net.URL;

public class Tray {
    public static void main(String name) {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon;
        final SystemTray tray = SystemTray.getSystemTray();
        URL urlIconFile = Tray.class.getResource("resources/icon.png");
        Image image = Toolkit.getDefaultToolkit().getImage(urlIconFile);
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