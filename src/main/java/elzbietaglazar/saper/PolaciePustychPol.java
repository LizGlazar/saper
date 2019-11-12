package elzbietaglazar.saper;

import static elzbietaglazar.saper.FunkcjePomocnicze.*;

/**
 * Klasa implementująca logikę odsłaniania połaci pustych pól. Gdy użytkownik kliknie na puste pole, odsłaniane są
 * wszystkie sąsiadujące puste pola oraz najbliższe niepuste pola sąsiadujące z połacią (brzeg).
 * @author Elżbieta Glazar
 */
public class PolaciePustychPol
{
    /**
     * Metoda odsłania kliknięte pole, wszystkie puste pola sąsiadujące z danym polem oraz brzeg.
     * @param x współrzędna x pola
     * @param y współrzędna y pola
     * @param tablicaPrzyciskow dwuwymiarowa tablica przycisków planszy
     * @param punktacja dwuwymiarowa tablica punktacji
     * @param szerokoscPlanszy szerokość planszy
     * @param wysokoscPlanszy wysokość planszy
     * @return metoda zwraca liczbę odsłoniętych pól
     * @see PrzyciskPlanszy
     */
    public int odslonPustePolaIBrzeg(int x, int y, PrzyciskPlanszy[][] tablicaPrzyciskow, String[][] punktacja, int szerokoscPlanszy, int wysokoscPlanszy)
    {
        String biezacaPunktacja = punktacja[x][y];
        PrzyciskPlanszy przyciskPlanszy = tablicaPrzyciskow[x][y];
        if (biezacaPunktacja.equals("0") && przyciskPlanszy.isEnabled())
        {
            int licznikOdslonietychPol = 0;
            przyciskPlanszy.odslon();
            licznikOdslonietychPol++;

            if (czyIstniejeLewyGornySasiad(x, y))
            {
                licznikOdslonietychPol += analizujSasiada(x - 1, y - 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
            }
            if (czyIstniejeGornySasiad(y))
            {
                licznikOdslonietychPol += analizujSasiada(x, y - 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
            }
            if (czyIstniejePrawyGornySasiad(x, y, szerokoscPlanszy))
            {
                licznikOdslonietychPol += analizujSasiada(x + 1, y - 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
            }
            if (czyIstniejeLewySasiad(x))
            {
                licznikOdslonietychPol += analizujSasiada(x - 1, y, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
            }
            if (czyIstniejePrawySasiad(x, szerokoscPlanszy))
            {
                licznikOdslonietychPol += analizujSasiada(x + 1, y, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
            }
            if (czyIstniejeLewyDolnySasiad(x, y, wysokoscPlanszy))
            {
                licznikOdslonietychPol += analizujSasiada(x - 1, y + 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
            }
            if (czyIstniejeDolnySasiad(y, wysokoscPlanszy))
            {
                licznikOdslonietychPol += analizujSasiada(x, y + 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
            }
            if (czyIstniejePrawyDolnySasiad(x, y, szerokoscPlanszy, wysokoscPlanszy))
            {
                licznikOdslonietychPol += analizujSasiada(x + 1, y + 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
            }

            return licznikOdslonietychPol;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Metoda sprawdza, czy pole opisane współrzędnymi x, y jest puste.
     * @param x współrzędna x pola
     * @param y współrzędna y pola
     * @param punktacja dwuwymiarowa tablica z punktacją
     * @return metoda zwraca true, jeżeli dane pole jest puste
     */
    private boolean czySasiadJestPustymPolem(int x, int y, String[][] punktacja)
    {
        String biezacePole = punktacja[x][y];
        return biezacePole.equals("0");
    }

    /**
     * Metoda przetwarza pole opisane współrzędnymi x, y. Jeżeli pole jest puste, następuje rekurencyjne przetworzenie
     * tego pola; jeżeli pole jest niepuste, oznacza to, że jest brzegiem, więc zostaje tylko odsłonięte.
     * @param x współrzędna x pola
     * @param y współrzędna y pola
     * @param tablicaPrzyciskow dwuwymiarowa tablica przycisków
     * @param punktacja dwuwymiarowa tablica z punktacją
     * @param szerokoscPlanszy szerokość planszy
     * @param wysokoscPlanszy wysokość planszy
     * @return metoda zwraca liczbę odsłoniętych pól
     */
    private int analizujSasiada(int x, int y, PrzyciskPlanszy[][] tablicaPrzyciskow, String[][] punktacja, int szerokoscPlanszy, int wysokoscPlanszy)
    {
        if (czySasiadJestPustymPolem(x, y, punktacja))
        {
            return odslonPustePolaIBrzeg(x, y, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
        }
        else
        {
            PrzyciskPlanszy brzeg = tablicaPrzyciskow[x][y];
            if (brzeg.isEnabled())
            {
                brzeg.odslon();
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }

}
