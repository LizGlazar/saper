package elzbietaglazar.saper;

import java.util.List;

public class FunkcjePomocnicze
{
    public static boolean czyIstniejeMinaNaPozycji(int x, int y, List<PozycjaMiny> pozycjeMin)
    {
        PozycjaMiny potencjalnaPozycja = new PozycjaMiny(x, y);
        return pozycjeMin.contains(potencjalnaPozycja);
    }

    //funkcja pomocnicza sprawdzajaca, czy istnieje lewy gorny sasiad
    public static boolean czyIstniejeLewyGornySasiad(int x, int y)
    {
        return x > 0 && y > 0;
    }

    //funkcja pomocnicza sprawdzajaca, czy istnieje gorny sasiad
    public static boolean czyIstniejeGornySasiad(int y)
    {
        return y > 0;
    }

    //funkcja pomocnicza sprawdzajaca, czy istnieje prawy gorny sasiad
    public static boolean czyIstniejePrawyGornySasiad(int x, int y, int szerokoscPlanszy)
    {
        return x < szerokoscPlanszy - 1 && y > 0;
    }

    //funkcja pomocnicza sprawdzajaca, czy istnieje lewy sasiad
    public static boolean czyIstniejeLewySasiad(int x)
    {
        return x > 0;
    }

    //funkcja pomocnicza sprawdzajaca, czy istnieje prawy sasiad
    public static boolean czyIstniejePrawySasiad(int x, int szerokoscPlanszy)
    {
        return x < szerokoscPlanszy - 1;
    }

    //funkcja pomocnicza sprawdzajaca, czy istnieje lewy dolny sasiad
    public static boolean czyIstniejeLewyDolnySasiad(int x, int y, int wysokoscPlanszy)
    {
        return x > 0 && y < wysokoscPlanszy -1;
    }

    //funkcja pomocnicza sprawdzajaca, czy istnieje dolny sasiad
    public static boolean czyIstniejeDolnySasiad(int y, int wysokoscPlanszy)
    {
        return y < wysokoscPlanszy - 1;
    }

    //funkcja pomocnicza sprawdzajaca, czy istnieje prawy dolny sasiad
    public static boolean czyIstniejePrawyDolnySasiad(int x, int y, int szerokoscPlanszy, int wysokoscPlanszy)
    {
        return x < szerokoscPlanszy - 1 && y < wysokoscPlanszy - 1;
    }
}
