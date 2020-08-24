import org.junit.Assert;
import org.junit.Test;

public class Part1Test {
    Part1 part1 = new Part1();

    @Test
    public void testFindSimpleGene() throws Exception {
        String result = part1.findSimpleGene("TRYTRUYRATGFHGYRTUJHKJIMNJBHFTAATWRGWT");
        Assert.assertEquals("ATGFHGYRTUJHKJIMNJBHFTAA", result);
    }

}
