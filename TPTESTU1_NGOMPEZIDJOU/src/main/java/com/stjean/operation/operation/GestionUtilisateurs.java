package com.stjean.operation.operation;

import java.util.ArrayList;
import java.util.List;

public class GestionUtilisateurs {
    public static List<Utilisateur> users = new ArrayList<>();

    public static void ajouter(Utilisateur user) throws EmailInvalidException {
        if (!user.getNom().contains("@")) { // validation simple email
            throw new EmailInvalidException("Email invalide pour : " + user.getNom());
        }
        users.add(user);
    }

    public static void supprimer(int id) throws SuppressionInvalidException {
        boolean removed = users.removeIf(u -> u.getId() == id);
        if (!removed) throw new SuppressionInvalidException("Utilisateur introuvable : id " + id);
    }

    public static List<Utilisateur> lister() {
        return new ArrayList<>(users);
    }

    public static Utilisateur utilisateurLePlusRiche() {
        if (users.isEmpty()) return null;
        Utilisateur riche = users.get(0);
        for (Utilisateur u : users) {
            if (u.getSoldePersonnel() > riche.getSoldePersonnel()) riche = u;
        }
        return riche;
    }

    public static double analyseSoldeGeneral() throws NegativeGeneralBalanceException {
        double total = 0;
        for (Utilisateur u : users) total += u.getSoldePersonnel();
        if (total < 0) throw new NegativeGeneralBalanceException("Solde général négatif !");
        return total;
    }
}
