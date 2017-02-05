package codewars.kyu7;

/**
 * Created by Andrew on 30.01.2017.
 */
public class BrokenSequence {
    public int findMissingNumber(String sequence) {
        String[] numbersStringArray = sequence.split(" ");
        int[] numbersArray = new int[numbersStringArray.length];
        if (numbersStringArray.length < 2) return 0;
        for (int i = 0; i < numbersArray.length; i++) {
            for (int j = 0; j < numbersStringArray.length; j++) {
                try {
                    if (Integer.parseInt(numbersStringArray[j]) == i + 1) {
                        numbersArray[i] = i + 1;
                        break;
                    }
                } catch (NumberFormatException e) {
                    return 1;
                }
            }
            if (numbersArray[i] == 0) return i + 1;
        }
        return 0;
    }

}
