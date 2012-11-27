package edu.hm.hafner.shareit;

import java.util.Collection;

/**
 * TODO: Document type BenutzerRegistrierungUsecaseController.
 */
public interface BenutzerRegistrierungUsecaseController {
    
    /**
     * Liefert alle bestehenden Registrierungen zur�ck.
     *
     * @return die Registrierungen
     */
    Collection<Registrierung> getRegistrierungen();
    
    /**
     * Registriert einen neuen Benutzer.
     *
     * @param vorname
     *            Vorname des Benutzers
     * @param nachname
     *            Nachname des Benutzers
     * @param email
     *            Email Adresse des Benutzers
     * @param passwort
     *            Passwort des Benutzers
     * @return der erzeugte Benutzer
     */
    Registrierung registriereBenutzer(String vorname, String nachname, String email, String passwort);
    
}