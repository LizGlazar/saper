package elzbietaglazar.saper;

import javax.swing.*;

/**
 * Klasa implementująca pasek menu aplikacji.
 * @author Elżbieta Glazar
 */
public class PasekMenu extends JMenuBar
{
    /**
     * Konstruktor dodaje do paska menu Gra i menu Pomoc.
     * @param pomocMenu Menu Pomoc
     * @param graMenu Menu Gra
     * @see PomocMenu
     * @see GraMenu
     */
    public PasekMenu(PomocMenu pomocMenu, GraMenu graMenu)
    {
        add(graMenu);
        add(pomocMenu);
    }
}
