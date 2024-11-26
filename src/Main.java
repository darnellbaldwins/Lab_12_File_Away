import javax.swing.*;
import java.io.*;
public class Main {

    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("src"));
        int result = fileChooser.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("No file selected.");
            return;
        }
        File file = fileChooser.getSelectedFile();
        System.out.println("File selected: " + file.getName());
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                System.out.println(line);
                String[] words = line.split("\\s+");
                wordCount += words.length;
                charCount += line.length();
            }
        } catch (IOException e) {
            System.out.println("Coudlnt read the file: " + e.getMessage());
        }
        System.out.println("\nSummary Report:");
        System.out.println("File name: " + file.getName());
        System.out.println("Line counts: " + lineCount);
        System.out.println("Word counts: " + wordCount);
        System.out.println("character counts: " + charCount);
    }
}
