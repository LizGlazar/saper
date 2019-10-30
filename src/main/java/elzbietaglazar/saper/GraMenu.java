package elzbietaglazar.saper;

import javax.swing.*;

public class GraMenu extends JMenu
{
    public GraMenu(MenuItemPoziomTrudnosci poczatkujacy, MenuItemPoziomTrudnosci zaawansowany, MenuItemPoziomTrudnosci ekspert)
    {
        super("Gra");
        JMenuItem zakoncz = new JMenuItem("Zakoncz");
        add(poczatkujacy);
        add(zaawansowany);
        add(ekspert);
        addSeparator();
        add(zakoncz);

    }
}
