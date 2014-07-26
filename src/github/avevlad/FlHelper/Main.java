package github.avevlad.FlHelper;

import java.awt.*;
import java.net.URL;

public class Main {
    public final String name = "FL Helper";

    public static void main(String[] args) {
        Main main = new Main();
        MainGui.run(main.name, main.getIconImage());
        Tray.run(main.name, main.getIconImage());
    }

    public Image getIconImage() {
        URL urlIconFile = Tray.class.getResource("resources/icon.png");
        return Toolkit.getDefaultToolkit().getImage(urlIconFile);
    }
}