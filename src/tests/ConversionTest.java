package tests;

import codewars.kyu4.RomanEncoder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConversionTest {


    @Test
    public void shouldCovertToRoman() {
        assertEquals("solution(1) should equal to I", "I", RomanEncoder.solution(1));
        assertEquals("solution(4) should equal to IV", "IV", RomanEncoder.solution(4));
        assertEquals("solution(6) should equal to VI", "VI", RomanEncoder.solution(6));
    }
}
