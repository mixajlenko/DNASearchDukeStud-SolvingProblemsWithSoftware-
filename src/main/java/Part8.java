import java.util.ArrayList;
import java.util.List;

public class Part8 {
    int counterIfH9 = 0;
    int counterIfRatioH35 = 0;
    String currentLongestString = "";
    /**
     * Make a copy of the printAllGenes method called getAllGenes. Instead of printing the genes found, this method
     * should create and return a StorageResource containing the genes found. Remember to import the edu.duke libraries
     * otherwise you will get an error message cannot find the class StorageResource.
     */
    public ArrayList<String> getAllGene(String dna) {
        ArrayList<String> genesList = new ArrayList<>();
        String newDna = dna.toUpperCase();

        int startIndex = 0;
        System.out.print("Genes in this DNA sequence is: ");
        while (true) {
            String currentGene = Part5.findGene(newDna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            genesList.add(currentGene);
            startIndex = newDna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        System.out.println(genesList.size());
        return genesList;
    }
    /**
     * method cgRatio that has one String parameter dna, and returns the ratio of C’s and G’s in dna as a fraction of
     * the entire strand of DNA. For example if the String were “ATGCCATAG,” then cgRatio would return 4/9 or .4444444.
     * <p>
     * Hint: 9/2 uses integer division because you are dividing an integer by an integer and thus Java thinks you want
     * the result to be an integer. If you want the result to be a decimal number, then make sure you convert one of
     * the integers to a decimal number by changing it to a float. For example, (float) 9/2 is interpreted by Java as
     * 9.0/2 and if one of the numbers is a decimal, then Java assumes you want the result to be a decimal number.
     * Thus (float) 9/2 is 4.5.
     */
    public float cgRatio(String dna) {
        int indexG = dna.indexOf("G");
        int indexC = dna.indexOf("C");
        float counderG = 0;
        float counderC = 0;
        while (indexG != -1 && indexG < dna.length()) {
            counderG++;
            indexG = dna.indexOf("G", indexG + 1);
        }
        while (indexC != -1 && indexC < dna.length()) {
            counderC++;
            indexC = dna.indexOf("C", indexC + 1);
        }
        return (counderC + counderG) / dna.length();
    }
    /**
     * method countCTG that has one String parameter dna, and returns the number of times the codon CTG appears in dna.
     */
    public int countCTG(String dna) {
        int counterCTG = 0;
        int index = dna.indexOf("CTG");

        while (index != -1) {
            counterCTG++;
            index = dna.indexOf("CTG", index + 3);
        }
        return counterCTG;
    }
    /**
     * the void method processGenes that has one parameter sr, which is a StorageResource of strings. This method
     * processes all the strings in sr to find out information about them. Specifically, it should:
     * <p>
     * print all the Strings in sr that are longer than 9 characters
     * print the number of Strings in sr that are longer than 9 characters
     * print the Strings in sr whose C-G-ratio is higher than 0.35
     * print the number of strings in sr whose C-G-ratio is higher than 0.35
     * print the length of the longest gene in sr
     */
    public void processGenes(List<String> sr) {
        List<String> newList = new ArrayList<>();
        System.out.println("\n\nDNA strings with more than 9 characters:\n");
        for (String s : sr) {
            if (s.length() > 9) {
                counterIfH9++;
                System.out.println(s);
                newList.add(s);
            }
        }

        System.out.println("\nDNA strings with more than 9 characters: " + counterIfH9);
        System.out.println("\n\nStrings in DNA whose C-G-ratio is higher than 0.35:\n");

        for (String s : sr) {
            if (cgRatio(s) > 0.35) {
                counterIfRatioH35++;
                System.out.println(s);
            }
        }
        System.out.println("\nStrings in DNA whose C-G-ratio is higher than 0.35: " + counterIfRatioH35);

        for (String s : sr) {
            currentLongestString = "";
            if (s.length() > 0)
                currentLongestString = s;
        }
        System.out.println("\nLongest gene in DNA is: " + currentLongestString.length() + " characters");
    }
}
