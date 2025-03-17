import java.io.*;

public class FileMerger {
    public static void main(String[] args) {
        String[] fileNames = {"file1.txt", "file2.txt", "file3.txt"};
        String mergedFile = "merged.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFile))) {
            for (String fileName : fileNames) {
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error reading " + fileName + ": " + e.getMessage());
                }
            }
            System.out.println("Files merged successfully into " + mergedFile);
        } catch (IOException e) {
            System.out.println("Error writing to " + mergedFile + ": " + e.getMessage());
        }
    }
}
