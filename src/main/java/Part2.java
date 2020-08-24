public class Part2 {
    /**
     * Similar method from Part1 class with few changes.
     * 1. To this method were added such parameters: String startCodon and String stopCodon which add to program
     * start and stop position to search.
     * =================================================================================================================
     * 2. Modified the findSimpleGene method to work with DNA strings that are either
     * all uppercase letters such as “ATGGGTTAAGTC” or all lowercase letters such as “gatgctataat”.
     * =================================================================================================================
     */
    public String StringsFirstAssignments(String dna, String startCodon, String stopCodon) {

        String result;
        String valid = "not valid";

        int startPosition;
        int stopPosition;

        String alterStart = startCodon.toLowerCase(); //set all input to lower case.
        String alterStop = stopCodon.toLowerCase();

        if (dna.equals(dna.toLowerCase())) {  //if the initial string of dna was in lower case.
            startPosition = dna.indexOf(alterStart); //string position == startCodon index in lower case.
            stopPosition = dna.indexOf(alterStop, startPosition + 3); //stop position and index+3 for count
            // of stop position characters.
        } else { //if the initial string was in upper case.
            startPosition = dna.indexOf(startCodon);
            stopPosition = dna.indexOf(stopCodon, startPosition + 3);
        }

        if (startPosition == -1 || stopPosition == -1) {
            return "not find";
        }

        result = dna.substring(startPosition, stopPosition + 3);

        if (result.length() % 3 == 0) {
            valid = "valid";
        }

        if (result.equals(result.toLowerCase())) {
            result = result.toUpperCase();
        } else {
            result = result.toLowerCase();
        }

        System.out.println("DNA is: " +
                result +
                " String is: " + valid);
        return result;
    }

}
