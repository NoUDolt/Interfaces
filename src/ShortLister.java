import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args) {

        // Inform the user to select a file
        System.out.println("Please use the menu to select a desired text file: \n");

        // File chooser for user to pick a file
        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        // File reading variables
        String word;

        try {
            // Get the current working directory of the IDE
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            // Allow the user to select a file, process the file only if chosen
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                // Open the file for reading
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                // Initialize ShortWordFilter
                ShortWordFilter filter = new ShortWordFilter();

                System.out.println("Short words (length < 5):");
                System.out.println("=========================");

                // Read the file and apply the filter to each word
                while (reader.ready()) {
                    word = reader.readLine();
                    String[] words = word.split("\\s+");  // Split the line into words
                    for (String w : words) {
                        if (filter.accept(w)) {
                            System.out.println(w);
                        }
                    }
                }

                // Close the reader after reading the file
                reader.close();
                System.out.println("\n\nData file read!");

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}