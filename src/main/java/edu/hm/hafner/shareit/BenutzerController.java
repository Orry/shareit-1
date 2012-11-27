package edu.hm.hafner.shareit;

import java.util.Collection;

/**
 * Erzeugt, findet und �ndert Registrierungen.
 *
 * @author Ulli Hafner
 */
public interface BenutzerController {
    /**
     * Liefert alle Benutzer mit der �bergebenen EMail zur�ck.
     *
     * @param email
     *            die EMail Addresse
     * @return die Benutzer
     */
    Collection<Benutzer> findByEmail(String email);
}
