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


    public Plansza(PoziomTrudnosci poziomTrudnosci, GeneratorPozycjiMin generatorPozycjiMin, GeneratorPunktacji generatorPunktacji)
    {
        this.poziomTrudnosci = poziomTrudnosci;
        this.generatorPozycjiMin = generatorPozycjiMin;
        this.generatorPunktacji = generatorPunktacji;

        pozycjeMin = generatorPozycjiMin.generujPozycjeMin(poziomTrudnosci);
        punktacja = generatorPunktacji.zwrocTablicePlanszy(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc, pozycjeMin);
        listaPrzyciskow = new ArrayList<>();
        for (int i = 0; i < poziomTrudnosci.wysokosc; i++)
        {
            for (int j = 0; j < poziomTrudnosci.szerokosc; j++)
            {
                String tekst = punktacja[j][i];
                PrzyciskPlanszy przyciskPlanszy = new PrzyciskPlanszy (j, i);
                /*if (tekst.equals("m"))
                {
                    przyciskPlanszy.setBackground(Color.RED);
                }*/
                przyciskPlanszy.addActionListener(this);
                przyciskPlanszy.setMinimumSize(new Dimension(15, 15));
                listaPrzyciskow.add(przyciskPlanszy);
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
        przyciskPlanszy.setEnabled(false);
        int x = przyciskPlanszy.zwrocX();
        int y = przyciskPlanszy.zwrocY();
        String tekst = punktacja[x][y];
        przyciskPlanszy.setText(tekst);
    }
}
