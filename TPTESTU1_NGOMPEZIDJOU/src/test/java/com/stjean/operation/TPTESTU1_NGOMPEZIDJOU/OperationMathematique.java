package com.stjean.operation.TPTESTU1_NGOMPEZIDJOU;

import java.util.Arrays;

public class OperationMathematique {

    public boolean estPositif(int nombre) {
        return nombre > 0;
    }

    public int factoriel(int nombre) {
        if (nombre < 0) {
            throw new IllegalArgumentException("Le factoriel d'un nombre négatif n'existe pas");
        }
        int fact = 1;
        for (int i = 1; i <= nombre; i++) {
            fact *= i;
        }
        return fact;
    }

    // Méthode pour trier un tableau d'entiers en ordre décroissant
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

    // Méthode pour trouver le maximum d'un tableau de doubles
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
