package codewars.kyu7;
/**
 * Created by Andrew on 29.01.2017.
 */
import java.util.Arrays;
public class MinMax {
    public static int[] minMax(int[] arr) {
        // Your awesome code here
        Arrays.sort(arr);
        return new int[]{arr[0],arr[arr.length-1]};
    }
}