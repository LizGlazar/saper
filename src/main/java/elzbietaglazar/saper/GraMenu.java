package elzbietaglazar.saper;

import javax.swing.*;

/**
 * Klasa stanowi menu Gra pozwalające wybrać poziom trudnosci lub zakończyć grę.
 * @author Elżbieta Glazar
 */
public class GraMenu extends JMenu
{
    /**
     * Konstruktor oddziela wybór poziomu trudności od zakończenia gry.
     * @param poczatkujacy początkujący poziom trudności
     * @param zaawansowany zaawansowany poziom trudności
     * @param ekspert poziom trudności ekspert
     * @param zakoncz zakończ grę
     * @see MenuItemPoziomTrudnosci
     * @see MenuItemZakoncz
     */
    public GraMenu(MenuItemPoziomTrudnosci poczatkujacy, MenuItemPoziomTrudnosci zaawansowany, MenuItemPoziomTrudnosci ekspert, MenuItemZakoncz zakoncz)
    {
        super("Gra");
        add(poczatkujacy);
        add(zaawansowany);
        add(ekspert);
        addSeparator();
        add(zakoncz);
    }
}
