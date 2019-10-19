package elzbietaglazar.saper;

public class Saper
{
    public static void main(String[] args)
    {
        PomocMenu pomocMenu = new PomocMenu();
        PasekMenu pasekMenu = new PasekMenu(pomocMenu);
        new GlowneOkno(pasekMenu);
    }
}
