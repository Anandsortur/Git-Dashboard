import java.io.BufferedReader; // Efficiently reads text.
import java.io.File;  //Represents a file or directory path (like "." for the current directory).
import java.io.IOException;
import java.io.InputStreamReader; //A bridge to read bytes of data as text.

public class GitCommandRunner {
    public String run(String command) {
        // efficiently build the final output string
        // efficient than using concatenation
        StringBuilder output = new StringBuilder();
        try {

            // creating and managing OS processes.
            // "git branch --show-current" converted to ["git", "branch", "--show-current"].
            ProcessBuilder builder = new ProcessBuilder(command.split(" "));

            //Setting the Working Directory
            // the command to execute in the current directory (`.`).
            builder.directory(new File("."));

            Process process = builder.start(); // execute the command.
//            Process process = Runtime.getRuntime().exec();


            // Reading Output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // getInputStream() -- Capture the output from a subprocess
            // InputStreamReader -- Convert it from bytes to readable characters.
            //BufferedReader -- buffers input in memory and allows to read it line-by-line

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
                output.append(System.lineSeparator());

            }

            // Waiting for the Command to Finish
            // exit code  0 = success.
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Error: Command exited with code " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return output.toString();
    }
}