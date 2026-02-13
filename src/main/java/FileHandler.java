import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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

    public String getFileContent(String fileName){
        String pathToCheck = "data/" + fileName;
        
        try {
            File file = new File(pathToCheck);
            Scanner s = new Scanner(file);
            // read all into a string
            StringBuilder content = new StringBuilder();
            while (s.hasNextLine()) {
                content.append(s.nextLine()).append("\n");
            }
            s.close();
            return content.toString();            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getKeyContents(String keyPath) {
        try {
            File file = new File(keyPath);
            Scanner s = new Scanner(file);
            // read all into a string
            List<String> content = new ArrayList<>();
            while (s.hasNextLine()) {
                content.add(s.nextLine());
            }
            s.close();
            return content;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Failed to read key file");
        }
    }

}
