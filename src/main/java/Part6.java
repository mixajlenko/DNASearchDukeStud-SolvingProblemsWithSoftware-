public class Part6 {
    /**
     * method named howMany that has two String parameters named stringa and stringb. This method returns an integer
     * indicating how many times stringa appears in stringb, where each occurrence of stringa must not overlap with
     * another occurrence of it. For example, the call howMany(“GAA”, “ATGAACGAATTGAATC”) returns 3 as GAA occurs
     * 3 times. The call howMany(“AA”, “ATAAAA”) returns 2. Note that the AA’s found cannot overlap.
     */
    public static int howMany(String a, String b) {

        int count = 0;
        int index = 0;

        while (index != -1) {
            String newB = b.toUpperCase();
            String newA = a.toUpperCase();
            index = newB.indexOf(newA, index);
            if (index == -1) {
                break;
            }
            index += newA.length();
            count++;
        }
        return count;
    }
}
