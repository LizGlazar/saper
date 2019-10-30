package elzbietaglazar.saper;

import javax.swing.*;

public class MenuItemPoziomTrudnosci extends JMenuItem
{
    private final PoziomTrudnosci poziomTrudnosci;
    public MenuItemPoziomTrudnosci(String tekstDoWyswietlenia, PoziomTrudnosci poziomTrudnosci)
    {
        super(tekstDoWyswietlenia);
        this.poziomTrudnosci = poziomTrudnosci;
    }
    public PoziomTrudnosci zwrocPoziomTrudnosci()
    {
        return poziomTrudnosci;
    }
}
