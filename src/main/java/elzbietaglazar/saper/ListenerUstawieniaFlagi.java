package elzbietaglazar.saper;

/**
 * Interfejs nasłuchujący na wydarzenie ustawienia lub zdjęcia flagi.
 * @author Elżbieta Glazar
 */
public interface ListenerUstawieniaFlagi
{
    /**
     * Metoda wywyływana w momencie ustawienia lub zdjęcia flagi. Ustawienie flagi zmniejsza liczbę min, natomiast
     * zdjęcie flagi zwiększa tę liczbę. Użytkownik może ustawić flagę na każdym polu planszy, co będzie skutkowało
     * tym, że aktualna liczba min będzie mniejsza od zera.
     * @param aktualnaLiczbaMin aktualna liczba min jest równa liczbie min z poziomu trudności minus liczba ustawionych
     *                          flag
     */
    void zmianaLiczbyMin(int aktualnaLiczbaMin);
}
