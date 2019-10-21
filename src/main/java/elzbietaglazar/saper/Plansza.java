package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plansza
{
    private final PoziomTrudnosci poziomTrudnosci;
    private final GeneratorPozycjiMin generatorPozycjiMin;

    public Plansza(PoziomTrudnosci poziomTrudnosci, GeneratorPozycjiMin generatorPozycjiMin)
    {
        this.poziomTrudnosci = poziomTrudnosci;
        this.generatorPozycjiMin = generatorPozycjiMin;
    }

    public GridLayout zwrocLayoutPlanszy()
    {
        return new GridLayout(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc);
    }

    public List<JButton> zwrocListePrzyciskow()
    {
        List<PozycjaMiny> pozycjeMin = generatorPozycjiMin.generujPozycjeMin(poziomTrudnosci);
        List<JButton> listaPrzyciskow = new ArrayList<>();
        for (int i = 0; i < poziomTrudnosci.wysokosc; i++)
        {
            for (int j = 0; j < poziomTrudnosci.szerokosc; j++)
            {
                String tekst = tekstPrzycisku(j, i, pozycjeMin);
                JButton button = new JButton (tekst);
                button.setMinimumSize(new Dimension(15, 15));
                listaPrzyciskow.add(button);
            }
        }
        return listaPrzyciskow;
    }

    private String tekstPrzycisku(int x, int y, List<PozycjaMiny> pozycjeMin)
    {
        PozycjaMiny potencjalnaPozycja = new PozycjaMiny(x, y);
        if (pozycjeMin.contains(potencjalnaPozycja))
        {
            return "m";
        }
        else
        {
            return " ";
        }
    }
}
