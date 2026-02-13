import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CipherHandler {
    private String realChar;
    private String cipherChar;
    private FileHandler fileHandler;


    public CipherHandler(String keyFilePath) {
        fileHandler = new FileHandler();
        loadKey(keyFilePath);

        if (!validateKey()) {
            throw new RuntimeException("Invalid cipher key");
        }
    }

    public void loadKey(String keyFilePath) {

        List<String> lines = fileHandler.getKeyContents(keyFilePath);
        if (lines.size() != 2) {
            throw new RuntimeException("Key file must contain exactly 2 lines");
        }

        realChar = lines.get(0).trim();
        cipherChar = lines.get(1).trim();


    }

    public boolean validateKey() {

        if (realChar == null || cipherChar == null)
            return false;

        if (realChar.length() != cipherChar.length())
            return false;

        if (realChar.isEmpty())
            return false;

        // check for duplicates
        for (char c : realChar.toCharArray()) {
            if (realChar.indexOf(c) != realChar.lastIndexOf(c))
                return false;
        }

        for (char c : cipherChar.toCharArray()) {
            if (cipherChar.indexOf(c) != cipherChar.lastIndexOf(c))
                return false;
        }

        return true;
    }

    public String decipher(String text) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {

            char lower = Character.toLowerCase(c);
            int index = cipherChar.indexOf(lower);

            if (index != -1) {
                char decoded = realChar.charAt(index);

                // keeps the uppercase
                if (Character.isUpperCase(c)) {
                    decoded = Character.toUpperCase(decoded);
                }

                result.append(decoded);
            } else {
                result.append(c); // spaces or punctuation
            }
        }

        return result.toString();
    }


}

