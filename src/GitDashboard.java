public class GitDashboard {
    public static void main(String[] args) {
        GitCommandRunner runner = new GitCommandRunner();
        GitStatusParser parser = new GitStatusParser();

        String isGitRepo = runner.run("git rev-parse --is-inside-work-tree");


        if (isGitRepo.trim().equals("true")) {
            System.out.println("--- My Git Dashboard ---");


            String gitStatusOutput = runner.run("git status --short");
            String statusSummary = parser.parse(gitStatusOutput);
            System.out.println("📊 Status: " + GitUI.color(statusSummary, GitUI.ANSI_YELLOW));

            String currentBranch = runner.run("git branch --show-current").trim();
            System.out.println("🌿 Current Branch: " + GitUI.color(currentBranch, GitUI.ANSI_GREEN));

            System.out.println();
            System.out.println("🔨 Recent Commits:");
            String recentCommits = runner.run("git log -n 5 --oneline");
            System.out.println(GitUI.color(recentCommits, GitUI.ANSI_CYAN));

            System.out.println();
            System.out.println("🔁 Remote Info:");
            String remoteInfo = runner.run("git remote -v");
            System.out.println(GitUI.color(remoteInfo, GitUI.ANSI_GRAY));

        } else {
            System.out.println("Error: This is not a Git repository.");
        }
    }
}