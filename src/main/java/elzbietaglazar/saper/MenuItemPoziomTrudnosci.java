package elzbietaglazar.saper;

import javax.swing.*;

/**
 * Klasa implementująca element menu pozwalający na zmianę poziomu trudności gry.
 * @author Elżbieta Glazar
 */
public class MenuItemPoziomTrudnosci extends JMenuItem
{
    /**
     * Poziom trudności.
     */
    private final PoziomTrudnosci poziomTrudnosci;

    /**
     * Konstruktor.
     * @param tekstDoWyswietlenia tekst do wyświetlenia w elemencie menu
     * @param poziomTrudnosci poziom trudności
     * @see PoziomTrudnosci
     */
    public MenuItemPoziomTrudnosci(String tekstDoWyswietlenia, PoziomTrudnosci poziomTrudnosci)
    {
        super(tekstDoWyswietlenia);
        this.poziomTrudnosci = poziomTrudnosci;
    }

    /**
     * Metoda zwraca poziom trudności związany z danym elementem menu.
     * @return poziom trudności
     * @see PoziomTrudnosci
     */
    public PoziomTrudnosci zwrocPoziomTrudnosci()
    {
        return poziomTrudnosci;
    }
}
