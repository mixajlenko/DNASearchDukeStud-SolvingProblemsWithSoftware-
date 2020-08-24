import org.junit.Assert;
import org.junit.Test;

public class Part3Test {
    Part3 part3 = new Part3();
    String stringb = "this world is to small for world in your mind";

    @Test
    public void testTwoOccurrences() throws Exception {
        boolean result = part3.twoOccurrences("o", stringb);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testLastPart() throws Exception {
        String result = part3.lastPart("small", stringb);
        Assert.assertEquals(" for world in your mind", result);
    }
}