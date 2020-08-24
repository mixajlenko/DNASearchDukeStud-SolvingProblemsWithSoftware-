public class Part3 {
    /**
     * twoOccurrences method returns true if stringa appears at least twice in stringb, otherwise it returns false.
     * For example, the call twoOccurrences(“by”, “A story by Abby Long”) returns true as there are two occurrences
     * of “by”, the call twoOccurrences(“a”, “banana”) returns true as there are three occurrences of “a” so “a”
     * occurs at least twice, and the call twoOccurrences(“atg”, “ctgtatgta”) returns false as there is only one
     * occurence of “atg”.
     */
    public boolean twoOccurrences(String stringa, String stringb) {
        int counter = 0;
        int index = stringb.indexOf(stringa);
        boolean result = false;
        while (index != -1) {
            result = true;
            counter++;
            index = stringb.indexOf(stringa, index + 1);
        }
        if (counter > 1) {
            System.out.println("String contain " + "'" + stringa + "' " + counter + " times.");
        } else {
            System.out.println("Just " + counter + " occurence of " + stringa + " in " + stringb);
        }

        return result;
    }

    /**
     * lastPart method that has two String parameters named stringa and stringb. This method finds the
     * first occurrence of stringa in stringb, and returns the part of stringb that follows stringa. If stringa does
     * not occur in stringb, then return stringb. For example, the call lastPart(“an”, “banana”) returns the string
     * “ana”, the part of the string after the first “an”. The call lastPart(“zoo”, “forest”) returns the string
     * “forest” since “zoo” does not appear in that word.
     */
    public String lastPart(String stringa, String stringb) {
        int index = stringb.indexOf(stringa);
        String result = "";

        if (index != -1) {
            result = stringb.substring(index + stringa.length());
            System.out.println(result);
        } else {
            System.out.println("'" + stringa + "'" + " didn`t found. Original string: " + stringb);
        }
        return result;
    }
}
