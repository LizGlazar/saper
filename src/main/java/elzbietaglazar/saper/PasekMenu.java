package elzbietaglazar.saper;

import javax.swing.*;

public class PasekMenu extends JMenuBar
{
    public PasekMenu()
    {
        JMenu gra = new JMenu("Gra");
        JMenu pomoc = new JMenu("Pomoc");
        add(gra);
        add(pomoc);
    }
}
