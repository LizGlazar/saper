package elzbietaglazar.saper;

import java.util.List;

import static elzbietaglazar.saper.FunkcjePomocnicze.*;

/**
 * Klasa generuje punktację na podstawie rozmiarów planszy i pozycji min. Przez punktację rozumiemy liczbę min
 * sąsiadujących z danym polem.
 * @author Elżbieta Glazar
 */
public class GeneratorPunktacji
{
    /**
     * Pomocnicza stała, która opisuje pozycję miny na planszy.
     */
    public static final String OZNACZENIE_MINY = "m";

    /**
     * Metoda generuje punktację dla planszy. Każdemu polu przypisana jest cyfra oznaczająca liczbę min sąsiadującą
     * z danym polem. Cyfra ta jest następnie wyświetlana użytkownikowi. Gdy cyfra jest równa zero, wyświetlany jest
     * pusty kwadrat.
     * @param wysokosc wysokość planszy
     * @param szerokosc szerokość planszy
     * @param pozycjeMin pozycje min
     * @return metoda zwraca tablicę, której szerokość jest równa szerokości planszy, a wysokość wysokości planszy;
     * w tablicy znajduje się punktacja
     * @see PozycjaMiny
     */
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
                    if (czyIstniejeLewyGornySasiad(j, i) && czyIstniejeMinaNaPozycji(j - 1, i - 1, pozycjeMin))
                    {
                        licznikMin++;
                    }
                    if (czyIstniejeGornySasiad(i) && czyIstniejeMinaNaPozycji(j, i - 1, pozycjeMin))
                    {
                        licznikMin++;
                    }
                    if (czyIstniejePrawyGornySasiad(j, i, szerokosc) && czyIstniejeMinaNaPozycji(j + 1, i - 1, pozycjeMin))
                    {
                        licznikMin++;
                    }
                    if (czyIstniejeLewySasiad(j) && czyIstniejeMinaNaPozycji(j - 1, i, pozycjeMin))
                    {
                        licznikMin++;
                    }
                    if (czyIstniejePrawySasiad(j, szerokosc) && czyIstniejeMinaNaPozycji(j + 1, i, pozycjeMin))
                    {
                        licznikMin++;
                    }
                    if (czyIstniejeLewyDolnySasiad(j, i, wysokosc) && czyIstniejeMinaNaPozycji(j - 1, i + 1, pozycjeMin))
                    {
                        licznikMin++;
                    }
                    if (czyIstniejeDolnySasiad(i, wysokosc) && czyIstniejeMinaNaPozycji(j, i + 1, pozycjeMin))
                    {
                        licznikMin++;
                    }
                    if (czyIstniejePrawyDolnySasiad(j, i, szerokosc, wysokosc) && czyIstniejeMinaNaPozycji(j + 1, i + 1, pozycjeMin))
                    {
                        licznikMin++;
                    }
                    tablicaPlanszy[j][i] = Integer.toString(licznikMin);
                }
            }
        }
        return tablicaPlanszy;
    }
}
