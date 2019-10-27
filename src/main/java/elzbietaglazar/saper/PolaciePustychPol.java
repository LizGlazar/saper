package elzbietaglazar.saper;
import static elzbietaglazar.saper.FunkcjePomocnicze.*;
public class PolaciePustychPol
{
    public void odslonPustePolaIBrzeg(int x, int y, PrzyciskPlanszy[][] tablicaPrzyciskow, String[][] punktacja, int szerokoscPlanszy, int wysokoscPlanszy)
    {
        String biezacaPunktacja = punktacja[x][y];
        PrzyciskPlanszy przyciskPlanszy = tablicaPrzyciskow[x][y];//TODO ewentualnie wrzucic punktacje do przycisku
        if (biezacaPunktacja.equals("0") && przyciskPlanszy.isEnabled())
        {
            przyciskPlanszy.setEnabled(false);
            przyciskPlanszy.setText(biezacaPunktacja);

            if (czyIstniejeLewyGornySasiad(x, y))
            {
                if (czySasiadJestPustymPolem(x - 1, y - 1, punktacja))
                {
                    odslonPustePolaIBrzeg(x - 1, y - 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
                }
                else
                {
                    PrzyciskPlanszy brzeg = tablicaPrzyciskow[x - 1][y - 1];
                    brzeg.setEnabled(false);
                    String tekstBrzegu = punktacja[x - 1][y - 1];
                    brzeg.setText(tekstBrzegu);
                }
            }
            if (czyIstniejeGornySasiad(y))
            {
                if (czySasiadJestPustymPolem(x, y - 1, punktacja))
                {
                    odslonPustePolaIBrzeg(x, y - 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
                }
                else
                {
                    PrzyciskPlanszy brzeg = tablicaPrzyciskow[x][y - 1];
                    brzeg.setEnabled(false);
                    String tekstBrzegu = punktacja[x][y - 1];
                    brzeg.setText(tekstBrzegu);
                }
            }
            if (czyIstniejePrawyGornySasiad(x, y, szerokoscPlanszy))
            {
                if (czySasiadJestPustymPolem(x + 1, y - 1, punktacja))
                {
                    odslonPustePolaIBrzeg( x + 1, y - 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
                }
                else
                {
                    PrzyciskPlanszy brzeg = tablicaPrzyciskow[x + 1][y - 1];
                    brzeg.setEnabled(false);
                    String tekstBrzegu = punktacja[x + 1][y - 1];
                    brzeg.setText(tekstBrzegu);
                }
            }
            if (czyIstniejeLewySasiad(x))
            {
                if (czySasiadJestPustymPolem(x - 1, y, punktacja))
                {
                    odslonPustePolaIBrzeg(x - 1, y, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
                }
                else
                {
                    PrzyciskPlanszy brzeg = tablicaPrzyciskow[x - 1][y];
                    brzeg.setEnabled(false);
                    String tekstBrzegu = punktacja[x - 1][y];
                    brzeg.setText(tekstBrzegu);
                }
            }
            if (czyIstniejePrawySasiad(x, szerokoscPlanszy))
            {
                if (czySasiadJestPustymPolem(x + 1, y, punktacja))
                {
                    odslonPustePolaIBrzeg(x + 1, y, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
                }
                else
                {
                    PrzyciskPlanszy brzeg = tablicaPrzyciskow[x + 1][y];
                    brzeg.setEnabled(false);
                    String tekstBrzegu = punktacja[x + 1][y];
                    brzeg.setText(tekstBrzegu);
                }
            }
            if (czyIstniejeLewyDolnySasiad(x, y, wysokoscPlanszy))
            {
                if (czySasiadJestPustymPolem(x - 1, y + 1, punktacja))
                {
                    odslonPustePolaIBrzeg(x - 1, y + 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
                }
                else
                {
                    PrzyciskPlanszy brzeg = tablicaPrzyciskow[x - 1][y + 1];
                    brzeg.setEnabled(false);
                    String tekstBrzegu = punktacja[x - 1][y + 1];
                    brzeg.setText(tekstBrzegu);
                }
            }
            if (czyIstniejeDolnySasiad(y, wysokoscPlanszy))
            {
                if (czySasiadJestPustymPolem(x, y + 1, punktacja))
                {
                    odslonPustePolaIBrzeg(x, y + 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
                }
                else
                {
                    PrzyciskPlanszy brzeg = tablicaPrzyciskow[x][y + 1];
                    brzeg.setEnabled(false);
                    String tekstBrzegu = punktacja[x][y + 1];
                    brzeg.setText(tekstBrzegu);
                }
            }
            if (czyIstniejePrawyDolnySasiad(x, y, szerokoscPlanszy, wysokoscPlanszy))
            {
                if (czySasiadJestPustymPolem(x + 1, y + 1, punktacja))
                {
                    odslonPustePolaIBrzeg(x + 1, y + 1, tablicaPrzyciskow, punktacja, szerokoscPlanszy, wysokoscPlanszy);
                }
                else
                {
                    PrzyciskPlanszy brzeg = tablicaPrzyciskow[x + 1][y + 1];
                    brzeg.setEnabled(false);
                    String tekstBrzegu = punktacja[x + 1][y + 1];
                    brzeg.setText(tekstBrzegu);
                }
            }
        }
    }

    private boolean czySasiadJestPustymPolem(int x, int y, String[][] punktacja)
    {
        String biezacePole = punktacja[x][y];
        return biezacePole.equals("0");
    }
}
