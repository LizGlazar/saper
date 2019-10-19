package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PomocMenu extends JMenu
{
    public PomocMenu()
    {
        super("Pomoc");
        JMenuItem oProgramie = new JMenuItem("O programie");
        add(oProgramie);
        oProgramie.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JOptionPane.showMessageDialog(PomocMenu.this, "Elżbieta Glazar \u2014 Saper",
                        "Programowanie obiektowe", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
