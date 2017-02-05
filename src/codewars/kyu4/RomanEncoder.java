package codewars.kyu4;
/**
 * Created by Andrew on 01.02.2017.
 */
public class RomanEncoder {
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int thousands = n / 1000;
        appendLetter(sb, "M", thousands);
        int hundreds = n % 1000 / 100;
        appendSwitch("C", "D", "M", hundreds, sb);
        int tens = n % 100 / 10;
        appendSwitch("X", "L", "C", tens, sb);
        int numbers = n % 10;
        appendSwitch("I", "V", "X", numbers, sb);
        return sb.toString();
    }

    private static void appendLetter(StringBuilder sb, String s, int count) {
        if (count != 0) appendLetter(sb.append(s), s, --count);
    }

    private static void appendSwitch(String first, String middle, String last, int number, StringBuilder sb) {
        switch (number) {
            case 1:
            case 2:
            case 3:
                appendLetter(sb, first, number);
                break;
            case 4:
                appendLetter(sb, first + middle, 1);
                break;
            case 5:
                appendLetter(sb, middle, 1);
                break;
            case 6:
            case 7:
            case 8:
                appendLetter(sb, middle, 1);
                appendLetter(sb, first, number - 5);
                break;
            case 9:
                appendLetter(sb, first + last, 1);
        }
    }


}
