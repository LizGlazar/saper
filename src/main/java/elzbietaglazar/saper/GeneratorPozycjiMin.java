package elzbietaglazar.saper;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class GeneratorPozycjiMin
{
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
