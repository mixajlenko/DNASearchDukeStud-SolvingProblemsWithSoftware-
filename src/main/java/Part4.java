import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Part4 {

    int counterOfFoundedUrl = 0;
    /**
     * Program that reads the lines from the file at this URL location,
     * https://www.dukelearntoprogram.com//course2/data/manylinks.html, and prints each URL on the page that is a link to
     * youtube.com. Assume that a link to youtube.com has no spaces in it and would be in the format (where [stuff]
     * represents characters that are not verbatim): “http:[stuff]youtube.com[stuff]”
     * =================================================================================================================
     * 1. For each word, check to see if “youtube.com” is in it. If it is, find the double quote to the left and right
     * of the occurrence of “youtube.com” to identify the beginning and end of the URL. Note, the double quotation mark
     * is a special character in Java. To look for a double quote, look for (\”), since the backslash (\) character
     * indicates we want the literal quotation marks (“) and not the Java character. The string you search for would be
     * written “\”” for one double quotation mark.
     * =================================================================================================================
     * 2. In addition to the String method indexOf(x, num), you might want to consider using the String method
     * lastIndexOf(s, num) that can be used with two parameters s and num. The parameter s is the string or character
     * to look for, and num is the last position in the string to look for it. This method returns the last match from
     * the start of the string up to the num position, so it is a good option for finding the opening quotation mark of
     * a string searching backward from “youtube.com.” More information on String methods can be found in the Java
     * documentation for Strings: http://docs.oracle.com/javase/7/docs/api/java/lang/String.html.
     */
    public boolean urlParse(String urlString, String whatToFind) throws IOException {
        //Open and read url.
        //https://www.dukelearntoprogram.com/course2/data/manylinks.html
        boolean result = false;
        URL url = new URL(urlString);
        BufferedReader read = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String i;
        while ((i = read.readLine()) != null) {
            findURL(whatToFind, i); //Using "findURL" method for finding set value.
            if (counterOfFoundedUrl > 0)
                result = true;
        }
        read.close();
        return result;
    }

    public boolean findURL(String stringa, String stringb) {
        String newB = stringb.toLowerCase();
        int startPosition = newB.indexOf(stringa);

        if (startPosition != -1) {
            int startPosition2 = stringb.indexOf("\"");
            int stopPosition = stringb.indexOf("\"", startPosition + 1);
            if (startPosition2 != -1 || stopPosition != -1) {
                String findValue = stringb.substring(startPosition2, stopPosition + 1);
                counterOfFoundedUrl++;
                System.out.println(findValue);
            }
        }
        return false;
    }
}
