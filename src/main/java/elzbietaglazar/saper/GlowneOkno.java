package elzbietaglazar.saper;

import javax.swing.*;

public class GlowneOkno extends JFrame
{
    public GlowneOkno(PasekMenu pasekMenu, Plansza plansza)
    {
        super("Saper");
        setJMenuBar(pasekMenu);

        setLayout(plansza.zwrocLayoutPlanszy());
        for (JButton button : plansza.zwrocListePrzyciskow()) {
            add(button);
        }

        pack();
        setVisible(true);
//        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
