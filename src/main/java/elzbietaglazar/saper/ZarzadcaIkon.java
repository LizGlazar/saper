package elzbietaglazar.saper;

import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ZarzadcaIkon
{
    public static final ImageIcon OBRAZEK_MINY = wczytajObrazek("/mine.png");
    public static final ImageIcon OBRAZEK_PUSTE_POLE = wczytajObrazek("/0.png");
    public static final ImageIcon OBRAZEK_1 = wczytajObrazek("/1.png");
    public static final ImageIcon OBRAZEK_2 = wczytajObrazek("/2.png");
    public static final ImageIcon OBRAZEK_3 = wczytajObrazek("/3.png");
    public static final ImageIcon OBRAZEK_4 = wczytajObrazek("/4.png");
    public static final ImageIcon OBRAZEK_5 = wczytajObrazek("/5.png");
    public static final ImageIcon OBRAZEK_6 = wczytajObrazek("/6.png");
    public static final ImageIcon OBRAZEK_7 = wczytajObrazek("/7.png");
    public static final ImageIcon OBRAZEK_8 = wczytajObrazek("/8.png");
    public static final ImageIcon OBRAZEK_FLAGA = wczytajObrazek("/flag.png");
    public static final ImageIcon OBRAZEK_OFLAGOWANA_MINA = wczytajObrazek("/flagmine.png");
    public static final ImageIcon OBRAZEK_POLE_ZAKRYTE = wczytajObrazek("/hidden.png");
    public static final ImageIcon OBRAZEK_CZERWONA_MINA = wczytajObrazek("/redmine.png");
    public static final Map<String, ImageIcon> OBRAZKI_PUNKTACJI = zbudujObrazkiPunktacji();

    private static ImageIcon wczytajObrazek(String ikona)
    {
        try {
            return new ImageIcon(ImageIO.read(ZarzadcaIkon.class.getResourceAsStream(ikona)));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

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
        obrazkiPunktacji.put("m", OBRAZEK_CZERWONA_MINA);
        return obrazkiPunktacji;
    }
}
