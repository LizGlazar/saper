package elzbietaglazar.saper;

import javax.swing.*;

public class GlowneOkno extends JFrame
{
    public GlowneOkno(PasekMenu pasekMenu, GeneratorPlanszy generatorPlanszy)
    {
        super("Saper");
        setJMenuBar(pasekMenu);
        Plansza plansza = generatorPlanszy.generujPlansze();
        JPanel panel = plansza.zwrocPanelPlanszy();
        getContentPane().add(panel);

        pack();
        setVisible(true);
//        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
