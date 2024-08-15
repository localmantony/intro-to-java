import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class WriteTextToFile {
  public static void main(String[] args) {
    // creates strings in an array lists and then adds text
    ArrayList<String> lines = new ArrayList<>();
    lines.add("Line 1");
    lines.add("Line 2");
    lines.add("Line 3");

    ArrayList<String> lines2 = new ArrayList<>();
    lines.add("Line 4");
    lines.add("Line 5");
    lines.add("Line 6");

    // create output text file
    File output = new File("output.txt");

    try {
      Files.writeString(output.toPath(), "Second Line", StandardOpenOption.CREATE);
      Files.writeString(output.toPath(), "Third Line", StandardOpenOption.CREATE);
    }
    catch(IOException ex) {
      System.out.println("Error writing to file: " + ex.getMessage());
    }
  }
}