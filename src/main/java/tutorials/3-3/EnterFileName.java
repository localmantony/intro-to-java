import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

class EnterFileName {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter existing file name: ");
    String fileName = input.nextLine();
    File inputFile = new File(fileName);

    try{
      List<String> lines = Files.readAllLines(inputFile.toPath());
      System.out.println(inputFile.getName() + " contains " + lines.size() + " lines.");
      
    }
    catch(IOException ex) {
      System.out.println("File error: " + ex.getMessage());
    }
  }
}