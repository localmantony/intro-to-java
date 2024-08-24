public class ConsoleMethods {
    
    public void inputError(int options) {
        System.out.print("Invalid input. Please enter ");
        for (int i = 1; i < options; i++) {
            System.out.print(i + ", ");
        }
        System.out.println("or " + options + "." );   
    }

    // clears the shell to make viewing Menus cleaner and easier
    public void clear() {
        try {
            // Execute the 'clear' command on Linux/Unix/MacOS
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

