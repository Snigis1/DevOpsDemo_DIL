package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MathLibTest {

    @Test
    public void testIsEven () {
        boolean result = MathLib.isEven(8);
        assertTrue(result);
    }
    
}
