package github.avevlad.FlHelper;

import java.awt.*;

public class Tray {
    public static void main(String name) {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon;
        final SystemTray tray = SystemTray.getSystemTray();

        Image image = Toolkit.getDefaultToolkit().getImage("D:/icon16.png");
        trayIcon = new TrayIcon(image, name);
        MenuItem aboutItem = new MenuItem("Настройки");
        MenuItem exitItem = new MenuItem("Выход");

        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }
}