package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlowneOkno extends JFrame implements ActionListener, ListenerUstawieniaFlagi
{
    private JPanel panelPlanszy;
    private final GeneratorPlanszy generatorPlanszy;
    private final JLabel wyswietlaczLiczbyMin = new JLabel();

    public GlowneOkno(PasekMenu pasekMenu, GeneratorPlanszy generatorPlanszy, PoziomTrudnosci poziomTrudnosci)
    {
        super("Saper");
        this.generatorPlanszy = generatorPlanszy;
        setJMenuBar(pasekMenu);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JPanel panelDodatkowychInformacji = new JPanel();
        panelDodatkowychInformacji.setLayout(new FlowLayout());
        panelDodatkowychInformacji.add(wyswietlaczLiczbyMin);
        ustawTekstWyswietlaczaMin(poziomTrudnosci.liczbaMin);
        getContentPane().add(panelDodatkowychInformacji);
        Plansza plansza = generatorPlanszy.generujPlansze(poziomTrudnosci);
        plansza.dodajListenera(this);
        panelPlanszy = plansza.zwrocPanelPlanszy();
        getContentPane().add(panelPlanszy);

        pack();
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void ustawTekstWyswietlaczaMin(int liczbaMin)
    {
        wyswietlaczLiczbyMin.setText("Liczba min: " + liczbaMin);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        MenuItemPoziomTrudnosci wybranaPozycjaMenu = (MenuItemPoziomTrudnosci) e.getSource();
        PoziomTrudnosci nowyPoziomTrudnosci = wybranaPozycjaMenu.zwrocPoziomTrudnosci();
        Plansza plansza = generatorPlanszy.generujPlansze(nowyPoziomTrudnosci);
        plansza.dodajListenera(this);
        getContentPane().remove(panelPlanszy);
        panelPlanszy = plansza.zwrocPanelPlanszy();
        getContentPane().add(panelPlanszy);
        ustawTekstWyswietlaczaMin(nowyPoziomTrudnosci.liczbaMin);
        pack();
        revalidate();
        repaint();
    }

    @Override
    public void zmianaLiczbyMin(int aktualnaLiczbaMin)
    {
        ustawTekstWyswietlaczaMin(aktualnaLiczbaMin);
    }
}
