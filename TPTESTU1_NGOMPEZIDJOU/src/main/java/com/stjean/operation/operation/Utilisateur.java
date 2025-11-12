package com.stjean.operation.operation;

import java.util.ArrayList;

public class Utilisateur {

    private int id;
    private String nom;
    private int age;
    private String email;
    private String telephone;
    private String ville;
    private double soldePersonnel;

    // Liste statique de tous les utilisateurs
    public static ArrayList<Utilisateur> users = new ArrayList<>();

    public Utilisateur(int id, String nom, int age, String email, String telephone, String ville, double solde) {
        this.id = id;
        this.nom = nom;
        this.age = age;
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
        this.soldePersonnel = solde;
    }

    // Getters et Setters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
    public String getVille() { return ville; }
    public double getSoldePersonnel() { return soldePersonnel; }

    public void setNom(String nom) { this.nom = nom; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setVille(String ville) { this.ville = ville; }
    public void setSoldePersonnel(double soldePersonnel) { this.soldePersonnel = soldePersonnel; }

    // Ajouter un utilisateur avec validation de l'email
    public void ajouter(Utilisateur u) {
        if (!u.email.contains("@")) {
            throw new EmailInvalidException("Email invalide");
        }
        users.add(u);
    }

    // Supprimer un utilisateur par ID
    public void supprimer(int id) {
        boolean removed = users.removeIf(u -> u.id == id);
        if (!removed) throw new SuppressionInvalidException("Utilisateur inexistant");
    }

    // Lister tous les utilisateurs
    public ArrayList<Utilisateur> lister() {
        return new ArrayList<>(users);
    }

    // Afficher un utilisateur par ID
    public Utilisateur afficher(int id) {
        return users.stream()
                    .filter(u -> u.id == id)
                    .findFirst()
                    .orElse(null);
    }

    // Analyse du solde général
    public double analyseSoldeGeneral() {
        double total = users.stream().mapToDouble(u -> u.soldePersonnel).sum();
        if (total < 0) throw new NegativeGeneralBalanceException("Solde général négatif");
        return total;
    }

    // Retourne l’utilisateur le plus riche
    public Utilisateur utilisateurPlusRiche() {
        return users.stream()
                    .max((u1, u2) -> Double.compare(u1.soldePersonnel, u2.soldePersonnel))
                    .orElse(null);
    }
}
