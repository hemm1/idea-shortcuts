package bekk;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Collections.sort;

public class OtherClass {
    public static void sortList(ArrayList<String> strings) {
        sort(strings, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length() - o2.length();
            }
        });
    }
}
