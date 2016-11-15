package net.tlalka.java.hackerrank.interview;

import org.junit.Assert;
import org.junit.Test;

public class StringsAnagramsTest {

    @Test
    public void testCheckAnagramsInTwoStrings() {

        // given
        String a = "cde";
        String b = "abc";

        // when:
        int result = StringsAnagrams.numberNeeded(a, b);

        // then
        Assert.assertEquals(4, result);
    }

    @Test
    public void testCheckAnagramsInSameString() {

        // given
        String a = "abcd";
        String b = "abcd";

        // when:
        int result = StringsAnagrams.numberNeeded(a, b);

        // then
        Assert.assertEquals(0, result);
    }
}
