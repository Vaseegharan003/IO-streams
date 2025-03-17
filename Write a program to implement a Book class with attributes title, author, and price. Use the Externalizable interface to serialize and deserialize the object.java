import java.io.*;

public class LineCounter {
    public static void main(String[] args) {
        String inputFile = "data.txt";
        String outputFile = "result.txt";
        int lineCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Error reading " + inputFile + ": " + e.getMessage());
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Number of lines: " + lineCount);
            System.out.println("Line count written to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to " + outputFile + ": " + e.getMessage());
        }
    }
}
