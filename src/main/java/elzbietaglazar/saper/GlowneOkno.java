package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa stanowi główne okno gry, na którym wyświetlane jest menu, plansza oraz dodatkowa informacja związana z
 * przebiegiem gry.
 * @author Elżbieta Glazar
 */
public class GlowneOkno extends JFrame implements ActionListener, ListenerUstawieniaFlagi, ListenerPoczatekGry, ListenerKoniecGry
{
    /**
     * Stała określająca, jak często aktualizowany jest stoper. Jednostką czasu jest milisekunda.
     */
    private static final int TYKNIECIA_ZEGARA = 1000;

    /**
     * Panel planszy.
     */
    private JPanel panelPlanszy;
    /**
     * Generator planszy.
     */
    private final GeneratorPlanszy generatorPlanszy;
    /**
     * Wyświetla liczbę min, która pozostała do oflagowania.
     */
    private final JLabel wyswietlaczLiczbyMin = new JLabel();
    /**
     * Stoper odmierzający czas od rozpoczęcia gry.
     */
    private Timer stoper = new Timer(TYKNIECIA_ZEGARA, this);
    /**
     * Wyświetla sekundy, które upłynęły od początku gry.
     */
    private final JLabel wyswietlaczStopera = new JLabel();
    /**
     * Liczba sekund, która upłynęła od początku gry.
     */
    private int licznikSekund = 0;

    /**
     * Konstruktor za pomocą swoich argumentów generuje planszę oraz obiekty pomocnicze, a następnie wyświetla okno gry.
     * @param pasekMenu pasek menu
     * @param generatorPlanszy generator planszy
     * @param poziomTrudnosci poziom trudności
     * @see PasekMenu
     * @see GeneratorPlanszy
     * @see PoziomTrudnosci
     */
    public GlowneOkno(PasekMenu pasekMenu, GeneratorPlanszy generatorPlanszy, PoziomTrudnosci poziomTrudnosci)
    {
        super("Saper");
        this.generatorPlanszy = generatorPlanszy;
        setJMenuBar(pasekMenu);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JPanel panelDodatkowychInformacji = new JPanel();
        panelDodatkowychInformacji.setLayout(new FlowLayout());
        panelDodatkowychInformacji.add(wyswietlaczLiczbyMin);
        panelDodatkowychInformacji.add(wyswietlaczStopera);
        ustawTekstWyswietlaczaMin(poziomTrudnosci.liczbaMin);
        getContentPane().add(panelDodatkowychInformacji);
        Plansza plansza = generatorPlanszy.generujPlansze(poziomTrudnosci);
        plansza.dodajListenera(this);
        plansza.dodajListeneraPoczatekGry(this);
        plansza.dodajListeneraKoniecGry(this);
        panelPlanszy = plansza.zwrocPanelPlanszy();
        getContentPane().add(panelPlanszy);

        pack();
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Metoda aktualizuje liczbę min pozostałych do oflagowania.
     * @param liczbaMin liczba min
     */
    private void ustawTekstWyswietlaczaMin(int liczbaMin)
    {
        wyswietlaczLiczbyMin.setText("Liczba min: " + liczbaMin);
    }

    /**
     * Metoda obsługująca zdarzenia. Pierwszy typ zdarzeń, to zdarzenia wysyłane przez stoper, w przypadku których
     * należy zaktualizować czas, który upłynął od początku gry. Drugi typ zdarzeń związany jest ze zmianą poziomu
     * trudności wywołaną przez akcję użytkownika; tworzona jest nowa plansza, która zastępuje poprzednią planszę;
     * dodatkowe informacje związane z grą zostają przywrócone do początkowych ustawień.
     * @param e zdarzenie
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(stoper))
        {
            licznikSekund++;
            wyswietlaczStopera.setText("Uplynelo: " + licznikSekund + " s");
        }
        else
        {
            MenuItemPoziomTrudnosci wybranaPozycjaMenu = (MenuItemPoziomTrudnosci) e.getSource();
            PoziomTrudnosci nowyPoziomTrudnosci = wybranaPozycjaMenu.zwrocPoziomTrudnosci();
            Plansza plansza = generatorPlanszy.generujPlansze(nowyPoziomTrudnosci);
            plansza.dodajListenera(this);
            plansza.dodajListeneraPoczatekGry(this);
            plansza.dodajListeneraKoniecGry(this);
            getContentPane().remove(panelPlanszy);
            panelPlanszy = plansza.zwrocPanelPlanszy();
            getContentPane().add(panelPlanszy);
            ustawTekstWyswietlaczaMin(nowyPoziomTrudnosci.liczbaMin);
            stoper = new Timer(TYKNIECIA_ZEGARA, this);
            licznikSekund = 0;
            wyswietlaczStopera.setText("");
            pack();
            revalidate();
            repaint();
        }
    }

    /**
     * Metoda aktualizuje wyświetlacz min pozostałych do oflagowania.
     * @param aktualnaLiczbaMin aktualna liczba min
     */
    @Override
    public void zmianaLiczbyMin(int aktualnaLiczbaMin)
    {
        ustawTekstWyswietlaczaMin(aktualnaLiczbaMin);
    }

    /**
     * Metoda zatrzymuje stoper w momencie zakończenia gry.
     */
    @Override
    public void zakonczonoGre()
    {
        stoper.stop();
    }

    /**
     * Metoda uruchamia stoper w momencie rozpoczęcia gry.
     */
    @Override
    public void rozpoczetoGre()
    {
        stoper.start();
    }
}
