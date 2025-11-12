package com.stjean.operation.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TestGestionUtilisateurs {

    @Test
    public void testUtilisateurLePlusRiche() throws Exception {
        GestionUtilisateurs.users.clear();
        GestionUtilisateurs.users.add(new Utilisateur(1,"Alice",30,"alice@example.com","000","Paris",1000));
        GestionUtilisateurs.users.add(new Utilisateur(2,"Bob",25,"bob@example.com","111","Lyon",2000));
        Utilisateur riche = GestionUtilisateurs.utilisateurLePlusRiche();
        assertEquals("Bob", riche.getNom());
    }

    @Test
    public void testAnalyseSoldeGeneral() throws Exception {
        GestionUtilisateurs.users.clear();
        GestionUtilisateurs.users.add(new Utilisateur(1,"Alice",30,"alice@example.com","000","Paris",1000));
        GestionUtilisateurs.users.add(new Utilisateur(2,"Bob",25,"bob@example.com","111","Lyon",2000));
        double total = GestionUtilisateurs.analyseSoldeGeneral();
        assertEquals(3000, total);
    }

    @Test
    public void testAnalyseSoldeGeneralNegatif() {
        GestionUtilisateurs.users.clear();
        GestionUtilisateurs.users.add(new Utilisateur(1,"Alice",30,"alice@example.com","000","Paris",-500));
        GestionUtilisateurs.users.add(new Utilisateur(2,"Bob",25,"bob@example.com","111","Lyon",-600));
        assertThrows(NegativeGeneralBalanceException.class, () -> {
            GestionUtilisateurs.analyseSoldeGeneral();
        });
    }
}
