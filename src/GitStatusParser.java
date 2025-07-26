public class GitStatusParser {


    public String parse(String statusOutput) {

        if (statusOutput.isEmpty()) {
            return "Clean ✨";
        }

        int modified = 0;
        int newFiles = 0;
        int untracked = 0;


        String[] lines = statusOutput.split(System.lineSeparator());

        for (String line : lines) {
            if (line.startsWith(" M")) {
                modified++;
            } else if (line.startsWith("A ")) {
                newFiles++;
            } else if (line.startsWith("??")) {
                untracked++;
            }
        }

        StringBuilder summary = new StringBuilder("Changes found: ");
        if (modified > 0) summary.append(modified).append(" Modified, ");
        if (newFiles > 0) summary.append(newFiles).append(" New, ");
        if (untracked > 0) summary.append(untracked).append(" Untracked, ");

        return summary.substring(0, summary.length() - 2);
    }
}