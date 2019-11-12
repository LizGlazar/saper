package elzbietaglazar.saper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa implementująca planszę oraz obsługująca akcje użytkownika związane z logiką gry, w tym ustawienie i zdjęcie
 * flagi, odsłonięcie pól, rozpoczęcie gry i zakończenie gry. Użytkownik przegrywa w momencie odsłonięcia miny,
 * natomiast wygrana następuje, gdy użytkownik odsłoni wszystkie pola niebędące minami.
 * @author Elżbieta Glazar
 */
public class Plansza implements MouseListener
{
    /**
     * Poziom trudności
     */
    private final PoziomTrudnosci poziomTrudnosci;
    /**
     * Lista zawierająca pozycje min
     */
    private final List<PozycjaMiny> pozycjeMin;
    /**
     * Dwuwymiarowa tablica zawierająca punktację
     */
    private final String[][] punktacja;
    /**
     * Dwuwymiarowa tablica składająca się z przycisków na planszy
     */
    private final PrzyciskPlanszy[][] tablicaPrzyciskow;
    /**
     * Logika do odsłaniania połaci pustych pól
     */
    private final PolaciePustychPol polaciePustychPol;
    /**
     * Licznik pól do odsłonięcia
     */
    private int licznikPolDoOdsloniecia;
    /**
     * Lista obiektów nasłuchujących na wydarzenie ustawienia flagi
     */
    private List<ListenerUstawieniaFlagi> listenerzyUstawieniaFlagi = new ArrayList<>();
    /**
     * Lista obiektów nasłuchujących na wydarzenie rozpoczęcia gry
     */
    private List<ListenerPoczatekGry> listenerzyPoczatekGry = new ArrayList<>();
    /**
     * Lista obiektów nasłuchujących na wydarzenie zakończenia gry
     */
    private List<ListenerKoniecGry> listenerzyKoniecGry = new ArrayList<>();
    /**
     * Liczba ustawionych flag
     */
    private int liczbaUstawionychFlag = 0;
    /**
     * Zmienia wartość na true w momencie odsłonięcia przez użytkownika pierwszego pola
     */
    private boolean czyGraWToku = false;

    /**
     * Konstruktor tworzy planszę na podstawie podanych argumentów. Każde pole planszy reprezentowane jest przez przycisk
     * z odpowiednią ikoną. Każda możliwa wartość punktacji ma odpowiadającą ikonę. Plansza jest tablicą dwuwymiarową,
     * której pole o współrzędnych [0,0] znajduje się w lewym górnym rogu. Przyciski tworzone są z góry na dół
     * (zmienna i) i od lewej do prawej (zmienna j).
     * @param poziomTrudnosci poziom trudności
     * @param pozycjeMin lista zawierająca pozycje min
     * @param punktacja tablica dwuwymiarowa zawierająca punktację każdego pola planszy
     * @param polaciePustychPol logika do odsłaniania połaci pustych pól
     * @see PoziomTrudnosci
     * @see PozycjaMiny
     * @see PolaciePustychPol
     */
    public Plansza(PoziomTrudnosci poziomTrudnosci, List<PozycjaMiny> pozycjeMin, String[][] punktacja, PolaciePustychPol polaciePustychPol)
    {
        this.poziomTrudnosci = poziomTrudnosci;
        this.pozycjeMin = pozycjeMin;
        this.punktacja = punktacja;
        this.polaciePustychPol = polaciePustychPol;
        tablicaPrzyciskow = new PrzyciskPlanszy[poziomTrudnosci.szerokosc][poziomTrudnosci.wysokosc];
        licznikPolDoOdsloniecia = poziomTrudnosci.szerokosc * poziomTrudnosci.wysokosc - poziomTrudnosci.liczbaMin;

        for (int i = 0; i < poziomTrudnosci.wysokosc; i++)
        {
            for (int j = 0; j < poziomTrudnosci.szerokosc; j++)
            {
                String punktacjaPrzycisku = punktacja[j][i];
                PrzyciskPlanszy przyciskPlanszy = new PrzyciskPlanszy(j, i, ZarzadcaIkon.OBRAZEK_POLE_ZAKRYTE, ZarzadcaIkon.OBRAZKI_PUNKTACJI.get(punktacjaPrzycisku));
                przyciskPlanszy.addMouseListener(this);
                tablicaPrzyciskow[j][i] = przyciskPlanszy;
            }
        }
    }

