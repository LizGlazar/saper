package elzbietaglazar.saper;

import javax.swing.*;

public class PasekMenu extends JMenuBar
{
    public PasekMenu(PomocMenu pomocMenu)
    {
        JMenu gra = new JMenu("Gra");
        add(gra);
        add(pomocMenu);
    }
}
