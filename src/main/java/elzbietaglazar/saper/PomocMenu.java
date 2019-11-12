package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa implementująca menu Pomoc.
 * @author Elżbieta Glazar
 */
public class PomocMenu extends JMenu
{
    /**
     * Konstruktor dodaje element menu O programie. Po kliknięciu na element menu wyświetlane jest
     * okienko dialogowe z informacją.
     */
    public PomocMenu()
    {
        super("Pomoc");
        JMenuItem oProgramie = new JMenuItem("O programie");
        add(oProgramie);
        oProgramie.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                JOptionPane.showMessageDialog(PomocMenu.this, "Elżbieta Glazar \u2014 Saper",
                        "Programowanie obiektowe", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
