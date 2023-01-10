import java.awt.*;

public class Menu extends MenuBar {


    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}
