package elzbietaglazar.saper;

import java.util.Objects;

/**
 * Klasa implementująca pozycję miny.
 * @author Elżbieta Glazar
 */
public class PozycjaMiny
{
    /**
     * Współrzędna x
     */
    private final int x;
    /**
     * Współrzędna y
     */
    private final int y;

    /**
     * Konstruktor.
     * @param x współrzędna x
     * @param y współrzędna y
     */
    public PozycjaMiny(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Metoda zwraca współrzędną x.
     * @return metoda zwraca współrzędną x
     */
    public int zwrocX()
    {
        return x;
    }

    /**
     * Metoda zwraca współrzędną y.
     * @return metoda zwraca współrzędną y
     */
    public int zwrocY()
    {
        return y;
    }

    /**
     * Automatycznie wygenerowana metoda do porównywania obiektów
     * @param o obiekt do porównania
     * @return metoda zwraca true, jeżeli obiekt jest typu PozycjaMiny oraz współrzędne x, y tego obiektu są równe
     * współrzędnym x, y danej pozycji miny
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PozycjaMiny that = (PozycjaMiny) o;
        boolean wynikPorownania = x == that.x && y == that.y;
        return wynikPorownania;
    }

    /**
     * Automatycznie wygnerowana metoda do obliczania funkcji skrótu
     * @return metoda zwraca obliczoną wartość funkcji skrótu
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }
}
