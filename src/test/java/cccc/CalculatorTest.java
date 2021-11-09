package cccc;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calc() {
        Calculator calculator = new Calculator();

        int rr = calculator.calcSum("numbers.txt");
        assertEquals(10, rr);

        int rMul = calculator.calcMultiply("numbers.txt");
        assertEquals(24, rMul);
    }
}