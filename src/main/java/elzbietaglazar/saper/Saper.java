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
                GeneratorPlanszy generatorPlanszy = new GeneratorPlanszy (generatorPozycjiMin, generatorPunktacji, polaciePustychPol);
                PomocMenu pomocMenu = new PomocMenu();
                MenuItemPoziomTrudnosci poczatkujacy = new MenuItemPoziomTrudnosci("Poczatkujacy", PoziomTrudnosci.POCZATKUJACY);
                MenuItemPoziomTrudnosci zaawansowany = new MenuItemPoziomTrudnosci("Zaawansowany", PoziomTrudnosci.ZAAWANSOWANY);
                MenuItemPoziomTrudnosci ekspert = new MenuItemPoziomTrudnosci("Ekspert", PoziomTrudnosci.EKSPERT);
                MenuItemZakoncz zakoncz = new MenuItemZakoncz();
                GraMenu graMenu = new GraMenu(poczatkujacy, zaawansowany, ekspert, zakoncz);
                PasekMenu pasekMenu = new PasekMenu(pomocMenu, graMenu);
                GlowneOkno glowneOkno = new GlowneOkno(pasekMenu, generatorPlanszy, PoziomTrudnosci.POCZATKUJACY);
                poczatkujacy.addActionListener(glowneOkno);
                zaawansowany.addActionListener(glowneOkno);
                ekspert.addActionListener(glowneOkno);
            }
        });
    }
}
