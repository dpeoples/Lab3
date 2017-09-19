import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

/**
 * A program to process web content as strings & count words from raw text.
 * @author darciap2
 */
public class WebWordCount {

    /**
     * Max length of contents for it to be printed.
     */
    public static final int LINE_LENGTH = 140;
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * Counts words from raw text url.
     *
     * @param unused unused parameter
     */
    public static void main(final String[] unused) {
        String search = "winds";

        String contents = urlToString(
                "http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt");
        //String contents = "This is a String a String 67";
        if (contents.length() < LINE_LENGTH) {
            System.out.println(contents);
        }
        String[] words = contents.split(" ");
        String[] occurrences = contents.toLowerCase().split(search.toLowerCase());
        System.out.println("Occurances of \"" + search + "\": " + (occurrences.length - 1));
        System.out.println("Word count: " + words.length);

        HashMap<String, String> map = new HashMap<>();
        for (String i:words) {
            map.put(i, i);
        }
        System.out.println(map.keySet().size());

    }
}
