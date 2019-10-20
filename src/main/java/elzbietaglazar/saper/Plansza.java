package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plansza
{
    private final PoziomTrudnosci poziomTrudnosci;

    public Plansza(PoziomTrudnosci poziomTrudnosci)
    {
        this.poziomTrudnosci = poziomTrudnosci;
    }

    public GridLayout zwrocLayoutPlanszy()
    {
        return new GridLayout(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc);
    }

    public List<JButton> zwrocListePrzyciskow()
    {
        List<JButton> listaPrzyciskow = new ArrayList<>();
        for (int i = 0; i < poziomTrudnosci.wysokosc; i++)
        {
            for (int j = 0; j < poziomTrudnosci.szerokosc; j++)
            {
                JButton button = new JButton(" ");
                button.setMinimumSize(new Dimension(15, 15));
                listaPrzyciskow.add(button);
            }
        }
        return listaPrzyciskow;
    }
}
