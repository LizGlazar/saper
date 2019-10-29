package elzbietaglazar.saper;

import javax.swing.*;

public class GlowneOkno extends JFrame
{
    public GlowneOkno(PasekMenu pasekMenu, GeneratorPlanszy generatorPlanszy)
    {
        super("Saper");
        setJMenuBar(pasekMenu);
        Plansza plansza = generatorPlanszy.generujPlansze();
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
