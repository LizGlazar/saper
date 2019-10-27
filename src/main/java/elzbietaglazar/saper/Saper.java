package elzbietaglazar.saper;

public class Saper
{
    public static void main(String[] args)
    {
        GeneratorPozycjiMin generatorPozycjiMin = new GeneratorPozycjiMin();
        GeneratorPunktacji generatorPunktacji = new GeneratorPunktacji();
        PolaciePustychPol polaciePustychPol = new PolaciePustychPol();
        Plansza plansza = new Plansza(PoziomTrudnosci.TEST_POLACI, generatorPozycjiMin, generatorPunktacji, polaciePustychPol);
        PomocMenu pomocMenu = new PomocMenu();
        PasekMenu pasekMenu = new PasekMenu(pomocMenu);
        new GlowneOkno(pasekMenu, plansza);
    }
}
