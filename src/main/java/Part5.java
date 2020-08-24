public class Part5 {
    /**
     * method findGene that has one String parameter dna, representing a string of DNA. In this method you should do
     * the following:
     * =================================================================================================================
     * Find the index of the first occurrence of the start codon “ATG”. If there is no “ATG”, return the empty string.
     * =================================================================================================================
     * Find the index of the first occurrence of the stop codon “TAA” after the first occurrence of “ATG” that is a
     * multiple of three away from the “ATG”. Hint: call findStopCodon.
     * =================================================================================================================
     * Find the index of the first occurrence of the stop codon “TAG” after the first occurrence of “ATG” that is a
     * multiple of three away from the “ATG”. Find the index of the first occurrence of the stop codon “TGA” after the
     * first occurrence of “ATG” that is a multiple of three away from the “ATG”.
     * =================================================================================================================
     * Return the gene formed from the “ATG” and the closest stop codon that is a multiple of three away. If there is
     * no valid stop codon and therefore no gene, return the empty string.
     */
    public static String findGene(String dna, int where) {
        int startCodon = dna.indexOf("ATG", where);

        if (startCodon == -1) {
            return "";
        }

        int taa = findStopCodon(dna, startCodon, "TAA");
        int tga = findStopCodon(dna, startCodon, "TGA");
        int tag = findStopCodon(dna, startCodon, "TAG");

        int temp = Math.min(taa, tag);
        int minIndex = Math.min(temp, tga);

        if (minIndex == dna.length()) {
            return "";
        } else {
            return dna.substring(startCodon, minIndex + 3);
        }
    }
    /**
     * Method findStopCodon that has three parameters, a String parameter named dnaStr, an integer parameter named
     * startIndex that represents where the first occurrence of ATG occurs in dna, and a String parameter named
     * stopIndex. This method returns the index of the first occurrence of stopCodon that appears past startIndex and
     * is a multiple of 3 away from startIndex. If there is no such stopCodon, this method returns the length of the
     * dna strand.
     */
    public static int findStopCodon(String dnaStr, int startIndex, String stopIndex) {

        int currIndex = dnaStr.indexOf(stopIndex, startIndex + 3);

        while (currIndex != -1) {
            int diff = currIndex - startIndex;

            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dnaStr.indexOf(stopIndex, currIndex + 3);
            }
        }
        return dnaStr.length();
    }
    /**
     * The void method printAllGenes that has one String parameter dna, representing a string of DNA. In this
     * method you should repeatedly find genes and print each one until there are no more genes.
     */
    public boolean printAllGene(String dna) {

        String newDna = dna.toUpperCase();

        int startIndex = 0;
        int geneCounter = 0;
        System.out.println("Genes in this DNA sequence is: ");
        while (true) {
            String currentGene = findGene(newDna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            geneCounter++;
            System.out.println(geneCounter + ": " + currentGene);
            startIndex = newDna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneCounter >= 1;
    }
}
