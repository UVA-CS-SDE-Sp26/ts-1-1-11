import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestProgramControl {

    @Test
     void startWithNoArgsThrowsException() {
        ProgramControl pc = new ProgramControl();

        assertThrows(NullPointerException.class, () -> {
            pc.Start(new String[]{});
        });
    }

    @Test
    void startWithOneArgReturnsNull() {
        ProgramControl pc = new ProgramControl();

        ArrayList<String> result = pc.Start(new String[]{"1"});
        assertNull(result);
    }

    @Test
    void startWithTwoArgsReturnsNull() {
        ProgramControl pc = new ProgramControl();

        ArrayList<String> result = pc.Start(new String[]{"1", "key.txt"});
        assertNull(result);
    }

    @Test
    void startWithTooManyArgsThrowsException() {
        ProgramControl pc = new ProgramControl();

        assertThrows(RuntimeException.class, () -> {
            pc.Start(new String[]{"1", "key.txt", "extra"});
        });
    }

    @Test
    void pullFileWithInvalidNumberFormatThrowsException() {
        ProgramControl pc = new ProgramControl();

        assertThrows(RuntimeException.class, () -> {
            pc.PullFile("abc", null);
        });
    }
}