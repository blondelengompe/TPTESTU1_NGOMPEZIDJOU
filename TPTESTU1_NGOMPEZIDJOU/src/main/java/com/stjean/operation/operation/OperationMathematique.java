package com.stjean.operation.operation;

import java.util.Arrays;

public class OperationMathematique {

    public boolean estPositif(int nombre) {
        return nombre > 0;
    }

    // Ici on remplace l'ancienne factoriel
    public int factoriel(int nombre) {
        if(nombre < 0) throw new IllegalParamISIException("Factoriel d'un nombre négatif impossible");
        int fact = 1;
        for (int i = 1; i <= nombre; i++) {
            fact *= i;
        }
        return fact;
    }

    public int[] trier(int[] liste) {
        Arrays.sort(liste); // trie croissant
        int n = liste.length;
        int[] resultat = new int[n];
        for (int i = 0; i < n; i++) {
            resultat[i] = liste[n - 1 - i]; // inverse pour décroissant
        }
        return resultat;
    }

    public double maxNumba(double[] valeurs) {
        if (valeurs == null || valeurs.length == 0) {
            throw new IllegalArgumentException("Le tableau ne peut pas être vide");
        }
        double max = valeurs[0];
        for (double val : valeurs) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }
}
