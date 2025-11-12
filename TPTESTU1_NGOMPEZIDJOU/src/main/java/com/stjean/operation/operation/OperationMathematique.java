package com.stjean.operation.operation;

public class OperationMathematique {
public boolean estPositif(int nombre) {
    return nombre > 0;
}

public int factoriel(int nombre) {
    if (nombre < 0) {
        throw new IllegalArgumentException("Le nombre doit être positif ou nul");
    }
    int fact = 1;
    for (int i = 1; i <= nombre; i++) {
        fact *= i;
    }
    return fact;
}

}
