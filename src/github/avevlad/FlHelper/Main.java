package github.avevlad.FlHelper;

import java.awt.*;

public class Main {
    public final String name = "FL Helper";

    public static void main(String[] args) {
        Main main = new Main();
        MainGui.main(args, main.name);
        Tray.main(main.name);
    }
}