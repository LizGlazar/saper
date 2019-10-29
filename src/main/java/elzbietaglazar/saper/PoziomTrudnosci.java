package elzbietaglazar.saper;

public enum PoziomTrudnosci {

    POCZATKUJACY(10, 8, 8),
    ZAAWANSOWANY(40, 16, 16),
    EKSPERT(99, 30, 16),
    TEST_POLACI(10, 30, 16),
    MALA_PLANSZA(3, 5, 5);

    public final int liczbaMin;
    public final int szerokosc;
    public final int wysokosc;

    PoziomTrudnosci(int liczbaMin, int szerokosc, int wysokosc)
    {
        this.liczbaMin = liczbaMin;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }
}
