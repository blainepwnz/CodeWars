package codewars.kyu7;
import java.util.Arrays;

/**
 * Created by Andrew on 29.01.2017.
 */
public class DescendingOrder {
    public static int sortDesc(final int num) {
        //Your code
        char[] array = String.valueOf(num).toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[array.length-i-1]);
        }
        return Integer.valueOf(sb.toString());
    }

}
