package com.stjean.operation.operation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOperationMathematique {

    private OperationMathematique op;

    @BeforeEach
    void setUp() {
        op = new OperationMathematique();
    }

    @Test
    void testEstPositif() {
        assertTrue(op.estPositif(5));
        assertFalse(op.estPositif(0));
        assertFalse(op.estPositif(-3));
    }

    @Test
    void testFactoriel() {
        assertEquals(1, op.factoriel(0));
        assertEquals(1, op.factoriel(1));
        assertEquals(120, op.factoriel(5));
    }

    @Test
    void testFactorielNegatif() {
        // Vérifie que la méthode lance bien IllegalParamISIException pour un nombre négatif
        assertThrows(IllegalParamISIException.class, () -> op.factoriel(-1));
    }

    @Test
    void testTrier() {
        int[] tableau = {3, 1, 4, 2};
        int[] attendu = {4, 3, 2, 1};
        assertArrayEquals(attendu, op.trier(tableau));
    }

    @Test
    void testMaxNumba() {
        double[] valeurs = {2.5, 7.1, 4.0};
        assertEquals(7.1, op.maxNumba(valeurs));
    }

    @Test
    void testMaxNumbaTableauVide() {
        assertThrows(IllegalArgumentException.class, () -> op.maxNumba(new double[0]));
    }
}
