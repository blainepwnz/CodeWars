package codewars.kyu6;
/**
 * Created by Andrew on 29.01.2017.
 */
public class Diamond {

    public static void main(String[] args) {

    }

    public static String print(int i) {
        if (i % 2 == 0 || i < 0)
            return null;
        int index = i / 2;
        StringBuilder incrementSb = new StringBuilder();
        StringBuilder decrementSb = new StringBuilder();
        for (int j = 0; j < index; j++) {
            StringBuilder asterixBuffer = new StringBuilder();
            asterixBuffer.append("*");
            for (int k = 0; k < index - j; k++) {
                incrementSb.append(" ");
                asterixBuffer.append("**");
            }
            asterixBuffer.delete(asterixBuffer.length() - 2, asterixBuffer.length());
            incrementSb.append("*");
            decrementSb.append(" ");
            for (int k = 0; k < j; k++) {
                incrementSb.append("**");
                decrementSb.append(" ");
            }
            decrementSb.append(asterixBuffer);
            incrementSb.append("\n");
            decrementSb.append("\n");
        }
        incrementSb.append("*");
        for (int j = 0; j < i / 2; j++) {
            incrementSb.append("**");
        }
        incrementSb.append("\n");

        return incrementSb.append(decrementSb).toString();

    }


}
