package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemZakoncz extends JMenuItem implements ActionListener
{
    public MenuItemZakoncz()
    {
        super("Zakoncz");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
}
