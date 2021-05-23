package Loesung_G33;

import java.util.List;

public class Utility {

    public static boolean charExistsInAlphabet(char c, List<Character> chars) {

        int m = 0;

        for (char c1: chars) {
            if (c == c1)
                m++;
        }

        return (m > 0);
    }

}
