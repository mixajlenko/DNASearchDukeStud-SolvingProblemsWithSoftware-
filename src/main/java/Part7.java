import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part7 {
    /**
     * method named countGenes that has a String parameter named dna representing a string of DNA. This method returns
     * the number of genes found in dna. For example the call countGenes(“ATGTAAGATGCCCTAGT”) returns 2, finding the
     * gene ATGTAA first and then the gene ATGCCCTAG. Hint: This is very similar to finding all genes and printing them,
     * except that instead of printing all the genes you will count them.
     */
    public int countGenes(String dna) {
        int startIndex = 0, counter = 0;

        while (true) {
            String currentGene = Part5.findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            counter++;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return counter;
    }

    public String readGeneFile(String filename) {
        String dna = "";
        try {
            File dnaFile = new File("src\\main\\resources\\" + filename + ".txt");
            Scanner reader = new Scanner(dnaFile);
            while (reader.hasNextLine()) {
                dna = reader.nextLine();
            }
        } catch (FileNotFoundException io) {
            System.out.println("file not found");
        }
        return dna;
    }
    //    public void printAllGene(String dna) {
//        int startIndex = 0;
//        int geneCounter = 0;
//        System.out.println("Genes in this DNA sequence is: ");
//        while (true) {
//            String currentGene = Part5.findGene(dna, startIndex);
//
//            if (currentGene.isEmpty()) {
//                break;
//            }
//            geneCounter++;
//            System.out.println(geneCounter + ": " + currentGene);
//            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
//        }
//    }
}
