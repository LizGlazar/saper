package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plansza
{
    private final PoziomTrudnosci poziomTrudnosci;
    private final GeneratorPozycjiMin generatorPozycjiMin;
    private final GeneratorPunktacji generatorPunktacji;

    public Plansza(PoziomTrudnosci poziomTrudnosci, GeneratorPozycjiMin generatorPozycjiMin, GeneratorPunktacji generatorPunktacji)
    {
        this.poziomTrudnosci = poziomTrudnosci;
        this.generatorPozycjiMin = generatorPozycjiMin;
        this.generatorPunktacji = generatorPunktacji;
    }

    public GridLayout zwrocLayoutPlanszy()
    {
        return new GridLayout(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc);
    }

    public List<JButton> zwrocListePrzyciskow()
    {
        List<PozycjaMiny> pozycjeMin = generatorPozycjiMin.generujPozycjeMin(poziomTrudnosci);
        String[][] punktacja = generatorPunktacji.zwrocTablicePlanszy(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc, pozycjeMin);
        List<JButton> listaPrzyciskow = new ArrayList<>();
        for (int i = 0; i < poziomTrudnosci.wysokosc; i++)
        {
            for (int j = 0; j < poziomTrudnosci.szerokosc; j++)
            {
                String tekst = punktacja[j][i];
                JButton button = new JButton (tekst);
                if (tekst.equals("m"))
                {
                    button.setBackground(Color.RED);
                }
                button.setMinimumSize(new Dimension(15, 15));
                listaPrzyciskow.add(button);
            }
        }
        return listaPrzyciskow;
    }
}
