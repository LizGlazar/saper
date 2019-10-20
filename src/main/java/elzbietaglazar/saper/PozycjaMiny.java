package elzbietaglazar.saper;

import java.util.Objects;

public class PozycjaMiny
{
    private final int x;
    private final int y;

    public PozycjaMiny(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int zwrocX()
    {
        return x;
    }

    public int zwrocY()
    {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PozycjaMiny that = (PozycjaMiny) o;
        boolean wynikPorownania = x == that.x && y == that.y;
        return wynikPorownania;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
