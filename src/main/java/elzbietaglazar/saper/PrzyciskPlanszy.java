package elzbietaglazar.saper;

import javax.swing.*;

public class PrzyciskPlanszy extends JButton
{
    private final int x;
    private final int y;

    public PrzyciskPlanszy (int x, int y)
    {
        this.x = x;
        this.y = y;
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
