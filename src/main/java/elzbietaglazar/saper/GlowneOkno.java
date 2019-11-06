package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlowneOkno extends JFrame implements ActionListener, ListenerUstawieniaFlagi, ListenerPoczatekGry, ListenerKoniecGry
{
    private static final int TYKNIECIA_ZEGARA = 1000;
    private JPanel panelPlanszy;
    private final GeneratorPlanszy generatorPlanszy;
    private final JLabel wyswietlaczLiczbyMin = new JLabel();
    private Timer stoper = new Timer(TYKNIECIA_ZEGARA, this);
    private final JLabel wyswietlaczStopera = new JLabel();
    private int licznikSekund = 0;

    public GlowneOkno(PasekMenu pasekMenu, GeneratorPlanszy generatorPlanszy, PoziomTrudnosci poziomTrudnosci)
    {
        super("Saper");
        this.generatorPlanszy = generatorPlanszy;
        setJMenuBar(pasekMenu);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JPanel panelDodatkowychInformacji = new JPanel();
        panelDodatkowychInformacji.setLayout(new FlowLayout());
        panelDodatkowychInformacji.add(wyswietlaczLiczbyMin);
        panelDodatkowychInformacji.add(wyswietlaczStopera);
        ustawTekstWyswietlaczaMin(poziomTrudnosci.liczbaMin);
        getContentPane().add(panelDodatkowychInformacji);
        Plansza plansza = generatorPlanszy.generujPlansze(poziomTrudnosci);
        plansza.dodajListenera(this);
        plansza.dodajListeneraPoczatekGry(this);
        plansza.dodajListeneraKoniecGry(this);
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
        if (e.getSource().equals(stoper))
        {
            licznikSekund++;
            wyswietlaczStopera.setText("Uplynelo: " + licznikSekund + " s");
        }
        else
        {
            MenuItemPoziomTrudnosci wybranaPozycjaMenu = (MenuItemPoziomTrudnosci) e.getSource();
            PoziomTrudnosci nowyPoziomTrudnosci = wybranaPozycjaMenu.zwrocPoziomTrudnosci();
            Plansza plansza = generatorPlanszy.generujPlansze(nowyPoziomTrudnosci);
            plansza.dodajListenera(this);
            plansza.dodajListeneraPoczatekGry(this);
            plansza.dodajListeneraKoniecGry(this);
            getContentPane().remove(panelPlanszy);
            panelPlanszy = plansza.zwrocPanelPlanszy();
            getContentPane().add(panelPlanszy);
            ustawTekstWyswietlaczaMin(nowyPoziomTrudnosci.liczbaMin);
            stoper = new Timer(TYKNIECIA_ZEGARA, this);
            licznikSekund = 0;
            wyswietlaczStopera.setText("");
            pack();
            revalidate();
            repaint();
        }
    }

    @Override
    public void zmianaLiczbyMin(int aktualnaLiczbaMin)
    {
        ustawTekstWyswietlaczaMin(aktualnaLiczbaMin);
    }

    @Override
    public void zakonczonoGre()
    {
        stoper.stop();
    }

    @Override
    public void rozpoczetoGre()
    {
        stoper.start();
    }
}