    /**
     * Metoda zwracająca panel, w którym znajdują się przyciski reprezentujące pola planszy.
     * @return metoda zwraca panel planszy
     */
    public JPanel zwrocPanelPlanszy()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(poziomTrudnosci.wysokosc, poziomTrudnosci.szerokosc));

        for (int i = 0; i < poziomTrudnosci.wysokosc; i++)
        {
            for (int j = 0; j < poziomTrudnosci.szerokosc; j++)
            {
                panel.add(tablicaPrzyciskow[j][i]);
            }
        }

        return panel;
    }

    /**
     * Metoda realizująca obsługę lewego przycisku myszy, czyli odsłonięcie pola. Jeżeli użytkownik odsłoni minę, to
     * przegrywa. Jeżeli odsłoni ostatnie pole niebędące miną, wygrywa.
     * @param przyciskPlanszy przycisk, który został wciśnięty przez użytkownika
     */
    public void obslugaLewegoPrzyciskuMyszy(PrzyciskPlanszy przyciskPlanszy)
    {
        if (!czyGraWToku)
        {
            czyGraWToku = true;
            powiadomoListenerowOPoczatkuGry();
        }
        int x = przyciskPlanszy.zwrocX();
        int y = przyciskPlanszy.zwrocY();
        String tekst = punktacja[x][y];
        if (tekst.equals("0"))
        {
            int odslonietePolaPolaci = polaciePustychPol.odslonPustePolaIBrzeg(x, y, tablicaPrzyciskow, punktacja, poziomTrudnosci.szerokosc, poziomTrudnosci.wysokosc);
            licznikPolDoOdsloniecia -= odslonietePolaPolaci;
        }
        else
        {
            przyciskPlanszy.odslon();
            licznikPolDoOdsloniecia--;
        }
        if (tekst.equals(GeneratorPunktacji.OZNACZENIE_MINY))
        {
            koniecGryPoKliknieciuNaMine();
        }
        else if (licznikPolDoOdsloniecia == 0)
        {
            zablokujWszystkiePrzyciski();
            powiadomoListenerowOKoncuGry();
            JOptionPane.showMessageDialog(null, "Gratulacje, wygrana!");
        }
    }

    /**
     * Metoda wykonuje akcje związane z zakończeniem gry: pokazuje, gdzie znajdują się miny, blokuje wszystkie przyciski
     * oraz wyświetla okno dialogowe informujące o przegranej.
     */
    private void koniecGryPoKliknieciuNaMine()
    {
        odslonWszystkieMiny();
        zablokujWszystkiePrzyciski();
        wyswietlOknoDialogowe();
    }

    /**
     * Metoda odsłania wszystkie pola, pod którymi znajdują się miny.
     */
    private void odslonWszystkieMiny()
    {
        for (PozycjaMiny pozycjaMiny : pozycjeMin)
        {
            int x = pozycjaMiny.zwrocX();
            int y = pozycjaMiny.zwrocY();
            PrzyciskPlanszy przyciskPlanszy = tablicaPrzyciskow[x][y];
            przyciskPlanszy.odslon(ZarzadcaIkon.OBRAZEK_MINY);
        }
    }

    /**
     * Metoda blokuje wszystkie przyciski.
     */
    private void zablokujWszystkiePrzyciski()
    {
        for (int i = 0; i < poziomTrudnosci.wysokosc; i++)
        {
            for (int j = 0; j < poziomTrudnosci.szerokosc; j++)
            {
                tablicaPrzyciskow[j][i].setEnabled(false);
            }
        }
    }

    /**
     * Metoda powiadamia słuchaczy o zakończeniu gry oraz wyświetla okno dialogowe informujące o przegranej.
     */
    private void wyswietlOknoDialogowe()
    {
        powiadomoListenerowOKoncuGry();
        JOptionPane.showMessageDialog(null, "Koniec gry.");
    }

    /**
     * Metoda powiadamia słuchaczy o ustawieniu bądź zdjęciu flagi.
     */
    private void powiadomListenerow()
    {
        int aktualnaLiczbaMin = poziomTrudnosci.liczbaMin - liczbaUstawionychFlag;
        for (ListenerUstawieniaFlagi listener : listenerzyUstawieniaFlagi)
        {
            listener.zmianaLiczbyMin(aktualnaLiczbaMin);
        }
    }

    /**
     * Metoda dodaje słuchacza zainteresowanego wydarzeniami ustawienia lub zdjęcia flagi.
     * @param listener słuchacz
     * @see ListenerUstawieniaFlagi
     */
    public void dodajListenera(ListenerUstawieniaFlagi listener)
    {
        listenerzyUstawieniaFlagi.add(listener);
    }

    /**
     * Metoda dodaje słuchacza zainteresowanego wydarzeniem rozpoczęcia gry.
     * @param listener słuchacz
     * @see ListenerPoczatekGry
     */
    public void dodajListeneraPoczatekGry(ListenerPoczatekGry listener)
    {
        listenerzyPoczatekGry.add(listener);
    }

    /**
     * Metoda dodaje słuchacza zainteresowanego wydarzeniem zakończenia gry.
     * @param listener słuchacz
     * @see ListenerKoniecGry
     */
    public void dodajListeneraKoniecGry(ListenerKoniecGry listener)
    {
        listenerzyKoniecGry.add(listener);
    }

    /**
     * Metoda powiadamia słuchaczy o końcu gry.
     */
    private void powiadomoListenerowOKoncuGry()
    {
        for (ListenerKoniecGry listener : listenerzyKoniecGry)
        {
            listener.zakonczonoGre();
        }
    }

    /**
     * Metoda powiadamia słuchaczy o rozpoczęciu gry.
     */
    private void powiadomoListenerowOPoczatkuGry()
    {
        for (ListenerPoczatekGry listener : listenerzyPoczatekGry)
        {
            listener.rozpoczetoGre();
        }
    }

    /**
     * Metoda odpowiedzialna za obsługę kliknięć myszy. Kliknięcie prawym przyciskiem myszy na pole ustawia na nim flagę.
     * Ponowne kliknięcie prawym przyciskiem myszy zdejmuje flagę. Kliknięcie lewym przyciskiem myszy odsłania pole,
     * pod warunkiem że na polu tym nie znajduje się flaga.
     * @param e zdarzenie
     */
    @Override
    public void mouseClicked(MouseEvent e)
    {
        PrzyciskPlanszy przyciskPlanszy = (PrzyciskPlanszy) e.getSource();
        if (SwingUtilities.isLeftMouseButton(e) && !przyciskPlanszy.zwrocCzyUstawionoFlage())
        {
            obslugaLewegoPrzyciskuMyszy(przyciskPlanszy);
        }
        else if (SwingUtilities.isRightMouseButton(e))
        {
            if (przyciskPlanszy.zwrocCzyUstawionoFlage())
            {
                przyciskPlanszy.zdejmijFlage();
                liczbaUstawionychFlag--;
            }
            else
            {
                przyciskPlanszy.ustawFlage(ZarzadcaIkon.OBRAZEK_FLAGA);
                liczbaUstawionychFlag++;
            }
            powiadomListenerow();
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
