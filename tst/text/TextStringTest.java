package text;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TextStringTest {

    @Test
    public void testConcatString() throws Exception {
        final TextString inputValue1 = new TextString("Today ");
        final TextString inputValue2 = new TextString("is ");
        final TextString inputValue3 = new TextString("monday, ");
        final TextString inputValue4 = new TextString("the ");
        final TextString inputValue5 = new TextString("weather ");
        final TextString inputValue6 = new TextString("fine!");

        final TextString expectedValue = new TextString("Today is monday, the weather is fine!");

        final TextString actualValue1 = inputValue1.concatTextString(inputValue2.concatTextString(inputValue3));
        final TextString actualValue2 = inputValue4.concatTextString(inputValue5.concatTextString(inputValue2.concatTextString(inputValue6)));
        final TextString actualValue = actualValue1.concatTextString(actualValue2);

        assertEquals(expectedValue.contents(), actualValue.contents());

    }

    @Test
    public void testDivideToArrayString() throws Exception {


    }

    @Test
    public void testLowerCase() throws Exception {

    }

    @Test
    public void testUpperCase() throws Exception {

    }

    @Test
    public void testConcatTextString() throws Exception {

    }

    @Test
    public void testTextFromTo() throws Exception {

        final TextString text = new TextString("Today is monday, the weather is fine!");
        final int from = 9;
        final int to = 14;
        final TextString expectedValue = new TextString("monday");
        final TextString actualValue = text.textFromTo(from, to);

        assertEquals(expectedValue.contents(), actualValue.contents());

    }

    @Test
    public void testItemByIndex() throws Exception {

    }

    @Test
    public void testReverseText() throws Exception {

    }

    @Test
    public void testIsPalindrome() throws Exception {

    }

    @Test
    public void testFindCharFirstPlace() throws Exception {

    }

    @Test
    public void testFindChar() throws Exception {

    }

    @Test
    public void testFindTextFirstPlace() throws Exception {

    }

    @Test
    public void testFindTextFirstPlace1() throws Exception {

    }

    @Test
    public void testFindText() throws Exception {

    }

    @Test
    public void testContents() throws Exception {

    }
}