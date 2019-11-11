package elzbietaglazar.saper;

import java.util.List;

/**
 * Klasa służy do generowania planszy.
 * @author Elżbieta Glazar
 */
public class GeneratorPlanszy
{
    /**
     * Generator pozycji min.
     */
    private final GeneratorPozycjiMin generatorPozycjiMin;
    /**
     * Generator punktacji.
     */
    private final GeneratorPunktacji generatorPunktacji;
    /**
     * Połacie pustych pól.
     */
    private final PolaciePustychPol polaciePustychPol;

    /**
     * Konstruktor generatora planszy.
     * @param generatorPozycjiMin generator pozycji min
     * @param generatorPunktacji generator punktacji
     * @param polaciePustychPol połacie pustych pól
     * @see GeneratorPozycjiMin
     * @see GeneratorPunktacji
     * @see PolaciePustychPol
     */
    public GeneratorPlanszy(GeneratorPozycjiMin generatorPozycjiMin, GeneratorPunktacji generatorPunktacji, PolaciePustychPol polaciePustychPol)
    {
        this.generatorPozycjiMin = generatorPozycjiMin;
        this.generatorPunktacji = generatorPunktacji;
        this.polaciePustychPol = polaciePustychPol;
    }

    /**
     * Metoda generuje nową planszę na podstawie podanego poziomu trudności.
     * @param poziomTrudnosci poziom trudności
     * @return metoda zwraca planszę
     * @see PoziomTrudnosci
     * @see Plansza
     */
    public Plansza generujPlansze(PoziomTrudnosci poziomTrudnosci)
    {
        List<PozycjaMiny> pozycjeMin = generatorPozycjiMin.generujPozycjeMin(poziomTrudnosci);
        String[][] punktacja = generatorPunktacji.zwrocTablicePlanszy(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc, pozycjeMin);

        return new Plansza(poziomTrudnosci, pozycjeMin, punktacja, polaciePustychPol);
    }
}
