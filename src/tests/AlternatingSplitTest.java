package tests;
import codewars.kyu6.AlternatingSplit;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Andrew on 29.01.2017.
 */
public class AlternatingSplitTest {

    @Test
    public void testEncrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", AlternatingSplit.encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", AlternatingSplit.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", AlternatingSplit.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", AlternatingSplit.encrypt("This is a test!", 3));
        assertEquals("This is a test!", AlternatingSplit.encrypt("This is a test!", 4));
        assertEquals("This is a test!", AlternatingSplit.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", AlternatingSplit.encrypt("This kata is very interesting!", 1));
    }

    @Test
    public void testDecrypt() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", AlternatingSplit.decrypt("This is a test!", 0));
        assertEquals("This is a test!", AlternatingSplit.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", AlternatingSplit.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", AlternatingSplit.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", AlternatingSplit.decrypt("This is a test!", 4));
        assertEquals("This is a test!", AlternatingSplit.decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", AlternatingSplit.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    public void testNullOrEmpty() {
        // assertEquals("expected", "actual");
        assertEquals("", AlternatingSplit.encrypt("", 0));
        assertEquals("", AlternatingSplit.decrypt("", 0));
        assertEquals(null, AlternatingSplit.encrypt(null, 0));
        assertEquals(null, AlternatingSplit.decrypt(null, 0));
    }

}
