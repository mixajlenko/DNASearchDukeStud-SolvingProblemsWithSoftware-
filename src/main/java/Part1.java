
/**
 * Write a description of class Part1 here.
 *
 * @author mixajlenko
 * @version 1.0
 */
public class Part1 {
    /**
     * "StringsFirstAssignments" method following:
     * <p>
     * Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string.
     * =================================================================================================================
     * Finds the index position of the first stop codon “TAA” appearing after the “ATG” that was found.
     * If there is no such “TAA”, return the empty string.
     * =================================================================================================================
     * If the length of the substring between the “ATG” and “TAA” is a multiple of 3,
     * then return the substring that starts with that “ATG” and ends with that “TAA”.
     * =================================================================================================================
     */
    public String findSimpleGene(String dna) {

        String result;  //Start with empty result string. We will put the result string later.
        String valid = "not valid";  //This string will print if DNA string is not valid (if is not multiple of 3).

        if (dna.contains("ATG") && dna.contains("TAA")) {

            int startPosition = dna.indexOf("ATG");  //ATG is a trigger which say to program when start the search.
            int stopPosition = dna.indexOf("TAA", startPosition + 3); //When will stop the search.

            if (startPosition == -1 || stopPosition == -1) {
                return "not find";
            }
            result = dna.substring(startPosition, stopPosition + 3);  //put the result string to result.

            if (result.length() % 3 == 0) {  //check to multiple of 3.
                valid = "valid";
            }

            return result;
        } else {
            System.out.println(valid + ". DNA didn't`t found");
        }
        return "";
    }
}
