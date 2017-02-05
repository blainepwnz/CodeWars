package codewars.kyu6;

/**
 * Created by Andrew on 29.01.2017.
 */
public class AlternatingSplit {
    public static String encrypt(final String text, final int n) {
        // Your code here
        if (text == null) return null;
        if (n <= 0) return text;
        return encryptString(text, n);
    }

    private static String encryptString(String s, int n) {
        StringBuilder encryptedSb = new StringBuilder();
        StringBuilder mainSB = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0)
                encryptedSb.append(chars[i]);
            else
                mainSB.append(chars[i]);
        }
        String encrypted = mainSB.append(encryptedSb).toString();
        return n == 1 ? encrypted : encryptString(encrypted, --n);
    }

    private static String decryptString(String s, int n) {
        StringBuilder firstSb = new StringBuilder();
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = chars.length / 2; i < chars.length; i++) {
            firstSb.append(chars[i])
                    .append(chars[j]);
            j++;
        }
        if (chars.length % 2 != 0) firstSb.deleteCharAt(firstSb.length() - 1);
        String decrypted = firstSb.toString();
        return n == 1 ? decrypted : decryptString(decrypted, --n);
    }

    public static String decrypt(final String encryptedText, final int n) {
        // Your code here
        if (encryptedText == null) return null;
        if (n <= 0) return encryptedText;
        return decryptString(encryptedText, n);
    }
}
