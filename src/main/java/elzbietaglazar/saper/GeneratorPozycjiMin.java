package elzbietaglazar.saper;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa rozmieszcza miny na losowych pozycjach.
 * @author Elżbieta Glazar
 */
public class GeneratorPozycjiMin
{
    /**
     * Metoda generuje losowe pozycje min na podstawie liczby min, wysokości i szerokości planszy. Pozycje min nie
     * powtarzają się, tzn. każda mina znajduje się na innej pozycji.
     * @param poziomTrudnosci poziom trudności
     * @return metoda zwraca listę pozycji min; długość listy jest równa liczbie min z poziomu trudności
     * @see PoziomTrudnosci
     * @see PozycjaMiny
     */
    public List<PozycjaMiny> generujPozycjeMin(PoziomTrudnosci poziomTrudnosci)
    {
        SecureRandom generatorLiczbLosowych = new SecureRandom();
        List<PozycjaMiny> pozycjeMin = new ArrayList<>();

        int ileMinZostalo = poziomTrudnosci.liczbaMin;
        while (ileMinZostalo > 0)
        {
            int x = generatorLiczbLosowych.nextInt(poziomTrudnosci.szerokosc);
            int y = generatorLiczbLosowych.nextInt(poziomTrudnosci.wysokosc);
            PozycjaMiny pozycjaMiny = new PozycjaMiny(x, y);
            //Teraz nalezy sprawdzic, czy wczesniej nie wylosowalismy takiej samej pozycji
            //Zeby contains zadzialalo poprawnie, to w klasie PozycjaMiny musimy zaimplementowac equals i hashCode
            if (!pozycjeMin.contains(pozycjaMiny))
            {
                pozycjeMin.add(pozycjaMiny);
                ileMinZostalo--;
            }
        }

        return pozycjeMin;
    }
}
