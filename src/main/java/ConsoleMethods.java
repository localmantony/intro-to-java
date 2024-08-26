import java.util.Scanner;

// common methods for cleaning up user input 
public class ConsoleMethods {
    Scanner scanner = new Scanner(System.in);  // initialize user input interface

    // prints valid inputs for menu options if user enters incorrect choice
    public void inputError(int options) {
        clear();
        System.out.print("Invalid input. Please enter ");
        if (options == 1) {
            System.out.println("1.\n");
        }
        // prevent the output "1, or 2" by making separate case for 2 options
        else if (options == 2) {
            System.out.println("1 or 2.\n");
        }
        else {
            for (int i = 1; i < options; i++) {
                System.out.print(i + ", ");
            }
            System.out.println("or " + options + ".\n" ); 
        }
          
    }

    // clears the shell to make viewing Menus cleaner and easier - prevents long scrolling input
    public void clear() {
        try {
            // Execute the 'clear' command on Linux/Unix/MacOS
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // pauses program and waits for user to continue
    public void pressEnterTo(String wheretogo) {
        System.out.println("Press Enter to "+ wheretogo + ": \n");
        scanner.nextLine();
        clear();
    }
}

