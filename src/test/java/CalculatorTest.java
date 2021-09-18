import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest
{
    private StringCalculator stringCalculator;

    @BeforeEach
    public void init()
    {
        stringCalculator = new StringCalculator();
    }

    @Test
    void emptyString() throws Exception
    {
        assertEquals(stringCalculator.Add(""), 0);
    }

    @Test
    void oneNumberInString() throws Exception
    {
        assertEquals(stringCalculator.Add("1"), 1);
    }

    @Test
    void twoNumbersSum() throws Exception
    {
        assertEquals(stringCalculator.Add("1,2"), 3);
    }

    @Test
    void newLineDelimiter() throws Exception
    {
        assertEquals(stringCalculator.Add("1/n2"), 3);
    }

    @Test
    public void negativeNumbersException()
    {
        Assertions.assertThrows(Exception.class, () ->
        {
            stringCalculator.Add("-1");
        });

    }

    @Test
    public void multipleNegativeNumbersException()
    {
        Assertions.assertThrows(Exception.class, () ->
        {
            assertEquals(stringCalculator.Add("-1,-2"), "negatives not allowed:-1,-2");
        });

    }

    @Test
    void ignoreLargeNumbers() throws Exception
    {
        assertEquals(stringCalculator.Add("10,1001"), 10);
    }

    @Test
    void delimitersOfAnyLenght() throws Exception
    {
        assertEquals(stringCalculator.Add("//[***]/n1***1***2"), 3);
    }


}

