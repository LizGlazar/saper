package elzbietaglazar.saper;

/**
 * Typ wyliczeniowy implementujący poziomy trudności gry.
 * @author Elżbieta Glazar
 */
public enum PoziomTrudnosci
{

    POCZATKUJACY(10, 8, 8),
    ZAAWANSOWANY(40, 16, 16),
    EKSPERT(99, 30, 16);

    /**
     * Liczba min
     */
    public final int liczbaMin;
    /**
     * Szerokość planszy
     */
    public final int szerokosc;
    /**
     * Wysokość planszy
     */
    public final int wysokosc;

    /**
     * Konstruktor tworzy poziom trudności na podstawie podanych parametrów.
     * @param liczbaMin liczba min
     * @param szerokosc szerokość planszy
     * @param wysokosc wysokość planszy
     */
    PoziomTrudnosci(int liczbaMin, int szerokosc, int wysokosc)
    {
        this.liczbaMin = liczbaMin;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }
}
