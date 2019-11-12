package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa implementująca przycisk planszy.
 * @author Elżbieta Glazar
 */
public class PrzyciskPlanszy extends JButton
{
    /**
     * Współrzędna x przycisku
     */
    private final int x;
    /**
     * Współrzędna y przycisku
     */
    private final int y;
    /**
     * Ikona wyświetlana po odsłonięciu przycisku
     */
    private final ImageIcon ikonaOdslonieta;
    /**
     * Ikona wyświetlana przed odsłonięciem przycisku
     */
    private final ImageIcon ikonaZaslonieta;
    /**
     * Po ustawieniu flagi zmienna przyjmuje wartość true
     */
    private boolean czyUstawionoFlage = false;

    /**
     * Konstruktor.
     * @param x współrzędna x przycisku
     * @param y współrzędna y przycisku
     * @param ikonaZaslonieta ikona zasłonięta
     * @param ikonaOdslonieta ikona odsłonięta
     * @see ImageIcon
     */
    public PrzyciskPlanszy (int x, int y, ImageIcon ikonaZaslonieta, ImageIcon ikonaOdslonieta)
    {
        super(ikonaZaslonieta);
        this.x = x;
        this.y = y;
        this.ikonaOdslonieta = ikonaOdslonieta;
        this.ikonaZaslonieta = ikonaZaslonieta;
        setPreferredSize(new Dimension(24, 24));
    }

    /**
     * Metoda odsłania przycisk, tj. ustawia odpowiednią ikonę oraz wyłącza ten przycisk
     */
    public void odslon()
    {
        setDisabledIcon(ikonaOdslonieta);
        setEnabled(false);
    }

    /**
     * Metoda odsłania przycisk, tj. ustawia ikonę będącą argumentem metody oraz wyłącza ten przycisk
     * @param ikona ikona, która będzie ustawiona na przycisku zamiast ikony odsłoniętej
     */
    public void odslon(ImageIcon ikona)
    {
        setDisabledIcon(ikona);
        setEnabled(false);
    }

    /**
     * Metoda zwraca współrzędną x przycisku
     * @return metoda zwraca współrzędną x przycisku
     */
    public int zwrocX()
    {
        return x;
    }

    /**
     * Metoda zwraca współrzędną y przycisku
     * @return metoda zwraca współrzędną y przycisku
     */
    public int zwrocY()
    {
        return y;
    }

    /**
     * Metoda informuje o tym, czy na przycisku jest ustawiona flaga
     * @return metoda zwraca true, jeżeli użytkownik ustawił flagę na przycisku
     */
    public boolean zwrocCzyUstawionoFlage()
    {
        return czyUstawionoFlage;
    }

    /**
     * Metoda zdejmuje flagę z przycisku poprzez ustawienie ikony zasłoniętej
     */
    public void zdejmijFlage()
    {
        setIcon(ikonaZaslonieta);
        czyUstawionoFlage = false;
    }

    /**
     * Metoda ustawia flagę na przycisku poprzez wyświetlenie ikony flagi
     * @param obrazekFlaga ikona flagi
     */
    public void ustawFlage(ImageIcon obrazekFlaga)
    {
        setIcon(obrazekFlaga);
        czyUstawionoFlage = true;
    }
}
