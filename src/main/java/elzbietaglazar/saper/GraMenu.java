package elzbietaglazar.saper;

import javax.swing.*;

public class GraMenu extends JMenu
{
    public GraMenu()
    {
        super("Gra");
        JMenuItem poczatkujacy = new JMenuItem("Poczatkujacy");
        JMenuItem zaawansowany = new JMenuItem("Zaawansowany");
        JMenuItem ekspert = new JMenuItem("Ekspert");
        JMenuItem zakoncz = new JMenuItem("Zakoncz");
        add(poczatkujacy);
        add(zaawansowany);
        add(ekspert);
        addSeparator();
        add(zakoncz);

    }
}
