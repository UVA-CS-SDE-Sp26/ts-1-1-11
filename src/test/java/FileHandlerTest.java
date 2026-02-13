import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void getAvailableFiles() {
        FileHandler fileHandler = new FileHandler();
        assertEquals(4, fileHandler.getAvailableFiles().size()); // Right now there are 4 files in the data folder and this test will fail if any files are added or removed
        assertTrue(fileHandler.getAvailableFiles().contains("carnivore.cip"));
        assertTrue(fileHandler.getAvailableFiles().contains("carnivore.txt"));
    }


    @Test
    void getFileContent() {
        FileHandler fileHandler = new FileHandler();
        assertEquals(4, fileHandler.getFileContent("carnivore.cip").split("\n").length); // Right now there are 4 lines in carnivore.cip and this test will fail if any lines are added or removed
        assertEquals("Dbsojwpsf, mbufs sfobnfe EDT2aaa, xbt b tztufn jnqmfnfoufe cz uif Gfefsbm Cvsfbv pg Jowftujhbujpo (GCJ) uibu xbt", fileHandler.getFileContent("carnivore.cip").split("\n")[0]);
    }

    @Test
    void testGetKeyContents() {
        FileHandler fileHandler = new FileHandler();
        assertEquals(2, fileHandler.getKeyContents("ciphers/key.txt").size());
        assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", fileHandler.getKeyContents("ciphers/key.txt").get(0));
    }
}