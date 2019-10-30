package elzbietaglazar.saper;

import javax.swing.*;

public class PasekMenu extends JMenuBar
{
    public PasekMenu(PomocMenu pomocMenu, GraMenu graMenu)
    {
        add(graMenu);
        add(pomocMenu);
    }
}
