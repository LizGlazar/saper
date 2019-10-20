package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plansza
{
    public static final int SZEROKOSC = 9;
    public static final int WYSOKOSC = 9;

    public GridLayout zwrocLayoutPlanszy()
    {
        return new GridLayout(SZEROKOSC, WYSOKOSC);
    }

    public List<JButton> zwrocListePrzyciskow()
    {
        List<JButton> listaPrzyciskow = new ArrayList<>();
        for (int i = 0; i < SZEROKOSC; i++)
        {
            for (int j = 0; j < WYSOKOSC; j++)
            {
                JButton button = new JButton(" ");
                button.setMinimumSize(new Dimension(15, 15));
                listaPrzyciskow.add(button);
            }
        }
        return listaPrzyciskow;
    }
}
