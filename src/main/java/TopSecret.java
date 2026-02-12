/**
 * Commmand Line Utility
 */

public class TopSecret {

    public static void main(String[] args) {
        TopSecret cli = new TopSecret();
        cli.run(args);
    }

    /**
     * main logic for handling CLI arguments
     */
    public void run(String[] args) {
        // no arguments lists available files
        if (args.length == 0) {
            displayFileList();
        }
        // one argument displays a specific file
        else if (args.length == 1) {
            if (!args[0].matches("\\d{2}")) {
                throw new Error("Error: File number must be in two-digit format.");}
            displayFileContent(args[0], null);
        }
        // two arguments for custom cipher key
        else if (args.length == 2) {
            if (!args[0].matches("\\d{2}")) {
                throw new Error("Error: File number must be in two-digit format.");}
            displayFileContent(args[0], args[1]);
        }
        // handle unexpected input
        else {
            throw new Error("Too many Arguments. Usage: java TopSecret [fileNumber] [optionalKey]");
        }
    }

    private void displayFileList() {
        // this will call Team Member C's controller
        System.out.println("01 filea.txt");
        System.out.println("02 fileb.txt");
        System.out.println("03 filec.txt");
    }

    private void displayFileContent(String fileId, String keyPath) {
        // this will interconnect with Member C (Control) and D (Cipher)
        System.out.println("(Displaying contents of file " + fileId + "...)" + keyPath);
    }
}
