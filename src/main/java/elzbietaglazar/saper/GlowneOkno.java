package elzbietaglazar.saper;

import javax.swing.*;

public class GlowneOkno extends JFrame
{
    public GlowneOkno(PasekMenu pasekMenu)
    {
        super("Saper");
        setJMenuBar(pasekMenu);

        pack();
        setVisible(true);
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
