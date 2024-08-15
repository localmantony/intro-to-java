import java.util.*;
import java.io.*;
import java.nio.file.*;

class CompanyEmployeesProgram {
  public static void addEmployees(Scanner input, String csvFile) {
    ArrayList<CompanyEmployee> employeesToAdd = new ArrayList<>();
    char keepGoing = 'Y';
    while(keepGoing == 'Y') {
      System.out.print("Enter Employee Last Name: ");
      String last = input.nextLine();
      System.out.print("Enter Employee First Name: ");
      String first = input.nextLine();
      System.out.print("Enter Employee ID#: ");
      int id = input.nextInt();
      System.out.print("Enter Salary: ");
      int salary = input.nextInt();
      input.nextLine();

      CompanyEmployee employee = new CompanyEmployee(last, first, id, salary);
      employeesToAdd.add(employee);

      System.out.print("Continue adding? (Y/N): ");

      keepGoing = input.nextLine().charAt(0);
    }

    writeEmployees("employees.csv", employeesToAdd);
  }
  
  public static void writeEmployees(String csvFile, ArrayList<String> employees) {
    File outputFile = new File(csvFile);
    try {
      Files.write(outputFile.toPath(), employees, StandardOpenOption.APPEND);
    }
    catch(IOException ex) {
      System.out.println("Error writing to file: " + ex.getMessage());
    }
  }
  
  public static ArrayList<CompanyEmployee> readEmployees(String csvFile) {
    
    //empty array list initialized, will add CompanyEmployee objects
    ArrayList<CompanyEmployee> employeeList = new ArrayList<>();
    
    File inputDataFile = new File(csvFile);
    List<String> lines = new ArrayList<>();

    try {
      lines = Files.readAllLines(inputDataFile.toPath());

      //each line parsed
      for(String line: lines) {

        //split csv (comma separated values) by commas to separate columns
        String[] employeeData = line.split(",");

        // all csv data is text (String) by default, convert to Integers
        int id = Integer.parseInt(employeeData[0]);
        int salary = Integer.parseInt(employeeData[1]);

        //last name and first name dont need to be converted because they're already text
        String lastName = employeeData[2];
        String firstName = employeeData[3];
      
        // Constructing a CompanyEmployee object for each line in lines with the variables above passed as parameters
        CompanyEmployee empl = new CompanyEmployee(lastName, firstName, id, salary);

        //add each empl to the empty array list created above
        employeeList.add(empl);
      }
    }
    catch(FileNotFoundException ex) {
      System.out.println("File not found: " + ex.getMessage());
    }
    catch(IOException ex) {
      System.out.println("I/O error: " + ex.getMessage());
    }
    catch(NumberFormatException ex) {
       System.out.println("Number Format Error: " + ex.getMessage());
    }
    return employeeList;
  }
  
  public static void main(String[] args) {
    ArrayList<CompanyEmployee> employees = readEmployees("employees.csv");
  }
}