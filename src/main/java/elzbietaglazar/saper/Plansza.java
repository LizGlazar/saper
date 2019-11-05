package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Plansza implements MouseListener
{
    private final PoziomTrudnosci poziomTrudnosci;
    private final List<PozycjaMiny> pozycjeMin;
    private final String[][] punktacja;
    private final PrzyciskPlanszy[][] tablicaPrzyciskow;
    private final PolaciePustychPol polaciePustychPol;
    private int licznikPolDoOdsloniecia;
    private List<ListenerUstawieniaFlagi> listenerzy = new ArrayList<>();
    private int liczbaUstawionychFlag = 0;

    public Plansza(PoziomTrudnosci poziomTrudnosci, List<PozycjaMiny> pozycjeMin, String[][] punktacja, PolaciePustychPol polaciePustychPol) {
        this.poziomTrudnosci = poziomTrudnosci;
        this.pozycjeMin = pozycjeMin;
        this.punktacja = punktacja;
        this.polaciePustychPol = polaciePustychPol;
        tablicaPrzyciskow = new PrzyciskPlanszy[poziomTrudnosci.szerokosc][poziomTrudnosci.wysokosc];
        licznikPolDoOdsloniecia = poziomTrudnosci.szerokosc * poziomTrudnosci.wysokosc - poziomTrudnosci.liczbaMin;

        for (int i = 0; i < poziomTrudnosci.wysokosc; i++)
        {
            for (int j = 0; j < poziomTrudnosci.szerokosc; j++)
            {
                String punktacjaPrzycisku = punktacja[j][i];
                PrzyciskPlanszy przyciskPlanszy = new PrzyciskPlanszy(j, i, ZarzadcaIkon.OBRAZEK_POLE_ZAKRYTE, ZarzadcaIkon.OBRAZKI_PUNKTACJI.get(punktacjaPrzycisku));
                przyciskPlanszy.addMouseListener(this);
                tablicaPrzyciskow[j][i] = przyciskPlanszy;
            }
        }
    }

    public JPanel zwrocPanelPlanszy()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc));

        for (int i = 0; i < poziomTrudnosci.wysokosc; i++)
        {
            for (int j = 0; j < poziomTrudnosci.szerokosc; j++)
            {
                panel.add(tablicaPrzyciskow[j][i]);
            }
        }

        return panel;
    }

    public void obslugaLewegoPrzyciskuMyszy(PrzyciskPlanszy przyciskPlanszy)
    {
        int x = przyciskPlanszy.zwrocX();
        int y = przyciskPlanszy.zwrocY();
        String tekst = punktacja[x][y];
        if (tekst.equals("0"))
        {
            int odslonietePolaPolaci = polaciePustychPol.odslonPustePolaIBrzeg(x, y, tablicaPrzyciskow, punktacja, poziomTrudnosci.szerokosc, poziomTrudnosci.wysokosc);
            licznikPolDoOdsloniecia -= odslonietePolaPolaci;
        }
        else
        {
            przyciskPlanszy.odslon();
            licznikPolDoOdsloniecia--;
        }
        if (tekst.equals(GeneratorPunktacji.OZNACZENIE_MINY))
        {
            koniecGryPoKliknieciuNaMine(x, y);
        }
        else if (licznikPolDoOdsloniecia == 0)
        {
            zablokujWszystkiePrzyciski();
            JOptionPane.showMessageDialog(null, "Gratulacje, wygrana!");
        }
    }

    private void koniecGryPoKliknieciuNaMine(int xOdslonietejMiny, int yOdslonietejMiny)
    {
        odslonWszystkieMiny(xOdslonietejMiny, yOdslonietejMiny);
        zablokujWszystkiePrzyciski();
        wyswietlOknoDialogowe();
    }

    private void odslonWszystkieMiny(int xOdslonietejMiny, int yOdslonietejMiny)
    {
        for (PozycjaMiny pozycjaMiny : pozycjeMin)
        {
            int x = pozycjaMiny.zwrocX();
            int y = pozycjaMiny.zwrocY();
//            if (x != xOdslonietejMiny && y != yOdslonietejMiny)
//            {
                PrzyciskPlanszy przyciskPlanszy = tablicaPrzyciskow[x][y];
                przyciskPlanszy.odslon(ZarzadcaIkon.OBRAZEK_MINY);
//            }
        }
    }

    private void zablokujWszystkiePrzyciski()
    {
        for (int i = 0; i < poziomTrudnosci.wysokosc; i++)
        {
            for (int j = 0; j < poziomTrudnosci.szerokosc; j++)
            {
                tablicaPrzyciskow[j][i].setEnabled(false);
            }
        }
    }

    private void wyswietlOknoDialogowe()
    {
        JOptionPane.showMessageDialog(null, "Koniec gry.");
    }

    private void powiadomListenerow()
    {
        int aktualnaLiczbaMin = poziomTrudnosci.liczbaMin - liczbaUstawionychFlag;
        for (ListenerUstawieniaFlagi listener : listenerzy)
        {
            listener.zmianaLiczbyMin(aktualnaLiczbaMin);
        }
    }

    public void dodajListenera(ListenerUstawieniaFlagi listener)
    {
        listenerzy.add(listener);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        PrzyciskPlanszy przyciskPlanszy = (PrzyciskPlanszy) e.getSource();
        if (SwingUtilities.isLeftMouseButton(e) && !przyciskPlanszy.zwrocCzyUstawionoFlage())
        {
            obslugaLewegoPrzyciskuMyszy(przyciskPlanszy);
        }
        else if (SwingUtilities.isRightMouseButton(e))
        {
            if (przyciskPlanszy.zwrocCzyUstawionoFlage())
            {
                przyciskPlanszy.zdejmijFlage();
                liczbaUstawionychFlag--;
            }
            else
            {
                przyciskPlanszy.ustawFlage(ZarzadcaIkon.OBRAZEK_FLAGA);
                liczbaUstawionychFlag++;
            }
            powiadomListenerow();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

