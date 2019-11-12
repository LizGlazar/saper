package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa implementująca element menu Zakończ.
 * @author Elżbieta Glazar
 */
public class MenuItemZakoncz extends JMenuItem implements ActionListener
{
    /**
     * Konstruktor, który ustawia samego siebie jako nasłuchującego na kliknięcia użytkownika.
     */
    public MenuItemZakoncz()
    {
        super("Zakoncz");
        addActionListener(this);
    }

    /**
     * Metoda obsługująca kliknięcia użytkownika. Akcja użytkownika wyłącza program.
     * @param e zdarzenie
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
}
