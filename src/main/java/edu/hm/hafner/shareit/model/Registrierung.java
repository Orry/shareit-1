package edu.hm.hafner.shareit.model;

/**
 * Enthält alle relevanten Daten für einen neuen Benutzer von ShareIt. Ein Benutzer kann im System eindeutig über seine
 * EMail identifiziert werden, diese Email wird gleichzeitig als Benutzername verwendet.
 *
 * @author Ulli Hafner
 */
public class Registrierung {
    private final String email;
    private final String vorname;
    private final String nachname;
    private final String passwort;

    /**
     * Erzeugt eine neue {@link Registrierung}.
     *
     * @param email
     *            Email Adresse des Benutzers
     * @param vorname
     *            Vorname des Benutzers
     * @param nachname
     *            Nachname des Benutzers
     * @param passwort
     *            Passwort des Benutzers
     */
    public Registrierung(final String email, final String vorname, final String nachname, final String passwort) {
        this.email = email;
        this.vorname = vorname;
        this.nachname = nachname;
        this.passwort = passwort;
    }

    /**
     * Liefert den Nachnamen zurück.
     *
     * @return der Nachname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Liefert den Vornamen zurück.
     *
     * @return der Vorname
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Liefert die EMail zurück.
     *
     * @return die EMail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Liefert das Passwort zurück.
     *
     * @return das Passwort
     */
    public String getPasswort() {
        return passwort;
    }
}
