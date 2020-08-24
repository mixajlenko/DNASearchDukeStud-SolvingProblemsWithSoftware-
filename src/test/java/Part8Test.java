import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class Part8Test {
    Part8 part8 = new Part8();

    public ArrayList<String> testFindGene() throws IOException {
        URL url = new URL("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
        ArrayList<String> genes = null;
        BufferedReader read = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String i;
        while ((i = read.readLine()) != null) {
            genes = part8.getAllGene(i);
            part8.processGenes(part8.getAllGene(i));
        }
        read.close();
        String dnaTest = "CATGTAATAGATGAATGACTGATAGATATGCTGCTGCTGCTTGTATGCTATGAAAATGTGAAATGACCCA";

        System.out.println("\nNumber of CTG codon in DNA: " + part8.countCTG(dnaTest) + " (I'm works too!)");
        return genes;
    }

    String dnaTest = "CATGTAATAGATGAATGACTGATAGATATGCTGCTGCTGCTTGTATGCTATGAAAATGTGAAATGACCCA";

    @Test
    public void testGetAllGene() {
        ArrayList<String> result = part8.getAllGene(dnaTest);
        Assert.assertEquals(new ArrayList<String>(Arrays.asList("ATGTAA",
                "ATGAATGACTGA",
                "ATGCTGCTGCTGCTTGTATGCTATGAAAATGTGAAATGA")), result);
        Assert.assertEquals(3, part8.getAllGene(dnaTest).size());
    }

    @Test
    public void testCgRatio() {
        float result = part8.cgRatio(dnaTest);
        Assert.assertEquals(0.37142857909202576, result, 0);
    }

    @Test
    public void testCountCTG() {
        int result = part8.countCTG(dnaTest);
        Assert.assertEquals(4, result);
    }

    @Test
    public void testProcessGenes() throws IOException {

        Assert.assertEquals(69, testFindGene().size());
        Assert.assertEquals(61, part8.counterIfH9);
        Assert.assertEquals(40, part8.counterIfRatioH35);
        Assert.assertEquals(45, part8.currentLongestString.length());
    }
}
