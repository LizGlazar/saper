package elzbietaglazar.saper;

import java.util.List;

/**
 * Klasa zawiera pomocnicze funkcje służące do sprawdzania, czy istnieje sąsiednie pole na planszy oraz czy na danym
 * polu znajduje się mina.
 * @author Elżbieta Glazar
 */
public class FunkcjePomocnicze
{
    /**
     * Funkcja sprawdzająca, czy na danej pozycji planszy znajduje się mina.
     * @param x współrzędna x na planszy
     * @param y współrzędna y na planszy
     * @param pozycjeMin lista zawierająca pozycje min
     * @return funkcja zwraca true, jeżeli lista pozycjeMin zawiera minę na danych współrzędnych
     */
    public static boolean czyIstniejeMinaNaPozycji(int x, int y, List<PozycjaMiny> pozycjeMin)
    {
        PozycjaMiny potencjalnaPozycja = new PozycjaMiny(x, y);
        return pozycjeMin.contains(potencjalnaPozycja);
    }

    /**
     * Funkcja pomocnicza sprawdzająca, czy istnieje lewy górny sąsiad.
     * @param x współrzędna x na planszy
     * @param y współrzędna y na planszy
     * @return funkcja zwraca true, jeżeli istnieje pole na planszy znajdujące się na lewo do góry od danego pola
     */
    public static boolean czyIstniejeLewyGornySasiad(int x, int y)
    {
        return x > 0 && y > 0;
    }

    /**
     * Funkcja pomocnicza sprawdzająca, czy istnieje górny sąsiad.
     * @param y współrzędna y na planszy
     * @return funkcja zwraca true, jeżeli istnieje pole na planszy znajdujące się do góry od danego pola
     */
    public static boolean czyIstniejeGornySasiad(int y)
    {
        return y > 0;
    }

    /**
     * Funkcja pomocnicza sprawdzająca, czy istnieje prawy górny sąsiad.
     * @param x współrzędna x na planszy
     * @param y współrzędna y na planszy
     * @param szerokoscPlanszy szerokość planszy
     * @return funkcja zwraca true, jeżeli istnieje pole na planszy znajdujące się na prawo do góry od danego pola
     */
    public static boolean czyIstniejePrawyGornySasiad(int x, int y, int szerokoscPlanszy)
    {
        return x < szerokoscPlanszy - 1 && y > 0;
    }

    /**
     * Funkcja pomocnicza sprawdzająca, czy istnieje lewy sąsiad.
     * @param x współrzędna x na planszy
     * @return funkcja zwraca true, jeżeli istnieje pole na planszy znajdujące się na lewo od danego pola
     */
    public static boolean czyIstniejeLewySasiad(int x)
    {
        return x > 0;
    }

    /**
     * Funkcja pomocnicza sprawdzająca, czy istnieje prawy sąsiad.
     * @param x współrzędna x na planszy
     * @param szerokoscPlanszy szerokość planszy
     * @return funkcja zwraca true, jeżeli istnieje pole na planszy znajdujące się na prawo od danego pola
     */
    public static boolean czyIstniejePrawySasiad(int x, int szerokoscPlanszy)
    {
        return x < szerokoscPlanszy - 1;
    }

    /**
     * Funkcja pomocnicza sprawdzająca, czy istnieje lewy dolny sąsiad.
     * @param x współrzędna x na planszy
     * @param y współrzędna y na planszy
     * @param wysokoscPlanszy wysokość planszy
     * @return funkcja zwraca true, jeżeli istnieje pole na planszy znajdujące się na lewo do dołu od danego pola
     */
    public static boolean czyIstniejeLewyDolnySasiad(int x, int y, int wysokoscPlanszy)
    {
        return x > 0 && y < wysokoscPlanszy -1;
    }

    /**
     * Funkcja pomocnicza sprawdzająca, czy istnieje dolny sąsiad.
     * @param y współrzędna y na planszy
     * @param wysokoscPlanszy wysokość planszy
     * @return funkcja zwraca true, jeżeli istnieje pole na planszy znajdujące się do dołu od danego pola
     */
    public static boolean czyIstniejeDolnySasiad(int y, int wysokoscPlanszy)
    {
        return y < wysokoscPlanszy - 1;
    }

    /**
     * Funkcja pomocnicza sprawdzająca, czy istnieje prawy dolny sąsiad.
     * @param x współrzędna x na planszy
     * @param y współrzędna y na planszy
     * @param szerokoscPlanszy szerokość planszy
     * @param wysokoscPlanszy wysokość planszy
     * @return funkcja zwraca true, jeżeli istnieje pole na planszy znajdujące się na prawo do dołu od danego pola
     */
    public static boolean czyIstniejePrawyDolnySasiad(int x, int y, int szerokoscPlanszy, int wysokoscPlanszy)
    {
        return x < szerokoscPlanszy - 1 && y < wysokoscPlanszy - 1;
    }
}
