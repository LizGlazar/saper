package elzbietaglazar.saper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Klasa zarządzająca ikonami wykorzystywanymi w grze.
 * @author Elżbieta Glazar
 */
public class ZarzadcaIkon
{
    /**
     * Ikona miny
     */
    public static final ImageIcon OBRAZEK_MINY = wczytajObrazek("/mine.png");
    /**
     * Ikona pustego pola
     */
    public static final ImageIcon OBRAZEK_PUSTE_POLE = wczytajObrazek("/0.png");
    /**
     * Ikona pola punktacji o wartości 1
     */
    public static final ImageIcon OBRAZEK_1 = wczytajObrazek("/1.png");
    /**
     * Ikona pola punktacji o wartości 2
     */
    public static final ImageIcon OBRAZEK_2 = wczytajObrazek("/2.png");
    /**
     * Ikona pola punktacji o wartości 3
     */
    public static final ImageIcon OBRAZEK_3 = wczytajObrazek("/3.png");
    /**
     * Ikona pola punktacji o wartości 4
     */
    public static final ImageIcon OBRAZEK_4 = wczytajObrazek("/4.png");
    /**
     * Ikona pola punktacji o wartości 5
     */
    public static final ImageIcon OBRAZEK_5 = wczytajObrazek("/5.png");
    /**
     * Ikona pola punktacji o wartości 6
     */
    public static final ImageIcon OBRAZEK_6 = wczytajObrazek("/6.png");
    /**
     * Ikona pola punktacji o wartości 7
     */
    public static final ImageIcon OBRAZEK_7 = wczytajObrazek("/7.png");
    /**
     * Ikona pola punktacji o wartości 8
     */
    public static final ImageIcon OBRAZEK_8 = wczytajObrazek("/8.png");
    /**
     * Ikona flagi
     */
    public static final ImageIcon OBRAZEK_FLAGA = wczytajObrazek("/flag.png");
    /**
     * Ikona zakrytego pola
     */
    public static final ImageIcon OBRAZEK_POLE_ZAKRYTE = wczytajObrazek("/hidden.png");
    /**
     * Odwzorowanie (mapa) z punktacji na ikonę
     */
    public static final Map<String, ImageIcon> OBRAZKI_PUNKTACJI = zbudujObrazkiPunktacji();

    /**
     * Metoda wczytująca ikonę o podanej nazwie. Metoda przerabia wyjątek IOException (kontrolowany) na IllegalStateException
     * (niekontrolowany. Bez tego nie moglibyśmy wczytać ikony do statycznego pola w klasie.
     * @param ikona nazwa ikony
     * @return metoda zwraca ikonę
     */
    private static ImageIcon wczytajObrazek(String ikona)
    {
        try
        {
            return new ImageIcon(ImageIO.read(ZarzadcaIkon.class.getResourceAsStream(ikona)));
        }
        catch (IOException e)
        {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Metoda buduje odwzorowanie z punktacji na ikonę
     * @return metoda zwraca mapę, której kluczem jest punktacja, a wartością ikona
     */
    private static Map<String, ImageIcon> zbudujObrazkiPunktacji()
    {
        Map<String, ImageIcon> obrazkiPunktacji = new HashMap<>();
        obrazkiPunktacji.put("0", OBRAZEK_PUSTE_POLE);
        obrazkiPunktacji.put("1", OBRAZEK_1);
        obrazkiPunktacji.put("2", OBRAZEK_2);
        obrazkiPunktacji.put("3", OBRAZEK_3);
        obrazkiPunktacji.put("4", OBRAZEK_4);
        obrazkiPunktacji.put("5", OBRAZEK_5);
        obrazkiPunktacji.put("6", OBRAZEK_6);
        obrazkiPunktacji.put("7", OBRAZEK_7);
        obrazkiPunktacji.put("8", OBRAZEK_8);
        obrazkiPunktacji.put("m", OBRAZEK_MINY);
        return obrazkiPunktacji;
    }
}
