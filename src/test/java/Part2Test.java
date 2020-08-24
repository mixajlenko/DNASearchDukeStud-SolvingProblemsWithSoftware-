import org.junit.Assert;
import org.junit.Test;

public class Part2Test {
    Part2 part2 = new Part2();

    @Test
    public void testStringsFirstAssignments() throws Exception {
        String result = part2.StringsFirstAssignments("TRYTRUYRATGFHGYRTUJHKJIMNJBHFTAATWRGWT", "ATG", "TAA");
        Assert.assertEquals("ATGFHGYRTUJHKJIMNJBHFTAA", result.toUpperCase());
    }
}