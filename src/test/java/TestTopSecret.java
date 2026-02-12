import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTopSecret {

    @Test
    public void testNoArgumentsListsFiles() {
        TopSecret cli = new TopSecret();
        assertDoesNotThrow(() -> cli.run(new String[]{}));
    }

    @Test
    public void testSingleArgumentSelection() {
        TopSecret cli = new TopSecret();
        // verify single argument
        assertDoesNotThrow(() -> cli.run(new String[]{"01"}));
    }

    @Test
    public void testCustomKeyArgument() {
        TopSecret cli = new TopSecret();
        // verify two parameters
        assertDoesNotThrow(() -> cli.run(new String[]{"01", "customKey.txt"}));
    }

    @Test
    public void testThreeArguments() {
        TopSecret cli = new TopSecret();
        assertThrows(Error.class, () -> cli.run(new String[]{"01", "customKey.txt", "tooMany"}));
    }

    @Test
    public void testOneArgumentsSingleDigit() {
        TopSecret cli = new TopSecret();
        assertThrows(Error.class, () -> cli.run(new String[]{"1"}));
    }

    @Test
    public void testOneArgumentsThreeDigits() {
        TopSecret cli = new TopSecret();
        assertThrows(Error.class, () -> cli.run(new String[]{"011"}));
    }
}