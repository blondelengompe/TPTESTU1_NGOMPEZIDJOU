package com.stjean.operation.operation;

import java.util.Arrays;

public class OperationMathematique {

    public boolean estPositif(int nombre) {
        return nombre > 0;
    }

    public int factoriel(int nombre) {
        if (nombre < 0) {
            throw new IllegalArgumentException("Factoriel d'un nombre négatif impossible");
        }
        int fact = 1;
        for (int i = 1; i <= nombre; i++) {
            fact *= i;
        }
        return fact;
    }

    // Nouvelle méthode pour trier un tableau d'entiers en ordre décroissant
    public int[] trier(int[] liste) {
        Arrays.sort(liste);               // Trie en ordre croissant
        int n = liste.length;
        int[] resultat = new int[n];
        for (int i = 0; i < n; i++) {
            resultat[i] = liste[n - 1 - i]; // Inverse pour décroissant
        }
        return resultat;
    }
}
