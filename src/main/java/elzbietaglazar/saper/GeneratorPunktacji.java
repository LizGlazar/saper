package elzbietaglazar.saper;

import java.util.List;

public class GeneratorPunktacji
{
    public static final String OZNACZENIE_MINY = "m";
    public String[][] zwrocTablicePlanszy (int wysokosc, int szerokosc, List<PozycjaMiny> pozycjeMin)
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

    private boolean czyIstniejeMinaNaPozycji(int x, int y, List<PozycjaMiny> pozycjeMin)
    {
        PozycjaMiny potencjalnaPozycja = new PozycjaMiny(x, y);
        return pozycjeMin.contains(potencjalnaPozycja);
    }

    //funkcja pomocnicza sprawdzajaca, czy istnieje lewy gorny sasiad
    private boolean czyIstniejeLewyGornySasiad(int x, int y)
    {
        return x > 0 && y > 0;
    }

    //funkcja pomocnicza sprawdzajaca, czy istnieje gorny sasiad
    private boolean czyIstniejeGornySasiad(int y)
    {
        return y > 0;
    }
    //funkcja pomocnicza sprawdzajaca, czy istnieje prawy gorny sasiad
    private boolean czyIstniejePrawyGornySasiad(int x, int y, int szerokoscPlanszy)
    {
        return x < szerokoscPlanszy - 1 && y > 0;
    }
    //funkcja pomocnicza sprawdzajaca, czy istnieje lewy sasiad
    private boolean czyIstniejeLewySasiad(int x)
    {
        return x > 0;
    }
    //funkcja pomocnicza sprawdzajaca, czy istnieje prawy sasiad
    private boolean czyIstniejePrawySasiad(int x, int szerokoscPlanszy)
    {
        return x < szerokoscPlanszy - 1;
    }
    //funkcja pomocnicza sprawdzajaca, czy istnieje lewy dolny sasiad
    private boolean czyIstniejeLewyDolnySasiad(int x, int y, int wysokoscPlanszy)
    {
        return x > 0 && y < wysokoscPlanszy -1;
    }
    //funkcja pomocnicza sprawdzajaca, czy istnieje dolny sasiad

    private boolean czyIstniejeDolnySasiad(int y, int wysokoscPlanszy)
    {
        return y < wysokoscPlanszy - 1;
    }
    //funkcja pomocnicza sprawdzajaca, czy istnieje prawy dolny sasiad
    private boolean czyIstniejePrawyDolnySasiad(int x, int y, int szerokoscPlanszy, int wysokoscPlanszy)
    {
        return x < szerokoscPlanszy - 1 && y < wysokoscPlanszy - 1;
    }
}

