package elzbietaglazar.saper;
import static elzbietaglazar.saper.FunkcjePomocnicze.*;
public class PolaciePustychPol
{
    public int odslonPustePolaIBrzeg(int x, int y, PrzyciskPlanszy[][] tablicaPrzyciskow, String[][] punktacja, int szerokoscPlanszy, int wysokoscPlanszy)
    {
        String biezacaPunktacja = punktacja[x][y];
        PrzyciskPlanszy przyciskPlanszy = tablicaPrzyciskow[x][y];//TODO ewentualnie wrzucic punktacje do przycisku
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

    private boolean czySasiadJestPustymPolem(int x, int y, String[][] punktacja)
    {
        String biezacePole = punktacja[x][y];
        return biezacePole.equals("0");
    }

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
