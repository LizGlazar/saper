package elzbietaglazar.saper;

import java.util.List;

public class GeneratorPlanszy
{
    private final GeneratorPozycjiMin generatorPozycjiMin;
    private final GeneratorPunktacji generatorPunktacji;
    private final PolaciePustychPol polaciePustychPol;

    public GeneratorPlanszy(GeneratorPozycjiMin generatorPozycjiMin, GeneratorPunktacji generatorPunktacji, PolaciePustychPol polaciePustychPol)
    {
        this.generatorPozycjiMin = generatorPozycjiMin;
        this.generatorPunktacji = generatorPunktacji;
        this.polaciePustychPol = polaciePustychPol;
    }

    public Plansza generujPlansze(PoziomTrudnosci poziomTrudnosci)
    {
        List<PozycjaMiny> pozycjeMin = generatorPozycjiMin.generujPozycjeMin(poziomTrudnosci);
        String[][] punktacja = generatorPunktacji.zwrocTablicePlanszy(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc, pozycjeMin);

        return new Plansza(poziomTrudnosci, pozycjeMin, punktacja, polaciePustychPol);
    }
}
