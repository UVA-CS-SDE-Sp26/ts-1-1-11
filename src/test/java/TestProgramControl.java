import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestProgramControl {


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
}