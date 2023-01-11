import java.awt.*;

public class CustomMenu extends MenuBar {
    private MenuItem menuItem;
    private Menu menu;

    public CustomMenu(){

    }

    public MenuItem mkMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }

//    public MenuController getMenuController() {
//        return menuController;
//    }

    public Menu makeMenu(String name){
        return new Menu(name);
    }
}
