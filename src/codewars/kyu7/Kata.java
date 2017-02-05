package codewars.kyu7;
/**
 * Created by Andrew on 29.01.2017.
 */
public class Kata {
    public static String getMiddle(String word) {
        //Code goes here!
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(chars[chars.length/2]);
        if(word.length()%2 ==0){
            sb.insert(0,chars[chars.length/2-1]);
        }
        return sb.toString();
    }
}
