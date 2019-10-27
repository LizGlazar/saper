package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Plansza implements ActionListener
{
    private final PoziomTrudnosci poziomTrudnosci;
    private final GeneratorPozycjiMin generatorPozycjiMin;
    private final GeneratorPunktacji generatorPunktacji;
    private final List<PozycjaMiny> pozycjeMin;
    private final String[][] punktacja;
    private final List<PrzyciskPlanszy> listaPrzyciskow;
    private final PrzyciskPlanszy[][] tablicaPrzyciskow;
    private final PolaciePustychPol polaciePustychPol;


    public Plansza(PoziomTrudnosci poziomTrudnosci, GeneratorPozycjiMin generatorPozycjiMin, GeneratorPunktacji generatorPunktacji, PolaciePustychPol polaciePustychPol)
    {
        this.poziomTrudnosci = poziomTrudnosci;
        this.generatorPozycjiMin = generatorPozycjiMin;
        this.generatorPunktacji = generatorPunktacji;
        this.polaciePustychPol = polaciePustychPol;

        pozycjeMin = generatorPozycjiMin.generujPozycjeMin(poziomTrudnosci);
        punktacja = generatorPunktacji.zwrocTablicePlanszy(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc, pozycjeMin);
        listaPrzyciskow = new ArrayList<>();
        tablicaPrzyciskow = new PrzyciskPlanszy[poziomTrudnosci.szerokosc][poziomTrudnosci.wysokosc];
        for (int i = 0; i < poziomTrudnosci.wysokosc; i++)
        {
            for (int j = 0; j < poziomTrudnosci.szerokosc; j++)
            {
                PrzyciskPlanszy przyciskPlanszy = new PrzyciskPlanszy (j, i);
                przyciskPlanszy.addActionListener(this);
                przyciskPlanszy.setMinimumSize(new Dimension(15, 15));
                listaPrzyciskow.add(przyciskPlanszy);
                tablicaPrzyciskow[j][i] = przyciskPlanszy;
            }
        }
    }

    public GridLayout zwrocLayoutPlanszy()
    {
        return new GridLayout(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc);
    }

    public List<PrzyciskPlanszy> zwrocListePrzyciskow()
    {
        return listaPrzyciskow;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        PrzyciskPlanszy przyciskPlanszy = (PrzyciskPlanszy) e.getSource();
        int x = przyciskPlanszy.zwrocX();
        int y = przyciskPlanszy.zwrocY();
        String tekst = punktacja[x][y];
        if (tekst.equals("0"))
        {
            polaciePustychPol.odslonPustePolaIBrzeg(x, y, tablicaPrzyciskow, punktacja, poziomTrudnosci.szerokosc, poziomTrudnosci.wysokosc);
        }
        else
        {
            przyciskPlanszy.setEnabled(false);
            przyciskPlanszy.setText(tekst);
        }
        if (tekst.equals(GeneratorPunktacji.OZNACZENIE_MINY))
        {
            koniecGryPoKliknieciuNaMine();
        }
    }

    private void koniecGryPoKliknieciuNaMine()
    {
        odslonWszystkieMiny();
        zablokujWszystkiePrzyciski();
        wyswietlOknoDialogowe();
    }

    private void odslonWszystkieMiny()
    {
        for (PozycjaMiny pozycjaMiny : pozycjeMin)
        {
            int x = pozycjaMiny.zwrocX();
            int y = pozycjaMiny.zwrocY();
            PrzyciskPlanszy przyciskPlanszy = tablicaPrzyciskow[x][y];
            przyciskPlanszy.setText(GeneratorPunktacji.OZNACZENIE_MINY);
        }
    }

    private void zablokujWszystkiePrzyciski()
    {
        for (PrzyciskPlanszy przyciskPlanszy : listaPrzyciskow)
        {
            przyciskPlanszy.setEnabled(false);
        }
    }

    private void wyswietlOknoDialogowe()
    {
        JOptionPane.showMessageDialog(null, "Koniec gry.");
    }
}
