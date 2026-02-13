import java.util.ArrayList;

public class ProgramControl {

    private FileHandler fileHandler;
    private CipherHandler cipher;
    private ArrayList<String> availableFiles;

    // builds other objects
    public ProgramControl() {
        fileHandler = new FileHandler();
        availableFiles = fileHandler.getAvailableFiles();
        cipher = new CipherHandler("ciphers/key.txt");
        if (availableFiles == null) {
            availableFiles = new ArrayList<>();
        }
    }


    // returns numbered list of available files
    public String PrintFiles() {
        StringBuilder formattedList = new StringBuilder();
        for (int i = 0; i < availableFiles.size(); i++) {
            String formatted = String.format("%02d %s",
                    i + 1, availableFiles.get(i));
            formattedList.append(formatted).append("\n");
        }
        return formattedList.toString();
    }

    // returns deciphered file contents
    public String PullFile(String fileId, String keyPath) {
        int index;
        try {
            index = Integer.parseInt(fileId);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error: Invalid file number format.");
        }
        if (index < 1 || index > availableFiles.size()) {
            throw new RuntimeException("Error: File number out of range.");
        }

        String filename = availableFiles.get(index - 1);
        String content = fileHandler.getFileContent(filename);

        if (content == null) {
            throw new RuntimeException("Error: File not found.");
        }
        if (keyPath != null) {
            cipher.loadKey(keyPath);
        }
        if (cipher != null) {
            if (!cipher.validateKey()) {
                throw new RuntimeException("Error: Invalid cipher key.");
            }
            content = cipher.decipher(content);
        }
        return content;
    }
}
