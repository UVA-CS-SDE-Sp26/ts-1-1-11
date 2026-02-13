import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    public FileHandler(){}

    public ArrayList<String> getAvailableFiles(){
        // get the actual files
        ArrayList<String> files = new ArrayList<>();
        String pathToCheck = "data";
        File folder = new File(pathToCheck);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                files.add(file.getName());
            }
        }
        return files;
    }

    public ArrayList<String> getFileContent(String fileName){
        String pathToCheck = "data/" + fileName;
        ArrayList<String> content = new ArrayList<>();
        try {
            File file = new File(pathToCheck);
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                content.add(s.nextLine());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }

}
