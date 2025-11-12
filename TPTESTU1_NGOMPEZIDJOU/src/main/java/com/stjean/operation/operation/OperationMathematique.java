package com.stjean.operation.operation;

import java.util.Arrays;

public class OperationMathematique {

    // Vérifie si un nombre est positif
    public boolean estPositif(int nombre) {
        return nombre > 0;
    }

    // Calcule le factoriel d'un nombre, lève IllegalParamISIException si négatif
    public int factoriel(int nombre) {
        if (nombre < 0) {
            throw new IllegalParamISIException("Factoriel d'un nombre négatif impossible");
        }
        int fact = 1;
        for (int i = 1; i <= nombre; i++) {
            fact *= i;
        }
        return fact;
    }

    // Trie un tableau d'entiers en ordre décroissant
    public int[] trier(int[] liste) {
        int[] copie = Arrays.copyOf(liste, liste.length);
        Arrays.sort(copie);
        for (int i = 0; i < copie.length / 2; i++) {
            int temp = copie[i];
            copie[i] = copie[copie.length - 1 - i];
            copie[copie.length - 1 - i] = temp;
        }
        return copie;
    }

    // Retourne le maximum d'un tableau de doubles
    public double maxNumba(double[] valeurs) {
        if (valeurs == null || valeurs.length == 0) {
            throw new IllegalArgumentException("Le tableau est vide ou null");
        }
        double max = valeurs[0];
        for (double v : valeurs) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }
}
