package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlowneOkno extends JFrame implements ActionListener
{
    private JPanel panelPlanszy;
    private final GeneratorPlanszy generatorPlanszy;

    public GlowneOkno(PasekMenu pasekMenu, GeneratorPlanszy generatorPlanszy, PoziomTrudnosci poziomTrudnosci)
    {
        super("Saper");
        this.generatorPlanszy = generatorPlanszy;
        setJMenuBar(pasekMenu);
        Plansza plansza = generatorPlanszy.generujPlansze(poziomTrudnosci);
        panelPlanszy = plansza.zwrocPanelPlanszy();
        getContentPane().add(panelPlanszy);

        pack();
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        MenuItemPoziomTrudnosci wybranaPozycjaMenu = (MenuItemPoziomTrudnosci) e.getSource();
        PoziomTrudnosci nowyPoziomTrudnosci = wybranaPozycjaMenu.zwrocPoziomTrudnosci();
        Plansza plansza = generatorPlanszy.generujPlansze(nowyPoziomTrudnosci);
        getContentPane().remove(panelPlanszy);
        panelPlanszy = plansza.zwrocPanelPlanszy();
        getContentPane().add(panelPlanszy);
        pack();
        revalidate();
        repaint();
    }
}
