package edu.hm.hafner.shareit;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import edu.hm.hafner.shareit.model.Registrierung;
import edu.hm.hafner.shareit.util.AbstractDatabaseTest;

/**
 * Testet die Klasse {@link BenutzerRegistrierungUsecaseControllerImpl}.
 *
 * @author Ulli Hafner
 */
public class BenutzerRegistrierungUsecaseControllerImplTest extends AbstractDatabaseTest {
    private static final String TEST_PASSWORT = "geheim";
    private static final String TEST_EMAIL = "hafner@hm.edu";
    private static final String TEST_NACHNAME = "Hafner";
    private static final String TEST_VORNAME = "Ullrich";

    /**
     * Zeigt, dass die Neuanlage einer Registrierung funktioniert.
     */
    @Test
    public void testeAnlegenEinerRegistrierung() {
        BenutzerRegistrierungUsecaseController verwaltung = new BenutzerRegistrierungUsecaseControllerImpl();
        pruefeErwarteteAnzahlRegistrierungen(verwaltung, 0);

        verwaltung.registriereBenutzer(TEST_EMAIL, TEST_VORNAME, TEST_NACHNAME, TEST_PASSWORT);
        pruefeErwarteteAnzahlRegistrierungen(verwaltung, 1);
        pruefeInhaltRegistrierung(verwaltung);
    }

    private void pruefeInhaltRegistrierung(final BenutzerRegistrierungUsecaseController verwaltung) {
        Registrierung benutzer = verwaltung.findeRegistrierung(TEST_EMAIL);

        assertEquals("Falscher Vorname", TEST_VORNAME, benutzer.getVorname());
        assertEquals("Falscher Nachname", TEST_NACHNAME, benutzer.getNachname());
        assertEquals("Falsche EMail", TEST_EMAIL, benutzer.getEmail());
        assertEquals("Falsches Passwort", TEST_PASSWORT, benutzer.getPasswort());
    }

    private void pruefeErwarteteAnzahlRegistrierungen(final BenutzerRegistrierungUsecaseController verwaltung, final int expectedNumber) {
        assertEquals("Falsche Anzahl registierte Benutzer", expectedNumber, verwaltung.findeAlleRegistrierungen().size());
    }

    /**
     * Zeigt, dass die Neuanlage einer Registrierung fehlschlägt, wenn der Benutzername bereits existiert.
     */
    @Test(expected = IllegalStateException.class)
    public void testeDoppeltenBenutzernamen() {
        BenutzerRegistrierungUsecaseController verwaltung = new BenutzerRegistrierungUsecaseControllerImpl();

        verwaltung.registriereBenutzer(TEST_EMAIL, TEST_VORNAME, TEST_NACHNAME, TEST_PASSWORT);
        String gleicheEmail = TEST_EMAIL;
        verwaltung.registriereBenutzer(gleicheEmail, "Neuer Vorname", "Neuer Nachname", "Neues Passwort");
    }

    /**
     * Zeigt, dass eine Exception geworfen wird, falls eine Registrierung mit einem Nutzernamen nicht existiert.
     */
    @Test(expected = NoSuchElementException.class)
    public void testeEmailNichtGefunden() {
        BenutzerRegistrierungUsecaseController verwaltung = new BenutzerRegistrierungUsecaseControllerImpl();

        verwaltung.registriereBenutzer(TEST_EMAIL, TEST_VORNAME, TEST_NACHNAME, TEST_PASSWORT);
        verwaltung.findeRegistrierung("unkekannte@email");
    }
}

