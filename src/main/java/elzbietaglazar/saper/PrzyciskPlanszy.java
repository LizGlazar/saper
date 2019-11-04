package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;

public class PrzyciskPlanszy extends JButton
{
    private final int x;
    private final int y;
    private final ImageIcon ikonaOdslonieta;

    public PrzyciskPlanszy (int x, int y, ImageIcon ikonaZaslonieta, ImageIcon ikonaOdslonieta)
    {
        super(ikonaZaslonieta);
        this.x = x;
        this.y = y;
        this.ikonaOdslonieta = ikonaOdslonieta;
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
}
