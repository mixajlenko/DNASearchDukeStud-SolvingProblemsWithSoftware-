import org.junit.Assert;
import org.junit.Test;

public class Part4Test {
    Part4 part4 = new Part4();

    @Test
    public void testUrlParse() throws Exception {
        Assert.assertTrue(part4.urlParse("https://www.dukelearntoprogram.com/course2/data/manylinks.html",
                "youtube.com"));
    }

}