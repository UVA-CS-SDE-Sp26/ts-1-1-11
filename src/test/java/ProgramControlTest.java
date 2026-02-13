import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramControlTest {


    @Test
    void pullFileWithInvalidNumberFormatThrowsException() {
        ProgramControl pc = new ProgramControl();

        assertThrows(RuntimeException.class, () -> {
            pc.PullFile("abc", null);
        });
    }
    @Test
    void testPrintFiles() {
        ProgramControl pc = new ProgramControl();
        String output = pc.PrintFiles();
        assertTrue(output.contains("carnivore.cip"));
        assertTrue(output.contains("02"));
        assertTrue(output.contains("\n"));
        assertTrue(output.contains("04"));
    }

    @Test
    void pullFileWithOutOfRangeLowThrowsException() {
        ProgramControl pc = new ProgramControl();
        assertThrows(RuntimeException.class, () -> {
            pc.PullFile("0", null);
        });
    }

    @Test
    void pullFileWithOutOfRangeHighThrowsException() {
        ProgramControl pc = new ProgramControl();
        assertThrows(RuntimeException.class, () -> {
            pc.PullFile("999", null);
        });
    }

    @Test
    void printFilesIsNotNull() {
        ProgramControl pc = new ProgramControl();
        String output = pc.PrintFiles();
        assertNotNull(output);
    }

    @Test
    void printFilesContainsLeadingZeroFormat() {
        ProgramControl pc = new ProgramControl();
        String output = pc.PrintFiles();
        // checks that numbering format uses two digits
        assertTrue(output.matches("(?s).*\\b0\\d\\b.*"));
    }
}