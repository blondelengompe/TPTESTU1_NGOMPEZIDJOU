package com.stjean.operation.operation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestOperationMathematique {

    @Test
    public void testEstPositif() {
        OperationMathematique op = new OperationMathematique();
        assertTrue(op.estPositif(5));
        assertFalse(op.estPositif(-3));
    }

    @Test
    public void testFactoriel() {
        OperationMathematique op = new OperationMathematique();
        assertEquals(120, op.factoriel(5));
        assertThrows(IllegalArgumentException.class, () -> op.factoriel(-1));
    }
}
