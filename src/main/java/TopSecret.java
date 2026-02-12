/**
 * Commmand Line Utility
 */
import java.lang.*;

public class TopSecret {

    static void main(String[] args) {
        TopSecret cli = new TopSecret();
        try{
            cli.run(args);}
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * main logic for handling CLI arguments
     */
    public void run(String[] args) {
        // no arguments lists available files
        if (args.length == 0) {
            displayFileList();
            return;
        }
        // one argument displays a specific file
        if (args.length == 1) {
            if (!args[0].matches("\\d{2}")) {
                throw new RuntimeException("Error: File number must be in two-digit format.");}
            displayFileContent(args[0], null);
            return;
        }
        // two arguments for custom cipher key
        if (args.length == 2) {
            if (!args[0].matches("\\d{2}")) {
                throw new RuntimeException("Error: File number must be in two-digit format.");}
            displayFileContent(args[0], args[1]);
            return;
        }
        // handle unexpected input
        throw new RuntimeException("Too many Arguments. Usage: java TopSecret [fileNumber] [optionalKey]");
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
