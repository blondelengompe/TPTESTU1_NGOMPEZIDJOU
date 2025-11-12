package com.stjean.operation.operation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestUtilisateur {

    @BeforeEach
    void clearUsers() {
        Utilisateur.users.clear(); // On vide la liste avant chaque test
    }

    @Test
    void testAjouterUtilisateurEmailValide() {
        Utilisateur u = new Utilisateur(1, "Bob", 20, "bob@mail.com", "000", "Ville", 100);
        u.ajouter(u);
        assertTrue(Utilisateur.users.contains(u));
    }

    @Test
    void testAjouterUtilisateurEmailInvalide() {
        Utilisateur u = new Utilisateur(2, "Alice", 25, "alice-mail.com", "111", "Ville", 100);
        assertThrows(EmailInvalidException.class, () -> u.ajouter(u));
    }

    @Test
    void testSupprimerUtilisateurInexistant() {
        assertThrows(SuppressionInvalidException.class, () -> {
            new Utilisateur(0, "x", 0, "x@x.com", "0", "x", 0).supprimer(999);
        });
    }
}
