package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlowneOkno extends JFrame implements ActionListener
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


    @Override
    public void actionPerformed(ActionEvent e)
    {
        MenuItemPoziomTrudnosci wybranaPozycjaMenu = (MenuItemPoziomTrudnosci) e.getSource();
        //TODO
        //stworzyc pole w klasie typu jpanel
        //przekazac nowy poziom trudnosci do generatora planszy
        //wygenerowac nowa plansze
        //usunac jpanel starej planszy
        //dodac jpanel nowej planszy
        //wywowac metode repaint lub podobna
    }
}
