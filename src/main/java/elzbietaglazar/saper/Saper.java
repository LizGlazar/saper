package elzbietaglazar.saper;

public class Saper
{
    public static void main(String[] args)
    {
        GeneratorPozycjiMin generatorPozycjiMin = new GeneratorPozycjiMin();
        Plansza plansza = new Plansza(PoziomTrudnosci.EKSPERT, generatorPozycjiMin);
        PomocMenu pomocMenu = new PomocMenu();
        PasekMenu pasekMenu = new PasekMenu(pomocMenu);
        new GlowneOkno(pasekMenu, plansza);
    }
}
