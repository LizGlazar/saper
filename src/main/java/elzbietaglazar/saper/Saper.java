package elzbietaglazar.saper;

import javax.swing.*;

public class Saper
{
    public static void main(String[] args)
    {
        //przeniesienie tworzenia planszy i obiektow pomocniczych do watku Swinga
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                GeneratorPozycjiMin generatorPozycjiMin = new GeneratorPozycjiMin();
                GeneratorPunktacji generatorPunktacji = new GeneratorPunktacji();
                PolaciePustychPol polaciePustychPol = new PolaciePustychPol();
                GeneratorPlanszy generatorPlanszy = new GeneratorPlanszy(PoziomTrudnosci.TEST_POLACI, generatorPozycjiMin, generatorPunktacji, polaciePustychPol);
                PomocMenu pomocMenu = new PomocMenu();
                PasekMenu pasekMenu = new PasekMenu(pomocMenu);
                new GlowneOkno(pasekMenu, generatorPlanszy);
            }
        });
    }
}
