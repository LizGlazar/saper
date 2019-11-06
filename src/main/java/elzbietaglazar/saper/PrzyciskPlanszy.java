package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;

public class PrzyciskPlanszy extends JButton
{
    private final int x;
    private final int y;
    private final ImageIcon ikonaOdslonieta;
    private final ImageIcon ikonaZaslonieta;
    private boolean czyUstawionoFlage = false;

    public PrzyciskPlanszy (int x, int y, ImageIcon ikonaZaslonieta, ImageIcon ikonaOdslonieta)
    {
        super(ikonaZaslonieta);
        this.x = x;
        this.y = y;
        this.ikonaOdslonieta = ikonaOdslonieta;
        this.ikonaZaslonieta = ikonaZaslonieta;
        setPreferredSize(new Dimension(24, 24));
    }

    public void odslon()
    {
        setDisabledIcon(ikonaOdslonieta);
        setEnabled(false);
    }

    public void odslon(ImageIcon ikona)
    {
        setDisabledIcon(ikona);
        setEnabled(false);
    }

    public int zwrocX()
    {
        return x;
    }

    public int zwrocY()
    {
        return y;
    }

    public boolean zwrocCzyUstawionoFlage()
    {
        return czyUstawionoFlage;
    }

    public void zdejmijFlage()
    {
        setIcon(ikonaZaslonieta);
        czyUstawionoFlage = false;
    }

    public void ustawFlage(ImageIcon obrazekFlaga)
    {
        setIcon(obrazekFlaga);
        czyUstawionoFlage = true;
    }
}
