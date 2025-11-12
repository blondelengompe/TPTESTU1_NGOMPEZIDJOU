package com.stjean.operation.operation;

public class OperationMathematique {
    public boolean estPositif(int nombre) {
        return nombre > 0;
    }

    public int factoriel(int nombre) {
        int fact = 1;
        for (int i = 1; i <= nombre; i++) {
            fact *= i;
        }
        return fact;
    }

}
