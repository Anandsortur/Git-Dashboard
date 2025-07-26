class GitUI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GRAY = "\u001B[90m";


    public static String color(String text, String colorCode) {

        if (text == null || text.trim().isEmpty()) {
            return "";
        }
        return colorCode + text + ANSI_RESET;
    }
}
