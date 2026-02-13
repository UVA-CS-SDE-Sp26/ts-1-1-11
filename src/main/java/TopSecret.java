/**
 * Command Line Utility
 */
import java.lang.*;

public class TopSecret {
    public static void main(String[] args) {
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
        ProgramControl pc = new ProgramControl();
        if (args.length == 0) {
            System.out.printf(pc.PrintFiles());
            return;
        }
        // one argument displays a specific file
        if (args.length == 1) {
            if (!args[0].matches("\\d{2}")) {
                throw new RuntimeException("Error: File number must be in two-digit format.");}
            System.out.printf(pc.PullFile(args[0], null));
            return;
        }
        // two arguments for custom cipher key
        if (args.length == 2) {
            if (!args[0].matches("\\d{2}")) {
                throw new RuntimeException("Error: File number must be in two-digit format.");}
            System.out.printf(pc.PullFile(args[0], args[1]));
            return;
        }
        // handle unexpected input
        throw new RuntimeException("Too many Arguments. Usage: java TopSecret [fileNumber] [optionalKey]");
    }
}
