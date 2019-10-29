package elzbietaglazar.saper;

import java.util.List;

public class GeneratorPlanszy
{
    private final PoziomTrudnosci poziomTrudnosci;
    private final GeneratorPozycjiMin generatorPozycjiMin;
    private final GeneratorPunktacji generatorPunktacji;
    private final PolaciePustychPol polaciePustychPol;

    public GeneratorPlanszy(PoziomTrudnosci poziomTrudnosci, GeneratorPozycjiMin generatorPozycjiMin, GeneratorPunktacji generatorPunktacji, PolaciePustychPol polaciePustychPol)
    {
        this.poziomTrudnosci = poziomTrudnosci;
        this.generatorPozycjiMin = generatorPozycjiMin;
        this.generatorPunktacji = generatorPunktacji;
        this.polaciePustychPol = polaciePustychPol;
    }

    public Plansza generujPlansze()
    {
        List<PozycjaMiny> pozycjeMin = generatorPozycjiMin.generujPozycjeMin(poziomTrudnosci);
        String[][] punktacja = generatorPunktacji.zwrocTablicePlanszy(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc, pozycjeMin);


        return new Plansza(poziomTrudnosci, pozycjeMin, punktacja, polaciePustychPol);
    }








}
