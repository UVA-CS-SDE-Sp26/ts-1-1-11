import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

class CipherHandlerTest {

    @Test
    void loadKey() {
        // make sure this doesn't throw an exception
        CipherHandler ch = new CipherHandler("ciphers/key.txt");
        assertDoesNotThrow(() -> ch.loadKey("ciphers/key.txt"));
        assertThrows(RuntimeException.class, () -> ch.loadKey("ciphers/invalid.txt"));


    }

    @Test
    void validateKey() {
        CipherHandler ch = new CipherHandler("ciphers/key.txt");
        assertTrue(ch.validateKey());
        // now test with an invalid key
        ch.loadKey("ciphers/InvalidKey.txt");
        assertFalse(ch.validateKey());

    }

    @Test
    void decipher() {
        CipherHandler ch = new CipherHandler("ciphers/key.txt");
        assertEquals("abcdefghij", ch.decipher("bcdefghijk"));
        // now test a line break
        assertEquals("abc\ndef", ch.decipher("bcd\nefg"));
    }

}