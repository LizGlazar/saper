package elzbietaglazar.saper;

import javax.swing.*;

public class GraMenu extends JMenu
{
    public GraMenu(MenuItemPoziomTrudnosci poczatkujacy, MenuItemPoziomTrudnosci zaawansowany, MenuItemPoziomTrudnosci ekspert, MenuItemZakoncz zakoncz)
    {
        super("Gra");
        add(poczatkujacy);
        add(zaawansowany);
        add(ekspert);
        addSeparator();
        add(zakoncz);

    }
}
