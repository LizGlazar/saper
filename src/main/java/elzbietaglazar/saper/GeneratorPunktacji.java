package elzbietaglazar.saper;

import java.util.List;

import static elzbietaglazar.saper.FunkcjePomocnicze.*;

public class GeneratorPunktacji
{
    public static final String OZNACZENIE_MINY = "m";

    public String[][] zwrocTablicePlanszy(int wysokosc, int szerokosc, List<PozycjaMiny> pozycjeMin)
    {
        String[][] tablicaPlanszy = new String[szerokosc][wysokosc];

        for (int i = 0; i < wysokosc; i++)
        {
            for (int j = 0; j < szerokosc; j++)
            {
                if (czyIstniejeMinaNaPozycji(j, i, pozycjeMin))
                {
                    tablicaPlanszy[j][i] = OZNACZENIE_MINY;
                }
                else
                {
                    int licznikMin = 0;
                    if (czyIstniejeLewyGornySasiad(j, i) && czyIstniejeMinaNaPozycji(j - 1, i - 1, pozycjeMin)) {
                        licznikMin++;
                    }
                    if (czyIstniejeGornySasiad(i) && czyIstniejeMinaNaPozycji(j, i - 1, pozycjeMin)) {
                        licznikMin++;
                    }
                    if (czyIstniejePrawyGornySasiad(j, i, szerokosc) && czyIstniejeMinaNaPozycji(j + 1, i - 1, pozycjeMin)) {
                        licznikMin++;
                    }
                    if (czyIstniejeLewySasiad(j) && czyIstniejeMinaNaPozycji(j - 1, i, pozycjeMin)) {
                        licznikMin++;
                    }
                    if (czyIstniejePrawySasiad(j, szerokosc) && czyIstniejeMinaNaPozycji(j + 1, i, pozycjeMin)) {
                        licznikMin++;
                    }
                    if (czyIstniejeLewyDolnySasiad(j, i, wysokosc) && czyIstniejeMinaNaPozycji(j - 1, i + 1, pozycjeMin)) {
                        licznikMin++;
                    }
                    if (czyIstniejeDolnySasiad(i, wysokosc) && czyIstniejeMinaNaPozycji(j, i + 1, pozycjeMin)) {
                        licznikMin++;
                    }
                    if (czyIstniejePrawyDolnySasiad(j, i, szerokosc, wysokosc) && czyIstniejeMinaNaPozycji(j + 1, i + 1, pozycjeMin)) {
                        licznikMin++;
                    }
                    tablicaPlanszy[j][i] = Integer.toString(licznikMin);
                }
            }
        }
        return tablicaPlanszy;
    }
}
